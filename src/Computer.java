import javax.swing.*;
import java.awt.event.ActionEvent;

public class Computer implements IButtonListener {
    private int[][] btnRelation = new int[3][3];

    String computerMove = "O";
    String str = "";
    String emptyString = new String(str);
    String str1 = "X";
    String playerValue = new String(str1);

    public JButton[] calledButton;
    String[][] calledBoard = new String[3][3];
    int freeSpot = 4;

    Computer(JButton[] button, String[][] board) {
        calledButton = button;
        calledBoard = board;
        freeSpot--;
    }

    @Override
    public void currentButton(ActionEvent e) {

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
        String Board = new String(calledBoard[ai_i][ai_j]);

        //System.out.println("Outside loop - AI I: " + ai_i + " AI J: " + ai_j);

        while (true) {
            if ((Board.equals(emptyString) && GameLogic.currentState[btnCoord] == -1)) {

                //System.out.println("Inside loop if - AI I: " + ai_i + " AI J: " + ai_j);

                calledButton[btnCoord].setText(computerMove);
                calledButton[btnCoord].setEnabled(false);
                calledBoard[ai_i][ai_j] = computerMove;

                break;

            } else {

                ai_i = (int) (Math.random() * 3);
                ai_j = (int) (Math.random() * 3);
                Board = new String(calledBoard[ai_i][ai_j]);
                btnCoord = btnRelation[ai_i][ai_j];

                //System.out.println("Inside loop else - AI I: " + ai_i + " AI J: " + ai_j+" Board"+ Board+ "Button Cordinate: "+btnCoord);
            }
        }




    }
}
