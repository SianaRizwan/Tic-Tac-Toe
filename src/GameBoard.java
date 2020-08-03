import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameBoard  extends JFrame{
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton button4;
    private JButton button5;
    private JButton button6;
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
    private String startgame = "X";
    String [][]board = new String[3][3];

    Font f1  = new Font("Arial", Font.BOLD, 30);

    public GameBoard(JFrame frame){
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button1.setEnabled(false);
                button1.setText(startgame);
                button1.setFont(f1);
                choose_player();
                String c = button1.getText();
                board[0][0] = c;
                if (winner_player("X")){
                    lockBoard();
                    JOptionPane.showMessageDialog(mainpanel,"X has won");
                    unlockBoard();
                }
                else if(winner_player("O")){
                    lockBoard();
                    JOptionPane.showMessageDialog(mainpanel,"O has won");
                    unlockBoard();
                }
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button2.setEnabled(false);
                button2.setText(startgame);
                button2.setFont(f1);
                choose_player();
                String c = button2.getText();
                board[0][1] = c;
                if (winner_player("X")){
                    lockBoard();
                    JOptionPane.showMessageDialog(mainpanel,"X has won");
                    unlockBoard();
                }
                else if(winner_player("O")){
                    lockBoard();
                    JOptionPane.showMessageDialog(mainpanel,"O has won");
                    unlockBoard();
                }
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button3.setEnabled(false);
                button3.setText(startgame);
                button3.setFont(f1);
                choose_player();
                String c = button3.getText();
                board[0][2] = c;
                if (winner_player("X")){
                    lockBoard();
                    JOptionPane.showMessageDialog(mainpanel,"X has won");
                    unlockBoard();
                }
                else if(winner_player("O")){
                    lockBoard();
                    JOptionPane.showMessageDialog(mainpanel,"O has won");
                    unlockBoard();
                }
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button4.setEnabled(false);
                button4.setText(startgame);
                button4.setFont(f1);
                choose_player();
                String c = button4.getText();
                board[1][0] = c;
                if (winner_player("X")){
                    lockBoard();
                    JOptionPane.showMessageDialog(mainpanel,"X has won");
                    unlockBoard();
                }
                else if(winner_player("O")){
                    lockBoard();
                    JOptionPane.showMessageDialog(mainpanel,"O has won");
                    unlockBoard();
                }
            }
        });
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button5.setEnabled(false);
                button5.setText(startgame);
                button5.setFont(f1);
                choose_player();
                String c = button5.getText();
                board[1][1] = c;
                if (winner_player("X")){
                    lockBoard();
                    JOptionPane.showMessageDialog(mainpanel,"X has won");
                    unlockBoard();
                }
                else if(winner_player("O")){
                    lockBoard();
                    JOptionPane.showMessageDialog(mainpanel,"O has won");
                    unlockBoard();
                }
            }
        });
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button6.setEnabled(false);
                button6.setText(startgame);
                button6.setFont(f1);
                choose_player();
                String c = button6.getText();
                board[1][2] = c;
                if (winner_player("X")){
                    lockBoard();
                    JOptionPane.showMessageDialog(mainpanel,"X has won");
                    unlockBoard();
                }
                else if(winner_player("O")){
                    lockBoard();
                    JOptionPane.showMessageDialog(mainpanel,"O has won");
                    unlockBoard();
                }
            }
        });
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button7.setEnabled(false);
                button7.setText(startgame);
                button7.setFont(f1);
                choose_player();
                String c = button7.getText();
                board[2][0] = c;
                if (winner_player("X")){
                    lockBoard();
                    JOptionPane.showMessageDialog(mainpanel,"X has won");
                    unlockBoard();
                }
                else if(winner_player("O")){
                    lockBoard();
                    JOptionPane.showMessageDialog(mainpanel,"O has won");
                    unlockBoard();
                }
            }
        });
        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button8.setEnabled(false);
                button8.setText(startgame);
                button8.setFont(f1);
                choose_player();
                String c = button8.getText();
                board[2][1] = c;
                if (winner_player("X")){
                    lockBoard();
                    JOptionPane.showMessageDialog(mainpanel,"X has won");
                    unlockBoard();
                }
                else if(winner_player("O")){
                    lockBoard();
                    JOptionPane.showMessageDialog(mainpanel,"O has won");
                    unlockBoard();
                }
            }
        });
        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button9.setEnabled(false);
                button9.setText(startgame);
                button9.setFont(f1);
                choose_player();
                String c = button9.getText();
                board[2][2] = c;
                if (winner_player("X")){
                    lockBoard();
                    JOptionPane.showMessageDialog(mainpanel,"X has won");
                    unlockBoard();
                }
                else if(winner_player("O")){
                    lockBoard();
                    JOptionPane.showMessageDialog(mainpanel,"O has won");
                    unlockBoard();
                }
            }
        });
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
    private void choose_player(){
        if (startgame.equalsIgnoreCase("X")){
            startgame = "O";
        }
        else {
            startgame = "X";
        }
    }
    private boolean winner_player( String player){
        for (int i = 0; i<3 ; i++) {
            //Row
            if ((board[i][0] == player) && (board[i][1] == player) && (board[i][2] == player)) {
                return true;
            }
            //Column
            if ((board[0][i] == player) && (board[1][i] == player) && (board[2][i] == player)) {
                return true;
            }
        }

        //Diagonal left
        if ((board[0][0]== player) && (board[1][1]== player) && (board[2][2]== player)){
            return true;
        }
        //Diagonal right
        if ((board[0][2]== player) && (board[1][1]== player) && (board[2][0]== player)){
            return true;
        }
        return false;
    }
    private void lockBoard(){
        for (int i =0; i<9 ;i++){
            boardpanel.getComponent(i).setEnabled(false);
        }
    }
    private void unlockBoard(){
        for (int i =0; i<9 ;i++){
            boardpanel.getComponent(i).setEnabled(true);
        }
        //reset
        button1.setText("");
        button2.setText("");
        button3.setText("");
        button4.setText("");
        button5.setText("");
        button6.setText("");
        button7.setText("");
        button8.setText("");
        button9.setText("");
        for ( int i = 0; i<3; i++){
            for (int j = 0; j<3;j++){
                board[i][j] = " ";
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        new GameBoard(frame);

    }
}
