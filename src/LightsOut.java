import javax.swing.*;

public class LightsOut {
    static int TILE_SIZE = 100;
    static int GRID_SIZE = 5;

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainFrame frame = new MainFrame();
            }
        });

    }
}