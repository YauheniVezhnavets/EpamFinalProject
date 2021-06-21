package com.epam.web.entities;


public class Movie implements Identifiable{

    private Long id;
    private String name;
    private String pathToImage;
    private String description;
    private Long genreId;
    private double movieRating;
    private double [] listUpperAverageRating;
    private double [] listUnderAverageRating;


    public Movie(Long id, String name, String pathToImage, String description, Long genreId) {
        this.id = id;
        this.name = name;
        this.pathToImage = pathToImage;
        this.description = description;
        this.genreId = genreId;
        this.listUnderAverageRating = new double[3];
        this.listUpperAverageRating = new double[3];
        this.movieRating = 0;
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

    public Long getGenreId() {
        return genreId;
    }

    public double getMovieRating() {
        return movieRating;
    }

    public double[] getListUpperAverageRating() {
        return listUpperAverageRating;
    }

    public double[] getListUnderAverageRating() {
        return listUnderAverageRating;
    }


    public void setListUpperAverageRating(double[] listUpperAverageRating) {
        this.listUpperAverageRating = listUpperAverageRating;
    }

    public void setListUnderAverageRating(double[] listUnderAverageRating) {
        this.listUnderAverageRating = listUnderAverageRating;
    }
}
