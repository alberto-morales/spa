package eu.albertomorales.spa.country.controller;

import eu.albertomorales.spa.country.exception.CountryNotFoundException;
import eu.albertomorales.spa.country.model.Country;
import eu.albertomorales.spa.country.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/countries")
public class CountryController {

    private final CountryRepository repository;

    @Autowired
    public CountryController(CountryRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Country> findAll() {
        List<Country> result = new ArrayList<Country>();
        repository.findAll().forEach(result::add);
        return result;
    }

    @GetMapping("/{id}")
    public Country findById(@PathVariable String id) throws CountryNotFoundException {
        return repository.findById(id).orElseThrow(CountryNotFoundException::new);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Country create(@Valid @RequestBody Country country) {
        return repository.save(country);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody Country country, @PathVariable String id) {
        repository.save(country);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        repository.deleteById(id);
    }

}
