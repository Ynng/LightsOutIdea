import javax.swing.*;

public class LightsOut {
    // size of every tile, including the margin
    static int TILE_SIZE = 100;
    // the size of the grid used in the game
    static int GRID_SIZE = 5;
    // the distance between every tile
    static int TILE_MARGIN = 15;
    // the thickness of the border of a tile, if a border is needed.
    static int TILE_BORDER = 5;
    // the number of tiles turned on at the start
    static int STARTING_TILE = GRID_SIZE * GRID_SIZE / 2;
    // To display information that's bad for the gameplay but good for debugging
    static boolean DEBUG_MODE = true;

    static int randomRange(int min, int max) {
        int range = (max - min) + 1;
        return (int) (Math.random() * range) + min;
    }

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