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
//    static int theme = 0;


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
        //System.out.println("Classic: "+rBClassic+" Forest: "+rBForest+" High Contrast: "+rBHighContrast);
        //System.out.println("Main Panel: "+mainpanel+" Boardpanel: "+boardpanel+" Button: "+button);
        chooseThemeButton();

    }

    private void chooseThemeButton() {
        {
            ButtonGroup bg = new ButtonGroup();
            bg.add(rBClassic);
            bg.add(rBForest);
            bg.add(rBHighContrast);
        }
        int turn=0;

        rBClassic.addActionListener(e -> {
            choosetheme = new ClassicTheme(rBClassic, rBForest, rBHighContrast);
            changeTheme(button,choosetheme);
        });
        rBForest.addActionListener(e -> {
            choosetheme = new ForestTheme(rBClassic, rBForest, rBHighContrast);
            changeTheme(button,choosetheme);
        });
        rBHighContrast.addActionListener(e -> {
            choosetheme = new HighContrastTheme(rBClassic, rBForest, rBHighContrast);
            changeTheme(button,choosetheme);

        });
    }



    public void changeTheme(JButton[] button,ITheme choosetheme)
    {
        choosetheme.getBackroundColor(mainpanel, boardpanel, settingspanel, button, Theme);
        choosetheme.getButtonSymbol(button);
    }

}
