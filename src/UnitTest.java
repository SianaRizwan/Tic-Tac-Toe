import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UnitTest {

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
}
