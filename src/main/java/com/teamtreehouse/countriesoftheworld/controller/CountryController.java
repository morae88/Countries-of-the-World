package com.teamtreehouse.countriesoftheworld.controller;

import com.teamtreehouse.countriesoftheworld.data.CountryRepository;
import com.teamtreehouse.countriesoftheworld.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/")
public class CountryController {

    @Autowired
    private CountryRepository countryRepository;

    @RequestMapping("/")
    public String listCountries(ModelMap modelMap){
        List<Country> allCountries = countryRepository.getAllCountries();
        modelMap.put("countries", allCountries);
        return "index";
    }

    @RequestMapping("/country/{name}")
    public String countryDetails(@PathVariable String name, ModelMap modelMap) {
        Country country = countryRepository.findByName(name);
        modelMap.put("country", country);
        return "country-details";
    }



    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String sortCountries(@RequestParam("sort") String sorter, ModelMap modelMap) {
        List<Country> allCountries = countryRepository.getAllCountries();
        allCountries = sortBy(sorter, allCountries);
        modelMap.put("countries", allCountries);
        return "index";




 }

    private List<Country> sortBy(String sorter, List<Country> countries) {
        if (sorter.equals("Country Name")) Collections.sort(countries, Country.nameCompare);

        if (sorter.equals("Population")) Collections.sort(countries, Country.popCompare);

        return countries;
    }
}
