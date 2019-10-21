import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * Note: the provided tests use a (x, y) coordinate system where:
 * - x is the column index and y is the row index
 * - indexes start at 1
 * 
 * I wrote the code using the usual coordinate system for matrices, i.e. (i, j) where: 
 * - i is the row index and j is the column index
 * - indexes start at 0
 * 
 * The function xyLocationOf translates (i, j) to (x=j+1, y=i+1)
 */
class WordSearcher {

    static private final int[][] DIRECTIONS = { 
        { 0, 1 }, { 0, -1 }, // horizontal
        { 1, 0 }, { -1, 0 }, // vertical
        { 1, 1 }, { -1, -1 }, // diagonal
        { -1, 1 }, { 1, -1 }, // diagonal
    };

    Map<String, Optional<WordLocation>> search(Set<String> words, char[][] grid) {

        Map<String, Optional<WordLocation>> result = new HashMap<>();
        for (String word : words)
            result.put(word, Optional.empty());

        int numRows = grid.length;
        int numCols = grid[0].length;

        Set<String> wordsToFind = new HashSet<>(words);

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                Iterator<String> wordsToFindIter = wordsToFind.iterator();
                while (wordsToFindIter.hasNext()) {
                    String word = wordsToFindIter.next();

                    if (word.charAt(0) != grid[i][j])  // little optimization
                        continue;

                    WordLocation location = checkIfMatchAt(word, grid, i, j);
                    if (location != null) {
                        result.put(word, Optional.of(location));
                        wordsToFindIter.remove();
                    }
                }
                if (wordsToFind.isEmpty())
                    break;
            }
        }
        return result;
    }

    /**
     * Tries to match the provided word at the given start position (start_i, start_j)
     * along all possibile directions and returns the word location if there's a match,
     * otherwise null.
     */
    static WordLocation checkIfMatchAt(String word, char[][] grid, int start_i, int start_j) {
        int numRows = grid.length;
        int numCols = grid[0].length;
        int length = word.length();
        int numSteps = length - 1;

        for (int[] direction : DIRECTIONS) {
            int i = start_i;
            int delta_i = direction[0];
            int end_i = i + delta_i * numSteps;
            if (end_i < 0 || end_i >= numRows)
                continue;

            int j = start_j;
            int delta_j = direction[1];
            int end_j = j + delta_j * numSteps;
            if (end_j < 0 || end_j >= numCols)
                continue;

            boolean isMatch = true;
            for (int k = 0; k < length; k++) {
                if (word.charAt(k) != grid[i][j]) {
                    isMatch = false;
                    break;
                }
                i += delta_i;
                j += delta_j;
            }
            if (isMatch)
                return xyLocationOf(start_i, start_j, end_i, end_j);
        }
        return null;
    }

    /** 
     * 
    */
    static private WordLocation xyLocationOf(int start_i, int start_j, int end_i, int end_j) {
        return new WordLocation(new Pair(start_j + 1, start_i + 1), new Pair(end_j + 1, end_i + 1));
    }

}
