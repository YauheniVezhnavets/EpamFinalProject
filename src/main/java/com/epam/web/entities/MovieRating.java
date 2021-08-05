package com.epam.web.entities;

public class MovieRating implements Identifiable {

    private final long id;
    private final long movieId;
    private final long userId;
    private final double rating;


    public MovieRating(long id, long movieId, long userId, double rating) {
        this.id = id;
        this.movieId = movieId;
        this.userId = userId;
        this.rating = rating;
    }

    public long getId() {
        return id;
    }

    public long getMovieId() {
        return movieId;
    }

    public long getUserId() {
        return userId;
    }

    public double getRating() {
        return rating;
    }
}
