package controller.play;
import controller.map.GeographicalMapController;
import model.map.Continent;
import model.map.Country;
import model.player.Player;
import java.util.*;

/**
 * this class is made to calculate the reinforcement
 * @author   Mahedi Hassan
 */
public class CalculateReinforcement {

    /**
     * this method is written to calculate of the reinforcement
     * @param mapController the controller of the map
     * @param players the list of players
     */
    public void calculate(GeographicalMapController mapController, ArrayList<Player> players){
        //checking if there is any single owner for a particular continent
        for (Continent continent : mapController.geographicalMap.getContinents().values()){
            Set<Player> owners = new HashSet<Player>(); // no duplicate owners
            for (Country country : continent.getCountries().values()){
                owners.add(country.getOwner());
            }
            if (owners.size() == 1){ //if Single owner
                Iterator<Player> tmpPlayers = owners.iterator();
                if (tmpPlayers.hasNext()){
                    Player player = tmpPlayers.next();
                    player.setTotalReservedArmies(continent.getControlValue());
                }
            }
        }
        for (Player player : players){
            int newArmies = player.getCountries().size() / 3;
            player.setTotalReservedArmies(newArmies < 3 ? 3 : newArmies);
        }
    }
}