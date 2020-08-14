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


    //    END GAME TEXTS
    private String xWon = "Player Won!";
    private String yWon = "Computer Won!";
    private String tie = "It's a TIE!";

    public static int aiType = 0;

    //  Varibles
    int freeSpots = 9;
    private String startgame = "X";
    public String[][] board = new String[3][3];
    Font f1 = new Font("Arial", Font.BOLD, 30);

    String playerMark = "X";
    String playerMarkObj = new String(playerMark);

    String computerMark = "O";
    String computerMarkObj = new String(computerMark);

    int turn = 0;

    //  UI
    private JPanel boardpanel;
    private JPanel mainpanel;
    public JButton[] button = new JButton[]{btn_upperLeft, btn_upperMiddle, btn_upperRight,
            btn_lowerLeft, btn_lowerMiddle, btn_lowerRight,
            btn_middleLeft, btn_middleCenter, btn_middleRight};

    public Person player;
    public RandomAi randomAi;
    public DefensiveAi defensiveAi;

    //int testCounter = 0;//Testing

    public static int currentState[] = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

    private JPanel restartMainPanel;
    private JPanel restartBoardPanel;
    private JButton[] restartButton;
    private JFrame restartFrame;


    public GameLogic() {

    }

    public GameLogic(JPanel mainpanel, JPanel boardpanel, JButton[] button, JFrame frame) {
        this.mainpanel = mainpanel;
        this.boardpanel = boardpanel;
        this.button = button;


        restartMainPanel = mainpanel;
        restartBoardPanel = boardpanel;
        restartButton = button;
        restartFrame = frame;


        welcomeMessage();
        initboard();
        initButton(this.button, true, f1, startgame);

        player = new Person(this.button, board);
        randomAi = new RandomAi(this.button, board);
        defensiveAi = new DefensiveAi(this.button, board);

    }

    private void restartGame() {
        //        System.exit(0);
        JFrame frame = new JFrame();
        new GameBoard(frame);
        freeSpots = 9;
        initboard();
        initButton(this.button, true, f1, startgame);
        for (int i = 0; i < currentState.length; i++) {
            currentState[i] = -1;
        }
        player = new Person(this.button, board);
        randomAi = new RandomAi(this.button, board);
        defensiveAi = new DefensiveAi(this.button, board);

    }

    private void initboard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = "";
                for (int k = 0; k < 9; k++) {
                    boardpanel.getComponent(k).setEnabled(true);
                    button[k].setText("");
                }
            }
        }
    }

    public void welcomeMessage() {
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

    public class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!winner_player(computerMarkObj) && (turn % 2 == 0) && (freeSpots % 2 != 0)) {
                player.makeMove(e);
                freeSpots--;
                turn++;
                //testCounter++;
                //System.out.println("Test Counter: "+testCounter+ " Freespots:"+freeSpots);
                checkGameWinner();
            }

            if (!winner_player(playerMarkObj) && (turn % 2 != 0) && (freeSpots % 2 == 0)) {
                if (aiType == 0) {
                    randomAi.makeMove(e);
                } else if (aiType == 1) {
                    defensiveAi.makeMove(e);
                }

//

                freeSpots--;
                turn++;
                //testCounter++;
                //System.out.println("Test Counter: "+testCounter+ " Freespots:"+freeSpots);
                checkGameWinner();
            }

        }

        public void lockboard() {
            for (int i = 0; i < 9; i++) {
                button[i].setEnabled(false);
            }
        }


        public void checkGameWinner() {

            if (winner_player(playerMarkObj)) {
                lockboard();
                JOptionPane.showMessageDialog(null, xWon);
//                initboard(); //Refresh Board
                restartGame();
            } else if (winner_player(computerMarkObj)) {
                lockboard();
                JOptionPane.showMessageDialog(null, yWon);
//                initboard(); //Refresh Board
                restartGame();
            } else if (freeSpots == 0) {
                lockboard();
                JOptionPane.showMessageDialog(null, tie);
//                initboard(); //Refresh Board
                restartGame();
            }
        }

        //    Game Logic
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
