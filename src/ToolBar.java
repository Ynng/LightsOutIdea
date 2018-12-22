import javax.swing.*;


import java.awt.*;
public class ToolBar extends JPanel {
    static int GAME_DIMENSION = LightsOut.TILE_SIZE * LightsOut.GRID_SIZE;
    public JLabel mainOutput;
    public ToolBar() {
        setPreferredSize(new Dimension(GAME_DIMENSION, LightsOut.TILE_SIZE));
        setBackground(Color.WHITE);
        setLayout(new BorderLayout());
        //Setting up the step counter
        mainOutput = new JLabel();
        mainOutput.setForeground(Color.BLACK);
        mainOutput.setMinimumSize(new Dimension(LightsOut.TILE_SIZE, LightsOut.TILE_SIZE));
        mainOutput.setFont(new Font("Sans-Serif", Font.PLAIN, 18));
        
        add(mainOutput, BorderLayout.WEST);
    }

}
