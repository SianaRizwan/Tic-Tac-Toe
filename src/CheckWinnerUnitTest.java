import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class CheckWinnerUnitTest {

    @Test
    void firstColumnWinnerCheckTest() {
        String[][] Board = {
                {"X", "X", "O"},
                {"X", "O", "O"},
                {"X", "", ""}
        };
        WinLogic winnercheck = new WinLogic(Board);
        Assertions.assertFalse(winnercheck.winner_player("O"));
        Assertions.assertTrue(winnercheck.winner_player("X"));
    }

    @Test
    void secondColumnWinnerCheckTest() {
        String[][] Board = {
                {"X", "O", ""},
                {"X", "O", "X"},
                {"", "O", ""}
        };
        WinLogic winnercheck = new WinLogic(Board);
        Assertions.assertFalse(winnercheck.winner_player("X"));
        Assertions.assertTrue(winnercheck.winner_player("O"));

    }

    @Test
    void thirdColumnWinnerCheckTest() {
        String[][] Board = {
                {"", "X", "X"},
                {"X", "O", "X"},
                {"", "O", "X"}
        };
        WinLogic winnercheck = new WinLogic(Board);
        Assertions.assertFalse(winnercheck.winner_player("O"));
        Assertions.assertTrue(winnercheck.winner_player("X"));

    }

    @Test
    void firstRowWinnerCheckTest() {
        String[][] Board = {
                {"X", "X", "X"},
                {"O", "O", ""},
                {"X", "O", ""}
        };
        WinLogic winnercheck = new WinLogic(Board);
        Assertions.assertFalse(winnercheck.winner_player("O"));
        Assertions.assertTrue(winnercheck.winner_player("X"));
    }

    @Test
    void secondRowWinnerCheckTest() {
        String[][] Board = {
                {"X", "X", ""},
                {"O", "O", "O"},
                {"X", "", "X"}
        };
        WinLogic winnercheck = new WinLogic(Board);
        Assertions.assertFalse(winnercheck.winner_player("X"));
        Assertions.assertTrue(winnercheck.winner_player("O"));
    }

    @Test
    void thirdRowWinnerCheckTest() {
        String[][] Board = {
                {"X", "O", ""},
                {"O", "O", ""},
                {"X", "X", "X"}
        };
        WinLogic winnercheck = new WinLogic(Board);
        Assertions.assertFalse(winnercheck.winner_player("O"));
        Assertions.assertTrue(winnercheck.winner_player("X"));
    }

    @Test
    void diagonalWinnerCheckTest1() {
        String[][] Board = {
                {"O", "", ""},
                {"X", "O", "X"},
                {"X", "X", "O"}
        };
        WinLogic winnercheck = new WinLogic(Board);
        Assertions.assertFalse(winnercheck.winner_player("X"));
        Assertions.assertTrue(winnercheck.winner_player("O"));
    }

    @Test
    void diagonalWinnerCheckTest2() {
        String[][] Board = {
                {"O", "", "X"},
                {"X", "X", "O"},
                {"X", "O", ""}
        };
        WinLogic winnercheck = new WinLogic(Board);
        Assertions.assertFalse(winnercheck.winner_player("O"));
        Assertions.assertTrue(winnercheck.winner_player("X"));
    }


    @Test
    void winnerCheckTest() {
        String[][] Board = {
                {"O", "O", "X"},
                {"X", "X", "O"},
                {"X", "O", "X"}
        };
        WinLogic winnercheck = new WinLogic(Board);
        Assertions.assertFalse(winnercheck.winner_player("O"));
        Assertions.assertTrue(winnercheck.winner_player("X"));

    }

    @Test
    void drawCheckTest() {
        String[][] Board = {
                {"O", "O", "X"},
                {"X", "X", "O"},
                {"O", "X", "O"}
        };
        WinLogic winnercheck = new WinLogic(Board);
        Assertions.assertFalse(winnercheck.winner_player("O"));
        Assertions.assertFalse(winnercheck.winner_player("X"));

    }


}
