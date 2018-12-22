import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GamePanel extends JPanel implements MouseListener {
    static int TILE_SIZE_WITH_BORDER = LightsOut.TILE_SIZE - LightsOut.TILE_MARGIN - LightsOut.TILE_BORDER * 2;
    static int TILE_SIZE_WITH_MARGIN = LightsOut.TILE_SIZE - LightsOut.TILE_MARGIN;
    static int GAME_DIMENSION = LightsOut.TILE_SIZE * LightsOut.GRID_SIZE;

    // 2d arrays for storing the light states
    public boolean[][] lights;
    public boolean[][] lightsClicked;
    // stepp counter to record the number of steps the user have taken
    private int stepCounter;
    private int minimumSteps;
    private ToolBar toolbar;

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
        if (row + 1 <= LightsOut.GRID_SIZE - 1) {
            input[row + 1][col] = !input[row + 1][col];

        }
        if (col - 1 >= 0) {
            input[row][col - 1] = !input[row][col - 1];

        }
        if (col + 1 <= LightsOut.GRID_SIZE - 1) {
            input[row][col + 1] = !input[row][col + 1];

        }

    }

    public GamePanel(ToolBar toolbar) {
        this.toolbar = toolbar;
        setPreferredSize(new Dimension(GAME_DIMENSION, GAME_DIMENSION));
        setBackground(Color.PINK);

        // initialize the two arrays
        lights = new boolean[LightsOut.GRID_SIZE][LightsOut.GRID_SIZE];
        lightsClicked = new boolean[LightsOut.GRID_SIZE][LightsOut.GRID_SIZE];
        addMouseListener(this);
        initialize();

    }

    public void initialize() {
        // randomly turn on half of the lights
        stepCounter = 0;
        minimumSteps = 0;
        while (true) {
            int row = LightsOut.randomRange(0, LightsOut.GRID_SIZE - 1);
            int col = LightsOut.randomRange(0, LightsOut.GRID_SIZE - 1);
            lightsClicked[row][col] = !lightsClicked[row][col];
            toggle(lights, row, col);
            // System.out.println((row + 1) + " " + (col + 1) + "\n");
            if (countBools(lightsClicked) == LightsOut.STARTING_TILE)
                break;
        }
        // Prints the answer to the random generated level
        printBools(lightsClicked);
        minimumSteps = countBools(lightsClicked);
        System.out.println("It will take at least: " + minimumSteps + " steps to complete");
        toolbar.mainOutput.setText("This game will take you at least " + minimumSteps + " steps");
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g);
        int y = LightsOut.TILE_MARGIN / 2;
        for (int row = 0; row < LightsOut.GRID_SIZE; row++) {
            int x = LightsOut.TILE_MARGIN / 2;
            for (int col = 0; col < LightsOut.GRID_SIZE; col++) {
                if (lightsClicked[row][col] && LightsOut.DEBUG_MODE) {
                    // drawing the border
                    g2.setColor(Color.GREEN);
                    g2.fillRect(x, y, TILE_SIZE_WITH_MARGIN, TILE_SIZE_WITH_MARGIN);
                    // drawing the actuall tile
                    if (lights[row][col])
                        g2.setColor(Color.WHITE);
                    else
                        g2.setColor(Color.BLACK);
                    g2.fillRect(x + LightsOut.TILE_BORDER, y + LightsOut.TILE_BORDER, TILE_SIZE_WITH_BORDER,
                            TILE_SIZE_WITH_BORDER);

                } else {
                    // drawing the actuall tiles
                    if (lights[row][col])
                        g2.setColor(Color.WHITE);
                    else
                        g2.setColor(Color.BLACK);
                    g2.fillRect(x, y, TILE_SIZE_WITH_MARGIN, TILE_SIZE_WITH_MARGIN);
                    // drawing the border of the tiles
                }
                x += LightsOut.TILE_SIZE;
            }
            y += LightsOut.TILE_SIZE;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();
        System.out.println("Mouse X: " + mouseX + " Mouse Y: " + mouseY);

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
            toolbar.mainOutput.setText("<html>You already took " + stepCounter
                    + " Steps<br> It's possible to finish this game in only " + minimumSteps + " steps! </html>");
        }
        repaint();
    }

    public void gameOver() {
        // display ending messages
        if (stepCounter == minimumSteps)
            toolbar.mainOutput.setText("<html>You won using the least amount of steps possible!<br>That's only "
                    + minimumSteps + " steps! </html>");
        else {
            toolbar.mainOutput.setText("<html>You won by only taking " + stepCounter + " steps!<br>That's only "
                    + (stepCounter - minimumSteps) + " extra steps! </html>");
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
}
