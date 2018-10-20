package view;

import controller.PlayerController;
import controller.map.CheckValidityController;
import controller.map.GeographicalMapController;
import controller.play.CalculateReinforcement;
import exception.InvalidRiskMapException;
import model.map.Country;
import model.map.GeographicalMap;
import model.player.Player;
import org.graphstream.ui.graphicGraph.GraphicElement;
import org.graphstream.ui.swingViewer.ViewPanel;
import org.graphstream.ui.view.Viewer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;


/**
 * @author Mina
 * this class is made to make a  jfram for choosing the create a map or edit that.
 */
public class EditAndCreateMapView implements CurrentPlayerView.CurrentPlayerListener {
    public static String selectedFilePath;
    private JFrame window;
    private JPanel panel;
    private GeographicalMap geographicalMap;
    private GeographicalMapController mapController;
    private PlayerController playerController;
    private JFileChooser jFileChooserMap;
    private Player currentPlayer;
    private CalculateReinforcement calculateReinforcement;

    private static final Color playersColor[] = {Color.GREEN, Color.YELLOW, Color.BLUE, Color.RED, Color.GRAY, Color.CYAN};

    /**
     * constructor of the class
     * @param selectedFilePath the string value of the selected file path
     */
    public EditAndCreateMapView(String selectedFilePath) {
        playerController = new PlayerController();
        mapController = new GeographicalMapController();
        jFileChooserMap = new JFileChooser(mapController.getMapFileDirectory());
        this.selectedFilePath = selectedFilePath;
        window = new JFrame("Risk");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        panel = new JPanel();
        addComponentToPane(panel);
        window.add(panel);
        window.setMinimumSize(new Dimension(1000, 800));
        window.pack();
        window.setLocationRelativeTo(null);
        window.toFront();
        window.setVisible(true);
    }


    /**
     * method for adding the component (buttons for edit map or create mapGraph )
     *
     * @param pane the container for adding the component on it
     */
    private void addComponentToPane(Container pane) {

        final JButton jButtonBack = new JButton("Back");
        jButtonBack.addActionListener(actionListenerBackCreateGraph);


        JButton jButtonCreateMap = new JButton("Create Graph");
        jButtonCreateMap.addActionListener(actionListenerCreateGraph);


        //Create the "riskPanel".
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(jButtonBack);
        buttonPanel.add(jButtonCreateMap);

        //Create the panel that contains the "riskPanel".
        panel = new JPanel(new CardLayout());
        panel.add(buttonPanel, " Button Panel ");
        pane.add(panel, BorderLayout.CENTER);
    }

    /**
     * this method is written to show the frame
     */
    public void show() {
        window.setVisible(true);
    }

    /**
     * This method initialize the View for selecting the number of players.
     * It creates an object of {@link SelectPlayerView} by providing values and an interface {@link view.SelectPlayerView.SelectPlayerListener}
     * which gives a callback regarding the actions.
     * <p>
     * Call this method when you wants show the View for Player selection.
     * </p>
     */
    public void showSelectUsersPanel() {
        if (geographicalMap == null) {
            return;
        }

        SelectPlayerView selectPlayerView = new SelectPlayerView(window, playerListener, playerController);
        selectPlayerView.initView(geographicalMap);
        selectPlayerView.show();
    }

    /**
     * Listener for user selector
     */
    SelectPlayerView.SelectPlayerListener playerListener = new SelectPlayerView.SelectPlayerListener() {
        public void onViewReady() {

        }

        public void onButtonSelect(ArrayList<Player> players) {
            mapController.assignArmies(players);
            mapController.distributeCountriesAndArmies(players);
            calculateReinforcementArmies(players);
            setUpMapView();
        }
    };

    private void calculateReinforcementArmies(ArrayList<Player> players){
        calculateReinforcement = new CalculateReinforcement();
        calculateReinforcement.calculate(mapController, players);
    }

    /**
     * Method to initialize landing screen
     */

