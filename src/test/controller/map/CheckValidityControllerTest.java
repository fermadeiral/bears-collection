package controller.map;
import exception.InvalidRiskMapException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

/**
 * this class is made to test CheckValidityController
 * @author Mina
 * @see CheckValidityController
 */
public class CheckValidityControllerTest {
   private CheckValidityController checkValidityController;
   private GeographicalMapController geographicalMapController;
   private String mapFileInvalidName;
   private String mapFileValidName;

    /**
     * this method is written to initial the variables
     */
    @Before
    public void initial() {
        checkValidityController = new CheckValidityController();
        geographicalMapController = new GeographicalMapController();
        mapFileInvalidName = "InvalidFile.map";
        mapFileValidName = "test.map";
    }



    /**
     * method for testing the pars of file Completely
     */
    @Test
    public void testParseMapFileValidFile() {
        try {
            Boolean isValidFile = checkValidityController.isValidFile(geographicalMapController.getMapPath(mapFileValidName));
            assertTrue(isValidFile);
        } catch (InvalidRiskMapException e) {
            e.printStackTrace();
        }
    }

    @Test(expected = InvalidRiskMapException.class)
    public void testParseMapFileinvalidFile() throws InvalidRiskMapException {
        Boolean isValidFile = checkValidityController.isValidFile(geographicalMapController.getMapPath(mapFileInvalidName));
        assertTrue(isValidFile);
    }

}
