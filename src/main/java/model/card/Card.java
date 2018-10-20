package model.card;

import java.util.UUID;

/**
 * this class is made for model of cards
 *
 * @author Mina
 */
public class Card {

    private Type type; //type of card
    private String id;


    /**
     * the enum class of type pf cards
     *
     * @author mina
     */
    enum Type {
        Infantry(0), Cavalry(1), Artillery(2); //card can be between these tree types
        private int value;

        Type(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    /**
     * the constructor of the class
     *
     * @param type type of the card
     */
    public Card(Type type) {
        this.id = UUID.randomUUID().toString();
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public String getId() {
        return id;
    }
}
