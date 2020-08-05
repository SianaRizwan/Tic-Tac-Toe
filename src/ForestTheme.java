import javax.swing.*;
import java.awt.*;

public class ForestTheme {

    private JButton[] button;
    public void getProperty(JPanel mainpanel, JPanel boardpanel, JPanel settingspanel, JButton[] button) {
        boardpanel.setBackground(new Color(34,139,34));
        settingspanel.setBackground(new Color(181,245,171));
        mainpanel.setBackground(new Color(181,245,171));
        for (int i = 0; i < 9; i++) {
            button[i].setBackground(new Color(181,245,171));
            button[i].setForeground(Color.BLACK);
        }
    }
}
