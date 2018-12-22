import javax.swing.*;

public class LightsOut {
    static int TILE_SIZE = 100;
    static int GRID_SIZE = 5;
    static int TILE_MARGIN = 10;
    static int TILE_BORDER = 5;

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