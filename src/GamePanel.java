import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    public GamePanel() {
        setPreferredSize(
                new Dimension(LightsOut.TILE_SIZE * LightsOut.GRID_SIZE, LightsOut.TILE_SIZE * LightsOut.GRID_SIZE));
        setBackground(Color.PINK);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int y = LightsOut.TILE_MARGIN / 2;
        for (int i = 0; i < LightsOut.GRID_SIZE; i++) {
            int x = LightsOut.TILE_MARGIN / 2;
            for (int j = 0; j < LightsOut.GRID_SIZE; j++) {
                // drawing the border of the tiles
                g.setColor(Color.GREEN);
                g.fillRect(x, y, LightsOut.TILE_SIZE - LightsOut.TILE_MARGIN,
                        LightsOut.TILE_SIZE - LightsOut.TILE_MARGIN);
                // drawing the actuall tiles
                g.setColor(Color.WHITE);
                g.fillRect(x + LightsOut.TILE_BORDER, y + LightsOut.TILE_BORDER,
                        LightsOut.TILE_SIZE - LightsOut.TILE_MARGIN - LightsOut.TILE_BORDER*2,
                        LightsOut.TILE_SIZE - LightsOut.TILE_MARGIN - LightsOut.TILE_BORDER*2);

                x += LightsOut.TILE_SIZE;
            }
            y += LightsOut.TILE_SIZE;
        }
    }
}
