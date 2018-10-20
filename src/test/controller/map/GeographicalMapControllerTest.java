package controller.map;

import model.map.Continent;
import model.map.Country;
import model.player.Player;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * for testing the methods of class of GeographicalMapController
 *
 * @author Mina
 * @see GeographicalMapController
 */
public class GeographicalMapControllerTest {
    private GeographicalMapController geographicalMapController;
    private String mapFileName;
    private String mapPath;

    private CountryController countryController;
    private ContinentController continentController;
    private Country country;
    private Continent continent;

    /**
     * this method is written to initial the variables
     */
    @Before
    public void initial() {
        geographicalMapController = new GeographicalMapController();
        mapFileName = "test.map";
        mapPath = geographicalMapController.getMapPath(mapFileName);
        countryController = new CountryController();
        continentController = new ContinentController();

        geographicalMapController.geographicalMap = geographicalMapController.parseMapFile(mapPath);

        country = countryController.findCountryByName("Cockpit02", geographicalMapController.geographicalMap.getCountries());
        continent = continentController.findContinentByName("Cockpit", geographicalMapController.geographicalMap.getContinents());

    }


    /**
     * method for testing the pars of file Completely
     */
    @Test
    public void testParseMapFile() {

        // for testing parseMapInfo
        assertEquals("Dustwhirl", geographicalMapController.geographicalMap.getAuthor());// for testing parseMapInfo
        assertEquals(Boolean.TRUE, geographicalMapController.geographicalMap.getWarn());// for testing parseMapInfo
        assertEquals(Boolean.FALSE, geographicalMapController.geographicalMap.getWrap());// for testing parseMapInfo
        assertEquals("Aden.bmp", geographicalMapController.geographicalMap.getImageName());// for testing parseMapInfo
        assertEquals("none", geographicalMapController.geographicalMap.getScroll());


        //for testing the  p
    }

    /**
     * this method is made to parse  FileToFindCountriesByContinent
     */
    @Test
    public void testParseileToFindCountriesByContinent() {

        assertEquals(9, continent.getCountries().size());
    }

    /**
     * this method is made to parse Countries
     */
    @Test
    public void testParseCountries() {
        assertEquals(99, geographicalMapController.geographicalMap.getCountries().size());
        assertNotNull(country);
        assertEquals("Cockpit02", country.getName());
        assertEquals(375, country.getLongitude());
        assertEquals(658, country.getLatitude());
    }

    /**
     * this method is made to parse Continent
     */
    @Test
    public void testParseContinent() {
        assertNotNull(continent);
        assertEquals(5, continent.getControlValue());
        assertEquals("Cockpit", continent.getName());
        assertEquals(8, geographicalMapController.geographicalMap.getContinents().size());
    }


    /**
     * this method is made to parse adjacent
     */
    @Test
    public void testParseAdjacent() {

        assertEquals(4, country.getAdjacentCountries().size());
    }


    /**
     * it tests the number of armies to be distributed in each player
     */
    @Test
    public void testAssignArmies() {

        ArrayList<Player> players = new ArrayList<Player>();
        players.add(new Player("one"));
        players.add(new Player("two"));

        geographicalMapController.assignCountries(players);
        geographicalMapController.assignArmies(players);

        Iterator it = geographicalMapController.geographicalMap.getCountries().entrySet().iterator();
        Map.Entry pair = (Map.Entry) it.next();
        Country country = (Country) pair.getValue();
        Player player = country.getOwner();

        assertNotNull(player.getTotalReservedArmies());
        assertTrue(0 < player.getTotalArmiesOwn());

        country = (Country) ((Map.Entry) it.next()).getValue();
        assertTrue(0 < country.getOwner().getTotalArmiesOwn());

    }
}
