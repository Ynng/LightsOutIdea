import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    public GamePanel(int tile, int grid) {
        GridLayout layout = new GridLayout(grid, grid, tile / 15, tile / 15);
        setLayout(layout);
        setBackground(Color.BLUE);
        // for (int i = 0; i < grid; i++) {
        // for (int j = 0; j < grid; j++) {
        // add(new JButton("Button " + i + " " + j));
        // }
        // }
        repaint();
    }

    

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int y = 0;
        for (int i = 0; i < LightsOut.GRID_SIZE; i++) {
            int x = 0;
            for (int j = 0; j < LightsOut.GRID_SIZE; j++) {
                g.setColor(Color.WHITE);
                g.fillRect(x, y, LightsOut.TILE_SIZE, LightsOut.TILE_SIZE);
                g.setColor(Color.GREEN);
                g.drawRect(x, y, LightsOut.TILE_SIZE, LightsOut.TILE_SIZE);

                x+=LightsOut.TILE_SIZE;
            }
            y+=LightsOut.TILE_SIZE;
        }
    }
}
