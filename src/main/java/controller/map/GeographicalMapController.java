package controller.map;

import controller.RollTheDice;
import model.map.Continent;
import model.map.Country;
import model.map.GeographicalMap;
import model.player.Player;
import view.MessagePanel;

import java.io.*;
import java.util.*;


/**
 * This class is made for methods of related to GeographicalMap
 *
 * @author Mina
 */
public class GeographicalMapController {
    public GeographicalMap geographicalMap;

    /**
     * this is a constructor of a class with a geographicalMap param
     *
     * @param geographicalMap the instance of object of geographicalMap
     */
    public GeographicalMapController(GeographicalMap geographicalMap) {
        this.geographicalMap = geographicalMap;
        this.geographicalMap.addAttribute("ui.stylesheet", "node {size: 20px, 20px;}");
    }

    /**
     * this is a constructor of a class without a geographicalMap param
     */
    public GeographicalMapController() {
        this.geographicalMap = new GeographicalMap();
        this.geographicalMap.addAttribute("ui.stylesheet", "node {size: 20px, 20px;}");
    }

    /**
     * this method is written to set the geographicalMap
     *
     * @param geographicalMap the instance of object of geographicalMap
     */
    public void setGeographicalMap(GeographicalMap geographicalMap) {
        this.geographicalMap = geographicalMap;
        this.geographicalMap.addAttribute("ui.stylesheet", "node {size: 20px, 20px;}");
    }

    /**
     * This method is made for  extracting info from mapFile and setting the country , continent and adjacent
     *
     * @param filePath the path of file
     * @return GeographicalMap the instance of object of geographicalMap
     */
    public GeographicalMap parseMapFile(String filePath) {
        geographicalMap = new GeographicalMap();
        geographicalMap.setFilePath(filePath);
        File file = new File(filePath);
        parseMapInfo(file, geographicalMap);
        parseCountries(file, geographicalMap);
        //we have to parse Territories two times one for extract the countries , second for setting the adjuncies
        parseAdjacents(file);
        parseContinents(file);
        CheckConnectivityController checkConnectivityController = new CheckConnectivityController();
        checkConnectivityController.isGraphConnectedTotally(geographicalMap);
        return geographicalMap;
    }

