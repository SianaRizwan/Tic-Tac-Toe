package Theme;

import javax.swing.*;
import java.awt.*;

public class HighContrastTheme implements ITheme {

    Font f1 = new Font("Arial", Font.BOLD, 30);
    private JRadioButton rBClassic;
    private JRadioButton rBForest;
    private JRadioButton rBHighContrast;

    public HighContrastTheme(JRadioButton rBClassic, JRadioButton rBForest, JRadioButton rBHighContrast) {
        this.rBClassic = rBClassic;
        this.rBForest = rBForest;
        this.rBHighContrast = rBHighContrast;
    }

    public void setrb() {
        rBClassic.setBackground(Color.DARK_GRAY);
        rBForest.setBackground(Color.DARK_GRAY);
        rBHighContrast.setBackground(Color.DARK_GRAY);
        rBClassic.setForeground(Color.WHITE);
        rBForest.setForeground(Color.WHITE);
        rBHighContrast.setForeground(Color.WHITE);

    }

    @Override
    public void getBackroundColor(JPanel mainpanel, JPanel boardpanel, JPanel settingspanel, JButton[] button, JLabel Theme) {
        boardpanel.setBackground(Color.LIGHT_GRAY);
        settingspanel.setBackground(Color.DARK_GRAY);
        mainpanel.setBackground(Color.DARK_GRAY);
        Theme.setFont(f1);
        Theme.setForeground(Color.WHITE);
        setrb();
    }
    @Override
    public void getButtonSymbol(JButton[] button) {
        for (int i = 0; i < 9; i++) {
            if (button[i].getText().equals("X")) {
                button[i].setText(" ");
                button[i].setBackground(Color.BLACK);

            } else if (button[i].getText().equals("O")) {
                button[i].setText(" ");
                button[i].setBackground(Color.WHITE);
            }
        }
    }
}
