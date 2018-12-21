import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    static private int TILE_SIZE = 100;
    static private int GAME_SIZE = 5;

    public MainFrame() {
        super("Lights Out");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(TILE_SIZE * GAME_SIZE, TILE_SIZE * GAME_SIZE);
        setVisible(true);
    }
}
