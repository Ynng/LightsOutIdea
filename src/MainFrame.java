import javax.swing.*;
import javax.tools.Tool;

import java.awt.*;

public class MainFrame extends JFrame {

    public GamePanel panel;
    public ToolBar toolBar;
    public MainFrame() {
        super("Lights Out");
        setLayout(new BorderLayout());
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        toolBar = new ToolBar();
        add(toolBar, BorderLayout.PAGE_END);
        panel = new GamePanel();
        add(panel, BorderLayout.CENTER);

        // setSize(LightsOut.TILE_SIZE * LightsOut.GRID_SIZE, LightsOut.TILE_SIZE * LightsOut.GRID_SIZE);
        pack();
        setVisible(true);
    }

    
}
