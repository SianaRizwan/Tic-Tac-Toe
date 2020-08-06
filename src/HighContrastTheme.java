import javax.swing.*;
import java.awt.*;

public class HighContrastTheme {
    private JButton[] button;
    Font f1 = new Font("Arial", Font.BOLD, 30);
    public void getProperty(JPanel mainpanel, JPanel boardpanel, JPanel settingspanel, JButton[] button, JLabel Theme, JRadioButton rBForest, JRadioButton rBClassic, JRadioButton rBHighContrast) {
        boardpanel.setBackground(Color.LIGHT_GRAY);
        settingspanel.setBackground(Color.DARK_GRAY);
        mainpanel.setBackground(Color.DARK_GRAY);
        rBClassic.setBackground(Color.DARK_GRAY);
        rBForest.setBackground(Color.DARK_GRAY);
        rBHighContrast.setBackground(Color.DARK_GRAY);
        rBClassic.setForeground(Color.WHITE);
        rBForest.setForeground(Color.WHITE);
        rBHighContrast.setForeground(Color.WHITE);
        Theme.setFont(f1);
        Theme.setForeground(Color.WHITE);
        for (int i = 0; i < 9; i++) {
            button[i].setBackground(Color.WHITE);
            button[i].setForeground(Color.WHITE);
        }
    }
}
