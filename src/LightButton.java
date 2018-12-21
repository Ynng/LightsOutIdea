import javax.swing.*;

public class LightButton extends JButton {
    private boolean powerState;

    public LightButton(String test, boolean b) {
        super(test + b);
        powerState = b;
    }
}
