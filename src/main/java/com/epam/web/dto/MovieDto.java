package com.epam.web.dto;

import com.epam.web.entities.Movie;
import com.epam.web.entities.Review;

import java.time.LocalDateTime;
import java.util.List;

public class MovieDto {

    private Long id;
    private String name;
    private String pathToImage;
    private String description;
    private Long genreId;
    private Double rating;
    private List <Review> movieReviews;

    public MovieDto() {
    }

        public MovieDto(Movie movie, Double rating, List<Review> movieReviews) {

        this.id = movie.getId();
        this.name = movie.getName();
        this.pathToImage = movie.getPathToImage();
        this.description = movie.getDescription();
        this.genreId = movie.getGenreId();
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

    public Long getGenre() {
        return genreId;
    }

    public Double getRating() {
        return rating;
    }

    public List<Review> getMovieReviews() {
        return movieReviews;
    }

    @Override
    public String toString() {
        return "MovieDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pathToImage='" + pathToImage + '\'' +
                ", description='" + description + '\'' +
                ", genreId=" + genreId +
                ", rating=" + rating +
                ", movieReviews=" + movieReviews +
                '}';
    }
}
