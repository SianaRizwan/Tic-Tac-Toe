import javax.swing.*;
import java.awt.*;

public class HighContrastTheme {
    private JButton[] button;
    public void getProperty(JPanel mainpanel, JPanel boardpanel, JPanel settingspanel, JButton[] button) {
        boardpanel.setBackground(Color.LIGHT_GRAY);
        settingspanel.setBackground(Color.DARK_GRAY);
        mainpanel.setBackground(Color.DARK_GRAY);
        for (int i = 0; i < 9; i++) {
            button[i].setBackground(Color.WHITE);
            button[i].setForeground(Color.WHITE);
        }
    }
}
