package eu.albertomorales.spa.country.repository;

import eu.albertomorales.spa.country.exception.CountryNotFoundException;
import eu.albertomorales.spa.country.model.Country;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;


@Repository
public interface CountryRepository extends CrudRepository<Country, String> {}