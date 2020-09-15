import javax.swing.*;
import java.awt.event.ActionEvent;

public class DefensiveAi implements IAi {

    int[][] btnCoordfromNumber = new int[1][2];
    private int[][] btnRelation = new int[3][3];

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

            if ((Board.equals(emptyString) && GameLogic.currentState[btnCoord] == -1)) {
//                System.out.println("Inside if of While loop: \n Button Coordination: "+btnCoord+"\n CalledButton[btnCoord]: "+calledBoard[ai_i][ai_j]);

                isPersonWinning();
                btnCoord = btnRelation[ai_i][ai_j];
                GameLogic.currentState[btnCoord] = 500;
                calledButton[btnCoord].setText(computerMove);
                calledButton[btnCoord].setEnabled(false);
                calledBoard[ai_i][ai_j] = computerMove;
                break;
            } else {

//                System.out.println("Inside ELSE of While loop: \n Button Coordination: "+btnCoord+"\n CalledButton[btnCoord]: "+calledBoard[ai_j][ai_j]);
                isPersonWinning();
                Board = computerMove;
                btnCoord = btnRelation[ai_i][ai_j];
                calledButton[btnCoord].setText(computerMove);
                calledButton[btnCoord].setEnabled(false);
                calledBoard[ai_i][ai_j] = computerMove;
                GameLogic.currentState[btnCoord] = 500;
                break;

            }
        }
    }

    public void isPersonWinning() {
        ai_i = (int) (Math.random() * 3);
        ai_j = (int) (Math.random() * 3);
        System.out.println("Random AI_I and AI_J: "+ai_i+" "+ai_j);
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
//                System.out.println("Calledboard Value before if: " + calledBoard[row][column]);
                if (calledBoard[row][column].equals("")) {
                    calledBoard[row][column] = "X";
                    if (winner_player("X")) {
                        System.out.println("Inside if");
                        ai_i = row;
                        ai_j = column;
                        System.out.println("STOPWINNING AI_I and AI_J: "+ai_i+" "+ai_j);
                    }
                    calledBoard[row][column] = "";
                }
                if(calledBoard[ai_i][ai_j].equals("X"))
                {
                    System.out.println("Calledboard if X: "+calledBoard[row][column]);
                    ai_i = (int) (Math.random() * 3);
                    ai_j = (int) (Math.random() * 3);
                    System.out.println("NEWRandom AI_I and AI_J: "+ai_i+" "+ai_j);
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





