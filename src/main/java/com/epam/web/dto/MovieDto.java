package com.epam.web.dto;

import com.epam.web.entities.Review;

import java.util.List;

public class MovieDto {

    private final Long id;
    private final String name;
    private final String pathToImage;
    private final String description;
    private final String genre;
    private final String rating;
    private final List <Review> movieReviews;


    public MovieDto(Long id, String name, String pathToImage, String description, String genre, String rating, List<Review> movieReviews) {
        this.id = id;
        this.name = name;
        this.pathToImage = pathToImage;
        this.description = description;
        this.genre = genre;
        this.rating = rating;
        this.movieReviews = movieReviews;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPathToImage() {
        return pathToImage;
    }

    public String getDescription() {
        return description;
    }

    public String getGenre() {
        return genre;
    }

    public String getRating() {
        return rating;
    }

    public List<Review> getMovieReviews() {
        return movieReviews;
    }
}
