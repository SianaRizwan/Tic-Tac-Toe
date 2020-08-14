import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameBoard extends JFrame{
    private  JFrame frame;
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
    private JRadioButton classicRadioButton;
    private JRadioButton forestRadioButton;
    private JRadioButton highContrastRadioButton;
    private JRadioButton[] themeButtons;
    private JLabel Theme;
    private JButton exitButton;
    private JPanel boardpanel;
    private JPanel settingspanel;
    private JPanel mainpanel;
    private JButton startWithDefensiveAIButton;
    private JButton startWithRandomAIButton;
    GameLogic logic;
    ThemeSettings theme;
    AiSettings chooseAi;

    Font f1 = new Font("Arial", Font.BOLD, 30);


    public GameBoard(JFrame frame) {

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        logic = new GameLogic(mainpanel,boardpanel,button,frame);
        theme = new ThemeSettings(classicRadioButton, forestRadioButton, highContrastRadioButton, mainpanel, boardpanel, button, settingspanel, Theme);
        chooseAi = new AiSettings(mainpanel, boardpanel, button, settingspanel, startWithDefensiveAIButton, startWithRandomAIButton);
        initComponents();
    }

    private void initComponents(){
        this.setTitle("Tic Tac Toe");
        this.setSize(450,450);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(GameBoard.EXIT_ON_CLOSE);
        this.setBounds(300,40,700,600);
        this.setResizable(false);
        this.setContentPane(mainpanel);
        Theme.setFont(f1);
    }


    public static void main(String[] args) {

        JFrame frame = new JFrame();

        new GameBoard(frame);



    }




}