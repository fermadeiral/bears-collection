package controller;

import controller.map.*;
import model.card.CardTest;
import model.map.ContinentTest;
import model.map.CountryTest;
import model.map.GeographicalMapTest;
import model.player.PlayerTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import view.InitialViewTest;
import view.MapViewTest;

/**
 * this is the suit class of test classes
 */
@RunWith(Suite.class)
@SuiteClasses({CheckConnectivityControllerTest.class,
        CheckValidityControllerTest.class,
        ContinentControllerTest.class,
        CountryControllerTest.class,
        GeographicalMapControllerTest.class,
        RollTheDiceTest.class,
        SelectPlayerControllerTest.class

})
public class AppTest {
}