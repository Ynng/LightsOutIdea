import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class GamePanel extends JPanel {
    static int TILE_SIZE_WITH_BORDER = LightsOut.TILE_SIZE - LightsOut.TILE_MARGIN - LightsOut.TILE_BORDER * 2;

    public GamePanel() {
        setPreferredSize(
                new Dimension(LightsOut.TILE_SIZE * LightsOut.GRID_SIZE, LightsOut.TILE_SIZE * LightsOut.GRID_SIZE));
        setBackground(Color.PINK);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g);
        int y = LightsOut.TILE_MARGIN / 2;
        for (int i = 0; i < LightsOut.GRID_SIZE; i++) {
            int x = LightsOut.TILE_MARGIN / 2;
            for (int j = 0; j < LightsOut.GRID_SIZE; j++) {
                if (LightsOut.HAS_THE_WORLD_ENDED_YET) {

                    // drawing the actuall tiles
                    g2.setColor(Color.WHITE);
                    // g2.fillRect(x + LightsOut.TILE_BORDER, y + LightsOut.TILE_BORDER,
                    // ACTUALL_TILE_SIZE, ACTUALL_TILE_SIZE);
                    g2.fillRect(x, y, LightsOut.TILE_SIZE - LightsOut.TILE_MARGIN,
                            LightsOut.TILE_SIZE - LightsOut.TILE_MARGIN);
                    // drawing the border of the tiles
                } else {
                    // drawing the border
                    g2.setColor(Color.GREEN);
                    g2.fillRect(x, y, LightsOut.TILE_SIZE - LightsOut.TILE_MARGIN,
                            LightsOut.TILE_SIZE - LightsOut.TILE_MARGIN);
                    // drawing the actuall tile
                    g2.setColor(Color.WHITE);
                    g2.fillRect(x + LightsOut.TILE_BORDER, y + LightsOut.TILE_BORDER, TILE_SIZE_WITH_BORDER,
                            TILE_SIZE_WITH_BORDER);

                }

                x += LightsOut.TILE_SIZE;
            }
            y += LightsOut.TILE_SIZE;
        }
    }
}
