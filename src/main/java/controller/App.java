package controller;

import controller.game.Game;

/**
 * this class is made to run the project
 * @author Napoleon
 */
public class App {

    /**
     * this method is written to run the project
     * @param args array of String
     */
    public static void main(String[] args) {
        System.setProperty("org.graphstream.ui.renderer", "org.graphstream.ui.swingViewer.basicRenderer.SwingBasicGraphRenderer");
        Game game = new Game(gameListener);
        game.showInitView();
    }

    /**
     * this is a listener for game
     */
    private static Game.GameListener gameListener = new Game.GameListener() {
        public void onGameFinished() {
            System.exit(0);
        }
    };
}
