import java.awt.*;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;

public class LightsOut extends JPanel implements MouseListener {
    private static final long serialVersionUID = 1L;
    private boolean[][] lights;
    private boolean[][] lightsClicked;
    private int stepCounter = 0;
    private static int WINDOW_SIZE = 500;

    public static void main(String[] args) {
        // inialitizing Jframe
        JFrame frame = new JFrame("Lights Out!");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        // Initializintg the panel
        LightsOut panel = new LightsOut();

        panel.addMouseListener(panel);
        panel.setPreferredSize(new Dimension(WINDOW_SIZE, WINDOW_SIZE));
        panel.setMinimumSize(new Dimension(WINDOW_SIZE, WINDOW_SIZE));

        // inializting container
        Container c = frame.getContentPane();
        c.setLayout(new BorderLayout());
        c.add(panel, BorderLayout.CENTER);

        frame.pack();
    }

    // To generate a random number between two values
    int randomRange(int min, int max) {
        int range = (max - min) + 1;
        return (int) (Math.random() * range) + min;
    }

    public LightsOut() {
        // initialize the two arrays
        lights = new boolean[5][5];
        lightsClicked = new boolean[5][5];
        // randomly turn on 10 lights

        while (true) {
            int x = randomRange(0, 4);
            int y = randomRange(0, 4);
            lightsClicked[x][y] = !lightsClicked[x][y];
            // System.out.println((x + 1) + " " + (y + 1) + "\n");
            toggle(x, y);
            if (countBools(lights) == 10)
                break;
        }
        // display best answer to the question
        displaySolution();
        System.out.println("It will take atleast: " + countBools(lightsClicked) + " steps to complete");

    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int boxWidth = WINDOW_SIZE / 5;
        int boxHeight = WINDOW_SIZE / 5;

        int y = 0;
        for (int row = 0; row < 5; row++) {
            int x = 0;
            for (int col = 0; col < 5; col++) {
                if (lights[row][col]) {
                    g.setColor(Color.WHITE);
                } else {
                    g.setColor(Color.DARK_GRAY);
                }
                g.fillRect(x, y, boxWidth, boxHeight);

                g.setColor(Color.GREEN);
                g.drawRect(x, y, boxWidth, boxHeight);
                x += boxWidth;
            }
            y += boxHeight;
        }
    }

    // called when the mouse is pressed - determines what row/column the user
    // has clicked

    public void mousePressed(MouseEvent e) {
        // boolean finished = true;
        int mouseX = e.getX();
        int mouseY = e.getY();

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        int boxWidth = panelWidth / lights[0].length;
        int boxHeight = panelHeight / lights.length;

        int col = mouseX / boxWidth;
        int row = mouseY / boxHeight;

        toggle(row, col);
        repaint();
        stepCounter++;
        // Check if you won

        // outerloop: for (int x = 0; x < 5; x++) {
        // for (int y = 0; y < 5; y++) {
        // if (lights[x][y]) {
        // finished = false;
        // break outerloop;
        // }
        // }
        // }
        if (0 == countBools(lights)) {
            endGame();
        } else
            System.out.println("You already took: " + stepCounter + " steps");

    }

    public void endGame() {
        // display ending messages
        System.out.println("You Win!");
        System.out.println("You took: " + stepCounter + " steps");
        System.out.println("You took: " + (stepCounter - countBools(lightsClicked)) + " extra steps");
        System.out.print('\n');
        // displaySolution();
        System.exit(0);
    }

    public void displaySolution() {
        for (boolean[] list : lightsClicked) {
            for (boolean light : list) {
                System.out.print((light ? "1" : "0") + " ");
            }
            System.out.print('\n');
        }
    }

    // called to "toggle" the selected row and column, as well as the four
    // adjacent lights
    public void toggle(int row, int col) {

        lights[row][col] = !lights[row][col];
        if (row - 1 >= 0) {
            lights[row - 1][col] = !lights[row - 1][col];

        }
        if (row + 1 <= 4) {
            lights[row + 1][col] = !lights[row + 1][col];

        }
        if (col - 1 >= 0) {
            lights[row][col - 1] = !lights[row][col - 1];

        }
        if (col + 1 <= 4) {
            lights[row][col + 1] = !lights[row][col + 1];

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
}
