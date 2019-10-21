
class RnaTranscription {

    String transcribe(String dnaStrand) {

        StringBuilder rnaBuilder = new StringBuilder();
        int length = dnaStrand.length();

        for (int i=0; i<length; i++) {
            char nucleotide = dnaStrand.charAt(i);
            char complement = getNucleotideComplement(nucleotide);
            rnaBuilder.append(complement);
        }

        return rnaBuilder.toString();
    }
    
    private static char getNucleotideComplement(char nucleotide) {
        switch (nucleotide) {
            case 'G': return 'C';
            case 'C': return 'G';
            case 'T': return 'A';
            case 'A': return 'U';
            default:
                throw new IllegalArgumentException("Invalid nucleotide: " + nucleotide);
        }
    }

}
