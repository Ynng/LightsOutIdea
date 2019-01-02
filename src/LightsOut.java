import javax.swing.*;

public class LightsOut {
    // size of every tile, including the margin
    static int tileSize = 100;
    // the size of the grid used in the game
    static int gridSize = 5;
    // the distance between every tile
    static int tileMargin = 15;
    // the thickness of the border of a tile, if a border is needed.
    static int tileBorder = 5;
    // the number of tiles turned on at the start
    // static int startingTile = (gridSize * gridSize) / 2;
    // To display information that's bad for the gameplay but good for debugging
    static boolean debugMode = true;

    public static MainFrame frame = null;

    public static void main(String[] args) {
        newGame();
    }

    public static void newGame(){
        if(frame!=null)frame.dispose();
        getGridSize();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame = new MainFrame();
            }
        });
    }

    public static void getGridSize() {// Creates dialog boxes to ask for row and column dimensions
        String gridInput = null;
        try {
            gridInput = JOptionPane.showInputDialog("Enter the size of grid you want to play on (default is "+gridSize+")");
            if(Integer.parseInt(gridInput)<2){
                JOptionPane.showMessageDialog(null, "Please enter a number larger than 1");
                getGridSize();
            }
            else gridSize = Integer.parseInt(gridInput);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "No Input/Invalid Input is detected, the default value "+gridSize+" is used");
        }
    }

    public static void gameOver() {
        if (JOptionPane.showConfirmDialog(null, "You Won!\nPlay Again?", "Lights Out",
                JOptionPane.YES_NO_OPTION) != 0) {
            JOptionPane.showMessageDialog(null, "Thanks for Playing!");
        } else{
            newGame();
        }
        frame.dispose();
    }


}