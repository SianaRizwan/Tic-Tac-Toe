import javax.swing.*;
import java.awt.event.ActionEvent;

public class Person implements IAi {

    private JButton[] calledButton;
    int[][] btnCoord = new int[1][2];
    String[][] calledBoard = new String[3][3];
    String playerMove = "X";

    Person(JButton[] button, String[][] board) {
        calledButton = button;
        calledBoard = board;
    }

    @Override
    public void makeMove(ActionEvent e) {
        //get the particular button that was clicked
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == calledButton[i]) {
                GameLogic.currentState[i] = 500;
                calledButton[i].setText(playerMove);
                calledButton[i].setEnabled(false);
                btnCoord = getButtonCoordinate(i);
                //System.out.println("Array"+btnCoord[0][0]+ " Array"+ btnCoord[0][1]);
                calledBoard[btnCoord[0][0]][btnCoord[0][1]] = playerMove;
                break;
            }
        }

//        // For Testing
//        System.out.println("Flag " + flag);
//        System.out.println("Value: " + buttonClicked);
//        System.out.println("Button Click " + buttonClicked);


    }

    public int[][] getButtonCoordinate(int i) {
        int[][] coord = new int[1][2]; // x, y
        switch (i) {
            case 0:
                coord[0][0] = 0;
                coord[0][1] = 0;
                break;

            case 1:
                coord[0][0] = 0;
                coord[0][1] = 1;
                break;

            case 2:
                coord[0][0] = 0;
                coord[0][1] = 2;
                break;

            case 3:
                coord[0][0] = 1;
                coord[0][1] = 0;
                break;

            case 4:
                coord[0][0] = 1;
                coord[0][1] = 1;
                break;

            case 5:
                coord[0][0] = 1;
                coord[0][1] = 2;
                break;

            case 6:
                coord[0][0] = 2;
                coord[0][1] = 0;
                break;

            case 7:
                coord[0][0] = 2;
                coord[0][1] = 1;
                break;

            case 8:
                coord[0][0] = 2;
                coord[0][1] = 2;
                break;

            default:
                //System.out.println("Error");
                break;
        }
        return coord;

    }
}
