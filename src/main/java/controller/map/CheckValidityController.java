package controller.map;

import exception.InvalidRiskMapException;
import model.map.Continent;
import model.map.Country;
import model.map.GeographicalMap;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Mina
 * This class is made for methods of Checking the validity of map file
 */
public class CheckValidityController {

    /**
     * this method is written to check if a file is valid or not
     *
     * @param fileOfMap String path of file of map
     * @return boolean of is valid or not
     */
    public Boolean isValidFile(String fileOfMap) throws InvalidRiskMapException{
        GeographicalMapController geographicalMapController = new GeographicalMapController();
        GeographicalMap geographicalMap = null;
        try {
            geographicalMap = geographicalMapController.parseMapFile(fileOfMap);

            // check for min number of continent
            if (geographicalMap.getContinents().size() < 2) {
                geographicalMap.setValid(Boolean.FALSE);
                geographicalMap.setValidMessage(geographicalMap.getValidMessage() + " file is not valid (the min size of continent is two) ");
                geographicalMap.print();
                throw new InvalidRiskMapException("file is not valid (the min size of continent is two)");
            } else {
                //check for the continent of all countries has defined
                Boolean ifAllContinentsAreDefined = parseIfAllContinentsAreDefined(geographicalMap);
                if (!ifAllContinentsAreDefined) {
                    geographicalMap.print();
                    throw new InvalidRiskMapException("there is a continent for a country that has not bean defined");
                }

                //check for the country of all adjacent has defined
                Boolean parseIfAllAdjacentAreDefinedAsCountry = parseIfAllAdjacentAreDefinedAsCountry(geographicalMap);
                if (!parseIfAllAdjacentAreDefinedAsCountry) {
                    geographicalMap.print();
                    throw new InvalidRiskMapException("there is a adjacent for a country that has not bean defined");
                }

                // check for at least each continent has one country
                Iterator it = geographicalMap.getContinents().entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    Continent continent = (Continent) entry.getValue();
                    if (continent.getCountries() == null || continent.getCountries().size() == 0) {
                        geographicalMap.setValid(Boolean.FALSE);
                        geographicalMap.setValidMessage(geographicalMap.getValidMessage() + " file is not valid (each continent has to have at least one country) ");
                        geographicalMap.print();
                        throw new InvalidRiskMapException("file is not valid (each continent has to have at least one country");

                    }
                }
            }

        } catch (Exception e) {
            if (geographicalMap == null) geographicalMap = new GeographicalMap();
            geographicalMap.setValid(Boolean.FALSE);
            geographicalMap.setValidMessage(geographicalMap.getValidMessage() + " file is not valid (each continent has to have at least one country) ");
            geographicalMap.print();
            throw new InvalidRiskMapException("file is not valid");
        }
        geographicalMap.print();
        return true;
    }


    /**
     * This method is made to check all of continent is defined or not
     *
     * @param geographicalMap  the instance of object of geographicalMap
     * @return boolean of if all continent are defined
     */
    private Boolean parseIfAllContinentsAreDefined(GeographicalMap geographicalMap) {
        ContinentController continentController = new ContinentController();
        Scanner scanner;
        try {
            File file = new File(geographicalMap.getFilePath());
            scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String tmp = scanner.nextLine().trim();
                if (tmp.equalsIgnoreCase("[Territories]")) {
                    while (scanner.hasNextLine()) {
                        String tmpC = scanner.nextLine().trim();
                        if (!tmpC.equals("") && tmpC.contains(",")) {
                            Continent continent = continentController.findContinentByName(tmpC.split(",")[3], geographicalMap.getContinents());
                            if (continent == null) {
                                geographicalMap.setValid(Boolean.FALSE);
                                geographicalMap.setValidMessage(geographicalMap.getValidMessage() + " there is a territory that its continent  has not defined  " + tmpC.split(",")[3]);
                                return Boolean.FALSE;
                            }
                        }
                    }
                }
            }

        } catch (Exception e) {
            geographicalMap.setValid(Boolean.FALSE);
            geographicalMap.setValidMessage(geographicalMap.getValidMessage() + " there is a problem in parseFileToFindCountriesByContinent >>  " + e.getMessage());

        }

        return Boolean.TRUE;
    }


    /**
     * This method is made to check all of adjacent is defined or not
     *
     * @param geographicalMap the instance of object of geographicalMap
     * @return boolean of if all continent are defined
     */
    private Boolean parseIfAllAdjacentAreDefinedAsCountry(GeographicalMap geographicalMap) {
        CountryController countryController = new CountryController();
        Scanner scanner;
        try {
            File file = new File(geographicalMap.getFilePath());
            scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String tmp = scanner.nextLine().trim();
                if (tmp.equalsIgnoreCase("[Territories]")) {
                    while (scanner.hasNextLine()) {
                        String tmpC = scanner.nextLine().trim();
                        if (!tmpC.equals("") && tmpC.contains(",")) {
                            String[] countryInfo = tmpC.split(",");

                            if (countryInfo.length > 4) {
                                for (int i = 4; i < countryInfo.length; i++) {

                                    Country adjacency = countryController.findCountryByName(countryInfo[i], geographicalMap.getCountries());
                                    if (adjacency == null) {
                                        geographicalMap.setValid(Boolean.FALSE);
                                        geographicalMap.setValidMessage(geographicalMap.getValidMessage() + " there is a adjacent that has not defined yet " + countryInfo[i]);
                                        return Boolean.FALSE;
                                    }
                                }
                            }
                        }
                    }
                }
            }


        } catch (Exception e) {
            geographicalMap.setValid(Boolean.FALSE);
            geographicalMap.setValidMessage(geographicalMap.getValidMessage() + " there is a problem in parseFileToFindCountriesByContinent >>  " + e.getMessage());

        }

        return Boolean.TRUE;


    }


}
