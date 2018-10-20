package view;

import controller.map.CheckConnectivityController;
import controller.map.ContinentController;
import controller.map.CountryController;
import controller.map.GeographicalMapController;
import model.map.Country;
import model.map.GeographicalMap;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Mina
 * this class is made to make an creat a  fram for editing the existing map
 */
public class EditMapView {
    GeographicalMap geographicalMap;
    GeographicalMapController geographicalMapController;
    ContinentController continentController;
    CountryController countryController;
    String selectedFilePath;

    JFrame windowEditMap;
    JFrame windowAddContinent;
    JFrame windowAddCountry;
    JFrame windowAddAdjacent;
    JButton buttonCancel;


    /**
     * this is a constructor of this class
     *
     * @param selectedFilePath the path of selected map file
     * @param geographicalMap  the instance of object of geographicalMap
     */
    public EditMapView(String selectedFilePath, GeographicalMap geographicalMap) {
        this.selectedFilePath = selectedFilePath;
        this.geographicalMap = geographicalMap;
        countryController = new CountryController();
        geographicalMapController = new GeographicalMapController();
        continentController = new ContinentController();

        buttonCancel = new JButton("cancel");
        buttonCancel.addActionListener(actionListenerCancelNewMap);

    }

    /**
     * this method is made to generate the form for create new map
     */
    public void showEditMapFrame() {
        windowEditMap = new JFrame(selectedFilePath);
        JPanel panelMapInfo = new JPanel();
        panelMapInfo.setBorder(BorderFactory.createTitledBorder("Map Info"));
        BoxLayout boxLayout = new BoxLayout(panelMapInfo, BoxLayout.Y_AXIS);
        panelMapInfo.setLayout(boxLayout);

        Label labelAuthor = new Label("Author");
        final TextField textAuthor = new TextField(20);
        textAuthor.setText(geographicalMap.getAuthor());

        //todo  Map Info fields

        JButton buttonNext = new JButton("next");
        buttonNext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (textAuthor.getText().isEmpty()) {
                    MessagePanel.showMessage("text Author should not be null", MessagePanel.Type.Error);
                } else {
                    geographicalMap.setAuthor(textAuthor.getText());
                    windowEditMap.hide();
                    showEditContinentFrame();

                }
            }

        });

        JPanel panelButton = new JPanel();
        panelButton.setLayout(new GridBagLayout());
        panelButton.add(buttonNext);
        panelButton.add(buttonCancel);

        panelMapInfo.add(labelAuthor);
        panelMapInfo.add(textAuthor);
        panelMapInfo.add(panelButton);


        windowEditMap.add(panelMapInfo, BorderLayout.NORTH);
        windowEditMap.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        windowEditMap.setMinimumSize(new Dimension(500, 500));
        windowEditMap.pack();
        windowEditMap.setLocationRelativeTo(null);
        windowEditMap.toFront();
        windowEditMap.setVisible(true);

    }


    /**
     * this method is written to show the edit continent frame
     */
    public void showEditContinentFrame() {

        windowAddContinent = new JFrame("Edit Continent");
        JPanel panelAddContinent = new JPanel();
        panelAddContinent.setBorder(BorderFactory.createTitledBorder("Add Continent"));
        BoxLayout boxLayout = new BoxLayout(panelAddContinent, BoxLayout.Y_AXIS);
        panelAddContinent.setLayout(boxLayout);
        Label labelContinentName = new Label("Continent Name");
        final TextField textContinent = new TextField();
        Label labelControlValue = new Label("Control Value");
        final TextField textControlValue = new TextField();

        JButton buttonAddAnother = new JButton("Add");
        buttonAddAnother.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (textContinent.getText().isEmpty() || textControlValue.getText().isEmpty()) {
                    MessagePanel.showMessage("required fields", MessagePanel.Type.Error);
                } else {
                    geographicalMapController.addContinentToGeographicalMap(geographicalMap, textContinent.getText(), textControlValue.getText());
                    textContinent.setText("");
                    textControlValue.setText("");
                    windowAddContinent.hide();
                    showEditContinentFrame();

                }
            }

        });

        JButton buttonNext = new JButton("next");
        buttonNext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (geographicalMap.getContinents().size() < 2) {
                    MessagePanel.showMessage("Minimum of number of continent is 2 ", MessagePanel.Type.Error);
                    return;
                }
                windowAddContinent.hide();
                showEditCountryFrame();
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


        JPanel panelDeleteContinent = new JPanel();
        panelDeleteContinent.setBorder(BorderFactory.createTitledBorder("Delete Continent"));
        String[] continentNames = continentController.findContinentsName(geographicalMap.getContinents());//todo mina refactor it to set it static
        final JComboBox comboBoxContinent = new JComboBox(continentNames);
        comboBoxContinent.setEditable(false);
        panelDeleteContinent.add(comboBoxContinent);

        JButton buttonDelete = new JButton("Delete");
        buttonDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (comboBoxContinent.getSelectedItem() == null) {
                    MessagePanel.showMessage("required fields", MessagePanel.Type.Error);
                } else {
                    geographicalMapController.deleteContinentFromGeographicalMap(geographicalMap, comboBoxContinent.getSelectedItem().toString());
                    windowAddContinent.hide();
                    showEditContinentFrame();
                }
            }

        });
        JPanel buttonDeletePanel = new JPanel(new GridBagLayout());
        buttonDeletePanel.add(buttonDelete);

        panelAddContinent.add(buttonPanel);
        windowAddContinent.add(panelAddContinent, BorderLayout.NORTH);

        panelDeleteContinent.add(buttonDeletePanel);
        windowAddContinent.add(panelDeleteContinent, BorderLayout.SOUTH);

        windowAddContinent.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        windowAddContinent.setMinimumSize(new Dimension(500, 500));
        windowAddContinent.pack();
        windowAddContinent.setLocationRelativeTo(null);
        windowAddContinent.toFront();
        windowAddContinent.setVisible(true);


    }

    /**
     * this method is written to create form for edit and add country
     */
    public void showEditCountryFrame() {
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
        buttonAddAnother.addActionListener(new ActionListener() {
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
                    windowAddCountry.hide();
                    showEditCountryFrame();
                }
            }

        });

        JButton buttonNext = new JButton("next");
        buttonNext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                windowAddCountry.hide();
                showEditAdjacent(null, 0);
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

        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.add(buttonAddAnother);
        buttonPanel.add(buttonNext);
        buttonPanel.add(buttonCancel);

        JPanel panelDeleteCountry = new JPanel();
        panelDeleteCountry.setBorder(BorderFactory.createTitledBorder("Delete Country"));
        String[] countryNames = countryController.findCountryName(geographicalMap.getCountries());//todo mina refactor it to set it static
        final JComboBox comboBoxCountry = new JComboBox(countryNames);
        comboBoxCountry.setEditable(false);
        panelDeleteCountry.add(comboBoxCountry);


        JButton buttonDelete = new JButton("Delete");
        buttonDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (comboBoxCountry.getSelectedItem() == null) {
                    MessagePanel.showMessage("required fields", MessagePanel.Type.Error);
                } else {
                    geographicalMapController.deleteCountryFromGeographicalMap(geographicalMap, comboBoxCountry.getSelectedItem().toString());
                    windowAddCountry.hide();
                    showEditCountryFrame();
                }
            }

        });
        JPanel buttonDeletePanel = new JPanel(new GridBagLayout());
        buttonDeletePanel.add(buttonDelete);

        panelAddCountry.add(buttonPanel);
        windowAddCountry.add(panelAddCountry, BorderLayout.NORTH);

        panelDeleteCountry.add(buttonDeletePanel);
        windowAddCountry.add(panelDeleteCountry, BorderLayout.SOUTH);


        windowAddCountry.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        windowAddCountry.setMinimumSize(new Dimension(500, 500));
        windowAddCountry.pack();
        windowAddCountry.setLocationRelativeTo(null);
        windowAddCountry.toFront();
        windowAddCountry.setVisible(true);


    }

    /**
     * this method is written to create form for edit and add Adjacent
     *
     * @param adjacentNames        the array of names of adjacent
     * @param selectedCountryIndex the index of selected country
     */
    public void showEditAdjacent(String[] adjacentNames, int selectedCountryIndex) {
        JFrame windowAddAdjacent = new JFrame("Add Adjacent");
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


        //todo  add author fields

        JButton buttonAddAnother = new JButton("Add");
        buttonAddAnother.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                geographicalMapController.addAdjacentToCountry(geographicalMap,
                        comboBoxCountry.getSelectedItem().toString(),
                        comboBoxAdjacent.getSelectedItem().toString());
            }

        });

        JButton buttonNext = new JButton("save");
        buttonNext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                CheckConnectivityController checkConnectivityController = new CheckConnectivityController();
                Boolean isConnected = checkConnectivityController.isGraphConnectedTotally(geographicalMap);
                geographicalMap.setConnected(isConnected);
                geographicalMap.print();
                if (isConnected) {
                    MessagePanel.showMessage("Your map is Connected and edited successfully", MessagePanel.Type.Info);
                    windowAddAdjacent.hide();
                    geographicalMapController.setGeographicalMap(geographicalMap);
                    geographicalMapController.createMapFile(geographicalMap, geographicalMap.getFilePath());
                    windowAddAdjacent.hide();
                    EditAndCreateMapView editAndCreateMapView = new EditAndCreateMapView(geographicalMap.getFilePath());
                    editAndCreateMapView.showSelectUsersPanel();

                } else {
                    MessagePanel.showMessage("Your map is not connected", MessagePanel.Type.Error);


                }
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
        panelAddAdjacent.add(buttonPanel);

        JPanel panelDeleteAdjacent = new JPanel();
        panelDeleteAdjacent.setBorder(BorderFactory.createTitledBorder("Delete Adjacent"));
        Label labelCountryNames = new Label("Country Name");
        Label labelAdjacentNames = new Label("Adjacent Name");
        final JComboBox comboBoxCountryName = new JComboBox(countryNames);
        comboBoxCountryName.setEditable(false);

        if (countryNames != null) {
            comboBoxCountryName.setSelectedIndex(selectedCountryIndex);
        }
        if (adjacentNames == null) {
            if (countryNames != null && countryNames.length > 0) {
                Country c = countryController.findCountryByName(countryNames[0], geographicalMap.getCountries());
                adjacentNames = countryController.findCountryAdjacentName(c);
            }
            if (adjacentNames == null) {
                adjacentNames = new String[0];
            }
        }
        final JComboBox   comboBoxAdjacentCountry = new JComboBox(adjacentNames);
        comboBoxAdjacentCountry.setEditable(false);


        panelDeleteAdjacent.add(labelCountryNames);
        panelDeleteAdjacent.add(comboBoxCountryName);
        panelDeleteAdjacent.add(labelAdjacentNames);
        panelDeleteAdjacent.add(comboBoxAdjacentCountry);
        comboBoxCountryName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Country country = countryController.findCountryByName(comboBoxCountryName.getSelectedItem().toString(), geographicalMap.getCountries());
                if (country != null) {
                    String[] adjacentNames = countryController.findCountryAdjacentName(country);
                    windowAddAdjacent.hide();
                    showEditAdjacent(adjacentNames, comboBoxCountryName.getSelectedIndex());
                }
            }

        });


        JButton buttonDelete = new JButton("delete");
        buttonDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                geographicalMapController.deleteAdjacentFromGeographicalMap(geographicalMap, comboBoxCountryName.getSelectedItem().toString(), comboBoxAdjacentCountry.getSelectedItem().toString());
                windowAddAdjacent.hide();
                showEditAdjacent(null, 0);
            }

        });

        JPanel buttonDeletePanel = new JPanel(new GridBagLayout());
        buttonDeletePanel.add(buttonDelete);
        panelDeleteAdjacent.add(buttonDeletePanel);


        windowAddAdjacent.add(panelAddAdjacent, BorderLayout.NORTH);
//        windowAddAdjacent.add(buttonPanel);

        windowAddAdjacent.add(panelDeleteAdjacent, BorderLayout.SOUTH);
//        windowAddAdjacent.add(buttonDeletePanel);

        windowAddAdjacent.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        windowAddAdjacent.setMinimumSize(new Dimension(500, 500));
        windowAddAdjacent.pack();
        windowAddAdjacent.setLocationRelativeTo(null);
        windowAddAdjacent.toFront();
        windowAddAdjacent.setVisible(true);


    }


    /**
     * Listener called when a Cancel button is selected
     */
    private ActionListener actionListenerCancelNewMap = new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
            new EditAndCreateMapView(geographicalMap.getFilePath());
            if (windowEditMap != null) windowEditMap.hide();
            if (windowAddContinent != null) windowAddContinent.hide();
            if (windowAddCountry != null) windowAddCountry.hide();
            if (windowAddAdjacent != null) windowAddAdjacent.hide();
        }
    };


}
