package Theme;

import javax.swing.*;
import java.awt.*;

import static java.awt.Color.*;

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

    private void setRadiobuttonsColor() {
        rBClassic.setBackground(DARK_GRAY);
        rBForest.setBackground(DARK_GRAY);
        rBHighContrast.setBackground(DARK_GRAY);
        rBClassic.setForeground(Color.WHITE);
        rBForest.setForeground(Color.WHITE);
        rBHighContrast.setForeground(Color.WHITE);

    }

    @Override
    public void getBackroundColor(JPanel mainpanel, JPanel boardpanel, JPanel settingspanel, JButton[] button, JLabel Theme) {
        boardpanel.setBackground(DARK_GRAY);
        settingspanel.setBackground(DARK_GRAY);
        mainpanel.setBackground(DARK_GRAY);
        Theme.setFont(f1);
        Theme.setForeground(Color.WHITE);
        setRadiobuttonsColor();
    }
    @Override
    public void getButtonSymbol(JButton[] button) {
        for (int i = 0; i < 9; i++) {
            setHighContrastButtonProperty(button[i]);
            if (button[i].getText().equals("")) {
                setHighContrastButtonProperty(button[i]);
            } else if (button[i].getText().equals("X") || button[i].getText().equals(".")) {
                button[i].setText(".");
                button[i].setBackground(Color.BLACK);
                button[i].setForeground(BLACK);

            } else if (button[i].getText().equals("O") || button[i].getText().equals(",")) {
                button[i].setText(",");
                button[i].setForeground(WHITE);
                button[i].setBackground(Color.WHITE);
            }
        }

    }
    private void setHighContrastButtonProperty(JButton button){
        button.setBackground(LIGHT_GRAY);
        button.setIcon(null);
    }
}
