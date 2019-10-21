class Hamming {

    private int distance;

    Hamming(String leftStrand, String rightStrand) {
        int leftLength = leftStrand.length();
        int rightLength = rightStrand.length();
        if (leftLength == 0 && rightLength > 0) 
            throw new IllegalArgumentException("left strand must not be empty.");
        if (leftLength > 0 && rightLength == 0) 
            throw new IllegalArgumentException("right strand must not be empty.");
        if (leftLength != rightLength) 
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        
        for (int i=0; i<leftLength; i++) {
            if (leftStrand.charAt(i) != rightStrand.charAt(i))
                distance++;
        }
    }

    int getHammingDistance() {
        return distance;
    }

}
