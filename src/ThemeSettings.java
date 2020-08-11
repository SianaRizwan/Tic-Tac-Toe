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

    SetTheme choosetheme;

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
                choosetheme = new ClassicTheme();
                choosetheme.getProperty(mainpanel, boardpanel, settingspanel, button, Theme);


            }
        });
        rBForest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choosetheme = new ForestTheme(rBClassic, rBForest, rBHighContrast);
                choosetheme.getProperty(mainpanel, boardpanel, settingspanel, button, Theme);
            }
        });
        rBHighContrast.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choosetheme = new HighContrastTheme(rBClassic, rBForest, rBHighContrast);
                choosetheme.getProperty(mainpanel, boardpanel, settingspanel, button, Theme);
            }
        });
    }
}
