package Theme;

import javax.swing.*;
import java.awt.*;

public class ForestTheme implements ITheme {

    Font f1 = new Font("Arial", Font.BOLD, 30);
    private JRadioButton rBClassic;
    private JRadioButton rBForest;
    private JRadioButton rBHighContrast;

    public ForestTheme(JRadioButton rBClassic, JRadioButton rBForest, JRadioButton rBHighContrast) {
        this.rBClassic = rBClassic;
        this.rBForest = rBForest;
        this.rBHighContrast = rBHighContrast;
    }

    public void setrb() {
        rBClassic.setBackground(new Color(181,245,171));
        rBForest.setBackground(new Color(181,245,171));
        rBHighContrast.setBackground(new Color(181,245,171));
    }

    @Override
    public void getProperty(JPanel mainpanel, JPanel boardpanel, JPanel settingspanel, JButton[] button, JLabel Theme) {
        boardpanel.setBackground(new Color(34,139,34));
        settingspanel.setBackground(new Color(181,245,171));
        mainpanel.setBackground(new Color(181,245,171));
        Theme.setFont(f1);
        for (int i = 0; i < 9; i++) {
            button[i].setBackground(new Color(181,245,171));
            button[i].setForeground(Color.BLACK);
        }

        setrb();
    }

}

