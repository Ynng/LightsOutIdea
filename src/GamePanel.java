import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    public GamePanel(int tile, int grid) {
        GridLayout layout = new GridLayout(grid, grid, tile / 15, tile / 15);
        setLayout(layout);
        for (int i = 0; i < grid; i++) {
            for (int j = 0; j < grid; j++) {
                add(new LightButton("Button " + i + " " + j, true));
            }
        }
        setBackground(Color.white);
    }
}
