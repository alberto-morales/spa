package eu.albertomorales.spa.country.repository;

import eu.albertomorales.spa.country.exception.CountryNotFoundException;
import eu.albertomorales.spa.country.model.Country;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CountryRepositoryBackup {

    List<Country> countries = new ArrayList<>();

    public List<Country> findAll() {
        return countries;
    }

    public Country findById(String id) throws CountryNotFoundException {
        return countries.stream().filter(country -> country.getId().equals(id)).findFirst().orElseThrow(CountryNotFoundException::new);
    }

    public Country create(Country country) {
        countries.add(country);
        return country;
    }

    public void update(Country country, String id) {
        Country existing = countries.stream().filter(s -> s.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Country not found"));
        int i = countries.indexOf(existing);
        countries.set(i, country);
    }

    public void delete(String id) {
        countries.removeIf(country -> country.getId().equals(id));
    }

}
