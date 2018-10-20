package model.dice;

/**
 * this class is made for dice
 * @author  Napoleon
 */
public class Dice {

    private int value;//value of the dice it can be between 1-6

    /**
     * constructor of the class
     * @param value the value of the dice
     */
    public Dice(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
