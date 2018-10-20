package view;

import controller.PlayerController;
import model.map.GeographicalMap;
import model.player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * The purpose of this class is to show a drop-down to the user to get the number of playerOptions as input.
 * After selecting a value from drop-down, once the user press the OK button, then it redirects to
 * map again.
 *
 * @author Mahedi Hassan
 */

public class SelectPlayerView {

    private SelectPlayerListener selectPlayerListener;
    private JFrame window;
    private PlayerController selectPlayerController;
    private JComboBox comboBox;


    /**
     * This interface is to give callback to the controller regarding the user actions and
     * View initialization
     */
    public interface SelectPlayerListener {
        void onViewReady();

        void onButtonSelect(ArrayList<Player> players);
    }

    /**
     * This constructor initiates the listener and drop-down items
     *
     * @param window current frame
     * @param selectPlayerListener the listener of select player
     * @param playerController the class of controller of playerController
     */
    public SelectPlayerView(JFrame window, SelectPlayerListener selectPlayerListener, PlayerController playerController) {
        this.window = window;
        this.selectPlayerListener = selectPlayerListener;
        this.selectPlayerController = playerController;
    }


    /**
     * This method initiates the View for Selecting the number of playerOptions from the dropdown.
     * @param  map the instance of object of geographicalMap
     */
    public void initView(GeographicalMap map) {

        String[] playerOptions = selectPlayerController.getPlayerOptions(map);
        window.getContentPane().removeAll();
        window.setTitle("Select Players Number");

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        window.add(panel);

        GridBagConstraints gridBag = new GridBagConstraints();
        gridBag.gridx = 0;
        gridBag.gridx = 0;
        gridBag.insets = new Insets(2, 2, 2, 2);

        JLabel label = new JLabel("Number of Players : ");
        gridBag.gridx++;
        panel.add(label, gridBag);


        comboBox = new JComboBox(playerOptions);
        comboBox.setMaximumSize(comboBox.getPreferredSize());
        comboBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        gridBag.gridx = 0;
        gridBag.gridx++;
        gridBag.fill = GridBagConstraints.HORIZONTAL;
        panel.add(comboBox, gridBag);
        gridBag.gridx++;

        gridBag.gridx = 0;
        gridBag.gridx++;
        final JButton btn = new JButton("OK");
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn.addActionListener(actionListener);
        panel.add(btn, gridBag);

        window.setVisible(true);
    }


    /**
     * This method makes the View visible and gives callback to the controller {@link controller.game.Game}
     */
    public void show() {
        window.setVisible(true);
        selectPlayerListener.onViewReady();
    }

    /**
     * This method will return the number of playerOptions user selected
     */
    private ActionListener actionListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {

            int numOfPlayers = Integer.parseInt((String) comboBox.getSelectedItem());
            if (numOfPlayers == 1) {
                MessagePanel.showMessage("Game is designed for at least two playerOptions", MessagePanel.Type.Error);
            } else {
                selectPlayerController.initUsers(numOfPlayers);
                selectPlayerListener.onButtonSelect(selectPlayerController.getPlayerOptions());
            }
        }
    };
}
