package Players;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class DefensiveAi implements IAi {

    private int[][] btnRelation = new int[3][3];

    private String Board;

    private BtnCoordinate btnCoordinate;
    private String computerMove = "O";
    private String emptyString = "";
    private String playerMove = "X";
    private int ai_i, ai_j;
    private JButton[] calledButton;
    private String[][] calledBoard;
    private int btnCoord;
    private int[] newState;



    public DefensiveAi(JButton[] button, String[][] board, int[] currentState) {
        btnCoordinate = new BtnCoordinate();
        calledButton = button;
        calledBoard = board;
        newState = currentState;
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
        btnCoord = btnRelation[ai_i][ai_j];
        Board = calledBoard[ai_i][ai_j];

        while (true) {

            if ((Board.equals(emptyString) && newState [btnCoord] == -1)) {
                isPersonWinning();
                btnCoord = btnRelation[ai_i][ai_j];
                newState [btnCoord] = 500;
                calledButton[btnCoord].setText(computerMove);
                calledButton[btnCoord].setEnabled(false);
                break;
            } else {
                isPersonWinning();
                btnCoord = btnRelation[ai_i][ai_j];
                calledButton[btnCoord].setText(computerMove);
                calledButton[btnCoord].setEnabled(false);
                calledBoard[ai_i][ai_j] = computerMove;
                newState [btnCoord] = 500;
                break;

            }
        }
    }

    private void isPersonWinning() {
        ai_i = (int) (Math.random() * 3);
        ai_j = (int) (Math.random() * 3);
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                if (calledBoard[row][column].equals("")) {
                    calledBoard[row][column] = "X";
                    if (winner_player(playerMove)) {
                        ai_i = row;
                        ai_j = column;
                    }
                    calledBoard[row][column] = "";
                } else if (calledBoard[ai_i][ai_j].equals("X")) {
                    ai_i = (int) (Math.random() * 3);
                    ai_j = (int) (Math.random() * 3);
                }
            }
        }

    }
    private boolean winner_player(String player) {
        for (int i = 0; i < 3; i++) {
            //Row
            if ((calledBoard[i][0].equals(player)) && (calledBoard[i][1].equals(player)) && (calledBoard[i][2].equals(player))) {
                return true;
            }
            //Column
            if ((calledBoard[0][i].equals(player)) && (calledBoard[1][i].equals(player)) && (calledBoard[2][i].equals(player))) {
                return true;
            }


            //Diagonal left
            if ((calledBoard[0][0].equals(player)) && (calledBoard[1][1].equals(player)) && (calledBoard[2][2].equals(player))) {
                return true;
            }
            //Diagonal right
            if ((calledBoard[0][2].equals(player)) && (calledBoard[1][1].equals(player)) && (calledBoard[2][0].equals(player))) {
                return true;
            }
        }

        return false;
    }

}





