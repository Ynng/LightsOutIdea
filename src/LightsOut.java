import javax.swing.*;

public class LightsOut {
    // size of every tile, including the margin
    static int tileSize = 100;
    // the size of the grid used in the game
    static int gridSize = 5;
    // the distance between every tile
    static int tileMargin = 15;
    // the thickness of the border of a tile, if a border is needed.
    static int tileBorder = 5;
    // the number of tiles turned on at the start
    static int startingTile = gridSize * gridSize / 2;
    // To display information that's bad for the gameplay but good for debugging
    static boolean debugMode = true;

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LightsOut();
            }
        });

    }

    public LightsOut() {
        new MainFrame();
    }

}