import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {


    private GamePanel panel;


    public MainFrame() {
        super("Lights Out");
        setLayout(new BorderLayout());
        setResizable(false);

        panel = new GamePanel(LightsOut.TILE_SIZE, LightsOut.TILE_SIZE);
        add(panel, BorderLayout.CENTER);

        setSize(LightsOut.TILE_SIZE * LightsOut.GRID_SIZE, LightsOut.TILE_SIZE * LightsOut.GRID_SIZE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
