package com.epam.web.entities;


public class  Movie implements Identifiable {

    private Long id;
    private String name;
    private String pathToImage;
    private String description;
    private Long genreId;


    public Movie(Long id, String name, String pathToImage, String description, Long genreId) {
        this.id = id;
        this.name = name;
        this.pathToImage = pathToImage;
        this.description = description;
        this.genreId = genreId;
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


    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pathToImage='" + pathToImage + '\'' +
                ", description='" + description + '\'' +
                ", genreId=" + genreId +
                '}';
    }
}
