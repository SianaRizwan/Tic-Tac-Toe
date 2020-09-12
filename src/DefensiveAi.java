import javax.swing.*;
import java.awt.event.ActionEvent;

public class DefensiveAi implements IAi {

    private int[][] btnRelation = new int[3][3];
    int noSmartMove = 0;
    int[] iSet = {1,0,0,2,2,0,1,1,2};
    int[] jSet = {1,0,2,0,2,1,0,2,1};

//    private int[][] preferredMoves = {
//         {1, 1}, {0, 0}, {0, 2}, {2, 0}, {2, 2},
//         {0, 1}, {1, 0}, {1, 2}, {2, 1}};

    int loopCounter = 0;
    String computerMove = "O";
    String str = "";
    String emptyString = new String(str);
    String str1 = "X";
    String playerValue = new String(str1);
    int ai_i, ai_j;
    public JButton[] calledButton;
    String[][] calledBoard = new String[3][3];


    DefensiveAi(JButton[] button, String[][] board) {

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


        int pointer = 0;
        getNextMove(pointer);

        System.out.println("AI_I: "+ai_i+" AI_J: "+ai_j);
        int btnCoord = btnRelation[ai_i][ai_j];
        String Board = new String(calledBoard[ai_i][ai_j]);

        while (true) {
            getNextMove(pointer);
            if (loopCounter == 500) {
                break;
            }

          if ((Board.equals(emptyString) && GameLogic.currentState[btnCoord] == -1)) {
                System.out.println("INSIDE(DEFENSIVE) IF I:" + ai_i + " J:" + ai_j);

                GameLogic.currentState[btnCoord] = 500;
                calledButton[btnCoord].setText(computerMove);
                calledButton[btnCoord].setEnabled(false);
                calledBoard[ai_i][ai_j] = computerMove;
                loopCounter = 0;
                break;

            } else {

                System.out.println("INSIDE(DEFENSIVE) ELSE I:" + ai_i + " J:" + ai_j);
                if(noSmartMove == 0) {
                    getNextMove(pointer);
                    Board = new String(calledBoard[ai_i][ai_j]);
                    btnCoord = btnRelation[ai_i][ai_j];
                }else
                {
                    ai_i = (int) (Math.random() * 3);
                    ai_j = (int) (Math.random() * 3);
                    System.out.println("INSIDE ELSE of ELSE --------------- I:" + ai_i + " J:" + ai_j);
                    Board = new String(calledBoard[ai_i][ai_j]);
                    btnCoord = btnRelation[ai_i][ai_j];
                }



                //System.out.println("Inside loop else - AI I: " + ai_i + " AI J: " + ai_j+" Board"+ Board+ "Button Cordinate: "+btnCoord);
            }

        }
        loopCounter = 0;

    }

    public void getNextMove(int pointer)
    {
        if(iSet[pointer] != -1 && jSet[pointer] != -1)
        {
            System.out.println("INSIDE IF IF --------------- I:" + ai_i + " J:" + ai_j);

//            Player Halting Logic
//            if(X X O, X O X)
//            {
//
//            }

//            Preferred, ELSE
            ai_i = iSet[pointer];
            ai_j = jSet[pointer];
            iSet[pointer] = -1;
            jSet[pointer] = -1;
//            noSmartMove = 0;
            pointer ++;
        }
        else
        {
            noSmartMove = 1;
        }

    }


}
