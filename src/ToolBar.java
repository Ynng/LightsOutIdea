import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionEvent;
public class ToolBar extends JPanel {
    static int gameDimension = LightsOut.tileSize * LightsOut.gridSize;
    public static ToolBarButton newGameButton;
    public static ToolBarButton toggleDebugButton;
//    public static ToolBarButton solveButton;
    public ToolBar() {
//        setPreferredSize(new Dimension(gameDimension, LightsOut.tileSize/2));
        setBackground(Color.WHITE);
        setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
        //Setting up the new game button
        newGameButton = new ToolBarButton();
        newGameButton.setAction(new AbstractAction("New Game"){
            @Override
            public void actionPerformed(ActionEvent e) {
                LightsOut.newGame();
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

//        solveButton = new ToolBarButton();
//        solveButton.setEnabled(false);
//
//        solveButton.setText("Solving......");
//        solveButton.setAction(new AbstractAction("Solve It For Me") {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                    solveButton.setEnabled(false);
//                    MainFrame.panel.solve(true);
//                solveButton.setText("Solving......");
//                System.out.println("Trying to solve the game");
//            }
//        });
//        add(solveButton);
    }

//    public static void enableSolveButton(){
//        solveButton.setEnabled(true);
//        solveButton.setText("Solve It For Me");
//    }

}
