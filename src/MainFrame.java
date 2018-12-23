import javax.swing.*;

import java.awt.*;

public class MainFrame extends JFrame {

    public static GamePanel panel;
    public static StatusPanel statusPanel;

    public MainFrame() {
        super("Lights Out");
        setLayout(new BorderLayout());
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        statusPanel = new StatusPanel();
        add(statusPanel, BorderLayout.PAGE_END);
        panel = new GamePanel();
        add(panel, BorderLayout.CENTER);
        setVisible(true);

        // setSize(LightsOut.TILE_SIZE * LightsOut.GRID_SIZE, LightsOut.TILE_SIZE *
        // LightsOut.GRID_SIZE);
        pack();
    }

}
