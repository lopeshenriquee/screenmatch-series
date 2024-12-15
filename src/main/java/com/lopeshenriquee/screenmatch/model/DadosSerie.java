package com.lopeshenriquee.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record DadosSerie(@JsonAlias("Title") String title,
                         @JsonAlias("totalSeasons")  Integer totalSeasons,
                         @JsonAlias("imdbRating")  String imdbRating) {
}
