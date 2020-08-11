import javax.swing.*;
import java.awt.*;

public class ClassicTheme implements SetTheme {



    Font f1 = new Font("Arial", Font.BOLD, 30);

    public void getProperty(JPanel mainpanel, JPanel boardpanel, JPanel settingspanel, JButton[] button, JLabel Theme) {
        boardpanel.setBackground(Color.BLACK);
        settingspanel.setBackground(Color.WHITE);
        mainpanel.setBackground(Color.WHITE);
        Theme.setFont(f1);
        for (int i = 0; i < 9; i++) {
            button[i].setBackground(Color.white);
            button[i].setForeground(Color.BLACK);
        }
    }
}
