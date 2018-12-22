import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class GamePanel extends JPanel {
    static int TILE_SIZE_WITH_BORDER = LightsOut.TILE_SIZE - LightsOut.TILE_MARGIN - LightsOut.TILE_BORDER * 2;
    static int TILE_SIZE_WITH_MARGIN = LightsOut.TILE_SIZE - LightsOut.TILE_MARGIN;

    // 2d arrays for storing the light states
    private boolean[][] lights;
    private boolean[][] lightsClicked;
    // stepp counter to record the number of steps the user have taken
    public int stepCounter = 0;

    public GamePanel() {
        setPreferredSize(
                new Dimension(LightsOut.TILE_SIZE * LightsOut.GRID_SIZE, LightsOut.TILE_SIZE * LightsOut.GRID_SIZE));
        setBackground(Color.PINK);

        // initialize the two arrays
        lights = new boolean[LightsOut.GRID_SIZE][LightsOut.GRID_SIZE];
        lightsClicked = new boolean[LightsOut.GRID_SIZE][LightsOut.GRID_SIZE];

        // randomly turn on 10 lights
        while (true) {
            int x = LightsOut.randomRange(0, LightsOut.GRID_SIZE-1);
            int y = LightsOut.randomRange(0, LightsOut.GRID_SIZE-1);
            lightsClicked[x][y] = !lightsClicked[x][y];
            // System.out.println((x + 1) + " " + (y + 1) + "\n");
            toggle(lights, x, y);
            if (countBools(lights) == 10)
                break;
        }
        printBools(lightsClicked);
        System.out.println("It will take atleast: " + countBools(lightsClicked) + " steps to complete");

    }

    public void printBools(boolean[][] input) {
        for (boolean[] list : input) {
            for (boolean light : list) {
                System.out.print((light ? "1" : "0") + " ");
            }
            System.out.print('\n');
        }
    }

    public int countBools(boolean[][] input) {
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

    public void toggle(boolean[][] input, int row, int col) {

        input[row][col] = !input[row][col];
        if (row - 1 >= 0) {
            input[row - 1][col] = !input[row - 1][col];

        }
        if (row + 1 <= LightsOut.GRID_SIZE-1) {
            input[row + 1][col] = !input[row + 1][col];

        }
        if (col - 1 >= 0) {
            input[row][col - 1] = !input[row][col - 1];

        }
        if (col + 1 <= LightsOut.GRID_SIZE-1) {
            input[row][col + 1] = !input[row][col + 1];

        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g);
        int y = LightsOut.TILE_MARGIN / 2;
        for (int i = 0; i < LightsOut.GRID_SIZE; i++) {
            int x = LightsOut.TILE_MARGIN / 2;
            for (int j = 0; j < LightsOut.GRID_SIZE; j++) {
                if (lightsClicked[i][j]) {

                    // drawing the border
                    g2.setColor(Color.GREEN);
                    g2.fillRect(x, y, TILE_SIZE_WITH_MARGIN, TILE_SIZE_WITH_MARGIN);
                    // drawing the actuall tile
                    if (lights[i][j])
                        g2.setColor(Color.WHITE);
                    else
                        g2.setColor(Color.BLACK);
                    g2.fillRect(x + LightsOut.TILE_BORDER, y + LightsOut.TILE_BORDER, TILE_SIZE_WITH_BORDER,
                            TILE_SIZE_WITH_BORDER);

                } else {
                    // drawing the actuall tiles
                    if (lights[i][j])
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
}