    /**
     * Parse the selected mapfile and extract and the Map info.
     *
     * @param geographicalMap the instance of object of geographicalMap
     * @param fileOfMap       the  file of geographicalMap
     */
    private void parseMapInfo(File fileOfMap, GeographicalMap geographicalMap) {
        List<Continent> continentList = new ArrayList<Continent>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(fileOfMap);
        } catch (FileNotFoundException e) {
            MessagePanel.showMessage(e.getMessage(), MessagePanel.Type.Error);
        }
        if (scanner != null)
            while (scanner.hasNext()) {
                String tmp = scanner.nextLine().trim();
                if (tmp.equalsIgnoreCase("[Map]")) {
                    while (scanner.hasNextLine()) {
                        String mapInfo = scanner.nextLine().trim();
                        if (!mapInfo.equals("")
                                && mapInfo.contains("=")) {
                            String s = mapInfo.split("=")[0];
                            if ("author".equals(s)) {
                                geographicalMap.setAuthor(mapInfo.split("=")[1]);

                            } else if ("warn".equals(s)) {
                                geographicalMap.setWarn(!(mapInfo.split("=")[1]).equalsIgnoreCase("no"));

                            } else if ("image".equals(s)) {
                                geographicalMap.setImageName(mapInfo.split("=")[1]);

                            } else if ("wrap".equals(s)) {
                                geographicalMap.setWrap(!(mapInfo.split("=")[1]).equalsIgnoreCase("no"));

                            } else if ("scroll".equals(s)) {
                                geographicalMap.setScroll(mapInfo.split("=")[1]);

                            }

                        } else {
                            break;
                        }
                    }
                }
            }

    }

    /**
     * Parse the selected mapfile and extract the continentList.
     *
     * @param fileOfMap the  file of geographicalMap
     */
    private void parseContinents(File fileOfMap) {
        HashMap<String, Continent> continents = new HashMap<String, Continent>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(fileOfMap);
        } catch (FileNotFoundException e) {
            MessagePanel.showMessage(e.getMessage(), MessagePanel.Type.Error);

        }

        while (scanner.hasNext()) {
            String tmp = scanner.nextLine().trim();
            if (tmp.equalsIgnoreCase("[Continents]")) {
                while (scanner.hasNextLine()) {
                    String tmpC = scanner.nextLine().trim();
                    if (!tmpC.equals("") && tmpC.contains("=")) {
                        String continentName = tmpC.split("=")[0];
                        int continentControlValue = Integer.parseInt(tmpC.split("=")[1]);
                        HashMap<String, Country> countries = parseFileToFindCountriesByContinent(continentName, fileOfMap, geographicalMap);
                        Continent continent = new Continent(continentName, countries, continentControlValue);
                        continents.put(continent.getId(), continent);
                    } else {
                        if (!tmpC.equals("") && !tmpC.equals("[Territories]")) {
                            geographicalMap.setValid(Boolean.FALSE);
                        }
                        break;
                    }
                }
            }
        }
        geographicalMap.setContinents(continents);
    }

    /**
     * THis method is made to set the field of countries in a continent ,we need to list of countries
     *
     * @param continentName   the String of continent name
     * @param fileOfMap       the file of map
     * @param geographicalMap the instance of object of geographicalMap
     * @return Hash map of country
     */
    private HashMap<String, Country> parseFileToFindCountriesByContinent(String continentName, File fileOfMap, GeographicalMap geographicalMap) {
        CountryController countryController = new CountryController();
        HashMap<String, Country> countries = new HashMap<String, Country>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(fileOfMap);


            while (scanner.hasNext()) {
                String tmp = scanner.nextLine().trim();
                if (tmp.equalsIgnoreCase("[Territories]")) {
                    while (scanner.hasNextLine()) {
                        String tmpC = scanner.nextLine().trim();
                        if (!tmpC.equals("") && tmpC.contains(",")) {
                            if (tmpC.split(",")[3].equalsIgnoreCase(continentName)) {
                                Country country = countryController.findCountryByName(tmpC.split(",")[0], geographicalMap.getCountries());
                                if (country != null) {
                                    countries.put(country.getId(), country);
                                } else {
                                    geographicalMap.setValid(Boolean.FALSE);
                                    geographicalMap.setValidMessage(geographicalMap.getValidMessage() + " the country of " + country.getName() + " has not defined");
                                }
                            }

                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            MessagePanel.showMessage(e.getMessage(), MessagePanel.Type.Error);
            geographicalMap.setValid(Boolean.FALSE);
            geographicalMap.setValidMessage(geographicalMap.getValidMessage() + " there is a problem in parseFileToFindCountriesByContinent >>  " + e.getMessage());


        } catch (Exception e) {
            geographicalMap.setValid(Boolean.FALSE);
            geographicalMap.setValidMessage(geographicalMap.getValidMessage() + " there is a problem in parseFileToFindCountriesByContinent >>  " + e.getMessage());

        }

        return countries;
    }


    /**
     * This method is made for Parsing  the selected mapFile and extracting the countryList.
     *
     * @param geographicalMap the instance of object of geographicalMap
     * @param fileOfMap       the  file of geographicalMap
     */
    private void parseCountries(File fileOfMap, GeographicalMap geographicalMap) {
        Scanner scanner;
        try {
            scanner = new Scanner(fileOfMap);
            while (scanner.hasNext()) {
                String tmp = scanner.nextLine().trim();
                if (tmp.equalsIgnoreCase("[Territories]")) {
                    int order = 0;
                    while (scanner.hasNextLine()) {
                        String tmpC = scanner.nextLine().trim();
                        if (!tmpC.equals("") && tmpC.contains(",")) {
                            geographicalMap.addCountry(tmpC.split(","), order++);

                        }
                    }
                }
            }


        } catch (FileNotFoundException e) {
            MessagePanel.showMessage(e.getMessage(), MessagePanel.Type.Error);
            geographicalMap.setValid(Boolean.FALSE);
            geographicalMap.setValidMessage(geographicalMap.getValidMessage() + " there is a problem in parseCountries >>  " + e.getMessage());

        } catch (Exception e) {
            geographicalMap.setValid(Boolean.FALSE);
            geographicalMap.setValidMessage(geographicalMap.getValidMessage() + " there is a problem in parseCountries >>  " + e.getMessage());

        }
    }


    /**
     * this method is made for Parsing the selected mapFile and extract the adjacent of countries.
     *
     * @param fileOfMap the  file of geographicalMap
     */
    private void parseAdjacents(File fileOfMap) {
        CountryController countryController = new CountryController();
        Scanner scanner;
        try {
            scanner = new Scanner(fileOfMap);
            while (scanner.hasNext()) {
                String tmp = scanner.nextLine().trim();
                if (tmp.equalsIgnoreCase("[Territories]")) {
                    while (scanner.hasNextLine()) {
                        String tmpC = scanner.nextLine().trim();
                        if (!tmpC.equals("") && tmpC.contains(",")) {
                            String[] countryInfo = tmpC.split(",");
                            geographicalMap.addCountry(countryInfo, countryController);
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            MessagePanel.showMessage(e.getMessage(), MessagePanel.Type.Error);
            geographicalMap.setValid(Boolean.FALSE);
            geographicalMap.setValidMessage(geographicalMap.getValidMessage() + " there is a problem in parseAdjacents >>  " + e.getMessage());

        } catch (Exception e) {
            geographicalMap.setValid(Boolean.FALSE);
            geographicalMap.setValidMessage(geographicalMap.getValidMessage() + " there is a problem in parseAdjacents >>  " + e.getMessage());

        }
    }

    /**
     * method for returning the directory of map
     *
     * @return String of the mapDirectory
     */
    private String getFilesDirectory() {
        final String dir = System.getProperty("user.dir"); //getting the project current directory
        String mapDirectory = dir + "/src/main/files/";// set the directory for map files
        return mapDirectory;
    }

    /**
     * method for returning the directory of matrixFiles
     *
     * @return String of the matrixFileDirectory
     */
    public String getMatrixFileDirectory() {
        String matrixDirectory = getFilesDirectory() + "matrix";// set the directory for map files
        return matrixDirectory;
    }

    /**
     * method for returning the directory of mapFiles
     *
     * @return String of the mapFileDirectory
     */
    public String getMapFileDirectory() {
        String mapDirectory = getFilesDirectory() + "map";// set the directory for map files
        return mapDirectory;
    }

    /**
     * method for returning the directory of imageFiles
     *
     * @return String of the imageFileDirectory
     */
    public String getImageFileDirectory() {
        String imageDirectory = getFilesDirectory() + "image\\";// set the directory for image files
        return imageDirectory;
    }

    /**
     * method for returning the absolute path of mapFiles
     *
     * @param fileName the name of file
     * @return String of the mapFileDirectory
     */
    public String getMapPath(String fileName) {
        String mapPath = getMapFileDirectory() + "/" + fileName;
        return mapPath;
    }

    /**
     * method for assigning countries
     *
     * @param players list of players for assigning countries
     */
    public void assignCountries(ArrayList<Player> players) {
        HashMap<String, Country> countries = new HashMap<String, Country>(geographicalMap.getCountries());
        int currentPlayer = 0;
        while (!countries.isEmpty()) {
            assignCountryRandomly(players.get(currentPlayer), countries);
            if (currentPlayer >= players.size() - 1) {
                currentPlayer = 0;
            } else {
                currentPlayer++;
            }
        }
    }

    /**
     * method for assigning country randomly
     *
     * @param player    the instance of the player
     * @param countries the hashMap of countries
     */
    private void assignCountryRandomly(Player player, HashMap<String, Country> countries) {
        ArrayList<String> keys = new ArrayList<String>(countries.keySet());
        int countryIndex = new Random().nextInt(keys.size());
        String key = keys.get(countryIndex);
        Country country = countries.remove(key);
        country.setOwner(player, geographicalMap);
        player.assignCountry(country);
        geographicalMap.getNode(country.getId()).addAttribute("ui.label", player.getName());
        geographicalMap.addUpdateCountry(country);

    }

    /**
     * this method is written for adding a continent to map
     *
     * @param geographicalMap the instance of object of geographicalMap
     * @param continentName   the name of continent in String
     * @param controlValue    the value of control value in String
     */
    public void addContinentToGeographicalMap(GeographicalMap geographicalMap, String continentName, String controlValue) {
        if (geographicalMap.getContinents().size() >= 42) {
            MessagePanel.showMessage("the limit of the number of continents is 42 ", MessagePanel.Type.Error);
            geographicalMap.print();
            return ;
        }
        try {
            Continent continent = new Continent(continentName, Integer.valueOf(controlValue));
            geographicalMap.getContinents().put(continent.getId(), continent);
            MessagePanel.showMessage("your Continent was added successfully", MessagePanel.Type.Info);

        } catch (NumberFormatException e) {
            MessagePanel.showMessage(" Invalid Number ", MessagePanel.Type.Error);

        }
        geographicalMap.print();

    }

    /**
     * this method is written for Deleting a continent from map
     *
     * @param geographicalMap the instance of object of geographicalMap
     * @param continentName   the name of continent in String
     */
    public void deleteContinentFromGeographicalMap(GeographicalMap geographicalMap, String continentName) {
        ContinentController continentController = new ContinentController();
        Continent continent = continentController.findContinentByName(continentName, geographicalMap.getContinents());
        if (continent == null) {
            MessagePanel.showMessage("your continent is not exist", MessagePanel.Type.Error);
            return ;
        }
        if (continent.getCountries() != null && continent.getCountries().size() > 0) {
            Iterator it = continent.getCountries().entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                Country country = (Country) entry.getValue();
                deleteAllAdjacentOfACountry(geographicalMap, country);
                geographicalMap.getCountries().remove(country.getId(), country);

            }
        }
        geographicalMap.getContinents().remove(continent.getId(), continent);
        MessagePanel.showMessage("your continent was deleted successfully with their countries", MessagePanel.Type.Info);
        geographicalMap.print();
        return ;

    }


    /**
     * this method is written to delete all of adjacenty of the deleted country
     * @param geographicalMap the instance of object of geographicalMap
     * @param country the instance of deleted country
     */
    private void deleteAllAdjacentOfACountry(GeographicalMap geographicalMap, Country country) {
        if (geographicalMap != null) {
            if (geographicalMap.getCountries() != null && geographicalMap.getCountries().size() > 0) {
                Iterator it = geographicalMap.getCountries().entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    Country c = (Country) entry.getValue();
                    if (c.getAdjacentCountries() != null) {
                        for (Country ad : c.getAdjacentCountries()) {
                            if (ad.getId().equals(country.getId())) {
                                c.getAdjacentCountries().remove(ad);
                                break;
                            }
                        }
                    }

                }
            }
        }

    }

    /**
     * this method is written for Deleting a countryName from map
     *
     * @param geographicalMap the instance of object of geographicalMap
     * @param countryName     the name of country in String
     */
    public void deleteCountryFromGeographicalMap(GeographicalMap geographicalMap, String countryName) {
        CountryController countryController = new CountryController();
        Country country = countryController.findCountryByName(countryName, geographicalMap.getCountries());
        if (country == null) {
            MessagePanel.showMessage("your country is not exist", MessagePanel.Type.Error);
            return ;
        }

        if (geographicalMap.getCountries() != null && geographicalMap.getCountries().size() > 0) {//check if this country is a adjacent for others the adjacency must to delete
            Iterator it = geographicalMap.getCountries().entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                Country c = (Country) entry.getValue();
                if (c.getAdjacentCountries() != null && c.getAdjacentCountries().size() > 0) {
                    for (Country ad : c.getAdjacentCountries()) {
                        if (ad.getId().equals(country.getId())) {
                            c.getAdjacentCountries().remove(ad);
                            break;
                        }
                    }
                }
            }
        }


        geographicalMap.getCountries().remove(country.getId(), country);

        Iterator itContinent = geographicalMap.getContinents().entrySet().iterator();
        while (itContinent.hasNext()) {
            Map.Entry entry = (Map.Entry) itContinent.next();
            Continent c = (Continent) entry.getValue();
            if (c.getCountries().remove(country.getId(), country)) ;

        }
        MessagePanel.showMessage("your continent was deleted successfully with their countries", MessagePanel.Type.Info);
        geographicalMap.print();
        return ;

    }


    /**
     * this method is written to delete an adjacent
     *
     * @param geographicalMap the instance of object of geographicalMap
     * @param countryName     the name of country in String
     * @param adjacentName    the name of adjacent in String
     */
    public void deleteAdjacentFromGeographicalMap(GeographicalMap geographicalMap, String countryName, String adjacentName) {
        CountryController countryController = new CountryController();
        Country country = countryController.findCountryByName(countryName, geographicalMap.getCountries());
        Country adjacent = countryController.findCountryByName(adjacentName, geographicalMap.getCountries());

        if (country == null || adjacent == null) {
            MessagePanel.showMessage("the country is not valid", MessagePanel.Type.Error);
            return ;
        }
        if (country.getAdjacentCountries() != null && country.getAdjacentCountries().size() > 0 && country.getAdjacentCountries().contains(adjacent)) {
            country.getAdjacentCountries().remove(adjacent);
        }
        if (adjacent.getAdjacentCountries() != null && adjacent.getAdjacentCountries().size() > 0 && adjacent.getAdjacentCountries().contains(country)) {
            adjacent.getAdjacentCountries().remove(country);
        }
        return ;
    }

    /**
     * this method is written for adding a country to map
     *
     * @param geographicalMap the instance of object of geographicalMap
     * @param countryName     the name of country in String
     * @param continentName   the name of continent in String
     * @param latitude        the latitude of the country in the map
     * @param longitude       the longitude of the country in the map
     */
    public void addCountryToGeographicalMap(GeographicalMap geographicalMap, String countryName, String continentName, Integer latitude, Integer longitude) {
        ContinentController continentController = new ContinentController();
        Country country = new Country(countryName, geographicalMap);
        country.setLatitude(latitude);
        country.setLongitude(longitude);
        geographicalMap.getCountries().put(country.getId(), country);
        Continent continent = continentController.findContinentByName(continentName, geographicalMap.getContinents());
        continent.getCountries().put(country.getId(), country);
        MessagePanel.showMessage("your Country  was added successfully", MessagePanel.Type.Info);
        geographicalMap.print();

    }

    /**
     * this method is written for adding a adjacent to country
     *
     * @param geographicalMap object  of geographicalMap
     * @param countryName     type of String
     * @param adjacentName    the name of adjacent in String
     */
    public void addAdjacentToCountry(GeographicalMap geographicalMap, String countryName, String adjacentName) {
        MessagePanel messagePanel = new MessagePanel();

        CountryController countryController = new CountryController();
        Country country = countryController.findCountryByName(countryName, geographicalMap.getCountries());
        Country adjacent = countryController.findCountryByName(adjacentName, geographicalMap.getCountries());
        if (country.getId().equals(adjacent.getId())) { // in order of preventing the  wrong adjacency
            MessagePanel.showMessage("you can not add adjacent  the country with itself", MessagePanel.Type.Error);
            return ;
        }
        if (country.getAdjacentCountries() != null)
            for (Country a : country.getAdjacentCountries()) {// in order of preventing the  Duplicate  adjacency
                if (a.getId().equals(adjacent.getId())) {
                    MessagePanel.showMessage("this Adjacency is already exist", MessagePanel.Type.Error);
                    return ;
                }
            }

        if (country.getAdjacentCountries() != null) {
            country.getAdjacentCountries().add(adjacent);
        } else {
            List<Country> countryList = new ArrayList<Country>();
            countryList.add(adjacent);
            country.setAdjacentCountries(countryList);
        }
        if (adjacent.getAdjacentCountries() != null) {
            adjacent.getAdjacentCountries().add(country);
        } else {
            List<Country> countryList = new ArrayList<Country>();
            countryList.add(country);
            adjacent.setAdjacentCountries(countryList);

        }
        MessagePanel.showMessage("your adjacent was added successfully", MessagePanel.Type.Info);

    }


    /**
     * this method is written to produce of map file from object
     *
     * @param geographicalMap the instance of object of geographicalMap
     * @param mapPath         the path of map file
     */
    public void createMapFile(GeographicalMap geographicalMap, String mapPath) {
        String content = convertMapToText(geographicalMap);
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {

            fw = new FileWriter(mapPath);
            bw = new BufferedWriter(fw);
            bw.write(content);

            System.out.println(" Done");

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (bw != null)
                    bw.close();

                if (fw != null)
                    fw.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }
    }

    /**
     * this method is written to convert object to  text with format of the map
     *
     * @param geographicalMap the instance of object of geographicalMap
     * @return String of mapFile
     */
    private String convertMapToText(GeographicalMap geographicalMap) {
        String content = "";
        content += "[Map]\n";
        content += "image=" + geographicalMap.getImageName() + "\n";
        content += "wrap=" + (geographicalMap.getWrap() ? "yes" : "no") + "\n";
        content += "scroll=" + geographicalMap.getScroll() + "\n";
        content += "author=" + geographicalMap.getAuthor() + "\n";
        content += "warn=" + (geographicalMap.getWarn() ? "yes" : "no") + "\n";

        content += "\n";
        content += "[Continents]\n";
        Iterator it = geographicalMap.getContinents().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Continent continent = (Continent) entry.getValue();
            content += continent.getName() + "=" + continent.getControlValue() + "\n";
        }

        content += "\n";
        content += "[Territories]\n";
        Iterator itContinent = geographicalMap.getContinents().entrySet().iterator();
        while (itContinent.hasNext()) {
            Map.Entry entry = (Map.Entry) itContinent.next();
            Continent continent = (Continent) entry.getValue();
            Iterator itCountry = continent.getCountries().entrySet().iterator();
            while (itCountry.hasNext()) {
                Map.Entry entryCountry = (Map.Entry) itCountry.next();
                Country country = (Country) entryCountry.getValue();
                content += country.getName() + "," + country.getLatitude() + "," + country.getLongitude() + "," + continent.getName();
                if (country.getAdjacentCountries() != null) {
                    for (Country adjacent : country.getAdjacentCountries()) {
                        content += "," + adjacent.getName();
                    }
                }
                content += "\n";
            }

        }
//        MessagePanel.showMessage("your Map file was Created successfully", MessagePanel.Type.Info);
        return content;

    }


    /**
     * Calculates the number of armies to be assigned to each player
     * @param players list of players
     */
    public void assignArmies(ArrayList<Player> players){
        HashMap<String, Country> countries = geographicalMap.getCountries();
        for(Player player : players){
            if(players.size() == 2 && countries.size() < 20) {
                player.setTotalReservedArmies(20);
            }
            else if (players.size() == 2){
                player.setTotalReservedArmies(countries.size() / 2 + 1);
            }
            else if (players.size() == 3){
                player.setTotalReservedArmies(35);
            }
            else if (players.size() == 4){
                player.setTotalReservedArmies(30);
            }
            else if (players.size() == 5){
                player.setTotalReservedArmies(25);
            }
            else if (players.size() == 6){
                player.setTotalReservedArmies(20);
            }
        }
        distributeCountriesAndArmies(players);

    }


    /**
     * This method distribute countries to the players randomly
     *
     * @param players list of players
     */
    public void distributeCountriesAndArmies(ArrayList<Player> players){
        RollTheDice rollTheDice = new RollTheDice();
        ArrayList<Country> countries = new ArrayList<Country>(geographicalMap.getCountries().values());

        //assign countries to the players by deploying army
        while (countries.size() > 0){
            if(countries.size() >= players.size()) {
                for (int i = 0; i < players.size(); i++) {
                    Country country = rollTheDice.roll(countries, players.get(i));
                    countries.remove(country);
                    geographicalMap.getNode(country.getId()).addAttribute("ui.label", players.get(i).getName() + "(" + country.getArmyCount() + ")");
                    geographicalMap.addUpdateCountry(country);
                }
            }
            else { //when countries are less than player size
                Country country = rollTheDice.roll(countries, players.get(0));
                countries.remove(country);
                geographicalMap.getNode(country.getId()).addAttribute("ui.label", players.get(0).getName() + "(" + country.getArmyCount() + ")");
                geographicalMap.addUpdateCountry(country);
            }
        }

        //continue deploying remaining armies
        int totalRemainingArmy = 0;
        for (Player player : players){
            totalRemainingArmy = player.getTotalReservedArmies();
        }
        if (totalRemainingArmy > 0) {
            deployArmies(totalRemainingArmy);
        }
    }

    /**
     * This method deploys the armies to the countries in round-robin fashion
     *
     * @param tmpTotalArmies the number of armies to be distributed
     */
    private void deployArmies(int tmpTotalArmies){
        for (int i = 0; i < tmpTotalArmies; i++) {
            Iterator it = geographicalMap.getCountries().entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();
                Country country = (Country) pair.getValue();
                Player player = country.getOwner();
                if (player.getTotalReservedArmies() > 0) {
                    country.setArmyCount(country.getArmyCount() + 1);
                    player.decreaseOneArmy();
                    geographicalMap.getNode(country.getId()).addAttribute("ui.label", player.getName() + "(" + country.getArmyCount() + ")");
                    geographicalMap.addUpdateCountry(country);
                }
            }
        }
    }

    public void deployNewArmy(Country country, Player player, int armyNumber){
        country.setArmyCount(country.getArmyCount() + armyNumber);
        country.getOwner().decreaseReservedArmy(armyNumber);
        country.addAttribute("ui.label", player.getName() + "(" + country.getArmyCount() + ")");
        geographicalMap.addUpdateCountry(country);
    }
}
