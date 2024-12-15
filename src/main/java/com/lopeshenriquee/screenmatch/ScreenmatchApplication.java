package com.lopeshenriquee.screenmatch;

import com.lopeshenriquee.screenmatch.model.DataSeries;
import com.lopeshenriquee.screenmatch.service.ConsumoAPI;
import com.lopeshenriquee.screenmatch.service.DataConvert;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumoAPI = new ConsumoAPI();
		var json = consumoAPI.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=9287c99a");
//		System.out.println(json);
//		json = consumoAPI.getData("https://coffee.alexflipnote.dev/random.json");
		System.out.println(json);

		DataConvert dataConvert = new DataConvert();
		DataSeries data = dataConvert.getData(json, DataSeries.class);
		System.out.println(data);
	}
}
