import javax.swing.*;
import java.awt.event.ActionEvent;

public class DefensiveAi implements IAi {

    int[][] btnCoordfromNumber = new int[1][2];
    private int[][] btnRelation = new int[3][3];
    GameLogic.ButtonListener buttonListener;
    String Board;

    BtnCoordinate btnCoordinate;
    int loopCounter = 0;
    String computerMove = "O";
    String str = "";
    String emptyString = str;
    String str1 = "X";
    String playerValue = str1;
    int ai_i, ai_j;
    public JButton[] calledButton;
    String[][] calledBoard;
    int btnCoord;


    DefensiveAi(JButton[] button, String[][] board) {

        btnCoordinate = new BtnCoordinate();
        calledButton = button;
        calledBoard = board;
        System.out.println("Inside Defensive");
    }

    @Override
    public void makeMove(ActionEvent e) {
        int k = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                btnRelation[i][j] = k;
                k++;
            }
        }


        getNextMove();
        int btnCoord = btnRelation[ai_i][ai_j];
        Board = calledBoard[ai_i][ai_j];
        int counter = 0;

        while (true) {
            System.out.println("LOOP COUNTER : ");
            if (loopCounter == 500) {
                break;
            } else {
//            @TODO RANDOM AI CLASS NEEDS TO BE ADDED
                ai_i = (int) (Math.random() * 3);
                ai_j = (int) (Math.random() * 3);
                Board = calledBoard[ai_i][ai_j];
                btnCoord = btnRelation[ai_i][ai_j];
                calledButton[btnCoord].setText(computerMove);
                calledButton[btnCoord].setEnabled(false);
                calledBoard[ai_i][ai_j] = computerMove;
            }
            if ((Board.equals(emptyString) && GameLogic.currentState[btnCoord] == -1)) {
                GameLogic.currentState[btnCoord] = 500;
                loopCounter = 0;
                break;
            } else {
                getNextMove();
                Board = calledBoard[ai_i][ai_j];
                btnCoord = btnRelation[ai_i][ai_j];
            }
        }
        loopCounter = 0;

    }

    public void getNextMove() {
        if (isPersonWinning()) {
            ai_i = btnCoordfromNumber[0][0];
            ai_j = btnCoordfromNumber[0][1];
        } else if (hasBestMove()) {
            ai_i = btnCoordfromNumber[0][0];
            ai_j = btnCoordfromNumber[0][1];
        }
    }


    public boolean isPersonWinning() {
        int counter = 0;

        //Row
        if ((calledBoard[0][0].equals(playerValue)) && (calledBoard[0][1].equals(playerValue)) && (calledButton[2].getText() == "")) {
            btnCoordfromNumber = btnCoordinate.getButtonCoordinate(2);

            return true;
        }
        if ((calledBoard[1][0].equals(playerValue)) && (calledBoard[1][1].equals(playerValue)) && (calledButton[5].getText() == "")) {
            btnCoordfromNumber = btnCoordinate.getButtonCoordinate(5);

            return true;
        }
        if ((calledBoard[2][0].equals(playerValue)) && (calledBoard[2][1].equals(playerValue)) && (calledButton[8].getText() == "")) {
            btnCoordfromNumber = btnCoordinate.getButtonCoordinate(8);

            return true;
        }

        //Column
        if ((calledBoard[0][0].equals(playerValue)) && (calledBoard[1][0].equals(playerValue)) && (calledButton[6].getText() == "")) {
            btnCoordfromNumber = btnCoordinate.getButtonCoordinate(6);

            return true;
        }
        if ((calledBoard[0][1].equals(playerValue)) && (calledBoard[1][1].equals(playerValue)) && (calledButton[7].getText() == "")) {
            btnCoordfromNumber = btnCoordinate.getButtonCoordinate(7);

            return true;
        }
        if ((calledBoard[0][2].equals(playerValue)) && (calledBoard[1][2].equals(playerValue)) && (calledButton[8].getText() == "")) {
            btnCoordfromNumber = btnCoordinate.getButtonCoordinate(8);

            return true;
        }

        //Diagonal left
        if ((calledBoard[0][0].equals(playerValue)) && (calledBoard[1][1].equals(playerValue)) && (calledButton[8].getText() == "")) {
            btnCoordfromNumber = btnCoordinate.getButtonCoordinate(8);

            return true;
        }
        //Diagonal right
        if ((calledBoard[0][2].equals(playerValue)) && (calledBoard[1][1].equals(playerValue)) && (calledButton[6].getText() == "")) {
            btnCoordfromNumber = btnCoordinate.getButtonCoordinate(6);

            return true;
        }
        return false;
    }

    public boolean hasBestMove() {
        int counter = 0;

        //Row
        if ((calledBoard[0][0].equals(computerMove)) && (calledBoard[0][1].equals(computerMove)) && (calledButton[2].getText() == "")) {
            btnCoordfromNumber = btnCoordinate.getButtonCoordinate(2);

            return true;
        }
        if ((calledBoard[1][0].equals(computerMove)) && (calledBoard[1][1].equals(computerMove)) && (calledButton[5].getText() == "")) {
            btnCoordfromNumber = btnCoordinate.getButtonCoordinate(5);

            return true;
        }
        if ((calledBoard[2][0].equals(computerMove)) && (calledBoard[2][1].equals(computerMove)) && (calledButton[8].getText() == "")) {
            btnCoordfromNumber = btnCoordinate.getButtonCoordinate(8);

            return true;
        }

        //Column
        if ((calledBoard[0][0].equals(computerMove)) && (calledBoard[1][0].equals(computerMove)) && (calledButton[6].getText() == "")) {
            btnCoordfromNumber = btnCoordinate.getButtonCoordinate(6);

            return true;
        }
        if ((calledBoard[0][1].equals(computerMove)) && (calledBoard[1][1].equals(computerMove)) && (calledButton[7].getText() == "")) {
            btnCoordfromNumber = btnCoordinate.getButtonCoordinate(7);

            return true;
        }
        if ((calledBoard[0][2].equals(computerMove)) && (calledBoard[1][2].equals(computerMove)) && (calledButton[8].getText() == "")) {
            btnCoordfromNumber = btnCoordinate.getButtonCoordinate(8);

            return true;
        }

        //Diagonal left
        if ((calledBoard[0][0].equals(computerMove)) && (calledBoard[1][1].equals(computerMove)) && (calledButton[8].getText() == "")) {
            btnCoordfromNumber = btnCoordinate.getButtonCoordinate(8);

            return true;
        }
        //Diagonal right
        if ((calledBoard[0][2].equals(computerMove)) && (calledBoard[1][1].equals(computerMove)) && (calledButton[6].getText() == "")) {
            btnCoordfromNumber = btnCoordinate.getButtonCoordinate(6);

            return true;
        }
        return false;
    }
}

//



