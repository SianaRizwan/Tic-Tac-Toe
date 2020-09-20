import Theme.ClassicTheme;
import Theme.ForestTheme;
import Theme.HighContrastTheme;
import Theme.ITheme;

import javax.swing.*;

public class ThemeSettings {
    private JButton[] button;
    private JPanel mainpanel;
    private JPanel boardpanel;
    private JPanel settingspanel;
    private JLabel Theme;

    private JRadioButton rBClassic;
    private JRadioButton rBForest;
    private JRadioButton rBHighContrast;
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
    private void chooseThemeButton(){
        rBClassic.addActionListener(e -> {
            setClassicTheme();
            setCurrentTheme(0);
        });
        rBForest.addActionListener(e -> {
            setForestTheme();
            setCurrentTheme(1);
        });
        rBHighContrast.addActionListener(e -> {
            setHighContrastTheme();
            setCurrentTheme(2);

        });
    }

    public void setClassicTheme() {
        choosetheme = new ClassicTheme(rBClassic, rBForest, rBHighContrast);
        changeTheme(button, choosetheme);
    }

    public void setForestTheme() {
        choosetheme = new ForestTheme(rBClassic, rBForest, rBHighContrast);
        changeTheme(button, choosetheme);
    }

    public void setHighContrastTheme() {
        choosetheme = new HighContrastTheme(rBClassic, rBForest, rBHighContrast);
        changeTheme(button, choosetheme);
    }

    public void setTheme(int theme)
    {
        if(theme == 1)
        {
            System.out.println("Setting Forest Theme");
            setForestTheme();

        }else if(theme == 2)
        {
            System.out.println("Setting HighContrast Theme");
            setHighContrastTheme();
        }else
        {
            System.out.println("Setting Classic Theme");
            setClassicTheme();
        }
    }
    public void setCurrentTheme(int value)
    {
        theme = value;
        setTheme(theme);
    }

    public int getCurrentTheme()
    {
        return theme;
    }


    public void changeTheme(JButton[] button, ITheme choosetheme) {
        choosetheme.getBackroundColor(mainpanel, boardpanel, settingspanel, button, Theme);
        choosetheme.getButtonSymbol(button);
    }

}
