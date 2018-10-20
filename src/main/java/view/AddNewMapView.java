package view;

import controller.map.ContinentController;
import controller.map.CountryController;
import controller.map.GeographicalMapController;
import model.map.GeographicalMap;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Wedad
 * this class is made to make an initial  jfram for choosing the mapfile and creating the map.
 */
public class AddNewMapView {
    JFrame initialWindow;
    JFrame windowNewMap;
    JFrame windowAddContinent;
    JFrame windowAddCountry;
    JFrame windowAddAdjacent;

    JButton buttonCancel;

    GeographicalMap geographicalMap;

    GeographicalMapController geographicalMapController;
    ContinentController continentController;
    CountryController countryController;

    private static final String NEW_MAP_FILE_NAME = "new_map.map";//the var for default name of the  new map

    /**
     * the constructor of the class of Player
     */
    public AddNewMapView() {
        geographicalMap = new GeographicalMap();
        countryController = new CountryController();
        geographicalMapController = new GeographicalMapController();
        continentController = new ContinentController();
        buttonCancel = new JButton("cancel");
        buttonCancel.addActionListener(actionListenerCancelNewMap);
    }

    /**
     * this method is made to generate the form for create new map
     * @param initialWindow the frame of initial view
     */
    public void showNewMapFrame(JFrame initialWindow) {
        windowNewMap = new JFrame("New Map");
        this.initialWindow = initialWindow;
        JPanel panelMapInfo = new JPanel();
        panelMapInfo.setBorder(BorderFactory.createTitledBorder("Map Info"));
        BoxLayout boxLayout = new BoxLayout(panelMapInfo, BoxLayout.Y_AXIS);
        panelMapInfo.setLayout(boxLayout);

        Label labelFileName = new Label("File Name");
        final TextField textFileName = new TextField(20);
        textFileName.setText(NEW_MAP_FILE_NAME);

        Label labelAuthor = new Label("Author");
        final TextField textAuthor = new TextField(20);

        //todo  add author fields

        JButton buttonNext = new JButton("next");
        buttonNext.addActionListener(new ActionListener() { //the listener of the button of next
            public void actionPerformed(ActionEvent ae) {
                if (textAuthor.getText().isEmpty() || textFileName.getText().isEmpty()) {
                    MessagePanel.showMessage("Please fill required fields", MessagePanel.Type.Error);

                } else {
                    geographicalMap.setAuthor(textAuthor.getText());
                    geographicalMap.setFilePath(geographicalMapController.getMapPath(textFileName.getText()));
                    windowNewMap.hide();
                    showAddContinentFrame();
                }
            }

        });


        panelMapInfo.add(labelFileName);
        panelMapInfo.add(textFileName);
        panelMapInfo.add(labelAuthor);
        panelMapInfo.add(textAuthor);

        JPanel panelButton = new JPanel();
        panelButton.setLayout(new GridBagLayout());
        panelButton.add(buttonNext);
        panelButton.add(buttonCancel);

        panelMapInfo.add(panelButton);

        windowNewMap.add(panelMapInfo, BorderLayout.NORTH);
        windowNewMap.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        windowNewMap.setMinimumSize(new Dimension(500, 500));
        windowNewMap.pack();
        windowNewMap.setLocationRelativeTo(null);
        windowNewMap.toFront();
        windowNewMap.setVisible(true);


    }


