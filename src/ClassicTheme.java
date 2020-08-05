import javax.swing.*;
import java.awt.*;

public class ClassicTheme {


    private JButton[] button;

    public void getProperty(JPanel mainpanel, JPanel boardpanel, JPanel settingspanel, JButton[] button) {
        boardpanel.setBackground(Color.BLACK);
        settingspanel.setBackground(Color.WHITE);
        for (int i = 0; i < 9; i++) {
            button[i].setBackground(Color.white);
            button[i].setForeground(Color.BLACK);
        }
    }
}
