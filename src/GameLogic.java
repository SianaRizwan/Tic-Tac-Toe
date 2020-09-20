import Players.DefensiveAi;
import Players.HumanPlayer;
import Players.RandomAi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameLogic {

    private JPanel settingspanel;
    private JButton startWithDefensiveAIButton;
    private JButton startWithRandomAIButton;

    //    END GAME TEXTS
    private String xWon = "Player Won!";
    private String yWon = "Computer Won!";
    private String tie = "It's a TIE!";

    //  Varibles
    int freeSpots = 9;
    public String[][] board = new String[3][3];
    Font f1 = new Font("Arial", Font.BOLD, 30);

    private String playerMarkObj = "X";

    private String computerMarkObj = "O";




    //  UI
    private JPanel boardpanel;
    private JPanel mainpanel;
    private JFrame frame;
    public JButton[] button;


    private JRadioButton classicRadioButton;
    private JRadioButton forestRadioButton;
    private JRadioButton highContrastRadioButton;
    private JLabel Theme;


    private HumanPlayer player;
    private RandomAi randomAi;
    private DefensiveAi defensiveAi;
    private AiSettings aiSettings;
    public ThemeSettings themeSettings;
    private WinLogic winLogic;



    public int[] currentState = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};




    public GameLogic(JPanel mainpanel, JPanel boardpanel, JButton[] button, JFrame frame) {
        this.mainpanel = mainpanel;
        this.boardpanel = boardpanel;
        this.button = button;
        this.frame = frame;
        welcomeMessage();
        initButton(this.button, true, f1);
        initboard();
        aiSettings  = new AiSettings(mainpanel, boardpanel, button, settingspanel, startWithDefensiveAIButton, startWithRandomAIButton);
        player = new HumanPlayer(this.button, board,currentState);
        randomAi = new RandomAi(this.button, board,currentState);
        defensiveAi = new DefensiveAi(this.button, board,currentState);
        winLogic = new WinLogic(board);
        // themeSettings = new ThemeSettings(classicRadioButton,forestRadioButton,highContrastRadioButton,mainpanel,boardpanel,button,settingspanel,Theme);


    }

    private void restartGame() {
        new GameBoard();
        freeSpots =9 ;
        initboard();
        initButton(this.button, true, f1);
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

    private void welcomeMessage() {
        System.out.println(
                " ___   _   __   _   _   __  __ ___    _____  _  ___   _____  __   ___   _____  __   ____ \n" +
                        "/  _) ( ) (  ) ( \\ ( ) (  )/_//  _)  (_   _)( )(  _) (_   _)(  ) (  _) (_   _)(  ) (  __)\n" +
                        "\\_\"-. | | /o \\ | \\\\| | /o \\   \\_\"-.    | |  | || |     | |  /o \\ | |     | |  /  \\ | |_  \n" +
                        " __) )( )( __ )( )\\\\ )( __ )   __) )   ( )  ( )( )_    ( ) ( __ )( )_    ( ) ( O  )(  _) \n" +
                        "/___/ /_\\/_\\/_\\/_\\ \\_\\/_\\/_\\  /___/    /_\\  /_\\/___\\   /_\\ /_\\/_\\/___\\   /_\\  \\__/ /____\\");
    }


    private void initButton(JButton[] button, boolean enableStatus, Font font) {

        for (int i = 0; i < 9; i++) {
            button[i].setFont(font);
            button[i].setEnabled(true);
            button[i].addActionListener(new ButtonListener());
            button[i].setPreferredSize(new Dimension(40,40));
            button[i].setMaximumSize(new Dimension(40,40));
            button[i].setMinimumSize(new Dimension(40,40));
            button[i].setHorizontalTextPosition(SwingConstants.CENTER);
        }

    }



    public class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (!winLogic.winner_player(computerMarkObj)  && (freeSpots % 2 != 0)) {
                player.makeMove(e);
                freeSpots--;
                checkGameWinner();
            }


            if (!winLogic.winner_player(playerMarkObj)  && (freeSpots % 2 == 0)) {
                if(aiSettings.getType() == 1){
                    defensiveAi.makeMove(e);
                } else if(aiSettings.getType() == 0) {
                    randomAi.makeMove(e);
                }
                freeSpots--;
                checkGameWinner();
            }

        }



        private void lockboard() {
            for (int i = 0; i < 9; i++) {
                button[i].setEnabled(false);
            }
        }


        private void checkGameWinner() {
            if (winLogic.winner_player(playerMarkObj)) {
                lockboard();
                JOptionPane.showMessageDialog(null, xWon);
                restartGame();
            } else if (winLogic.winner_player(computerMarkObj)) {
                lockboard();
                JOptionPane.showMessageDialog(null, yWon);
                restartGame();
            } else if (freeSpots == 0) {
                lockboard();
                JOptionPane.showMessageDialog(null, tie);
                restartGame();
            }
        }

    }
}
