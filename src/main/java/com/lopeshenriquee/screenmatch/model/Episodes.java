package com.lopeshenriquee.screenmatch.model;

import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Episodes {
    private Integer season;
    private String title;
    private Integer episodeNumber;
    private Double imdbRating;
    private LocalDate release;

    public Episodes(Integer numberSeason, DataEpisodes dataEpisodes){
        this.season = numberSeason;
        this.title = dataEpisodes.title();
        this.episodeNumber = dataEpisodes.episode();

        try {
            this.imdbRating = Double.valueOf(dataEpisodes.imdbRating());
        } catch (NumberFormatException e) {
            this.imdbRating = 0.0;
        }
        try {
            this.release = LocalDate.parse(dataEpisodes.release());
        } catch (DateTimeParseException e) {
            this.release = null;
        }
        }


    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    public Integer getEpisodeNumber() {
        return episodeNumber;
    }

    public void setEpisodeNumber(Integer episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    public Double getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(Double imdbRating) {
        this.imdbRating = imdbRating;
    }

    public LocalDate getRelease() {
        return release;
    }

    public void setRelease(LocalDate release) {
        this.release = release;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return
                "episodeNumber=" + episodeNumber +
                ", season=" + season +
                ", title='" + title + '\'' +
                ", imdbRating=" + imdbRating +
                ", release=" + release;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
