import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {


    private GamePanel panel;


    public MainFrame(int tile, int grid) {
        super("Lights Out");
        setLayout(new BorderLayout());
        setResizable(false);

        panel = new GamePanel(tile, grid);
        add(panel, BorderLayout.CENTER);

        setSize(tile * grid, tile * grid);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
