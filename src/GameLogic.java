import Players.DefensiveAi;
import Players.HumanPlayer;
import Players.RandomAi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameLogic {

    ThemeSettings themeSettings;

    private JPanel settingspanel;
    private JButton startWithDefensiveAIButton;
    private JButton startWithRandomAIButton;

    //    END GAME TEXTS
    private String xWon = "Player Won!";
    private String yWon = "Computer Won!";
    private String tie = "It's a TIE!";

    //  Varibles
    int freeSpots = 9;
    private String startgame = "X";
    public String[][] board = new String[3][3];
    Font f1 = new Font("Arial", Font.BOLD, 30);

    String playerMark = "X";
    String playerMarkObj = playerMark;

    String computerMark = "O";
    String computerMarkObj = computerMark;



    //  UI
    private JPanel boardpanel;
    private JPanel mainpanel;
    private JFrame frame;
    public JButton[] button;


    private JRadioButton classicRadioButton;
    private JRadioButton forestRadioButton;
    private JRadioButton highContrastRadioButton;
    private JLabel Theme;


    public HumanPlayer player;
    public RandomAi randomAi;
    public DefensiveAi defensiveAi;
    public AiSettings aiSettings;



    public int[] currentState = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};




    public GameLogic(JPanel mainpanel, JPanel boardpanel, JButton[] button, JFrame frame) {
        this.mainpanel = mainpanel;
        this.boardpanel = boardpanel;
        this.button = button;
        welcomeMessage();
        initboard();
        initButton(this.button, true, f1, startgame);
        aiSettings  = new AiSettings(mainpanel, boardpanel, button, settingspanel, startWithDefensiveAIButton, startWithRandomAIButton);
        player = new HumanPlayer(this.button, board,currentState);
        randomAi = new RandomAi(this.button, board,currentState);
        defensiveAi = new DefensiveAi(this.button, board,currentState);
       // themeSettings = new ThemeSettings(classicRadioButton,forestRadioButton,highContrastRadioButton,mainpanel,boardpanel,button,settingspanel,Theme);


    }

    private void restartGame() {
        JFrame frame = new JFrame();
        new GameBoard(frame);
        freeSpots = 9;
        initboard();
        initButton(this.button, true, f1, startgame);
        for (int i = 0; i < currentState.length; i++) {
            currentState[i] = -1;
        }
        player = new HumanPlayer(this.button, board, currentState);
        randomAi = new RandomAi(this.button, board, currentState);
        defensiveAi = new DefensiveAi(this.button, board, currentState);



    }

    private void initboard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = "";
                for (int k = 0; k < 9; k++) {
                    boardpanel.getComponent(k).setEnabled(true);
                    button[k].setText("");
                    button[k].setPreferredSize(new Dimension(40,40));
                    button[k].setMaximumSize(new Dimension(40,40));
                    button[k].setMinimumSize(new Dimension(40,40));
                    button[k].setHorizontalTextPosition(SwingConstants.CENTER);
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

        int turn = 0;
        @Override
        public void actionPerformed(ActionEvent e) {
//            System.out.println(ThemeSettings.currentTheme);
//            if(ThemeSettings.currentTheme == 1)
//            {
//                themeSettings.setforestTheme();
//            }else if(ThemeSettings.currentTheme == 2)
//            {
//                themeSettings.setHighContrastTheme();
//            }
//            else
//            {
//                themeSettings.setClassicTheme();
//            }
            if (!winner_player(computerMarkObj) && (turn % 2 == 0) && (freeSpots % 2 != 0)) {
//                e.getSource().b
                player.makeMove(e);
                freeSpots--;
                turn++;
                checkGameWinner();
            }

            if (!winner_player(playerMarkObj) && (turn % 2 != 0) && (freeSpots % 2 == 0)) {
                if(aiSettings.getType() == 1){
                    defensiveAi.makeMove(e);
                } else if(aiSettings.getType() == 0) {
                    randomAi.makeMove(e);
                }
                freeSpots--;
                turn++;
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
                restartGame();
            } else if (winner_player(computerMarkObj)) {
                lockboard();
                JOptionPane.showMessageDialog(null, yWon);
                restartGame();
            } else if (freeSpots == 0) {
                lockboard();
                JOptionPane.showMessageDialog(null, tie);
                restartGame();
            }
        }

        //    Game Logic
        private boolean winner_player(String player) {
            for (int i = 0; i < 3; i++) {
                //Row
                if ((board[i][0].equals(player)) && (board[i][1].equals(player)) && (board[i][2].equals(player))) {
                    return true;
                }
                //Column
                if ((board[0][i].equals(player)) && (board[1][i].equals(player)) && (board[2][i].equals(player))) {
                    return true;
                }
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
