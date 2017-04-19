package com.teamtreehouse.countriesoftheworld.data;

import com.teamtreehouse.countriesoftheworld.model.Country;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class CountryRepository {
    private static List<String> denmark =  Arrays.asList("Danish", "German", "English");
    private static List<String> france =  Arrays.asList("French");
    private static List<String> singapore =  Arrays.asList("Mandarin", "English", "Malay");
    private static List<String> taiwan = Arrays.asList("Chinese (Mandarin)", "Taiwanese", "Hakka dialects");
    private static List<String> argentina = Arrays.asList("Spanish", "English", "Italian", "German", "French");

    public static final List<Country> ALL_COUNTRIES = Arrays.asList(
            new Country("Denmark", "5,707,420", "Copenhagen",denmark),
            new Country("France", "64,882,024", "Paris", france),
            new Country("Singapore", "5,766,013", "Singapore", singapore ),
            new Country("Taiwan", "23,403,259", "Taipei", taiwan),
            new Country("Argentina","44,182,926", "Buenos Aires", argentina)
    );

    public List<Country> getAllCountries() {
        return ALL_COUNTRIES;
    }

    public Country findByName(String name) {
//        for (Country country: ALL_COUNTRIES){
//            if(country.getName().equals(name)){
//                return country;
//            }
//        }
//        return null;

        return ALL_COUNTRIES.stream()
                .filter(country -> name.equals(country.getName()))
                .findFirst()
                .orElse(null);
    }


}

