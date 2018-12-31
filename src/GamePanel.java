import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.TimeUnit;

public class GamePanel extends JPanel implements MouseListener {

    // 2d arrays for storing the light states
    public boolean[][] lights;
    public boolean[][] lightsClicked;
    // step counter to record the number of steps the user have taken
    private int stepCounter;
    private int minimumSteps;
    public static boolean initializing = false;

    static int randomRange(int min, int max) {
        int range = (max - min) + 1;
        return (int) (Math.random() * range) + min;
    }

    public static int smaller(int a, int b) {
        if (a > b)
            return b;
        else
            return a;
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
        setPreferredSize(
                new Dimension(LightsOut.gridSize * LightsOut.tileSize, LightsOut.gridSize * LightsOut.tileSize));

        setBackground(Color.PINK);
        // initialize the two arrays
        lights = new boolean[LightsOut.gridSize][LightsOut.gridSize];
        lightsClicked = new boolean[LightsOut.gridSize][LightsOut.gridSize];
        addMouseListener(this);
        initialize();

    }

    public void initialize() {

        initializing = true;
        stepCounter = 0;
        minimumSteps = 0;

        // Clearing the List for better
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
        // randomly turn on half of the lights
        for(int i = 0; i<((LightsOut.gridSize * LightsOut.gridSize) / 2); i++){
//        while (true) {
            int row = randomRange(0, LightsOut.gridSize - 1);
            int col = randomRange(0, LightsOut.gridSize - 1);
            lightsClicked[row][col] = !lightsClicked[row][col];
            toggle(lights, row, col);
            // System.out.println((row + 1) + " " + (col + 1) + "\n");
//            if (countBools(lights) == (LightsOut.gridSize * LightsOut.gridSize) / 2)
//                break;
        }
        // Prints the answer to the random generated level
        printBools(lightsClicked);
        minimumSteps = countBools(lightsClicked);
        solve(false);
        MainFrame.statusPanel.setMinSteps(minimumSteps);

    }

    public void solve(boolean visible) {



        System.out.println("Starting solving");
            Thread t=new Thread(new Runnable(){
                boolean[][] solveClicked = new boolean[LightsOut.gridSize][LightsOut.gridSize];
                boolean[][] solveLights = new boolean[LightsOut.gridSize][LightsOut.gridSize];


                @Override

                public void run() {
                    //Copying lights to solveLights
                    for (int i = 0; i<LightsOut.gridSize; i++) {
                        for (int j = 0; j<LightsOut.gridSize; j++) {
                            solveLights[i][j] = lights[i][j];
                        }
                    }
                    for(int i = 0; i<Math.pow(2,LightsOut.gridSize);i++){
                        for(int j = 0; j<LightsOut.gridSize;j++){
                            if(i%Math.pow(2,j)==0){
                                if(visible)improveVisibility();
                                System.out.println("Toggling: 0 "+ j);
                                toggle(solveLights,0, j);
                                solveClicked[0][j] = !solveClicked[0][j];
                                if(visible)repaint();
                            }
                        }
                        for(int j=1;j<LightsOut.gridSize;j++){
                            for(int k=0; k<LightsOut.gridSize;k++){
                                if(lights[j-1][k]){
                                    if(visible)improveVisibility();
                                    System.out.println("Toggling: "+ j + " "+ k);
                                    toggle(solveLights,j,k);
                                    solveClicked[j][k] = !solveClicked[j][k];
                                    if(visible)repaint();
                                }

                            }
                            if (0 == countBools(solveLights)) {
                                    System.out.println("Found a solution");
                                int temp = countBools(solveClicked);
                                if(minimumSteps>temp){
                                    minimumSteps=temp;
                                    for (int x = 0; x<LightsOut.gridSize; x++) {
                                        for (int y = 0; y<LightsOut.gridSize; y++) {
                                            lightsClicked[x][y] = solveClicked[x][y];
                                        }
                                    }
                                    System.out.println("Found a better solution than the original");
                                    repaint();
                                }
                            }
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Finished Initializing");
                    System.out.println("Finished Solving");
                    initializing = false;
                }
            });
            t.start();

    }

    private void improveVisibility(){
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        int panelSize = smaller(getWidth(), getHeight());
        int tileSize = panelSize / LightsOut.gridSize;

        int y = (getHeight() - panelSize) / 2 + LightsOut.tileMargin / 2;
        for (int row = 0; row < LightsOut.gridSize; row++) {
            int x = (getWidth() - panelSize) / 2 + LightsOut.tileMargin / 2;
            for (int col = 0; col < LightsOut.gridSize; col++) {
                if (lightsClicked[row][col] && LightsOut.debugMode) {
                    // drawing the border
                    g2.setColor(Color.GREEN);
                    g2.fillRect(x, y, tileSize - LightsOut.tileMargin, tileSize - LightsOut.tileMargin);
                    // drawing the actuall tile
                    if (lights[row][col])
                        g2.setColor(Color.WHITE);
                    else
                        g2.setColor(Color.BLACK);
                    g2.fillRect(x + LightsOut.tileBorder, y + LightsOut.tileBorder,
                            tileSize - LightsOut.tileMargin - LightsOut.tileBorder * 2,
                            tileSize - LightsOut.tileMargin - LightsOut.tileBorder * 2);

                } else {
                    // drawing the actuall tiles
                    if (lights[row][col])
                        g2.setColor(Color.WHITE);
                    else
                        g2.setColor(Color.BLACK);
                    g2.fillRect(x, y, tileSize - LightsOut.tileMargin, tileSize - LightsOut.tileMargin);
                    // drawing the border of the tiles
                }
                x += tileSize;
            }
            y += tileSize;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(initializing){
            JOptionPane.showMessageDialog(null, "Initializing.....");
            return;
        }
        int mouseX = e.getX();
        int mouseY = e.getY();
        // System.out.println("Mouse X: " + mouseX + " Mouse Y: " + mouseY);
        int panelSize = smaller(getWidth(), getHeight());
        int tileSize = panelSize / LightsOut.gridSize;
        // filter out invalid clicks
        if (mouseX < ((getWidth() - panelSize) / 2) || mouseX > ((getWidth() - panelSize) / 2 + panelSize)
                || mouseY < ((getHeight() - panelSize) / 2) || mouseY > ((getHeight() - panelSize) / 2 + panelSize)) {
            return;
        }
        mouseX -= (getWidth() - panelSize) / 2;
        mouseY -= (getHeight() - panelSize) / 2;

        int col = mouseX / tileSize;
        int row = mouseY / tileSize;

        if (col > LightsOut.gridSize - 1) {
            col = LightsOut.gridSize - 1;
            System.out.println("col out of bound");
        }
        if (row > LightsOut.gridSize - 1) {
            row = LightsOut.gridSize - 1;
            System.out.println("row out of bound");
        }

        stepCounter++;
        toggle(lights, row, col);

        lightsClicked[row][col] = !lightsClicked[row][col];
        MainFrame.statusPanel.setStep(stepCounter);
        repaint();
        if (0 == countBools(lights)) {
//            gameOver();
            LightsOut.gameOver();
        }
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
