import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class ResolveTest {

    private static Board solvedBoard1 = new Board(new Integer[][] {
            {5, 3, 4, 6, 7, 8, 9, 1, 2},
            {6, 7, 2, 1, 9, 5, 3, 4, 8},
            {1, 9, 8, 3, 4, 2, 5, 6, 7},
            {8, 5, 9, 7, 6, 1, 4, 2, 3},
            {4, 2, 6, 8, 5, 3, 7, 9, 1},
            {7, 1, 3, 9, 2, 4, 8, 5, 6},
            {9, 6, 1, 5, 3, 7, 2, 8, 4},
            {2, 8, 7, 4, 1, 9, 6, 3, 5},
            {3, 4, 5, 2, 8, 6, 1, 7, 9}
    });

    private static Board incompleteBoard1 = new Board(new Integer[][] {
            {5, 3, null, 6, 7, 8, 9, 1, 2},
            {null, 7, 2, 1, 9, 5, 3, 4, 8},
            {1, 9, 8, 3, 4, 2, 5, 6, 7},
            {8, 5, 9, 7, 6, 1, 4, 2, null},
            {4, null, 6, 8, 5, 3, 7, 9, 1},
            {7, 1, 3, 9, 2, 4, 8, 5, 6},
            {9, 6, 1, 5, 3, 7, 2, 8, 4},
            {2, 8, 7, null, 1, 9, 6, 3, 5},
            {3, 4, 5, 2, 8, 6, 1, 7, null}
    });

    @Test
    public void resolve1() {
        SudokuNaiveResolver resolver = new SudokuNaiveResolver(incompleteBoard1);
        Board resolved = resolver.resolve();
        Assertions.assertTrue(resolved.isComplete());
        Assertions.assertEquals(solvedBoard1.toString(), resolved.toString());
    }
}
