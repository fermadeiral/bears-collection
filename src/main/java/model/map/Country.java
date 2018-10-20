package model.map;

import model.player.Player;
import org.graphstream.graph.implementations.AdjacencyListNode;
import org.graphstream.ui.graphicGraph.stylesheet.StyleConstants;
import org.graphstream.ui.spriteManager.Sprite;
import org.graphstream.ui.spriteManager.SpriteManager;

import java.util.List;
import java.util.UUID;

/**
 * this class is made for the object of the country
 * @author  Napoleon
 */
public class Country extends AdjacencyListNode{
    private String name;
    private List<Country> adjacentCountries; // list of the adjacent countries
    private Player owner; //the owner of the country
    private int armyCount; // the number of army
    private int latitude; //latitude of the country in the map (it is not used)
    private int longitude;//longitude of the country in the map (it is not used)
    private int order;//this field is used for checking the connectivity of countries
    private int continentOrder;//this field is used for checking the connectivity in continent

    /**
     * constructor of the class
     * @param name the name of the country
     * @param graph the instance of the graph
     */
    public Country(String name, GeographicalMap graph){
        super(graph, UUID.randomUUID().toString());
        this.name = name;
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

    public List<Country> getAdjacentCountries() {
        return adjacentCountries;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner, GeographicalMap map) {
        this.owner = owner;
    }

    public int getArmyCount() {
        return armyCount;
    }

    public void setArmyCount(int armyCount) {
        this.armyCount = armyCount;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public void setAdjacentCountries(List<Country> adjacentCountries) {
        this.adjacentCountries = adjacentCountries;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getContinentOrder() {
        return continentOrder;
    }

    public void setContinentOrder(int continentOrder) {
        this.continentOrder = continentOrder;
    }

    public void increaseArmy(int incrementValue){
        this.armyCount += incrementValue;
    }
    public void decreaseArmy(int incrementValue){
        this.armyCount -= incrementValue;
    }
}
