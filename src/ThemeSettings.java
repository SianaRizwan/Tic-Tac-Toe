import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ThemeSettings {
    private JButton[] button;
    private JPanel mainpanel;
    private JPanel boardpanel;
    private JPanel settingspanel;
    private JLabel Theme;

    private JRadioButton rBClassic;
    private JRadioButton rBForest;
    private JRadioButton rBHighContrast;

    ClassicTheme classic = new ClassicTheme();
    ForestTheme forest = new ForestTheme();
    HighContrastTheme highcontrast = new HighContrastTheme();


    public ThemeSettings(JRadioButton classicRadioButton, JRadioButton forestRadioButton, JRadioButton highContrastRadioButton, JPanel mainpanel, JPanel boardpanel, JButton[] button, JPanel settingspanel, JLabel Theme) {
        this.mainpanel = mainpanel;
        this.boardpanel = boardpanel;
        this.settingspanel = settingspanel;
        this.button = button;
        this.Theme = Theme;
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
                classic.getProperty(mainpanel, boardpanel, settingspanel, button,Theme);

            }
        });
        rBForest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                forest.getProperty(mainpanel, boardpanel, settingspanel, button,Theme,rBForest,rBClassic,rBHighContrast);
            }
        });
        rBHighContrast.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                highcontrast.getProperty(mainpanel, boardpanel, settingspanel, button,Theme,rBForest,rBClassic,rBHighContrast);
            }
        });
    }
}
