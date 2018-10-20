package controller.map;


import model.map.GeographicalMap;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * this class is made to test CheckConnectivityController
 * @author Mina
 * @see CheckConnectivityController
 */
public class CheckConnectivityControllerTest {

    private CheckConnectivityController checkConnectivityController;


    /**
     * this method is written to initial the variables
     */
    @Before
    public void initial() {
        checkConnectivityController = new CheckConnectivityController();
    }


    /**
     * method for testing the connectivity of Maps
     */
    @Test
    public void testIsGraphConnected() {
        GeographicalMapController geographicalMapController = new GeographicalMapController();
        String mapFileName = "test.map";
        GeographicalMap geographicalMap = geographicalMapController.parseMapFile(geographicalMapController.getMapPath(mapFileName));
        Boolean isConnected = checkConnectivityController.isGraphConnectedTotally(geographicalMap);
        assertNotNull(isConnected);
        assertTrue(isConnected);


        mapFileName = "unconnectedContinent.map";
        geographicalMap = geographicalMapController.parseMapFile(geographicalMapController.getMapPath(mapFileName));
        isConnected = checkConnectivityController.isGraphConnectedTotally(geographicalMap);
        assertNotNull(isConnected);
        assertFalse(isConnected);


        mapFileName = "unconnectedCountry.map";
        geographicalMap = geographicalMapController.parseMapFile(geographicalMapController.getMapPath(mapFileName));
        isConnected = checkConnectivityController.isGraphConnectedTotally(geographicalMap);
        assertNotNull(isConnected);
        assertFalse(isConnected);

    }


}
