import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;

public class ToolBar extends JPanel {
    static int gameDimension = LightsOut.tileSize * LightsOut.gridSize;
    public static ToolBarButton newGameButton;
    public static ToolBarButton solveButton;

    public ToolBar() {
        // setPreferredSize(new Dimension(gameDimension, LightsOut.tileSize/2));
        setBackground(Color.WHITE);
        setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
        // Setting up the new game button
        newGameButton = new ToolBarButton();
        newGameButton.setAction(new AbstractAction("New Game") {
            @Override
            public void actionPerformed(ActionEvent e) {
                LightsOut.newGame();
            }
        });
        add(newGameButton);
        solveButton = new ToolBarButton();
        solveButton.setAction(new AbstractAction("Solve it For Me") {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (JOptionPane.showConfirmDialog(null,
                        "This will invalid your score\nAre you sure you want to let a computer solve it for you?",
                        "Lights Out", JOptionPane.YES_NO_OPTION) == 0) {
                    solveButton.setEnabled(false);
                    solveButton.setText("Solved, solution shown");
                    MainFrame.panel.solve(true);
                }

            }
        });
        add(solveButton);

    }

}
