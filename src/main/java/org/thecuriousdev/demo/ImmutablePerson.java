package org.thecuriousdev.demo;

import java.util.ArrayList;
import java.util.List;

public class ImmutablePerson {

    private final String name;
    private final String city;
    private final List<String> favoriteDishes;

    private ImmutablePerson(Builder builder) {
        this.name = builder.name;
        this.city = builder.city;
        this.favoriteDishes = builder.favoriteDishes;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public List<String> getFavoriteDishes() {
        return favoriteDishes != null ? new ArrayList<>(favoriteDishes) : null;
    }

    public void addFavoriteDish(String dish) {
        favoriteDishes.add(dish);
    }

    public Builder toBuilder() {
        return new Builder(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {

        private String name;
        private String city;
        private List<String> favoriteDishes;

        public Builder() {
            // Empty constructor
        }

        public Builder(ImmutablePerson person) {
            this.name = person.name;
            this.city = person.city;
            this.favoriteDishes = person.favoriteDishes != null ? new ArrayList<>(person.favoriteDishes) : null;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withCity(String city) {
            this.city = city;
            return this;
        }

        public Builder withFavoriteDishes(List<String> dishes) {
            this.favoriteDishes = dishes != null ? new ArrayList<>(dishes) : null;
            return this;
        }

        public ImmutablePerson build() {
            return new ImmutablePerson(this);
        }
    }
}
