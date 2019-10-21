import java.util.*;
import java.util.stream.Collectors;


class MinesweeperBoard {

    private List<String> boardWithNumbers;

    MinesweeperBoard(List<String> board) {
        boardWithNumbers = generateBoardWithNumbers(board);
    }

    static List<String> generateBoardWithNumbers(List<String> board) {
        int numRows = board.size();
        if (numRows == 0)
            return new ArrayList<>(0); 
        int numCols = board.get(0).length();
        
        // Copy the board into the matrix
        char[][] matrix = new char[numRows][numCols];
        for (int i = 0; i < numRows; i++) 
            for (int j = 0; j < numCols; j++) 
                matrix[i][j] = board.get(i).charAt(j);

        // For each '*' in board, increment neighbors cells in matrix
        for (int i=0; i<numRows; i++) {
            String boardRow = board.get(i);
            
            // Range of row indexes for current cell neighborhood
            int rowStart = Math.max(i-1, 0);        // inclusive
            int rowEnd = Math.min(i+2, numRows);    // exclusive

            for (int j = 0; j < numCols; j++) {
                char cell = boardRow.charAt(j);
                if (cell != '*') 
                    continue;

                // Range of column indexes for current cell neighborhood
                int colStart = Math.max(j-1, 0);        // inclusive
                int colEnd = Math.min(j+2, numCols);    // exclusive
                
                for (int r=rowStart; r<rowEnd; r++) {
                    for (int c=colStart; c<colEnd; c++) {
                        char neighboor = matrix[r][c];
                        if (neighboor == '*')
                            continue;
                        if (neighboor == ' ')
                            matrix[r][c] = '1';
                        else 
                            matrix[r][c]++;
                    }
                }
            }
        }
        
        // Convert the matrix to List<String>
        return Arrays.stream(matrix)
            .map(String::valueOf)
            .collect(Collectors.toList());
    }

    List<String> withNumbers() {
        return boardWithNumbers;
    }

}
