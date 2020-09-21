import Theme.ClassicTheme;
import Theme.ForestTheme;
import Theme.HighContrastTheme;
import Theme.ITheme;

import javax.swing.*;

public class ThemeSettings {
    private JButton[] button;
    private JPanel mainpanel, boardpanel, settingspanel;
    private JLabel Theme;
    private JRadioButton radioButtonClassic, radioButtonForest, radioButtonHighContrast;

    static int theme = 0;

    ITheme choosetheme;

    public ThemeSettings(JRadioButton classicRadioButton, JRadioButton forestRadioButton, JRadioButton highContrastRadioButton, JPanel mainpanel, JPanel boardpanel, JButton[] button, JPanel settingspanel, JLabel Theme) {
        this.mainpanel = mainpanel;
        this.boardpanel = boardpanel;
        this.settingspanel = settingspanel;
        this.button = button;
        this.Theme = Theme;
        radioButtonClassic = classicRadioButton;
        radioButtonForest = forestRadioButton;
        radioButtonHighContrast = highContrastRadioButton;
        addThemeRadioButton();

    }

    private void addThemeRadioButton() {
        {
            ButtonGroup bg = new ButtonGroup();
            bg.add(radioButtonClassic);
            bg.add(radioButtonForest);
            bg.add(radioButtonHighContrast);
        }

        chooseThemeButton();

    }

    private void chooseThemeButton() {
        radioButtonClassic.addActionListener(e -> {
            setCurrentTheme(0);
        });
        radioButtonForest.addActionListener(e -> {
            setCurrentTheme(1);
        });
        radioButtonHighContrast.addActionListener(e -> {
            setCurrentTheme(2);

        });
    }

    private void setClassicTheme() {
        choosetheme = new ClassicTheme(radioButtonClassic, radioButtonForest, radioButtonHighContrast);
        changeTheme(button, choosetheme);
    }

    private void setForestTheme() {
        choosetheme = new ForestTheme(radioButtonClassic, radioButtonForest, radioButtonHighContrast);
        changeTheme(button, choosetheme);
    }

    private void setHighContrastTheme() {
        choosetheme = new HighContrastTheme(radioButtonClassic, radioButtonForest, radioButtonHighContrast);
        changeTheme(button, choosetheme);
    }

    private void changeTheme(JButton[] button, ITheme choosetheme) {
        choosetheme.getBackroundColor(mainpanel, boardpanel, settingspanel, button, Theme);
        choosetheme.getButtonSymbol(button);
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

}
