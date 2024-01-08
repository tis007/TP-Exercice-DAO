package monprojet.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import monprojet.entity.City;
import monprojet.entity.Country;

// This will be AUTO IMPLEMENTED by Spring 

public interface CountryRepository extends JpaRepository<Country, Integer> {


    @Query(value = "SELECT SUM(City.population) as nbrPop FROM City INNER JOIN Country ON City.country_id=Country.id WHERE City.country_id= :countryCode", nativeQuery = true)
    public int NombrePopulation(Integer countryCode);

    @Query(value = "SELECT SUM(City.population) as population, Country.name as nomPays FROM City INNER JOIN Country ON City.country_id=Country.id GROUP BY City.population, City.name", nativeQuery = true)
    public List<CountryNamePopulation> ListCountries();

}
