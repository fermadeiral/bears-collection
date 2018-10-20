package view;

import model.map.Country;
import model.player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class shows a pop-up window to initiate the attack
 *
 * @author Mahedi Hassan
 */
public class AttackView {
    private Country country;
    private JComboBox adjacentCountriesCombo;
    private JComboBox reinforcementCombo;
    private AttackListener attackListener;


    /**
     * this class of interface is written for attack
     *
     * @author Mahedi Hassan
     */
    public interface AttackListener {
        void onAttack(Country attacker, Country attacked);

        void onReinforcement(Country country, Player player, int newArmies);

        void onAttackCancel();
    }

    /**
     * constructor of the class
     *
     * @param country the instance of the country
     */
    public AttackView(Country country) {
        this.country = country;
    }


    /**
     * This method initiates the view for pop-up window and takes input from the player
     *
     * @param attackListener the listener of attackListener
     * @param player         the instance of the player
     */
    public void showDetails(final AttackListener attackListener, final Player player) {
        this.attackListener = attackListener;
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gridBag = new GridBagConstraints();
        gridBag.gridx = 0;
        gridBag.gridx = 0;
        gridBag.insets = new Insets(2, 2, 2, 2);
        JLabel reinforcement = new JLabel("Reinforcement : ");
        gridBag.gridx = 0;
        gridBag.gridx++;
        panel.add(reinforcement, gridBag);
        final String[] armyArray = this.getArrayOfArmies(player.getTotalReservedArmies());
        reinforcementCombo = new JComboBox(armyArray);
        reinforcementCombo.setMaximumSize(reinforcementCombo.getPreferredSize());
        reinforcementCombo.setAlignmentX(Component.CENTER_ALIGNMENT);
        gridBag.gridx++;
        gridBag.fill = GridBagConstraints.HORIZONTAL;
        panel.add(reinforcementCombo, gridBag);
        gridBag.gridx++;
        final JButton btn = new JButton("Add");
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int army = 0;
                if (armyArray.length > 0) {
                    army = Integer.parseInt((String) reinforcementCombo.getSelectedItem());
                }
                attackListener.onReinforcement(country, player, army > 0 ? army : 0);
                Window w = SwingUtilities.getWindowAncestor(btn);
                if (w != null) {
                    w.setVisible(false);
                }
            }
        });
        panel.add(btn, gridBag);
        JLabel countryLabel = new JLabel("Country : " + country.getName());
        gridBag.gridx = 0;
        gridBag.gridx++;
        panel.add(countryLabel, gridBag);
        JLabel armyLabel = new JLabel("Army : " + country.getArmyCount());
        gridBag.gridx++;
        panel.add(armyLabel, gridBag);
        JLabel attackTo = new JLabel("Attack To : ");
        gridBag.gridx = 0;
        gridBag.gridx++;
        panel.add(attackTo, gridBag);
        adjacentCountriesCombo = new JComboBox(getAdjacentCountriesName(country));
        adjacentCountriesCombo.setMaximumSize(adjacentCountriesCombo.getPreferredSize());
        adjacentCountriesCombo.setAlignmentX(Component.CENTER_ALIGNMENT);
        gridBag.gridx++;
        gridBag.fill = GridBagConstraints.HORIZONTAL;
        panel.add(adjacentCountriesCombo, gridBag);
        gridBag.gridx++;
        int result = JOptionPane.showOptionDialog(null, panel, country.getOwner().getName(),
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, null, null);
        if (result == JOptionPane.OK_OPTION) {
            attackListener.onAttack(country, country.getAdjacentCountries().get(adjacentCountriesCombo.getSelectedIndex()));
        }
    }


    /**
     * this method is written to get array of armies
     *
     * @param armies the number of armies
     * @return the array of string of armies
     */
    private String[] getArrayOfArmies(int armies) {
        String[] tmpArmies = new String[armies - 1];
        for (int i = 1; i < armies; i++) {
            tmpArmies[i - 1] = String.valueOf(i);
        }
        return tmpArmies;
    }


    /**
     * Calculates the name of adjacent countries and returns a String array
     *
     * @param country the instance of the country
     * @return the array of string of adjacent countries
     */
    private String[] getAdjacentCountriesName(Country country) {
        String[] countriesName = new String[country.getAdjacentCountries().size()];
        int i = 0;
        for (Country tmpCountry : country.getAdjacentCountries()) {
            countriesName[i] = tmpCountry.getName();
            i++;
        }
        return countriesName;
    }
}