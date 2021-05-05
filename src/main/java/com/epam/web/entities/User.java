package com.epam.web.entities;

public class User implements Identifiable {

    private Long id;
    private String name;
    private String username;
    private String password;
    private Role role;
    private UserRating userRating;


    public User(Long id, String name, String username, String password, Role role, UserRating userRating) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.role = role;
        this.userRating = userRating;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public UserRating getUserRating() {
        return userRating;
    }
}
