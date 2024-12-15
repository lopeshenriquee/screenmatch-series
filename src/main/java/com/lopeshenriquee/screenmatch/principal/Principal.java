package com.lopeshenriquee.screenmatch.principal;

import com.lopeshenriquee.screenmatch.model.DataEpisodes;
import com.lopeshenriquee.screenmatch.model.DataSeason;
import com.lopeshenriquee.screenmatch.model.DataSeries;
import com.lopeshenriquee.screenmatch.model.Episodes;
import com.lopeshenriquee.screenmatch.service.ConsumoAPI;
import com.lopeshenriquee.screenmatch.service.DataConvert;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    private Scanner scan = new Scanner(System.in);

    private ConsumoAPI consumptionAPI = new ConsumoAPI();

    private DataConvert dataConvert = new DataConvert();

    private final String ADRESS = "https://www.omdbapi.com/?t=";

    private final String APIKEY = "&apikey=9287c99a";

    public void showMenu(){
        System.out.println("Digite o nome da série");
        var nameSerie = scan.nextLine();

        var jsonGeneral = consumptionAPI.obterDados(ADRESS + nameSerie.replace(" ", "+") + APIKEY);

        DataSeries data1 = dataConvert.getData(jsonGeneral, DataSeries.class);
        System.out.println(data1);

        List<DataSeason> seasonsList = new ArrayList<>();

		for (int i = 1; i <= data1.totalSeasons() ; i++) { //https://www.omdbapi.com/?t=gilmore+girls&Season="+ i +"&apikey=9287c99a"
			var jsonSeason = consumptionAPI.obterDados(ADRESS + nameSerie.replace(" ", "+")+ "&Season="+ i + APIKEY);
			DataSeason data2 = dataConvert.getData(jsonSeason, DataSeason.class);
			seasonsList.add(data2);
		}
		seasonsList.forEach(System.out::println);

//        for (int i = 0; i < data1.totalSeasons(); i++){
//            List<DataEpisodes> episodesList = seasonsList.get(i).episodes();
//            for (int j = 0; j < episodesList.size(); j++) {
//                System.out.println(episodesList.get(j).title());
//            }
//        }

        seasonsList.forEach(s -> s.episodes().forEach(e -> System.out.println(e.title())));

        //Lista ordenada de todos os ep
        List<DataEpisodes> dataEpisodesList = seasonsList.stream()
                .flatMap(s -> s.episodes().stream())
                .collect(Collectors.toList()); //é mutável

        //TOP5
        dataEpisodesList.stream()
                .filter(e -> !e.imdbRating().equalsIgnoreCase("N/A"))
                .sorted(Comparator.comparing(DataEpisodes::imdbRating).reversed())
                .limit(5)
                .forEach(System.out::println);

        List<Episodes> episodes = seasonsList.stream()
                .flatMap(season -> season.episodes().stream()
                        .map(dataEpisode -> new Episodes(season.season(), dataEpisode))
                ).collect(Collectors.toList());

        episodes.forEach(System.out::println);
    }
}
