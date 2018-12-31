import javax.swing.*;


import java.awt.*;
public class StatusPanel extends JPanel {
    static int gameDimension = LightsOut.tileSize * LightsOut.gridSize;
    public JLabel steps;
    public JLabel minSteps;
    public StatusPanel() {
//        setPreferredSize(new Dimension(LightsOut.tileSize, gameDimension));
        setBackground(Color.WHITE);
        setLayout(new FlowLayout(FlowLayout.LEFT, 25, 0));
        //Setting up the step counter
        steps = new JLabel("Steps: 0");
        steps.setForeground(Color.BLACK);
        steps.setFont(new Font("Sans-Serif", Font.PLAIN, 18));
        add(steps);
        //Setting up minimum step counter
        minSteps = new JLabel("Min Steps: 0");
        minSteps.setForeground(Color.BLACK);
        minSteps.setFont(new Font("Sans-Serif", Font.PLAIN, 18));
        add(minSteps);
    }

    public void setStep(int stepCount){
        steps.setText("Steps: "+stepCount);
    }

    public void setMinSteps(int minStepCount){
        minSteps.setText("Min Steps: "+minStepCount);
    }
}
