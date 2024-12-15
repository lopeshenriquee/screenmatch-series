package com.lopeshenriquee.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record DataSerie(@JsonAlias("Title") String title,
                         @JsonAlias("totalSeasons")  Integer totalSeasons,
                         @JsonAlias("imdbRating")  String imdbRating) {
}
