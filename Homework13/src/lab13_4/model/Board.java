package lab13_4.model;

public class Board {
    private final int size;
    private final int[][] table;

    public Board(int size)
    {
        this.size = size;
        table = new int[size][size];

        for (int i = 0; i < size; ++i){
            for (int j = 0; j < size; ++j)
            {
                table[i][j] = -1;
            }
        }
    }

    public void setMove(int i, int j, int value)
    {
        if(i < size && j < size && i >= 0 && j >=0)
        {
            table[i][j] = value;
        }
    }

    public boolean checkState(){
        boolean winnerDiagonal = checkDiagonal();
        boolean winnerVH = checkVerticalHorizontal();

        return winnerDiagonal || winnerVH;
    }
    
    private boolean checkDiagonal(){
        boolean diagonalX = true, diagonalY = true;

        for(int i = 0; i < size - 1; i++){
            if(table[i][i] != table[i + 1][i + 1] || table[i][i] == -1){
               diagonalX = false;
            }
            if(table[i][size - 1 - i] != table[i + 1][size - 2 - i] || table[i][size - 1 - i] == -1){
                diagonalY = false;
            }
        }
        
        return diagonalX || diagonalY;
    }


    private boolean checkVerticalHorizontal(){
        boolean vertical, horizontal;

        for(int i = 1; i < size; i++){
            vertical = true; horizontal = true;

            for(int j = 1; j < size; j++){
                if(table[i - 1][j - 1] != table[i - 1][j] || table[i - 1][j - 1] == -1){
                    vertical = false;
                }
                if(table[j - 1][i - 1] != table[j][i - 1] || table[j - 1][i - 1] == -1){
                    horizontal = false;
                }
            }

            if(vertical || horizontal){
                return true;
            }
        }

        vertical = true; horizontal = true;
        for(int i = 0; i < size - 1; i++){
            if(table[size - 1][i] != table[size - 1][i + 1] || table[size - 1][i] == -1){
                vertical = false;
            }
            if(table[i][size - 1] != table[i + 1][size - 1] || table[i][size - 1] == -1 || table[i + 1][size - 1] == -1){
                horizontal = false;
            }

        }

        return vertical || horizontal;
    }


    public int getSize() {
        return size;
    }

    public int getBoardCell(int i, int j)
    {
        return this.table[i][j];
    }

    public void printTable(){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
    }
}
