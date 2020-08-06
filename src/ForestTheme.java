import javax.swing.*;
import java.awt.*;

public class ForestTheme {

    private JButton[] button;
    Font f1 = new Font("Arial", Font.BOLD, 30);
    public void getProperty(JPanel mainpanel, JPanel boardpanel, JPanel settingspanel, JButton[] button, JLabel Theme, JRadioButton rBForest, JRadioButton rBClassic, JRadioButton rBHighContrast) {
        boardpanel.setBackground(new Color(34,139,34));
        settingspanel.setBackground(new Color(181,245,171));
        rBClassic.setBackground(new Color(181,245,171));
        rBForest.setBackground(new Color(181,245,171));
        rBHighContrast.setBackground(new Color(181,245,171));
        mainpanel.setBackground(new Color(181,245,171));
        Theme.setFont(f1);
        for (int i = 0; i < 9; i++) {
            button[i].setBackground(new Color(181,245,171));
            button[i].setForeground(Color.BLACK);
        }
    }
}
