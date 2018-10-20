package controller.map;

import model.map.Continent;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/**
 * @author Mina
 * This class is made for methods of related to continent
 */
public class ContinentController {


    /**
     * This method is made for finding the Continent between the hashMaps of continent By name
     *
     * @param name the name of continent
     * @param continents the hashmaps of continents
     * @return the founded Continent
     */
    public Continent findContinentByName(String name, HashMap<String, Continent> continents) {
        Iterator it = continents.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Continent continent = (Continent) entry.getValue();
            if (continent.getName().equalsIgnoreCase(name)) {
                return continent;
            }
        }

        return null;
    }

    /**
     * This method is made for creating an array for continent names
     *
     * @param continents the hash map of continents
     * @return array of Continent names
     */
    public String[] findContinentsName(HashMap<String, Continent> continents) {
        String[] continentArray = new String[continents.size()];
        int i = 0;
        Iterator it = continents.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Continent continent = (Continent) entry.getValue();
            continentArray[i] = continent.getName();
            i++;
        }

        return continentArray;
    }


}
