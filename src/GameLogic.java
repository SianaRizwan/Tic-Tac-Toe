import Players.DefensiveAi;
import Players.HumanPlayer;
import Players.RandomAi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameLogic {

    //    END GAME TEXTS
    private String xWon = "Player Won!";
    private String yWon = "Computer Won!";
    private String tie = "It's a TIE!";
    private String playerMarkObj = "X";
    private String computerMarkObj = "O";

    //  Varibles
    int freeSpots = 9;
    public String[][] board = new String[3][3];
    public JButton[] button;
    public int[] currentState = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};  //Gives current state of the buttons (enable/disable)
    Font f1 = new Font("Arial", Font.BOLD, 30);

    //  UI
    private JPanel boardpanel,settingspanel,mainpanel;
    private JFrame frame;
    private JButton startWithDefensiveAIButton,startWithRandomAIButton;
    private JRadioButton classicRadioButton,forestRadioButton,highContrastRadioButton;
    private JLabel Theme;


    private HumanPlayer player;
    private RandomAi randomAi;
    private DefensiveAi defensiveAi;
    private AiSettings aiSettings;
    private ThemeSettings themeSettings;
    private WinLogic winLogic;








    public GameLogic(JPanel mainpanel, JPanel boardpanel, JButton[] button, JFrame frame, JPanel settingspanel, JLabel Theme,
                     JRadioButton classicRadioButton,JRadioButton forestRadioButton,JRadioButton highContrastRadioButton,
                     JButton startWithRandomAIButton,JButton startWithDefensiveAIButton) {
        this.boardpanel = boardpanel;
        this.settingspanel = settingspanel;
        this.Theme = Theme;
        this.button = button;
        this.classicRadioButton = classicRadioButton;
        this.forestRadioButton = forestRadioButton;
        this.highContrastRadioButton = highContrastRadioButton;
        this.startWithRandomAIButton = startWithRandomAIButton;
        this.startWithDefensiveAIButton = startWithDefensiveAIButton;
        this.frame = frame;
        welcomeMessage();
        initButton(button, f1);
        initboard();
        aiSettings  = new AiSettings(mainpanel, boardpanel, button, settingspanel, startWithDefensiveAIButton, startWithRandomAIButton,true);
        player = new HumanPlayer(button, board,currentState);
        randomAi = new RandomAi(button, board,currentState);
        defensiveAi = new DefensiveAi(button, board,currentState);
        winLogic = new WinLogic(board);
        themeSettings = new ThemeSettings(classicRadioButton,forestRadioButton,highContrastRadioButton,mainpanel,boardpanel,button,settingspanel,Theme);
        themeSettings.setCurrentTheme(0);
    }

    private void restartGame() {
        new GameBoard();
        freeSpots =9 ;
        initboard();
        initButton(this.button, f1);
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


    private void initButton(JButton[] button, Font font) {

        for (int i = 0; i < 9; i++) {
            button[i].setText("");
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
                setthemebuttons();
                checkGameWinner();
            }


            if (!winLogic.winner_player(playerMarkObj)  && (freeSpots % 2 == 0)) {
                if(aiSettings.getType() == 1){
                    defensiveAi.makeMove(e);
                } else if(aiSettings.getType() == 0) {
                    randomAi.makeMove(e);
                }
                freeSpots--;
                setthemebuttons();
                checkGameWinner();
            }

        }

        private void setthemebuttons() {
            themeSettings.setTheme(themeSettings.getCurrentTheme());
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
