
class LuhnValidator {

    private static final int[] MAPPED_DIGIT = {0, 2, 4, 6, 8, 1, 3, 5, 7, 9};

    boolean isValid(String candidate) {
        int sum = 0;
        int length = candidate.length();
        int digitIndexFromRight = 0;
        
        for (int i=length-1; i>=0; i--) 
        {
            char ch = candidate.charAt(i);
            if (ch == ' ')
                continue;
            else if (!Character.isDigit(ch))
                return false;
            
            int digitValue = ch - '0';
            sum += (digitIndexFromRight % 2 == 1) 
                ? MAPPED_DIGIT[digitValue] 
                : digitValue; 
            digitIndexFromRight++;
        }
        if (digitIndexFromRight <= 1)
            return false;
        return sum % 10 == 0;
    }
}
