import javax.swing.*;

public class LightsOut {



    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainFrame frame = new MainFrame();

            }
        });

    }
}