package controller.play;

import controller.map.GeographicalMapController;
import model.map.Country;
import model.player.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

public class CalculateReinforcementTest {

    private GeographicalMapController geographicalMapController;
    private String mapFileName;
    private CalculateReinforcement calculateReinforcement;
    private String mapPath;


    @Before
    public void init(){
        calculateReinforcement = new CalculateReinforcement();
        geographicalMapController = new GeographicalMapController();
        mapFileName = "test.map";
        mapPath = geographicalMapController.getMapPath(mapFileName);
        geographicalMapController.geographicalMap = geographicalMapController.parseMapFile(mapPath);
    }

    @Test
    public void testCalculate(){
        ArrayList<Player> players = new ArrayList<Player>();
        players.add(new Player("one"));
        players.add(new Player("two"));

        geographicalMapController.assignArmies(players);
        geographicalMapController.distributeCountriesAndArmies(players);
        geographicalMapController.assignArmies(players);
        calculateReinforcement.calculate(geographicalMapController, players);

        assertTrue(players.get(0).getTotalReservedArmies() > 0);
        assertFalse(players.get(0).getTotalReservedArmies() > players.get(0).getTotalArmiesOwn());
    }
}