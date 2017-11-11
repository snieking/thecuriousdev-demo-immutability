package org.thecuriousdev.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {
        mutableCityTest();
        immutableCityTest();
        mutableFoodListTest();
        immutableFoodListTest();
    }

    public static void mutableCityTest() {
        System.out.println("### Mutable City Test ###");
        MutablePerson mutablePerson = new MutablePerson("Viktor", "Stockholm", Arrays.asList("Pizza", "Tacos", "Steak"));

        new Thread(() -> {
            try {
                Thread.sleep(5); // Simulate some work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mutablePerson.setCity("Gothenburg");
        }).start();

        if ("Stockholm".equals(mutablePerson.getCity())) {
            try {
                Thread.sleep(10); // Simulate some work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Viktor lives in " + mutablePerson.getCity() + "\n");
        }
    }

    public static void immutableCityTest() {
        System.out.println("### Immutable City Test ###");
        ImmutablePerson immutablePerson = ImmutablePerson.builder()
                .withName("Viktor")
                .withCity("Stockholm")
                .withFavoriteDishes(Arrays.asList("Pizza", "Tacos", "Steak"))
                .build();

        new Thread(() -> {
            try {
                Thread.sleep(5); // Simulate some work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            immutablePerson.toBuilder()
                    .withCity("Gothenburg")
                    .build();
        }).start();

        if ("Stockholm".equals(immutablePerson.getCity())) {
            try {
                Thread.sleep(10); // Simulate some work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Viktor lives in " + immutablePerson.getCity() + "\n");
        }
    }

    public static void mutableFoodListTest() {
        System.out.println("### Mutable Food List Test ###");
        List<String> dishes = new ArrayList<>();
        dishes.add("Pizza");
        dishes.add("Tacos");
        dishes.add("Steak");

        MutablePerson mutablePerson1 = new MutablePerson("Viktor", "Stockholm", dishes);
        MutablePerson mutablePerson2 = new MutablePerson("Anastasia", "Stockholm", mutablePerson1.getFavoriteDishes());

        mutablePerson2.getFavoriteDishes().add("Sushi");

        for (String dish : mutablePerson1.getFavoriteDishes()) {
            System.out.println(dish);
        }

        System.out.println("");
    }

    public static void immutableFoodListTest() {
        System.out.println("### Immutable Food List Test ###");
        List<String> dishes = new ArrayList<>();
        dishes.add("Pizza");
        dishes.add("Tacos");
        dishes.add("Steak");

        ImmutablePerson immutablePerson1 = ImmutablePerson.builder()
                .withName("Viktor")
                .withCity("Stockholm")
                .withFavoriteDishes(dishes)
                .build();

        ImmutablePerson immutablePerson2 = ImmutablePerson.builder()
                .withName("Anastasia")
                .withCity("Stockholm")
                .withFavoriteDishes(immutablePerson1.getFavoriteDishes())
                .build();

        immutablePerson2.addFavoriteDish("Sushi");

        for (String dish : immutablePerson1.getFavoriteDishes()) {
            System.out.println(dish);
        }
    }
}
