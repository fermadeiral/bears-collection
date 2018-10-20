package controller;

import controller.map.GeographicalMapController;
import model.map.Country;
import model.player.Player;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;


/**
 * This class tests the {@link RollTheDice}
 *
 * @author Mahedi Hassan
 */

public class RollTheDiceTest {

    GeographicalMapController geographicalMapController;
    private RollTheDice rollTheDie;


    /**
     * this method is written to initial the variables
     */
    @Before
    public void init(){
        rollTheDie = new RollTheDice();
        geographicalMapController = new GeographicalMapController();
        geographicalMapController.geographicalMap = geographicalMapController.parseMapFile(geographicalMapController.getMapPath("test.map"));

    }

    /**
     * This method tests the roll method
     */
    @Test
    public void testRoll(){
        Player player = new Player("player 1");
        Country country = rollTheDie.roll(new ArrayList<Country>(geographicalMapController.geographicalMap.getCountries().values()), player);
        assertEquals(1, country.getArmyCount());
        assertNotNull(country);
        assertNotNull(country.getArmyCount());
    }
}
