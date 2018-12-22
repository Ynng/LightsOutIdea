import javax.swing.*;
import javax.swing.text.JTextComponent;


import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class ToolBar extends JPanel {
    static int GAME_DIMENSION = LightsOut.TILE_SIZE * LightsOut.GRID_SIZE;
    public JLabel stepsTaken;
    public ToolBar() {
        setPreferredSize(new Dimension(GAME_DIMENSION, LightsOut.TILE_SIZE));
        setBackground(Color.BLUE);
        setLayout(new BorderLayout());
        //Setting up the step counter
        stepsTaken = new JLabel("TEST");
        stepsTaken.setForeground(Color.WHITE);
        stepsTaken.setPreferredSize(new Dimension(LightsOut.TILE_SIZE, LightsOut.TILE_SIZE));
        stepsTaken.setFont(new Font("Sans-Serif", Font.PLAIN, 24));
        add(stepsTaken, BorderLayout.WEST);
    }

}