    /**
     * this method is made for showing the frame of the continent info
     */
    private void showAddContinentFrame() {
        windowAddContinent = new JFrame("Add Continent");
        JPanel panelAddContinent = new JPanel();
        panelAddContinent.setBorder(BorderFactory.createTitledBorder("Add Continent"));
        BoxLayout boxLayout = new BoxLayout(panelAddContinent, BoxLayout.Y_AXIS);
        panelAddContinent.setLayout(boxLayout);
        Label labelContinentName = new Label("Continent Name");
        final TextField textContinent = new TextField();
        Label labelControlValue = new Label("Control Value");
        final TextField textControlValue = new TextField();


        JButton buttonAddAnother = new JButton("Add");
        buttonAddAnother.addActionListener(new ActionListener() {//the listener of the button of add continent
            public void actionPerformed(ActionEvent ae) {
                if (textContinent.getText().isEmpty() || textControlValue.getText().isEmpty()) {
                    MessagePanel.showMessage("required fields", MessagePanel.Type.Error);


                } else {
                    geographicalMapController.addContinentToGeographicalMap(geographicalMap, textContinent.getText(), textControlValue.getText());
                    textContinent.setText("");
                    textControlValue.setText("");

                }
            }

        });

        JButton buttonNext = new JButton("next");
        buttonNext.addActionListener(new ActionListener() {//the listener of the button of nextadd continent
            public void actionPerformed(ActionEvent ae) {
                if (geographicalMap.getContinents().size() < 2) { //the min number of valid continent in the map is 2
                    MessagePanel.showMessage("Minimum of number of continent is 2 ", MessagePanel.Type.Error);
                    return;
                }
                windowAddContinent.hide();
                showAddCountryFrame();
            }

        });


        panelAddContinent.add(labelContinentName);
        panelAddContinent.add(textContinent);
        panelAddContinent.add(labelControlValue);
        panelAddContinent.add(textControlValue);


        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.add(buttonAddAnother);
        buttonPanel.add(buttonNext);
        buttonPanel.add(buttonCancel);


        windowAddContinent.add(panelAddContinent, BorderLayout.NORTH);
        windowAddContinent.add(buttonPanel);

        windowAddContinent.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        windowAddContinent.setMinimumSize(new Dimension(500, 500));
        windowAddContinent.pack();
        windowAddContinent.setLocationRelativeTo(null);
        windowAddContinent.toFront();
        windowAddContinent.setVisible(true);
    }


    /**
     * this method is made for showing the country frame
     */
    public void showAddCountryFrame() {
        windowAddCountry = new JFrame("Add Country");
        JPanel panelAddCountry = new JPanel();
        panelAddCountry.setBorder(BorderFactory.createTitledBorder("Add Continent"));
        BoxLayout boxLayout = new BoxLayout(panelAddCountry, BoxLayout.Y_AXIS);
        panelAddCountry.setLayout(boxLayout);

        Label labelCountryName = new Label("Country Name");
        final TextField textCountryName = new TextField();

        Label labelCountryLatitude = new Label("Country Latitude");
        final TextField textCountryLatitude = new TextField();

        Label labelCountryLongitude = new Label("Country Longitude");
        final TextField textCountryLongitude = new TextField();

        Label labelContinent = new Label("Continent Name");
        String[] continentNames = continentController.findContinentsName(geographicalMap.getContinents());//todo mina refactor it to set it static
        final JComboBox comboBoxContinent = new JComboBox(continentNames);
        comboBoxContinent.setEditable(false);


        JButton buttonAddAnother = new JButton("Add");
        buttonAddAnother.addActionListener(new ActionListener() {//the listener of the button of add
            public void actionPerformed(ActionEvent ae) {
                if (textCountryName.getText().isEmpty()) {
                    MessagePanel.showMessage("required fields", MessagePanel.Type.Error);


                } else {
                    geographicalMapController.addCountryToGeographicalMap(geographicalMap, textCountryName.getText(), comboBoxContinent.getSelectedItem().toString(),
                            (!textCountryLatitude.getText().isEmpty() ? Integer.valueOf(textCountryLatitude.getText()) : 0),
                            (!textCountryLongitude.getText().isEmpty() ? Integer.valueOf(textCountryLongitude.getText()) : 0));
                    textCountryName.setText("");
                    textCountryLatitude.setText("");
                    textCountryLongitude.setText("");
                }
            }

        });

        JButton buttonNext = new JButton("next");
        buttonNext.addActionListener(new ActionListener() {//the listener of the next button
            public void actionPerformed(ActionEvent ae) {
                windowAddCountry.hide();
                showAddAdjacent();
            }

        });

        panelAddCountry.add(labelCountryName);
        panelAddCountry.add(textCountryName);
        panelAddCountry.add(labelCountryLatitude);
        panelAddCountry.add(textCountryLatitude);
        panelAddCountry.add(labelCountryLongitude);
        panelAddCountry.add(textCountryLongitude);
        panelAddCountry.add(labelContinent);
        panelAddCountry.add(comboBoxContinent);

        JPanel buttonPanel = new JPanel(new  GridBagLayout());
        buttonPanel.add(buttonAddAnother);
        buttonPanel.add(buttonNext);
        buttonPanel.add(buttonCancel);


        windowAddCountry.add(panelAddCountry, BorderLayout.NORTH);
        windowAddCountry.add(buttonPanel);

        windowAddCountry.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        windowAddCountry.setMinimumSize(new Dimension(500, 500));
        windowAddCountry.pack();
        windowAddCountry.setLocationRelativeTo(null);
        windowAddCountry.toFront();
        windowAddCountry.setVisible(true);


    }

