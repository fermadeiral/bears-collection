package controller;

import model.map.GeographicalMap;
import model.player.Player;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * This class provides the directory for game_history.txt and
 * calculates the value for player selection dropdown.
 *
 * @author Mahedi Hassan
 */

public class PlayerController {

    public ArrayList<Player> players;

    /**
     * the constructor of the class
     */
    public PlayerController() {
        players = new ArrayList<Player>();
    }

    /**
     * this method is wriiten for getting the players number for filling the combobox of the player
     * @param geographicalMap the instance of the geographicalMap
     * @return the array of string of number of possible players
     */
    public String[] getPlayerOptions(GeographicalMap geographicalMap) {
        int maxUsers = geographicalMap.getNodeCount() > 6 ? 6 : geographicalMap.getNodeCount();
        String[] players = new String[maxUsers];
        for (int i = 0; i < maxUsers; i++) {
            players[i] = (i + 1) + "";
        }
        return players;
    }

    /**
     * this method is written to init the players
     * @param numOfPlayers int number of player
     */
    public void initUsers(int numOfPlayers) {
        players = new ArrayList<Player>();
        for (int x = 0; x < numOfPlayers; x++) {
            players.add(new Player("Player " + (x + 1)));
        }
    }

    /**
     * this method is written to get the players options
     * @return list of players
     */
    public ArrayList<Player> getPlayerOptions() {
        return players;
    }

    //TODO: Figure out how to integrate with Map
//    /**
//     *
//     * This method calculates the number of items should be for the drop-drop of select players
//     * It reads the game_history.txt file to measure the items
//     *
//     * @param playerFile takes file for game_history.txt
//     * @return the items for select players drop-down
//     */
//    public String[] getNumberOfPlayers(File playerFile){
//        Scanner scanner = null;
//        int numberOfPlayers = 0;
//        int totalCountry = 0;
//        try {
//            scanner = new Scanner(playerFile);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        while (scanner.hasNext()){
//
//            String tmpInfo = scanner.nextLine().trim();
//            String[] tmpInfoAry = tmpInfo.split(" ");
//            if (tmpInfoAry[0].contains("total_country")){
//                totalCountry = Integer.parseInt(tmpInfoAry[1]);
//            }
//            if (tmpInfoAry[0].equals("user")){
//                numberOfPlayers ++;
//            }
//        }
//        if(numberOfPlayers == 0 && totalCountry >= 6){
//            return new String[] {"2", "3", "4", "5", "6"};
//        }
//        else if (numberOfPlayers == 0 && totalCountry < 6){
//            String[] tmpPlayers = new String[totalCountry - 1];
//            for (int i = 0; i < tmpPlayers.length; i++){
//                tmpPlayers [i] = i + 2 + "";
//            }
//            return tmpPlayers;
//        }
//        else {
//            String[] tmpPlayers = new String[numberOfPlayers - 1];
//            for (int i = 0; i < tmpPlayers.length; i++){
//                tmpPlayers [i] = i + 2 + "";
//            }
//            return tmpPlayers;
//        }
//    }
//
//
//    /**
//     *
//     * This method plays role to retrieve the file location of the Game History
//     *
//     * @return the directory of the game_history.txt file
//     */
//    public String getFileLocation(){
//        String directory = System.getProperty("user.dir");
//        return directory + "/src/main/history/file/game_history.txt";
//    }


}
