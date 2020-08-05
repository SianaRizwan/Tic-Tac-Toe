import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ThemeSettings {
    private JButton upperLeft;
    private JButton upperMiddle;
    private JButton upperRight;
    private JButton lowerLeft;
    private JButton lowerMiddle;
    private JButton lowerRight;
    private JButton middleLeft;
    private JButton middleCenter;
    private JButton middleRight;
    private JButton[] button = new JButton[]{upperLeft, upperMiddle, upperRight, middleLeft, middleCenter, middleRight, lowerLeft, lowerMiddle, lowerRight};

    private JPanel mainpanel;
    private JPanel boardpanel;
    private JPanel settingspanel;

    private JRadioButton rBClassic;
    private JRadioButton rBForest;
    private JRadioButton rBHighContrast;

    ClassicTheme classic = new ClassicTheme();
    ForestTheme forest = new ForestTheme();
    HighContrastTheme highcontrast = new HighContrastTheme();


    public ThemeSettings(JRadioButton classicRadioButton, JRadioButton forestRadioButton, JRadioButton highContrastRadioButton, JPanel mainpanel, JPanel boardpanel, JButton[] button, JPanel settingspanel) {
        this.mainpanel = mainpanel;
        this.boardpanel = boardpanel;
        this.settingspanel = settingspanel;
        this.button = button;
        rBClassic = classicRadioButton;
        rBForest = forestRadioButton;
        rBHighContrast = highContrastRadioButton;
        chooseThemeButton();
    }

    private void chooseThemeButton() {
        {
            ButtonGroup bg = new ButtonGroup();
            bg.add(rBClassic);
            bg.add(rBForest);
            bg.add(rBHighContrast);
        }
        rBClassic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                classic.getProperty(mainpanel, boardpanel, settingspanel, button);

            }
        });
        rBForest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                forest.getProperty(mainpanel, boardpanel, settingspanel, button);
            }
        });
        rBHighContrast.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                highcontrast.getProperty(mainpanel, boardpanel, settingspanel, button);
            }
        });



    }
}
