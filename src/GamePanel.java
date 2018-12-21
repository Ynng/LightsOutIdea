import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    public GamePanel(int tile, int grid) {
        GridLayout layout = new GridLayout(grid, grid, tile / 15, tile / 15);
        setLayout(layout);
        setBackground(Color.white);
        // for (int i = 0; i < grid; i++) {
        // for (int j = 0; j < grid; j++) {
        // add(new JButton("Button " + i + " " + j));
        // }
        // }
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < LightsOut.GRID_SIZE; i++) {
            for (int j = 0; j < LightsOut.GRID_SIZE; j++) {
                add(new JButton("Button " + i + " " + j));
            }
        }
    }
}
