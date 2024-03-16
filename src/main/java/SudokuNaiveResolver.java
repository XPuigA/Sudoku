public class SudokuNaiveResolver {

    private Board board;

    public SudokuNaiveResolver(Board board) {
        this.board = board;
    }

    public Board resolve() {
        solveSudoku(0,0);
        return board;
    }

    private boolean solveSudoku(int row, int col) {
        int size = board.getSize();
        if (row == size-1 && col == size)
            return true;

        // Check if column value becomes 9, we move to next row and column start from 0
        if (col == size) {
            row++;
            col = 0;
        }

        // Check if the current position the grid already contains value
        // we iterate for next column
        if (!board.isEmpty(row, col)) {
            return solveSudoku(row, col + 1);
        }

        for (int num = 1; num < 10; num++) {

            // Check if it is safe to place the num (1-9) in the given row ,col
            // then we move to next column
            board.set(row, col, num);
            if (board.isValid()) {
                // Checking for next
                // possibility with next column
                if (solveSudoku(row, col + 1))
                    return true;
            }
            // remove the assigned num, since our assumption was wrong
            board.set(row, col, null);
        }
        return false;
    }
}
