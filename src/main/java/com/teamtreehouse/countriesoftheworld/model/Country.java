package com.teamtreehouse.countriesoftheworld.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Country{
    private String name;
    private String population;
    private String capitalCity;
    private List<String> languages = new ArrayList<>();

    public Country(String name, String population, String capitalCity, List<String> languages) {
        this.name = name;
        this.population = population;
        this.capitalCity = capitalCity;
        this.languages = languages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getCapitalCity() {
        return capitalCity;
    }

    public void setCapitalCity(String capitalCity) {
        this.capitalCity = capitalCity;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }


    public static Comparator<Country> nameCompare = new Comparator<Country>() {
        @Override
        public int compare(Country c1, Country c2) {
            String cName1 = c1.getName().toLowerCase();
            String cName2 = c2.getName().toLowerCase();
            return cName1.compareTo(cName2);
        }
    };

    public static Comparator<Country> popCompare = new Comparator<Country>() {
        @Override
        public int compare(Country c1, Country c2) {
            int pop1 = Integer.parseInt(c1.getPopulation().replaceAll(",", ""));
            int pop2 = Integer.parseInt(c2.getPopulation().replaceAll(",", ""));

            return pop1-pop2;
        }
    };

}
