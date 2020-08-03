import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameBoard extends JFrame{
    private  JFrame frame;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton []button = new JButton[]{button1, button2, button3, button4, button5, button6, button7, button8, button9};
    private JButton startWithDefensiveAIButton;
    private JRadioButton classicRadioButton;
    private JRadioButton forestRadioButton;
    private JRadioButton highContrastRadioButton;
    private JButton startWithRandomAIButton;
    private JLabel Theme;
    private JButton exitButton;
    private JPanel boardpanel;
    private JPanel settingspanel;
    private JPanel mainpanel;
    GameLogic logic;



    public GameBoard(JFrame frame){
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        logic = new GameLogic(mainpanel,boardpanel,button,frame);
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
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame();
        new GameBoard(frame);


    }
}
