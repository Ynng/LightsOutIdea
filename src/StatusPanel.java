import javax.swing.*;


import java.awt.*;
public class StatusPanel extends JPanel {
    static int GAME_DIMENSION = LightsOut.tileSize * LightsOut.gridSize;
    public JLabel mainOutput;
    public StatusPanel() {
        setPreferredSize(new Dimension(GAME_DIMENSION, LightsOut.tileSize));
        setBackground(Color.WHITE);
        setLayout(new BorderLayout());
        //Setting up the step counter
        mainOutput = new JLabel();
        mainOutput.setForeground(Color.BLACK);
        mainOutput.setMinimumSize(new Dimension(LightsOut.tileSize, LightsOut.tileSize));
        mainOutput.setFont(new Font("Sans-Serif", Font.PLAIN, 18));
        add(mainOutput, BorderLayout.WEST);

    }

}
