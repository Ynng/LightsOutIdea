import javax.swing.*;

import java.awt.*;

public class MainFrame extends JFrame {

    public static GamePanel panel;
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
        panel = new GamePanel();
        add(panel, BorderLayout.CENTER);
        setVisible(true);
        pack();
    }


}
