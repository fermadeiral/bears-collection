package view;

import javax.swing.*;


/**
 * @author Mina
 * This class is made for methoding related to messages
 */
public class MessagePanel {

    /**
     * this class of enum is made for Type of messages
     */
    public enum Type {
        Error, Info
    }

    public static final String Message_Error = "Error";//this is a static final String for Error Message
    public static final String Message_Info = "Info";//this is a static final String for Info Message


    /**
     * This method is made for showing error message
     *
     * @param message the string text of message
     * @param  type the type of message
     */
    public static void showMessage(String message, Type type) {
        final JPanel panel = new JPanel();
        if (type.toString().equals(Type.Info.toString())) {
            JOptionPane.showMessageDialog(panel, message, Message_Info, JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(panel, message, Message_Error, JOptionPane.ERROR_MESSAGE);
        }
    }

}
