package com.lopeshenriquee.screenmatch;

import com.lopeshenriquee.screenmatch.model.DataEpisodes;
import com.lopeshenriquee.screenmatch.model.DataSeason;
import com.lopeshenriquee.screenmatch.model.DataSeries;
import com.lopeshenriquee.screenmatch.service.ConsumoAPI;
import com.lopeshenriquee.screenmatch.service.DataConvert;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumoAPI = new ConsumoAPI();
		var jsonGeneral = consumoAPI.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=9287c99a");
		var jsonEpisode = consumoAPI.obterDados("https://www.omdbapi.com/?t=gilmore+girls&Season=1&episode=2&apikey=9287c99a");

		System.out.println(jsonGeneral);
		System.out.println(jsonEpisode);

		DataConvert dataConvert = new DataConvert();
		DataSeries data1 = dataConvert.getData(jsonGeneral, DataSeries.class);
		System.out.println(data1);

		DataEpisodes data2 = dataConvert.getData(jsonEpisode, DataEpisodes.class);
		System.out.println(data2);

		List<DataSeason> dataSeasonsList = new ArrayList<>();

		for (int i = 0; i <= data1.totalSeasons() ; i++) {
			var jsonSeason = consumoAPI.obterDados("https://www.omdbapi.com/?t=gilmore+girls&Season="+ i +"&apikey=9287c99a");
			DataSeason dataSeason = dataConvert.getData(jsonSeason, DataSeason.class);
			dataSeasonsList.add(dataSeason);
		}
		dataSeasonsList.forEach(System.out::println);

	}
}
