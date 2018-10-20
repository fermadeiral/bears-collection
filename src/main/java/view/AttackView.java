package view;

import controller.FortificationController;
import model.map.Country;
import model.player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


/**
 * This class shows a pop-up window to initiate the attack
 *
 * @author Mahedi Hassan
 */
public class AttackView {
    private FortificationController fortificationController;
    private Country country;
    private JComboBox adjacentCountriesCombo;
    private JComboBox fortCountryCombo;
    private JComboBox fortArmyCombo;
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
        void onFortification(Country countryGainsArmy, Country countryLosesArmy, Player player, int newArmies);

        void onAttackCancel();
    }

    /**
     * constructor of the class
     *
     * @param country the instance of the country
     */
    public AttackView(Country country) {
        this.country = country;
        fortificationController = new FortificationController();
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

        fortificationView(attackListener, player, panel, gridBag);

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
        gridBag.gridx++;
        gridBag.gridx++;
        gridBag.fill = GridBagConstraints.HORIZONTAL;
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
     *
     * this method is written to get array of armies
     *
     * @param attackListener
     * @param player
     * @param panel
     * @param gridBag
     */
    private void fortificationView(AttackListener attackListener, Player player, JPanel panel, GridBagConstraints gridBag) {
        gridBag.gridx = 0;
        gridBag.gridx = 0;
        gridBag.insets = new Insets(2, 2, 2, 2);
        JLabel reinforcement = new JLabel("Fortification : ");
        gridBag.gridx = 0;
        gridBag.gridx++;
        panel.add(reinforcement, gridBag);

        final ArrayList<Country> countryArray = fortificationController.getFortificationCountries(country);
        String[] countryNameArray = null;
        int i = 0;
        if (countryArray.size() > 0){
            countryNameArray = new String [countryArray.size()];
            for (Country country :countryArray){
                countryNameArray[i] = country.getName();
                i++;
            }
        }

        fortCountryCombo = new JComboBox(countryNameArray == null ? new String [] {} : countryNameArray);
        fortCountryCombo.setMaximumSize(fortCountryCombo.getPreferredSize());
        fortCountryCombo.setAlignmentX(Component.CENTER_ALIGNMENT);
        gridBag.gridx++;
        gridBag.fill = GridBagConstraints.HORIZONTAL;
        panel.add(fortCountryCombo, gridBag);
        gridBag.gridx++;
        fortCountryCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (countryArray.size() > 0) {
                    DefaultComboBoxModel model = new DefaultComboBoxModel(getArrayOfArmies(countryArray.get(fortCountryCombo.getSelectedIndex()).getArmyCount()));
                    fortArmyCombo.setModel(model);
                }
            }
        });

        String [] fortificationArmy = loadFortificationArmy(gridBag, panel, (countryArray.size() > 0 ? countryArray.get(0) : null));

        final JButton btn = new JButton("Move");
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (fortArmyCombo != null && fortCountryCombo != null){
                    int army = 0;
                    if (fortificationArmy != null && fortificationArmy.length > 0){
                        army = Integer.parseInt((String) fortArmyCombo.getSelectedItem());
                        Country countryLosesArmy = countryArray.get(fortCountryCombo.getSelectedIndex());
                        if (countryLosesArmy.getArmyCount() > army){
                            attackListener.onFortification(country, countryLosesArmy, player, army);
                        }
                        else {
                            MessagePanel.showMessage("A country must have at-least one army", MessagePanel.Type.Error);
                        }
                    }
                    Window w = SwingUtilities.getWindowAncestor(btn);
                    if (w != null) {
                        w.setVisible(false);
                    }
                }
            }
        });
        panel.add(btn, gridBag);
    }

    private String[] loadFortificationArmy(GridBagConstraints gridBag, JPanel panel, Country country){
        String[] armyArray = null;
        if (country != null){
            armyArray = this.getArrayOfArmies(country.getArmyCount());
        }
        fortArmyCombo = new JComboBox(armyArray == null ? new String[]{} : armyArray);
        fortArmyCombo.setMaximumSize(fortArmyCombo.getPreferredSize());
        fortArmyCombo.setAlignmentX(Component.CENTER_ALIGNMENT);
        gridBag.gridx++;
        gridBag.fill = GridBagConstraints.HORIZONTAL;
        panel.add(fortArmyCombo, gridBag);
        gridBag.gridx++;
        return armyArray;
    }

    private String[] getArrayOfArmies(int armies) {
        String[] tmpArmies = new String[armies];
        for (int i = 1; i < armies + 1; i++){
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