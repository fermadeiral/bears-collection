package controller.map;

import model.map.Country;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * This class is made for methods of related to Country
 *
 * @author Mina
 */
public class CountryController {

    /**
     * This method is made for finding the Country between the hashMaps of Country By name
     *
     * @param name the name of country
     * @param countries the hashmap of countries
     * @return Country the founded country
     */
    public Country findCountryByName(String name, HashMap<String, Country> countries) {
        Iterator it = countries.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Country country = (Country) entry.getValue();
            if (country.getName().equalsIgnoreCase(name)) {
                return country;
            }
        }

        return null;
    }


    /**
     * This method is made for creating an array for country names
     *
     * @param countries  the hashmap of countries
     * @return  the array of Country names
     */
    public String[] findCountryName(HashMap<String, Country> countries) {
        String[] countryArray = new String[countries.size()];
        int i = 0;
        Iterator it = countries.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Country country = (Country) entry.getValue();
            countryArray[i] = country.getName();
            i++;
        }

        return countryArray;
    }


    /**
     * this method is written to find the adjacents of a country
     * @param country the name of country
     * @return the array of name of countries
     */
    public String[] findCountryAdjacentName(Country country) {
        if (country.getAdjacentCountries() == null) return null;
        String[] countryAdjacentArray = new String[country.getAdjacentCountries().size()];
        int i = 0;
        for (Country c : country.getAdjacentCountries()) {
            countryAdjacentArray[i] = c.getName();
            i++;
        }

        return countryAdjacentArray;
    }


}
