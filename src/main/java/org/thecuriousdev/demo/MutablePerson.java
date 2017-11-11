package org.thecuriousdev.demo;

import java.util.List;

public class MutablePerson {

    private String name;
    private String city;
    private List<String> favoriteDishes;

    public MutablePerson(String name, String city, List<String> favoriteDishes) {
        this.name = name;
        this.city = city;
        this.favoriteDishes = favoriteDishes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<String> getFavoriteDishes() {
        return favoriteDishes;
    }

    public void setFavoriteDishes(List<String> favoriteDishes) {
        this.favoriteDishes = favoriteDishes;
    }
}
