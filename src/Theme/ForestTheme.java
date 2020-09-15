package Theme;

import javax.imageio.ImageIO;
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

    public void setrb() {
        rBClassic.setBackground(new Color(181,245,171));
        rBForest.setBackground(new Color(181,245,171));
        rBHighContrast.setBackground(new Color(181,245,171));
        rBClassic.setForeground(Color.BLACK);
        rBForest.setForeground(Color.BLACK);
        rBHighContrast.setForeground(Color.BLACK);
    }
    public  void setImageicon(JButton button, String imageName){
        try {
            Image img = ImageIO.read(getClass().getResource(imageName));
            ImageIcon imageIcon = new ImageIcon(img);
            button.setIcon(imageIcon);
            button.setDisabledIcon(imageIcon);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void getProperty(JPanel mainpanel, JPanel boardpanel, JPanel settingspanel, JButton[] button, JLabel Theme) {
        boardpanel.setBackground(new Color(34,139,34));
        settingspanel.setBackground(new Color(181,245,171));
        mainpanel.setBackground(new Color(181,245,171));
        Theme.setFont(f1);
        Theme.setForeground(Color.BLACK);
        for (int i = 0; i < 9; i++) {
            button[i].setBackground(new Color(181,245,171));
            button[i].setForeground(Color.BLACK);
            if(button[i].getText() == "X"){
                setImageicon(button[i],"Images/flower.jpg");
            } else if (button[i].getText() == "O"){
                setImageicon(button[i],"Images/fruit.jpg");
            }
        }
        setrb();
    }


}
