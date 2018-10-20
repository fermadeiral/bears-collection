package model.player;

import model.map.Country;

import java.util.HashMap;
import java.util.UUID;

/**
 * this class is made for Object of player
 */
public class Player{
    private String id;
    private String name;
    private HashMap<String, Country> countries;
    private int totalReservedArmies; //armies under no country
    private int totalArmiesOwn = 0; //armies under no country + armies under country;

    /**
     * the constructor of the class of Player
     * @param name the String of name of the player
     */
    public Player(String name) {
        this.id = UUID.randomUUID().toString();//make random id
        this.name = name;
        this.countries = new HashMap<String, Country>();
    }

    public String getId() {
        return id;
    }

    public void assignCountry(Country country){
        this.countries.put(country.getId(), country);
    }

    public HashMap<String, Country> getCountries() {
        return countries;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTotalReservedArmies(int totalReservedArmies) {
        this.totalReservedArmies += totalReservedArmies;
        this.totalArmiesOwn = totalArmiesOwn + totalReservedArmies;
    }

    public void decreaseReservedArmy(int number){
        this.totalReservedArmies = totalReservedArmies - number;
    }

    public int getTotalReservedArmies() {
        return totalReservedArmies;
    }

    public int getTotalArmiesOwn() {
        return totalArmiesOwn;
    }

    public void decreaseOneArmy(){
        totalReservedArmies--;
    }
}
