package com.epam.web.entities;


public class Review implements Identifiable {

    private final Long id;
    private final String review;
    private final Long userId;
    private final Long movieId;



    public Review(Long id, String review, Long userId, Long movieId) {
        this.id = id;
        this.review = review;
        this.userId = userId;
        this.movieId = movieId;
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
