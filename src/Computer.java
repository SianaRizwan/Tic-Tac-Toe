import javax.swing.*;
import java.awt.event.ActionEvent;


public class Computer implements IButtonListener {
    private int[][] btnRelation = new int[3][3];

    int loopCounter = 0;
    String computerMove = "O";
    String str = "";
    String emptyString = new String(str);
    String str1 = "X";
    String playerValue = new String(str1);

    public JButton[] calledButton;
    String[][] calledBoard = new String[3][3];


    Computer(JButton[] button, String[][] board) {

        calledButton = button;
        calledBoard = board;
    }

    @Override
    public void currentButton(ActionEvent e) {

        int k = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                btnRelation[i][j] = k;
                //System.out.println("Called Board:"+ calledBoard[i][j]);
                k++;
            }
        }

        int ai_i = (int) (Math.random() * 3);
        int ai_j = (int) (Math.random() * 3);
        int btnCoord = btnRelation[ai_i][ai_j];
        String Board = new String(calledBoard[ai_i][ai_j]);

        //System.out.println("Outside loop - AI I: " + ai_i + " AI J: " + ai_j);

        while (true) {
            //loopCounter++;
            //System.out.println("OUTSIDE LOOP COUNTER "+ loopCounter);
            if (loopCounter == 500) {
                System.out.println("INSIDE IF LOOP CROSSED " + loopCounter);
                break;
            }
            System.out.println("OUTSIDE IF ELSE Freespot inside Players.Computer.Players.Computer: " + btnCoord);
            System.out.println("OUTSIDE IF I:" + ai_i + " J:" + ai_j + "Gameboard Current State: " + GameLogic.currentState[btnCoord] + " Board: " + Board);
            if ((Board.equals(emptyString) && GameLogic.currentState[btnCoord] == -1)) {
                System.out.println("INSIDE IF I:" + ai_i + " J:" + ai_j);
                //System.out.println("Inside loop else - AI I: " + ai_i + " AI J: " + ai_j+" Board"+ Board+ "Button Cordinate: "+btnCoord);
                //System.out.println("Freespot inside Players.Computer.Players.Computer: "+btnCoord);
                //System.out.println("Inside loop if - AI I: " + ai_i + " AI J: " + ai_j);
                GameLogic.currentState[btnCoord] = 500;
                calledButton[btnCoord].setText(computerMove);
                calledButton[btnCoord].setEnabled(false);
                calledBoard[ai_i][ai_j] = computerMove;
                loopCounter = 0;
                break;

            } else {

                ai_i = (int) (Math.random() * 3);
                ai_j = (int) (Math.random() * 3);
                System.out.println("INSIDE ELSE I:"+ai_i+" J:"+ai_j);
                Board = new String(calledBoard[ai_i][ai_j]);
                btnCoord = btnRelation[ai_i][ai_j];

                //System.out.println("Inside loop else - AI I: " + ai_i + " AI J: " + ai_j+" Board"+ Board+ "Button Cordinate: "+btnCoord);
            }

        }
        loopCounter = 0;




    }
}
