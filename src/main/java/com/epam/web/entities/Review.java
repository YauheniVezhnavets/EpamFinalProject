package com.epam.web.entities;

public class Review implements Identifiable {

    private final Long id;
    private final Long userId;
    private final Long movieId;
    private final String review;


    public Review(Long id, Long userId, Long movieId, String review) {
        this.id = id;
        this.userId = userId;
        this.movieId = movieId;
        this.review = review;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }


    public Long getMovieId() {
        return movieId;
    }

    public String getReview() {
        return review;
    }
}
