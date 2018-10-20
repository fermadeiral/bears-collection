package controller.map;

import model.map.Country;
import model.map.GeographicalMap;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * this class is made to test CountryController
 * @author Mina
 * @see CountryController
 */
public class CountryControllerTest {
    private CountryController countryController;
    private HashMap<String, Country> countries;

    /**
     * this method is written to initial the variables
     */
    @Before
    public void initial() {
        countryController = new CountryController();
        String mapFileName = "test.map";
        GeographicalMapController geographicalMapController = new GeographicalMapController();
        GeographicalMap geographicalMap = geographicalMapController.parseMapFile(geographicalMapController.getMapPath(mapFileName));
        countries = geographicalMap.getCountries();

    }


    /**
     * method for testing the find the country and information of it
     */
    @Test
    public void testFindCountryByName() {
        Country country = countryController.findCountryByName("Cockpit02", countries);
        assertNotNull(country);
        assertEquals(4, country.getAdjacentCountries().size());
        Country countryNull = countryController.findCountryByName("nullTest", countries);
        assertNull(countryNull);

    }


}
