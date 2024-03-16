import java.util.HashSet;
import java.util.Set;

public class Board {

    @FunctionalInterface
    public interface ThreeParamLambda<T, U, V, R> {
        public R apply(T t, U u, V v);
    }

    ThreeParamLambda<Set<Integer>, Integer, Integer, Boolean> areValid = (Set<Integer> values, Integer nulls, Integer size) -> {
        return values.size() + nulls == size;
    };

    ThreeParamLambda<Set<Integer>, Integer, Integer, Boolean> areComplete = (Set<Integer> values, Integer nulls, Integer size) -> {
        return values.size() == size && nulls == 0;
    };


    private Integer[][] board = new Integer[9][9];
    private int size = 9;

    public Board() {}

    public Board(Integer[][] board) {
        this.board = board;
        size = board.length;
    }

    public Board clone() {
        Board cloned = new Board();
        for (int row = 0; row < size; ++row) {
            for (int col = 0; col < size; ++col) {
                cloned.board[row][col] = board[row][col];
            }
        }
        return cloned;
    }

    public void set(int row, int col, Integer value) {
        board[row][col] = value;
    }

    public Integer get(int row, int col) {
        return board[row][col];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("========================================\n");
        for (int row = 1; row <= size; ++row) {
            sb.append("|| ");
            for (int col = 1; col <= size; ++col) {
                sb.append(get(row-1, col-1));
                if (col % 3 == 0) {
                    sb.append(" || ");
                } else {
                    sb.append(" | ");
                }
            }
            if (row % 3 == 0) {
                sb.append("\n=========================================");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public boolean isValid() {
        return checkRows(areValid) && checkColumns(areValid) && checkGroups(areValid);
    }

    public boolean isComplete() {
        return checkRows(areComplete) && checkColumns(areComplete) && checkGroups(areComplete);
    }

    private boolean checkGroups(ThreeParamLambda<Set<Integer>, Integer, Integer, Boolean> condition) {
        for (int row = 0; row < size; row+=3) {
            for (int col = 0; col < size; col+=3) {
                Set<Integer> values = new HashSet<>();
                int nulls = 0;
                for (int i=0; i < 3; ++i) {
                    for (int j=0; j < 3; ++j) {
                        Integer value = get(row + i, col + j);
                        if (value == null) nulls++;
                        else values.add(value);
                    }
                }
                if (!condition.apply(values, nulls, size)) return false;
            }
        }
        return true;
    }

    private boolean checkColumns(ThreeParamLambda<Set<Integer>, Integer, Integer, Boolean> condition) {
        for (int col = 0; col < size; ++col) {
            Set<Integer> values = new HashSet<>();
            int nulls = 0;
            for (int row = 0; row < size; ++row) {
                Integer value = get(row, col);
                if (value == null) nulls++;
                else values.add(value);
            }
            if (!condition.apply(values, nulls, size)) return false;
        }
        return true;
    }

    private boolean checkRows(ThreeParamLambda<Set<Integer>, Integer, Integer, Boolean> condition) {
        for (int row = 0; row < size; ++row) {
            Set<Integer> values = new HashSet<>();
            int nulls = 0;
            for (int col = 0; col < size; ++col) {
                Integer value = get(row, col);
                if (value == null) nulls++;
                else values.add(value);
            }
            if (!condition.apply(values, nulls, size)) return false;
        }
        return true;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty(int row, int col) {
        return get(row, col) == null;
    }
}