    public void setUpMapView() {
        window.getContentPane().removeAll();

        final JButton jButtonChooseMap = new JButton("choose map");
        jButtonChooseMap.addActionListener(actionListener);

        Viewer viewer = new Viewer(geographicalMap, Viewer.ThreadingModel.GRAPH_IN_GUI_THREAD);
        viewer.enableAutoLayout();
        final ViewPanel view = viewer.addDefaultView(false);
        view.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {

                ArrayList<GraphicElement> arrayList = new ArrayList<GraphicElement>(view.allNodesOrSpritesIn(e.getX(), e.getY(), e.getX(), e.getY()));
                Country country = geographicalMap.getCountry(arrayList.get(0).getId());

                //TODO: COUNTRY CLICKED WORKFLOW HERE
                if (currentPlayer.getId().equalsIgnoreCase(country.getOwner().getId())) {
                    showCountryDetails(country, currentPlayer);
                }
            }

            public void mousePressed(MouseEvent e) {

            }

            public void mouseReleased(MouseEvent e) {


            }

            public void mouseEntered(MouseEvent e) {

            }

            public void mouseExited(MouseEvent e) {

            }
        });

        //Add Buttons.
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(jButtonChooseMap);

        final JButton jButtonBack = new JButton("Back");
        jButtonBack.addActionListener(actionListenerBack);

        final JButton jButtonEditMap = new JButton("edit Map");
        jButtonEditMap.addActionListener(actionListenerEditMap);

        buttonPanel.add(jButtonBack);
        buttonPanel.add(jButtonEditMap);

        //Fit map and buttons in screen.
        panel = new JPanel(new GridBagLayout());
        panel.add(buttonPanel, GeographicalMap.getHeaderConstraints());
        panel.add(view, GeographicalMap.getMapConstraints());

        JPanel playersPanel = new JPanel();
        int i = 0;
        for (Player player : playerController.players) {
            JButton tmpBtn = new JButton(player.getName() + " (" + player.getTotalArmiesOwn() + ")");
            tmpBtn.setBackground(playersColor[i]);
            playersPanel.add(tmpBtn);
            i++;
        }
        panel.add(playersPanel, GeographicalMap.getPlayersView());

        panel.add(new CurrentPlayerView().showCurrentPlayerView(playerController.players, currentPlayerListener), GeographicalMap.getPlayersView());
        currentPlayer = playerController.players.get(0);

        window.add(panel, BorderLayout.CENTER);
        window.pack();
    }

    private void showCountryDetails(Country country, Player player) {
        AttackView attackView = new AttackView(country);
        attackView.showDetails(attackListener, player);
    }

    AttackView.AttackListener attackListener = new AttackView.AttackListener() {
        public void onAttack(Country attacker, Country attacked) {
            System.out.println("Attacker : " + attacker.getName() + " | Attacked : " + attacked.getName());
            //TODO implement attack logic here
        }

        public void onAttackCancel() {
        }

        public void onReinforcement(Country country, Player player, int newArmies) {
            System.out.println(newArmies);
            mapController.setGeographicalMap(geographicalMap);
            mapController.deployNewArmy(country, player, newArmies);
        }

        @Override
        public void onFortification(Country countryGainsArmy, Country countryLosesArmy, Player player, int newArmies) {
            mapController.fortifyArmy(countryGainsArmy, countryLosesArmy, player, newArmies);
        }
    };

    @Override
    public void onPlayerSelected(int selectedIndex) {
        currentPlayer = playerController.players.get(selectedIndex);
    }

    /**
     * Listener called when a map file is selected
     */
    private ActionListener actionListener = new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
            if (jFileChooserMap.showOpenDialog(window) != JFileChooser.APPROVE_OPTION) {
                return;
            }
            String filePath = jFileChooserMap.getSelectedFile().getPath();
            geographicalMap = mapController.parseMapFile(filePath);
            mapController.setGeographicalMap(geographicalMap);
            showSelectUsersPanel();
        }
    };


    /**
     * Listener called when a back button is selected
     */
    private ActionListener actionListenerBack = new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
            window.hide();
            new EditAndCreateMapView(selectedFilePath);
        }
    };

    /**
     * Listener called when a back button is selected
     */
    private ActionListener actionListenerBackCreateGraph = new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
            window.hide();
            InitialView initialView = new InitialView();
            initialView.show();
        }
    };

    /**
     * Listener called when a Edit button is selected
     */
    private ActionListener actionListenerEditMap = new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
            geographicalMap = mapController.parseMapFile(selectedFilePath);
            EditMapView editMapView = new EditMapView(selectedFilePath, geographicalMap);
            window.hide();
            editMapView.showEditMapFrame();
        }

    };


    /**
     * Listener called when a Create Graph button is selected
     */
    private ActionListener actionListenerCreateGraph = new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
            if (selectedFilePath != null) {

                CheckValidityController checkValidityController = new CheckValidityController();
                Boolean isValid = false;
                try {
                    isValid = checkValidityController.isValidFile(selectedFilePath);
                } catch (InvalidRiskMapException e) {
                    MessagePanel.showMessage(e.getLocalizedMessage(), MessagePanel.Type.Error);
                }
                if (!isValid) {
                    return;
                }

                geographicalMap = mapController.parseMapFile(selectedFilePath);
                if (geographicalMap.getConnected()) {
                    mapController.setGeographicalMap(geographicalMap);
                    showSelectUsersPanel();
                } else {
                    MessagePanel.showMessage("Graph is not Connected", MessagePanel.Type.Error);
                }

            } else {
                MessagePanel.showMessage("you should choose a file at first", MessagePanel.Type.Error);

            }

        }

    };

    CurrentPlayerView.CurrentPlayerListener currentPlayerListener = new CurrentPlayerView.CurrentPlayerListener() {
        public void onPlayerSelected(int selectedIndex) {
            currentPlayer = playerController.players.get(selectedIndex);
        }
    };


}
