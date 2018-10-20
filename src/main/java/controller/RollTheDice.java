package controller;

import model.map.Country;
import model.player.Player;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * This class shuffle the countries and assign to the player randomly
 *
 * @author Mahedi Hassan
 */

public class RollTheDice {

    public RollTheDice(){

    }

    /**
     * This method takes all unoccupied countries and pick one random country to assign to the requested country
     *
     * @param countries the list of countries
     * @param player the instance of the player
     * @return Country, which has been assigned
     */
    public Country roll(ArrayList<Country> countries, Player player){
        Collections.shuffle(countries);
        Country tmpCountry = countries.get(0);
        tmpCountry.setOwner(player, null);
        tmpCountry.increaseArmy(1);
        player.decreaseOneArmy();

        return countries.get(0);
    }
}
