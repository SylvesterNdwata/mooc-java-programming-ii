
public class MagicSquareFactory {

    public MagicSquare createMagicSquare(int size) {

        MagicSquare square = new MagicSquare(size);

        // implement the creation of a magic square with the Siamese method algorithm here
        
        int row = 0;
        int column = size / 2;
        
        
        for (int num = 1; num <= size * size; num++) {
            square.placeValue(row, column, num);
            
            int nextRow = row - 1;
            int nextCol = column + 1;
            
            if (nextRow < 0)
                nextRow = size - 1;
            
            if (nextCol == size)
                nextCol = 0;
            
            if (square.readValue(nextRow, nextCol) != 0) {
                nextRow = row + 1;
                nextCol = column;
            }
            
            row = nextRow;
            column = nextCol;
        }
        
        return square;
    }

}
