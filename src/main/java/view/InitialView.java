package view;

import controller.PlayerController;
import controller.map.GeographicalMapController;
import model.map.Country;
import model.map.GeographicalMap;
import model.player.Player;
import org.graphstream.graph.Node;
import org.graphstream.ui.graphicGraph.GraphicElement;
import org.graphstream.ui.graphicGraph.GraphicNode;
import org.graphstream.ui.swingViewer.ViewPanel;
import org.graphstream.ui.view.Viewer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


/**
 * @author Mina
 * this class is made to make an initial  jfram for choosing the mapfile  or create new map.
 */
public class InitialView implements CurrentPlayerView.CurrentPlayerListener {

    public static String selectedFilePath;
    private JFrame window;
    private JPanel panel;
    private GeographicalMap geographicalMap;
    private GeographicalMapController mapController;
    private PlayerController playerController;
    private JFileChooser jFileChooserMap;
    private Player currentPlayer;

    private static final Color playersColor [] = {Color.GREEN, Color.YELLOW, Color.BLUE, Color.RED, Color.GRAY, Color.CYAN};

    /**
     * constructor of the class
     */
    public InitialView() {
        mapController = new GeographicalMapController();
        playerController = new PlayerController();
        jFileChooserMap = new JFileChooser(mapController.getMapFileDirectory());

        window = new JFrame("Risk");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        panel = new JPanel();
        addComponentToPane(panel);
        window.setLayout(new BorderLayout());
        window.add(panel, BorderLayout.CENTER);
        window.setMinimumSize(new Dimension(1000, 800));
        window.pack();
        window.setLocationRelativeTo(null);
        window.toFront();
    }

    /**
     * constructor of the class
     * @param windowListener the instance of the window listener
     */
    public InitialView(WindowListener windowListener) {
       this();
        window.addWindowListener(windowListener);
    }

    /**
     * method for adding the component (buttons and ChooseFile to JPanel)
     *
     * @param pane container for adding the component
     */
    private void addComponentToPane(final Container pane) {

        //Put the JComboBox in a JPanel to get a nicer look.
        final JButton jButtonChooseMap = new JButton("choose map");
        final JFileChooser jFileChooserMap = new JFileChooser(mapController.getMapFileDirectory());
        jButtonChooseMap.addActionListener(ae -> {
            if (jFileChooserMap.showOpenDialog(window) == JFileChooser.APPROVE_OPTION) {
                window.hide();
                selectedFilePath = jFileChooserMap.getSelectedFile().getPath();
                EditAndCreateMapView editAndCreateMapView = new EditAndCreateMapView(selectedFilePath);
            }
        });

//        jButtonChooseMap.addActionListener(actionListener);

        final JButton jButtonNewMap = new JButton("new Map");
        jButtonNewMap.addActionListener(newMapActionListener);

        setUpInitialView(pane, jButtonChooseMap,jButtonNewMap);
    }


    /**
     * Method to initialize landing screen
     * @param pane Container where view is placed
     * @param jButtonNewMap button to create new map
     * @param jButtonChooseMap button to choose map
     */
    private void setUpInitialView(Container pane, JButton jButtonNewMap, JButton jButtonChooseMap) {
        //Create the "riskPanel".
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(jButtonNewMap);
        buttonPanel.add(jButtonChooseMap);

        //Create the panel that contains the "riskPanel".
        panel = new JPanel(new CardLayout());
        panel.add(buttonPanel);
        pane.add(panel, BorderLayout.CENTER);
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
                if (currentPlayer.getId() == country.getOwner().getId()){

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

        //Fit map and buttons in screen.
        panel = new JPanel(new GridBagLayout());
        panel.add(buttonPanel, GeographicalMap.getHeaderConstraints());
        panel.add(view, GeographicalMap.getMapConstraints());

        JPanel playersPanel = new JPanel();
        int i = 0;
        for (Player player : playerController.players){
            JButton tmpBtn = new JButton( player.getName() + " (" + player.getTotalArmiesOwn() + ")");
            tmpBtn.setBackground(playersColor[i]);
            playersPanel.add(tmpBtn);
            i++;
        }
        panel.add(playersPanel, GeographicalMap.getPlayersView());

        panel.add(new CurrentPlayerView().showCurrentPlayerView(playerController.players, this), GeographicalMap.getPlayersView());
        currentPlayer = playerController.players.get(0);

        window.add(panel, BorderLayout.CENTER);
        window.pack();
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
     */
    public void showSelectUsersPanel() {
        if(geographicalMap == null){
            return;
        }

        SelectPlayerView selectPlayerView = new SelectPlayerView(window, playerListener, playerController);
        selectPlayerView.initView(geographicalMap);
        selectPlayerView.show();
    }

    /**
     * Listener called when new map is selected
     */
    private ActionListener newMapActionListener = new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
            AddNewMapView addNewMapView = new AddNewMapView();
            window.hide();
            addNewMapView.showNewMapFrame(window);
        }
    };


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
     * Listener for user selector
     */
    SelectPlayerView.SelectPlayerListener playerListener = new SelectPlayerView.SelectPlayerListener() {
        public void onViewReady() {

        }

        public void onButtonSelect(ArrayList<Player> players) {
//            mapController.assignCountries(players);
//            mapController.assignArmies(players);
            setUpMapView();
        }
    };

    /**
     *
     * @param selectedIndex int of index of selected pla
     */
    public void onPlayerSelected(int selectedIndex) {
        currentPlayer = playerController.players.get(selectedIndex);
    }
}