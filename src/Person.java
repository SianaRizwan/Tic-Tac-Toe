import javax.swing.*;
import java.awt.event.ActionEvent;

public class Person implements IAi {

    private JButton[] calledButton;
    public BtnCoordinate btnCoordinate = new BtnCoordinate();
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
                btnCoord = btnCoordinate.getButtonCoordinate(i);
                //System.out.println("Array"+btnCoord[0][0]+ " Array"+ btnCoord[0][1]);
                calledBoard[btnCoord[0][0]][btnCoord[0][1]] = playerMove;
//                delayMove();
                break;
            }
        }

//        // For Testing
//        System.out.println("Flag " + flag);
//        System.out.println("Value: " + buttonClicked);
//        System.out.println("Button Click " + buttonClicked);


    }
//    public void delayMove() {
//        System.out.println(".-----..-..-..-..-..-..-..-..-..-..-. .--.          \n" +
//                "`-. .-': :; :: :: `: :: :' ;: :: `: :: .--'         \n" +
//                "  : :  :    :: :: .` ::   ' : :: .` :: : _          \n" +
//                "  : :  : :: :: :: :. :: :.`.: :: :. :: :; : _  _  _ \n" +
//                "  :_;  :_;:_;:_;:_;:_;:_;:_;:_;:_;:_;`.__.':_;:_;:_;");
//        try {
//            Thread.sleep(1500);
//        } catch (InterruptedException ex) {
//            Thread.currentThread().interrupt();
//
//        }
//    }


}
