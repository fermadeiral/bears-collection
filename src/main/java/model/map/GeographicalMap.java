package model.map;

import controller.map.CountryController;
import org.graphstream.graph.implementations.AdjacencyListGraph;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * this class is made for object of geographical map
 * @author Napoleon
 *
 */
public class GeographicalMap extends AdjacencyListGraph {
    private HashMap<String, Country> countries;
    private HashMap<String, Continent> continents;

    //info in the file of map
    private String author;
    private String imageName;
    private Boolean wrap = Boolean.FALSE;
    private Boolean warn = Boolean.FALSE;
    private String scroll;
    private String filePath;
    private Boolean isConnected = Boolean.FALSE;
    private Boolean isValid = Boolean.TRUE;
    private String validMessage = "";

    /**
     * constructor of the class
     */
    public GeographicalMap() {
        super(UUID.randomUUID().toString(), false, true);
        this.countries = new HashMap<String, Country>();
        this.continents = new HashMap<String, Continent>();
    }

    /**
     * constructor of the class
     * @param author the string type of author name of file
     */
    public GeographicalMap(String author) {
        super(UUID.randomUUID().toString(), false, true);
        this.countries = new HashMap<String, Country>();
        this.continents = new HashMap<String, Continent>();
        this.author = author;
    }

    public Country getCountry(String id) {
        return countries.get(id);
    }

    public Continent getContinent(String id) {
        return continents.get(id);
    }


    public HashMap<String, Country> getCountries() {
        return countries;
    }

    /**
     * this method is written to add country
     * @param countryInfo the array of string of country info
     * @param countryController the controller of the country
     */
    public void addCountry(String[] countryInfo, CountryController countryController) {
        String countryName = countryInfo[0];
        Country country = countryController.findCountryByName(countryName, countries);
        addNode(country.getId());
        getNode(country.getId()).addAttribute("ui.style", "fill-mode: plain;");
        getNode(country.getId()).addAttribute("ui.style", "fill-color: " + randomColor() + ";");
        if (countryInfo.length > 4) {
            List<Country> adjacencyList = new ArrayList<Country>();
            for (int i = 4; i < countryInfo.length; i++) {
                Country adjacency = countryController.findCountryByName(countryInfo[i], countries);
                if (adjacency != null) {
                    adjacencyList.add(adjacency);
                    addEdge(UUID.randomUUID().toString(), country.getId(), adjacency.getId());
                }
            }
            country.setAdjacentCountries(adjacencyList);
        }
        this.countries.put(country.getId(), country);
    }

    /**
     * this method is written to add country
     * @param countryInfo the array of string of country info
     * @param order the int of order
     */
    public void addCountry(String[] countryInfo, int order) {
        String countryName = countryInfo[0];
        Country country = new Country(countryName, this);
        country.setOrder(order);
        country.setLatitude(Integer.parseInt(countryInfo[1]));
        country.setLongitude(Integer.parseInt(countryInfo[2]));
        this.countries.put(country.getId(), country);
    }

    public void addUpdateCountry(Country country) {
        countries.put(country.getId(), country);
    }

    public HashMap<String, Continent> getContinents() {
        return continents;
    }

    public void setContinents(HashMap<String, Continent> continents) {
        this.continents = continents;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public Boolean getWrap() {
        return wrap;
    }

    public void setWrap(Boolean wrap) {
        this.wrap = wrap;
    }

    public Boolean getWarn() {
        return warn;
    }

    public void setWarn(Boolean warn) {
        this.warn = warn;
    }

    public String getScroll() {
        return scroll;
    }

    public void setScroll(String scroll) {
        this.scroll = scroll;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Boolean getConnected() {
        return isConnected;
    }

    public void setConnected(Boolean connected) {
        isConnected = connected;
    }

    public Boolean getValid() {
        return isValid;
    }

    public void setValid(Boolean valid) {
        isValid = valid;
    }

    public String getValidMessage() {
        return validMessage;
    }

    public void setValidMessage(String validMessage) {
        this.validMessage = validMessage;
    }


    /**
     * this method is written to get the header constraints
     * @return the instance of GridBagConstraints
     */
    public static GridBagConstraints getHeaderConstraints() {
        GridBagConstraints header = new GridBagConstraints();
        header.gridwidth = GridBagConstraints.REMAINDER;
        header.weighty = 0.01f;
        header.weightx = 1f;
        header.fill = GridBagConstraints.BOTH;
        return header;
    }


    /**
     * this method is written to get the player views
     * @return the instance of GridBagConstraints
     */
    public static GridBagConstraints getPlayersView() {
        GridBagConstraints header = new GridBagConstraints();
        header.gridwidth = GridBagConstraints.REMAINDER;
        header.weighty = 0.01f;
        header.weightx = 0.01f;
        header.fill = GridBagConstraints.NONE;
        return header;
    }


    /**
     * this method is written to get current player view
     * @return the instance of GridBagConstraints
     */
    public static GridBagConstraints getCurrentPlayerView() {
        GridBagConstraints currentPlayer = new GridBagConstraints();
        currentPlayer.gridwidth = GridBagConstraints.REMAINDER;
        currentPlayer.weighty = 0.01f;
        currentPlayer.weightx = 0.01f;
        currentPlayer.fill = GridBagConstraints.NONE;
        return currentPlayer;
    }

    /**
     * this method is written to get the map constraints
     * @return the instance of GridBagConstraints
     */
    public static GridBagConstraints getMapConstraints() {
        GridBagConstraints bottom = new GridBagConstraints();
        bottom.gridwidth = GridBagConstraints.REMAINDER;
        bottom.weighty = 0.99f;
        bottom.weightx = 1f;
        bottom.fill = GridBagConstraints.BOTH;
        return bottom;
    }

    /**
     * print the info of the instance
     */
    public void print() {
        System.out.println("*********************");
        System.out.println("path of file : " + getFilePath());
        System.out.println("size of continent : " + getContinents().size());
        System.out.println("size of country : " + getCountries().size());
        System.out.println("size of nodes : " + getNodeCount());
        System.out.println("size of edges : " + getEdgeCount());
        System.out.println("Graph Connected : " + getConnected());
        System.out.println("File Valid : " + getValid());
        if (!getValid()) {
            System.out.println("Valid Message: " + getValidMessage());

        }
        System.out.println("*********************");
    }

    /**
     * Create random color every time the method is called.
     * @return return random color
     */
    public String randomColor() {
        Random random = new Random();
        int r = random.nextInt(255);
        int g = random.nextInt(255);
        int b = random.nextInt(255);
        return "rgb(" + r + "," + g + "," + b + ")";
    }
}
