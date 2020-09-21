package Players;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class HumanPlayer implements IAi {

    private JButton[] calledButton;
    private BtnCoordinate btnCoordinate = new BtnCoordinate();
    private int[][] btnCoord = new int[1][2];
    private String[][] calledBoard;
    private String playerMove = "X";
    private int[] newState;


    public HumanPlayer(JButton[] button, String[][] board, int[] currentState) {
        calledButton = button;
        calledBoard = board;
        newState = currentState;
    }

    @Override
    public void makeMove(ActionEvent e) {
        //get the particular button that was clicked
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == calledButton[i]) {
                newState[i] = 500;
                calledButton[i].setText(playerMove);
                calledButton[i].setEnabled(false);
                btnCoord = btnCoordinate.getButtonCoordinate(i);
                calledBoard[btnCoord[0][0]][btnCoord[0][1]] = playerMove;
                break;
            }
        }
    }


}