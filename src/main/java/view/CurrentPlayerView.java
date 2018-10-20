package view;

import model.player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * This class initiates the view for Current Player selection
 *
 * @author Mahedi Hassan
 */

public class CurrentPlayerView {

    private static JComboBox comboBox;
    private CurrentPlayerListener listener;

    public interface CurrentPlayerListener{
        void onPlayerSelected(int selectedIndex);
    }

    /**
     * this method is written to show the current player view
     * @param players the list of players
     * @param listener the listener of the current player
     * @return panel of the view
     */
    public JPanel showCurrentPlayerView(ArrayList<Player> players, CurrentPlayerListener listener){
        this.listener = listener;
        String [] playersName = new String[players.size()];
        int i = 0;
        for (Player player : players){
            playersName[i] = player.getName();
            i++;
        }
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
//        window.add(panel);

        GridBagConstraints gridBag = new GridBagConstraints();
        gridBag.gridx = 0;
        gridBag.gridx = 0;
        gridBag.insets = new Insets(2, 2, 2, 2);

        JLabel label = new JLabel("Now Playing : ");
        gridBag.gridx++;
        panel.add(label, gridBag);


        comboBox = new JComboBox(playersName);
        comboBox.setMaximumSize(comboBox.getPreferredSize());
        comboBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        gridBag.gridx = 0;
        gridBag.gridx++;
        gridBag.fill = GridBagConstraints.HORIZONTAL;
        panel.add(comboBox, gridBag);
        gridBag.gridx++;
        comboBox.addActionListener(actionListener);
        return panel;
    }

    /**
     * this is a variable of  ActionListener that create for combobox of player
     */
    private ActionListener actionListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            listener.onPlayerSelected(comboBox.getSelectedIndex());
        }
    };
}
