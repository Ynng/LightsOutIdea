import javax.swing.*;

public class LightsOut {
    //size of every tile, including the margin
    static int TILE_SIZE = 100;
    //the size of the grid used in the game
    static int GRID_SIZE = 5;
    //the distance between evry tile
    static int TILE_MARGIN = 20;
    //the thickness of the border of a tile, if a border is needed.
    static int TILE_BORDER = 5;
    //It's a joke
    static boolean HAS_THE_WORLD_ENDED_YET = false;
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame();
            }
        });

    }

    static int randomRange(int min, int max) {
        int range = (max - min) + 1;
        return (int) (Math.random() * range) + min;
    }
}