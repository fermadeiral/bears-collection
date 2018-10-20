package model.map;

import model.player.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * this class is made for the class of continent
 *
 * @author Napoleon
 */
public class Continent {

    private String id;
    private String name;
    private List<Country> adjacentContinents;
    private HashMap<String, Country> countries;//hashMap of countries of the continent
    private Player owner;
    private int controlValue; //the control value of the continent

    /**
     * constructor of the class
     *
     * @param name         string name of the continent
     * @param controlValue int value of the control value
     */
    public Continent(String name, int controlValue) {
        this.id = UUID.randomUUID().toString();//make random id
        this.name = name;
        this.controlValue = controlValue;
        this.adjacentContinents = new ArrayList<Country>();
        this.countries = new HashMap<String, Country>();
    }


    /**
     * constructor of the class
     *
     * @param name         string name of the continent
     * @param controlValue int value of the control value
     * @param countries    the hashmap of countries
     */
    public Continent(String name, HashMap<String, Country> countries, int controlValue) {
        this.id = UUID.randomUUID().toString();//make random id
        this.name = name;
        this.controlValue = controlValue;
        this.adjacentContinents = new ArrayList<Country>();
        this.countries = countries;
    }

    /**
     * constructor of the class
     *
     * @param name               string name of the continent
     * @param controlValue       int value of the control value
     * @param adjacentContinents the list of adjacent country
     * @param countries          the countries of the continent
     * @param player             the instance of the player
     */
    public Continent(String name, List<Country> adjacentContinents, HashMap<String, Country> countries, Player player, int controlValue) {
        this.id = UUID.randomUUID().toString();//make random id
        this.name = name;
        this.adjacentContinents = adjacentContinents;
        this.countries = countries;
        this.owner = player;
        this.controlValue = controlValue;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Country> getAdjacentContinents() {
        return adjacentContinents;
    }

    public HashMap<String, Country> getCountries() {
        return countries;
    }

    public void setCountries(HashMap<String, Country> countries) {
        this.countries = countries;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public int getControlValue() {
        return controlValue;
    }

    public void setControlValue(int controlValue) {
        this.controlValue = controlValue;
    }
}
