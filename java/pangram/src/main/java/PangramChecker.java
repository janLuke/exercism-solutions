import java.util.HashSet;
import java.util.Set;

public class PangramChecker {
    
    static int ALPHABET_SIZE = 26;
    
    public boolean isPangram(String input) {
        long numDistinctLetters = input.chars()
            .filter(Character::isLetter)
            .map(Character::toLowerCase)
            .distinct()
            .limit(ALPHABET_SIZE)
            .count();
        return numDistinctLetters == ALPHABET_SIZE;
    }

    /**
     * Solution using array of booleans and for loop. 
     * Pretty sure this is the most efficient.
     */
    public boolean isPangramUsingArray(String input) {
        boolean[] inputContains = new boolean[ALPHABET_SIZE];
        int numDistinctLetters = 0;
        int length = input.length();
     
        for (int i=0; i<length; i++) {
            
            char c = input.charAt(i);
            if (!Character.isLetter(c))
                continue;

            int letterIndex = Character.toLowerCase(c) - 'a';
            if (!inputContains[letterIndex]) {
                inputContains[letterIndex] = true;
                numDistinctLetters++;
                if (numDistinctLetters == ALPHABET_SIZE)
                    return true;
            }
        }
        return false;
    }

    /**
     * Iterative solution using Set and for loop.
     */
    public boolean isPangramUsingSet(String input) {
        Set<Character> letters = new HashSet<>();
        int length = input.length();
        for (int i=0; i<length; i++) {
            char c = input.charAt(i);
            if (!Character.isLetter(c))
                continue;
                
            letters.add(c);
            if (letters.size() == ALPHABET_SIZE)
                return true;
        }
        return false;
    }
}