    /**
     * this method is written for showing the add adjacent frame
     */
    private void showAddAdjacent() {
        windowAddAdjacent = new JFrame("Add Adjacent");
        JPanel panelAddAdjacent = new JPanel();
        panelAddAdjacent.setBorder(BorderFactory.createTitledBorder("Add Adjacent"));
        BoxLayout boxLayout = new BoxLayout(panelAddAdjacent, BoxLayout.Y_AXIS);
        panelAddAdjacent.setLayout(boxLayout);
        String[] countryNames = countryController.findCountryName(geographicalMap.getCountries());

        Label labelCountries = new Label("Country Name");
        final JComboBox comboBoxCountry = new JComboBox(countryNames);
        comboBoxCountry.setEditable(false);

        Label labelAdjacent = new Label("Adjacent Name");
        final JComboBox comboBoxAdjacent = new JComboBox(countryNames);
        comboBoxAdjacent.setEditable(false);


        JButton buttonAddAnother = new JButton("Add");
        buttonAddAnother.addActionListener(new ActionListener() {//the listener of the add button
            public void actionPerformed(ActionEvent ae) {
                geographicalMapController.addAdjacentToCountry(geographicalMap,
                        (    comboBoxCountry.getSelectedItem()!=null ?comboBoxCountry.getSelectedItem().toString():""),
                        (comboBoxAdjacent.getSelectedItem()!=null ? comboBoxAdjacent.getSelectedItem().toString() :""));
            }

        });

        JButton buttonNext = new JButton("save");
        buttonNext.addActionListener(new ActionListener() {//the listener of the save button
            public void actionPerformed(ActionEvent ae) {
                geographicalMapController.createMapFile(geographicalMap, geographicalMap.getFilePath());
                windowAddAdjacent.hide();
                EditAndCreateMapView editAndCreateMapView = new EditAndCreateMapView(geographicalMap.getFilePath());

            }

        });

        panelAddAdjacent.add(labelCountries);
        panelAddAdjacent.add(comboBoxCountry);
        panelAddAdjacent.add(labelAdjacent);
        panelAddAdjacent.add(comboBoxAdjacent);

        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.add(buttonAddAnother);
        buttonPanel.add(buttonNext);
        buttonPanel.add(buttonCancel);

        windowAddAdjacent.add(panelAddAdjacent, BorderLayout.NORTH);
        windowAddAdjacent.add(buttonPanel);

        windowAddAdjacent.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        windowAddAdjacent.setMinimumSize(new Dimension(500, 500));
        windowAddAdjacent.pack();
        windowAddAdjacent.setLocationRelativeTo(null);
        windowAddAdjacent.toFront();
        windowAddAdjacent.setVisible(true);


    }


    /**
     * this is a variable of  ActionListener that create for canceling the create of new map
     */
    private ActionListener actionListenerCancelNewMap = new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
            initialWindow.show();
            if (windowNewMap != null) windowNewMap.hide();
            if (windowAddContinent != null) windowAddContinent.hide();
            if (windowAddCountry != null) windowAddCountry.hide();
            if (windowAddAdjacent != null) windowAddAdjacent.hide();
        }
    };

}
