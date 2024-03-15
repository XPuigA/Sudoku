import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoardTest {

    private static Integer[][] validBoard = new Integer[][] {
            {5, 3, 4, 6, 7, 8, 9, 1, 2},
            {6, 7, 2, 1, 9, 5, 3, 4, 8},
            {1, 9, 8, 3, 4, 2, 5, 6, 7},
            {8, 5, 9, 7, 6, 1, 4, 2, 3},
            {4, 2, 6, 8, 5, 3, 7, 9, 1},
            {7, 1, 3, 9, 2, 4, 8, 5, 6},
            {9, 6, 1, 5, 3, 7, 2, 8, 4},
            {2, 8, 7, 4, 1, 9, 6, 3, 5},
            {3, 4, 5, 2, 8, 6, 1, 7, 9}
    };

    private static Integer[][] invalidBoard = new Integer[][] {
            {3, 3, 4, 6, 7, 8, 9, 1, 2},
            {6, 7, 2, 1, 9, 5, 3, 4, 8},
            {1, 9, 8, 3, 4, 2, 5, 6, 7},
            {8, 5, 9, 7, 6, 1, 4, 2, 3},
            {4, 2, 6, 8, 5, 3, 7, 9, 1},
            {7, 1, 3, 9, 2, 4, 8, 5, 6},
            {9, 6, 1, 5, 3, 7, 2, 8, 4},
            {2, 8, 7, 4, 1, 9, 6, 3, 5},
            {3, 4, 5, 2, 8, 6, 1, 7, 9}
    };

    private static Integer[][] validIncompleteBoard = new Integer[][] {
            {5, 3, 4, 6, 7, 8, 9, 1, 2},
            {null, 7, 2, 1, 9, 5, 3, 4, 8},
            {1, 9, 8, 3, 4, 2, 5, 6, 7},
            {8, 5, 9, 7, 6, 1, 4, 2, 3},
            {4, 2, 6, 8, 5, 3, 7, 9, 1},
            {7, 1, 3, 9, 2, 4, 8, 5, 6},
            {9, 6, 1, 5, 3, 7, 2, 8, 4},
            {2, 8, 7, 4, 1, 9, 6, 3, 5},
            {3, 4, 5, 2, 8, 6, 1, 7, null}
    };

    private static Integer[][] smallBoard = new Integer[][] {
            {2, 3, 1},
            {4, 6, 8},
            {5, 9, 7}
    };

    @Test
    void validAndCompleteBoard() {
        Board board = new Board(validBoard);
        Assertions.assertTrue(board.isValid());
        Assertions.assertTrue(board.isComplete());
    }

    @Test
    void invalidBoard() {
        Board board = new Board(invalidBoard);
        Assertions.assertFalse(board.isValid());
        Assertions.assertFalse(board.isComplete());
    }

    @Test
    void validIncompleteBoard() {
        Board board = new Board(validIncompleteBoard);
        Assertions.assertTrue(board.isValid());
        Assertions.assertFalse(board.isComplete());
    }

    @Test
    void cloneBoard() {
        Board original = new Board(smallBoard);
        Board cloned = original.clone();
        Assertions.assertEquals(2, cloned.get(0, 0));
        Assertions.assertEquals(3, cloned.get(0, 1));
        Assertions.assertEquals(1, cloned.get(0, 2));

        Assertions.assertEquals(4, cloned.get(1, 0));
        Assertions.assertEquals(6, cloned.get(1, 1));
        Assertions.assertEquals(8, cloned.get(1, 2));

        Assertions.assertEquals(5, cloned.get(2, 0));
        Assertions.assertEquals(9, cloned.get(2, 1));
        Assertions.assertEquals(7, cloned.get(2, 2));
    }
}
