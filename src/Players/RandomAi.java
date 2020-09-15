package Players;

import javax.swing.*;
import java.awt.event.ActionEvent;


public class RandomAi implements IAi {
    private int[][] btnRelation = new int[3][3];

    String computerMove = "O";
    String emptyString = "";
    String playerValue = "X";

    public JButton[] calledButton;
    String[][] calledBoard;
    public int[] newState;



    public RandomAi(JButton[] button, String[][] board, int[] currentState) {
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

        int ai_i = (int) (Math.random() * 3);
        int ai_j = (int) (Math.random() * 3);
        int btnCoord = btnRelation[ai_i][ai_j];
        String Board = calledBoard[ai_i][ai_j];



        while (true) {
            if ((Board.equals(emptyString) && newState[btnCoord] == -1)) {
                newState[btnCoord] = 500;
                calledButton[btnCoord].setText(computerMove);
                calledButton[btnCoord].setEnabled(false);
                calledBoard[ai_i][ai_j] = computerMove;
                break;

            } else {
                ai_i = (int) (Math.random() * 3);
                ai_j = (int) (Math.random() * 3);
                Board = calledBoard[ai_i][ai_j];
                btnCoord = btnRelation[ai_i][ai_j];

            }

        }



    }


}

