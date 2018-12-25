import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionEvent;
public class ToolBar extends JPanel {
    static int gameDimension = LightsOut.tileSize * LightsOut.gridSize;
    public JButton newGameButton;
    public ToolBar() {
        setPreferredSize(new Dimension(gameDimension, LightsOut.tileSize/2));
        setBackground(Color.WHITE);
        setLayout(new BorderLayout());
        //Setting up the new game button
        newGameButton = new JButton();
        newGameButton.setBackground(new Color(59, 89, 182));
        newGameButton.setForeground(Color.WHITE);
        newGameButton.setFocusPainted(false);
        newGameButton.setFont(new Font("Sans-Serif", Font.PLAIN, 16));
        newGameButton.setPreferredSize(new Dimension(LightsOut.tileSize, LightsOut.tileSize/2));
        newGameButton.setMargin(new Insets(0, 0, 0, 0));
        newGameButton.setAction(new AbstractAction("New Game"){
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.panel.initialize();
                MainFrame.panel.repaint();
            }
        });
        add(newGameButton, BorderLayout.WEST);
    }

}
