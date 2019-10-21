class Scrabble {

    private static final int CODE_POINT_OF_A = 65;
    private static final int[] LETTER_SCORES = new int[26];

    private static void setLettersScore(int score, String letters) {
        letters.codePoints()
            .filter(Character::isLetter)
            .forEach(c -> LETTER_SCORES[c - CODE_POINT_OF_A] = score);
    }

    static {
        setLettersScore(1,  "A E I O U L N R S T");
        setLettersScore(2,  "D G");
        setLettersScore(3,  "B C M P");
        setLettersScore(4,  "F H V W Y");
        setLettersScore(5,  "K");
        setLettersScore(8,  "J X");
        setLettersScore(10, "Q Z");
    }

    private int score;

    Scrabble(String word) {
        score = word.toUpperCase()
            .codePoints()
            .map(this::getLetterScore)
            .sum();
    }

    public int getLetterScore(int codePoint) {
        return LETTER_SCORES[codePoint - CODE_POINT_OF_A];
    }

    int getScore() {
        return score;
    }

}
