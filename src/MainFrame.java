import javax.swing.*;

import java.awt.*;

public class MainFrame extends JFrame {

    public static GamePanel panel;
    public static MessageLabel message;
    public static StatusPanel statusPanel;
    public static ToolBar toolbar;

    public MainFrame() {
        super("Lights Out");
        setLayout(new BorderLayout());
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(300, 400));

        toolbar = new ToolBar();
        add(toolbar, BorderLayout.PAGE_START);
        statusPanel = new StatusPanel();
        add(statusPanel, BorderLayout.PAGE_END);
        message = new MessageLabel(); 
        add(message, BorderLayout.CENTER);
        panel = new GamePanel();
        setVisible(true);
        pack();

        // setSize(LightsOut.tileSize * LightsOut.gridSize, LightsOut.tileSize *
        // LightsOut.gridSize);
//        pack();
    }

    public void startGame(){
//        panel.repaint();
        add(panel, BorderLayout.CENTER);
        message.setVisible(false);
        panel.setVisible(true);
        pack();

    }

}
