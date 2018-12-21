import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    static private int TILE_SIZE = 100;
    static private int GAME_SIZE = 5;

    private JTextArea text;
    private GamePanel panel;


    public MainFrame() {
        super("Lights Out");
        setLayout(new BorderLayout());
        setResizable(false);

        panel = new GamePanel();
        text = new JTextArea();
        add(panel, BorderLayout.CENTER);

        setSize(TILE_SIZE * GAME_SIZE, TILE_SIZE * GAME_SIZE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
