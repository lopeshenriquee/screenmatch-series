package com.lopeshenriquee.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataEpisodes(@JsonAlias("Title") String title,
                           @JsonAlias("Episode") Integer number,
                           @JsonAlias("imdbRating") String imdbRating,
                           @JsonAlias("Release") String release) {
}
