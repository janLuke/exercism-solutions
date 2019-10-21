
class SpiralMatrixBuilder {

    public int[][] buildMatrixOfSize(int n) {
        int[][] matrix = new int[n][n];
        int min = 0;
        int max = n-1;
        int value = 1;
        while (min <= max) {
            for (int j=min; j<=max; j++)    // To right
                matrix[min][j] = value++;
                
            for (int i=min+1; i<max; i++)   // To bottom
                matrix[i][max] = value++;
            
            for (int j=max; j>min; j--)     // To left
                matrix[max][j] = value++;
            
            for (int i=max; i>min; i--)     // To top
                matrix[i][min] = value++;
            
            min++; max--;
        }
        return matrix;
    }
    
}