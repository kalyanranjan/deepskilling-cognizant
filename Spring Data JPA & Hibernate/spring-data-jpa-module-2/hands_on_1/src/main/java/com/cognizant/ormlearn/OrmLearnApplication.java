package com.cognizant.ormlearn;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;

@SpringBootApplication
public class OrmLearnApplication {

    private static CountryService countryService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        countryService = context.getBean(CountryService.class);

        testSearchByKeyword();
        testSearchByKeywordSorted();
        testSearchByLetter();
    }

    private static void testSearchByKeyword() {
        List<Country> countries = countryService.searchByKeyword("ou");
        System.out.println(countries);
    }

    private static void testSearchByKeywordSorted() {
        List<Country> countries = countryService.searchByKeywordSorted("ou");
        System.out.println(countries);
    }

    private static void testSearchByLetter() {
        List<Country> countries = countryService.searchByLetter("Z");
        System.out.println(countries);
    }
}
