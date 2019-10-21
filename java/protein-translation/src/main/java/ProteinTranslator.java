import java.util.*;


class ProteinTranslator {

    private static final Map<String, String> codonToProtein = new HashMap<>();
    
    private static void setProteinCodons(String protein, String ... codons) {
        for (String codon: codons)
            codonToProtein.put(codon, protein);
    }
    
    static {
        setProteinCodons("Methionine", "AUG");
        setProteinCodons("Phenylalanine", "UUU", "UUC");
        setProteinCodons("Leucine", "UUA", "UUG");
        setProteinCodons("Serine", "UCU", "UCC", "UCA", "UCG");
        setProteinCodons("Tyrosine", "UAU", "UAC");
        setProteinCodons("Cysteine", "UGU", "UGC");
        setProteinCodons("Tryptophan", "UGG");
        setProteinCodons("STOP", "UAA", "UAG", "UGA");
    }

    List<String> translate(String rnaSequence) {
        int length = rnaSequence.length();
        List<String> translation = new ArrayList<>(length / 3 + 1);
        for (int i=0; i<length; i+=3) {
            String codon = rnaSequence.substring(i, i+3);
            String protein = codonToProtein.get(codon);
            if (protein.equals("STOP"))
                break;
            translation.add(protein);
        }
        return translation;
    }
}