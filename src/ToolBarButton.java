import javax.swing.*;
import java.awt.*;

public class ToolBarButton extends JButton {
    public ToolBarButton(){
        setBackground(new Color(59, 89, 182));
        setForeground(Color.WHITE);
        setFocusPainted(false);
        setFont(new Font("Sans-Serif", Font.PLAIN, 16));
//        setPreferredSize(new Dimension(LightsOut.tileSize, LightsOut.tileSize/2));
        setMargin(new Insets(0, 0, 0, 0));
    }
}
