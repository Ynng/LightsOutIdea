import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GamePanel extends JPanel implements MouseListener {
    static int borderedTileSize = LightsOut.tileSize - LightsOut.tileMargin - LightsOut.tileBorder * 2;
    static int normalTileSize = LightsOut.tileSize - LightsOut.tileMargin;
    static int gameDimension = LightsOut.tileSize * LightsOut.gridSize;

    // 2d arrays for storing the light states
    public boolean[][] lights;
    public boolean[][] lightsClicked;
    // step counter to record the number of steps the user have taken
    private int stepCounter;
    private int minimumSteps;

    static int randomRange(int min, int max) {
        int range = (max - min) + 1;
        return (int) (Math.random() * range) + min;
    }

    public static void printBools(boolean[][] input) {
        for (boolean[] list : input) {
            for (boolean light : list) {
                System.out.print((light ? "1" : "0") + " ");
            }
            System.out.print('\n');
        }
    }

    public static int countBools(boolean[][] input) {
        int count = 0;
        for (boolean[] list : input) {
            for (boolean item : list) {
                if (item) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void toggle(boolean[][] input, int row, int col) {

        input[row][col] = !input[row][col];
        if (row - 1 >= 0) {
            input[row - 1][col] = !input[row - 1][col];

        }
        if (row + 1 <= LightsOut.gridSize - 1) {
            input[row + 1][col] = !input[row + 1][col];

        }
        if (col - 1 >= 0) {
            input[row][col - 1] = !input[row][col - 1];

        }
        if (col + 1 <= LightsOut.gridSize - 1) {
            input[row][col + 1] = !input[row][col + 1];

        }

    }

    public GamePanel() {
        setPreferredSize(new Dimension(gameDimension, gameDimension));
        setBackground(Color.PINK);

        // initialize the two arrays
        lights = new boolean[LightsOut.gridSize][LightsOut.gridSize];
        lightsClicked = new boolean[LightsOut.gridSize][LightsOut.gridSize];
        addMouseListener(this);
        initialize();

    }

    public void initialize() {
        // randomly turn on half of the lights
        stepCounter = 0;
        minimumSteps = 0;


        for (boolean[] list : lights) {
            for (boolean item : list) {
                item = false;
            }
        }

        for (boolean[] list : lightsClicked) {
            for (boolean item : list) {
                item = false;
            }
        }
        while (true) {
            int row = randomRange(0, LightsOut.gridSize - 1);
            int col = randomRange(0, LightsOut.gridSize - 1);
            lightsClicked[row][col] = !lightsClicked[row][col];
            toggle(lights, row, col);
            // System.out.println((row + 1) + " " + (col + 1) + "\n");
            if (countBools(lightsClicked) == LightsOut.startingTile)
                break;
        }
        // Prints the answer to the random generated level
        printBools(lightsClicked);
        minimumSteps = countBools(lightsClicked);
        // System.out.println("It will take at least: " + minimumSteps + " steps to
        // complete");
        // MainFrame.statusPanel.mainOutput.setText("This game will take you at least "
        // + minimumSteps + " steps");
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g);
        int y = LightsOut.tileMargin / 2;
        for (int row = 0; row < LightsOut.gridSize; row++) {
            int x = LightsOut.tileMargin / 2;
            for (int col = 0; col < LightsOut.gridSize; col++) {
                if (lightsClicked[row][col] && LightsOut.debugMode) {
                    // drawing the border
                    g2.setColor(Color.GREEN);
                    g2.fillRect(x, y, normalTileSize, normalTileSize);
                    // drawing the actuall tile
                    if (lights[row][col])
                        g2.setColor(Color.WHITE);
                    else
                        g2.setColor(Color.BLACK);
                    g2.fillRect(x + LightsOut.tileBorder, y + LightsOut.tileBorder, borderedTileSize, borderedTileSize);

                } else {
                    // drawing the actuall tiles
                    if (lights[row][col])
                        g2.setColor(Color.WHITE);
                    else
                        g2.setColor(Color.BLACK);
                    g2.fillRect(x, y, normalTileSize, normalTileSize);
                    // drawing the border of the tiles
                }
                x += LightsOut.tileSize;
            }
            y += LightsOut.tileSize;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();
        // System.out.println("Mouse X: " + mouseX + " Mouse Y: " + mouseY);

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        int boxWidth = panelWidth / lights[0].length;
        int boxHeight = panelHeight / lights.length;

        int col = mouseX / boxWidth;
        int row = mouseY / boxHeight;

        stepCounter++;
        toggle(lights, row, col);
        lightsClicked[row][col] = !lightsClicked[row][col];

        if (0 == countBools(lights)) {
            gameOver();
        } else {
            MainFrame.statusPanel.mainOutput.setText("<html>You already took " + stepCounter
                    + " Steps<br> It's possible to finish this game in only " + minimumSteps + " steps! </html>");
        }
        repaint();
    }

    public void gameOver() {
        // display ending messages
        if (stepCounter == minimumSteps)
            MainFrame.statusPanel.mainOutput
                    .setText("<html>You won using the least amount of steps possible!<br>That's only " + minimumSteps
                            + " steps! </html>");
        else {
            MainFrame.statusPanel.mainOutput.setText("<html>You won by only taking " + stepCounter
                    + " steps!<br>That's only " + (stepCounter - minimumSteps) + " extra steps! </html>");
            // System.out.println("You Win!");
            // System.out.println("You took: " + stepCounter + " steps");

            // System.out.println("You took: " + (stepCounter - minimumSteps) + );
        }

        System.out.print('\n');
        System.out.println("Restarting Game");
        initialize();
        // displaySolution();
        // System.exit(0);
    }

    // Useless junk
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    // public int getStepCounter(){
    // return this.stepCounter;
    // }

    // public void setStepCounter(int stepCounter){
    // this.stepCounter = stepCounter;
    // }
}
