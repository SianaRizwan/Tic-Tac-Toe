import Theme.ClassicTheme;
import Theme.ForestTheme;
import Theme.HighContrastTheme;
import Theme.ITheme;

import javax.swing.*;

public class ThemeSettings {
    private JButton[] button;
    private JPanel mainpanel, boardpanel, settingspanel;
    private JLabel Theme;
    private JRadioButton rBClassic, rBForest, rBHighContrast;

    static int theme = 0;

    ITheme choosetheme;

    public ThemeSettings(JRadioButton classicRadioButton, JRadioButton forestRadioButton, JRadioButton highContrastRadioButton, JPanel mainpanel, JPanel boardpanel, JButton[] button, JPanel settingspanel, JLabel Theme) {
        this.mainpanel = mainpanel;
        this.boardpanel = boardpanel;
        this.settingspanel = settingspanel;
        this.button = button;
        this.Theme = Theme;
        rBClassic = classicRadioButton;
        rBForest = forestRadioButton;
        rBHighContrast = highContrastRadioButton;
        addThemeButton();

    }

    private void addThemeButton() {
        {
            ButtonGroup bg = new ButtonGroup();
            bg.add(rBClassic);
            bg.add(rBForest);
            bg.add(rBHighContrast);
        }

        chooseThemeButton();

    }

    private void chooseThemeButton() {
        rBClassic.addActionListener(e -> {
            setCurrentTheme(0);
        });
        rBForest.addActionListener(e -> {
            setCurrentTheme(1);
        });
        rBHighContrast.addActionListener(e -> {
            setCurrentTheme(2);

        });
    }

    private void setClassicTheme() {
        choosetheme = new ClassicTheme(rBClassic, rBForest, rBHighContrast);
        changeTheme(button, choosetheme);
    }

    private void setForestTheme() {
        choosetheme = new ForestTheme(rBClassic, rBForest, rBHighContrast);
        changeTheme(button, choosetheme);
    }

    private void setHighContrastTheme() {
        choosetheme = new HighContrastTheme(rBClassic, rBForest, rBHighContrast);
        changeTheme(button, choosetheme);
    }

    public void setTheme(int theme) {
        if (theme == 1) {
            setForestTheme();
        } else if (theme == 2) {
            setHighContrastTheme();
        } else {
            setClassicTheme();
        }
    }

    public void setCurrentTheme(int value) {
        theme = value;
        setTheme(theme);
    }

    public int getCurrentTheme() {
        return theme;
    }


    private void changeTheme(JButton[] button, ITheme choosetheme) {
        choosetheme.getBackroundColor(mainpanel, boardpanel, settingspanel, button, Theme);
        choosetheme.getButtonSymbol(button);
    }

}
