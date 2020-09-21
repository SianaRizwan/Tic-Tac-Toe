package Theme;

import javax.swing.*;
import java.awt.*;

public class ClassicTheme implements ITheme {
    private JRadioButton rBClassic;
    private JRadioButton rBForest;
    private JRadioButton rBHighContrast;
    Font f1 = new Font("Arial", Font.BOLD, 30);

    public ClassicTheme(JRadioButton rBClassic, JRadioButton rBForest, JRadioButton rBHighContrast) {
        this.rBClassic = rBClassic;
        this.rBForest = rBForest;
        this.rBHighContrast = rBHighContrast;
    }

    private void setRadiobuttonsColor() {
        rBClassic.setBackground(Color.WHITE);
        rBForest.setBackground(Color.WHITE);
        rBHighContrast.setBackground(Color.WHITE);
        rBClassic.setForeground(Color.BLACK);
        rBForest.setForeground(Color.BLACK);
        rBHighContrast.setForeground(Color.BLACK);
    }

    public void getBackroundColor(JPanel mainpanel, JPanel boardpanel, JPanel settingspanel, JButton[] button, JLabel Theme) {
        boardpanel.setBackground(Color.BLACK);
        settingspanel.setBackground(Color.WHITE);
        mainpanel.setBackground(Color.WHITE);
        Theme.setFont(f1);
        Theme.setForeground(Color.BLACK);
        setRadiobuttonsColor();
    }

    @Override
    public void getButtonSymbol(JButton[] button) {
        for (int i = 0; i < 9; i++) {
            setClassicButtonProperty(button[i]);
            if(button[i].getText().equals("")){
                setClassicButtonProperty(button[i]);
            }
            else if (button[i].getText().equals("X") || button[i].getText().equals(".")) {
                button[i].setText("X");
            } else if (button[i].getText().equals("O")  || button[i].getText().equals(",")) {
                button[i].setText("O");

            }
        }

    }
    private void setClassicButtonProperty(JButton button){
        for (int i = 0; i < 9; i++) {
            button.setBackground(Color.WHITE);
            button.setIcon(null);
        }
    }
}

