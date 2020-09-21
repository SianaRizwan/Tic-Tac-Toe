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

    private void setRadiobuttonsColor() {
        rBClassic.setBackground(new Color(181, 245, 171));
        rBForest.setBackground(new Color(181, 245, 171));
        rBHighContrast.setBackground(new Color(181, 245, 171));
        rBClassic.setForeground(Color.BLACK);
        rBForest.setForeground(Color.BLACK);
        rBHighContrast.setForeground(Color.BLACK);
    }


    @Override
    public void getBackroundColor(JPanel mainpanel, JPanel boardpanel, JPanel settingspanel, JButton[] button, JLabel Theme) {
        boardpanel.setBackground(new Color(34, 139, 34));
        settingspanel.setBackground(new Color(181, 245, 171));
        mainpanel.setBackground(new Color(181, 245, 171));
        Theme.setFont(f1);
        Theme.setForeground(Color.BLACK);
        setRadiobuttonsColor();
    }

    @Override
    public void getButtonSymbol(JButton[] button) {
        for (int i = 0; i < 9; i++) {
            setForestButtonBackground(button[i]);
            if(button[i].getText().equals("")){
                setForestButtonBackground(button[i]);}
            else if (button[i].getText().equals("X")  || button[i].getText().equals(".")) {
                button[i].setText(".");
                setImageicon(button[i], "images\\player1.png");
            } else if (button[i].getText().equals("O") || button[i].getText().equals(",")) {
                button[i].setText(",");
                setImageicon(button[i], "images\\computer1.png");
            }
        }
    }
    private void setForestButtonBackground(JButton button){
        button.setBackground(Color.WHITE);
    }


    public void setImageicon(JButton button, String imageName) {
        try {
            Icon icon = new ImageIcon(imageName);
            button.setDisabledIcon(icon);
            button.setIcon(icon);
        } catch (Exception ex) {
            System.out.println(ex);

        }
    }


}
