import javax.swing.*;

public class LightsOut {

    static private int TILE_SIZE = 100;
    static private int GAME_SIZE = 5;

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Lights Out");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setResizable(false);
                frame.setSize(TILE_SIZE * GAME_SIZE, TILE_SIZE * GAME_SIZE);
                frame.setVisible(true);

            }
        });

    }
}