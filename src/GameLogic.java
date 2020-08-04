import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameLogic {
    //  Buttons
    private JButton btn_upperLeft;
    private JButton btn_upperMiddle;
    private JButton btn_upperRight;
    private JButton btn_lowerLeft;
    private JButton btn_lowerMiddle;
    private JButton btn_lowerRight;
    private JButton btn_middleLeft;
    private JButton btn_middleCenter;
    private JButton btn_middleRight;

    //  Varibles
    int freeSpots = 9;
    private String startgame = "X";
    public String[][] board = new String[3][3];
    Font f1 = new Font("Arial", Font.BOLD, 30);

    String playerMark = "X";
    String playerMarkObj = new String(playerMark);

    String computerMark = "O";
    String computerMarkObj = new String(computerMark);

    //  UI
    private JPanel boardpanel;
    private JPanel mainpanel;
    public JButton[] button = new JButton[]{btn_upperLeft, btn_upperMiddle, btn_upperRight,
            btn_lowerLeft, btn_lowerMiddle, btn_lowerRight,
            btn_middleLeft, btn_middleCenter, btn_middleRight};

    Player player;
    Computer computer;

    static int currentState[] = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

    public GameLogic() {

    }

    public GameLogic(JPanel mainpanel, JPanel boardpanel, JButton[] button, JFrame frame) {
        this.mainpanel = mainpanel;
        this.boardpanel = boardpanel;
        this.button = button;
        welcomeMessage();
        initboard();
        initButton(this.button, true, f1, startgame);

        player = new Player(this.button,board);
        computer = new Computer(this.button, board);

    }

    private void initboard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = "";
            }
        }
    }

    public void welcomeMessage()
    {
        System.out.println(
                " ___   _   __   _   _   __  __ ___    _____  _  ___   _____  __   ___   _____  __   ____ \n" +
                "/  _) ( ) (  ) ( \\ ( ) (  )/_//  _)  (_   _)( )(  _) (_   _)(  ) (  _) (_   _)(  ) (  __)\n" +
                "\\_\"-. | | /o \\ | \\\\| | /o \\   \\_\"-.    | |  | || |     | |  /o \\ | |     | |  /  \\ | |_  \n" +
                " __) )( )( __ )( )\\\\ )( __ )   __) )   ( )  ( )( )_    ( ) ( __ )( )_    ( ) ( O  )(  _) \n" +
                "/___/ /_\\/_\\/_\\/_\\ \\_\\/_\\/_\\  /___/    /_\\  /_\\/___\\   /_\\ /_\\/_\\/___\\   /_\\  \\__/ /____\\");
    }


    private void initButton(JButton[] button, boolean enableStatus, Font font, String startgame) {

        for (int i = 0; i < 9; i++) {
            button[i].setFont(font);
            button[i].setText("");
            button[i].setEnabled(true);
            button[i].addActionListener(new ButtonListener());
        }

    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!winner_player(computerMarkObj)) {
                player.currentButton(e);
                freeSpots--;
                checkGameWinner();
            }

            if (!winner_player(playerMarkObj)) {
                computer.currentButton(e);
                freeSpots--;
                checkGameWinner();
            }

        }

        public void lockboard() {
            for (int i = 0; i < 9; i++) {
                button[i].setText("");
                button[i].setEnabled(false);
            }
        }


        public void checkGameWinner() {

            if (winner_player(playerMarkObj)) {
                JOptionPane.showMessageDialog(null, "X Won!");
                lockboard();
                initboard(); //Refresh Board

            } else if (winner_player(computerMarkObj)) {
                JOptionPane.showMessageDialog(null, "O Won!");
                lockboard();
                initboard(); //Refresh Board
            } else if (freeSpots == 0) {
                JOptionPane.showMessageDialog(null, "It's a tie!");
                lockboard();
                initboard(); //Refresh Board
            }
        }

        //    Game Logi
        private boolean winner_player(String player) {
            for (int i = 0; i < 3; i++) {

//                Test winning Condition
//                System.out.println("ITERNATION NUMBER: "+i);
//                System.out.printf("Row Check if Board %d 0: %s\t Board %d 1: %s\t Board %d 2: %s\n",i,board[i][0],i,board[i][1],i,board[i][2]);
//                System.out.printf("Row Check if Board 0 %d: %s\t Board 1 %d: %s\t Board 2 %d: %s\n",i,board[0][i],i,board[1][i],i,board[2][i]);
//
                //Row
                if ((board[i][0].equals(player)) && (board[i][1].equals(player)) && (board[i][2].equals(player))) {
                    return true;
                }
                //Column
                if ((board[0][i].equals(player)) && (board[1][i].equals(player)) && (board[2][i].equals(player))) {
                    return true;
                }

//                Test Winning Condition
//                System.out.println("Left D Check If Board 0 0:" + board[0][0] + "Board 1 1:" + board[1][1] + "Board 2 2:" + board[2][2]);
//                System.out.println("Right D Check If Board 0 2:" + board[0][2] + "Board 1 1:" + board[1][1] + "Board 2 0:" + board[2][0]);

                //Diagonal left
                if ((board[0][0].equals(player)) && (board[1][1].equals(player)) && (board[2][2].equals(player))) {
                    return true;
                }
                //Diagonal right
                if ((board[0][2].equals(player)) && (board[1][1].equals(player)) && (board[2][0].equals(player))) {
                    return true;
                }
            }

            return false;
        }
    }
}
