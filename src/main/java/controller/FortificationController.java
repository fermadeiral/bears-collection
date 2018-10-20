package controller;

import model.map.Country;
import model.player.Player;

import java.util.ArrayList;

/**
 *
 * This class calculates countries for fortification
 *
 * @author Mahedi
 */

public class FortificationController {

    public FortificationController(){

    }
    public ArrayList<Country> getFortificationCountries(Country country){
        ArrayList<Country> fortCountries = new ArrayList<>();
        Player owner = country.getOwner();
        for (Country tmpCountry : country.getAdjacentCountries()){
            tmpCountry.getName();
            if (owner.getId().equals(tmpCountry.getOwner().getId())){
                fortCountries.add(tmpCountry);
            }
        }
        return fortCountries;
    }
}
