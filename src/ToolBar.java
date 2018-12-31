import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionEvent;
public class ToolBar extends JPanel {
    static int gameDimension = LightsOut.tileSize * LightsOut.gridSize;
    public ToolBarButton newGameButton;
    public ToolBarButton toggleDebugButton;
    public ToolBar() {
//        setPreferredSize(new Dimension(gameDimension, LightsOut.tileSize/2));
        setBackground(Color.WHITE);
        setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
        //Setting up the new game button
        newGameButton = new ToolBarButton();
        newGameButton.setAction(new AbstractAction("New Game"){
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.panel.initialize();
                MainFrame.panel.repaint();
            }
        });
        add(newGameButton);
        toggleDebugButton = new ToolBarButton();
        toggleDebugButton.setAction(new AbstractAction("Toggle Debug"){
            @Override
            public void actionPerformed(ActionEvent e) {
                LightsOut.debugMode=!LightsOut.debugMode;
                MainFrame.panel.repaint();
            }
        });
        add(toggleDebugButton);
    }

}
