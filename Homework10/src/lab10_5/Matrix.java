package lab10_5;

import java.util.Random;

public class Matrix {
    private double[][] data;
    private int rows, columns;

    public Matrix(int rows, int columns){
        if(rows != 0 && columns != 0){
            this.rows = rows;
            this.columns = columns;
            this.data = new double[this.rows][this.columns];
        }
    }

    public Matrix(double[][] matrix){
        if(matrix[0].length != 0){
            this.rows = matrix[0].length;
            this.columns = matrix.length;
            this.data = new double[this.rows][this.columns];

            for(int i = 0; i < this.rows; i++){
                for(int j = 0; j < this.columns; j++){
                    data[i][j] = matrix[i][j];
                }
            }
        }
    }

    public Matrix(Matrix matrix){
        if(matrix.rows != 0 && matrix.columns!= 0){
            this.rows = matrix.rows;
            this.columns = matrix.columns;
            this.data = new double[this.rows][this.columns];

            for(int i = 0; i < this.rows; i++){
                for(int j = 0; j < this.columns; j++){
                    data[i][j] = matrix.data[i][j];
                }
            }
        }
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    // fill the matrix with random numbers
    public void fillRandom(double minimum, double maximum){
        Random rand = new Random();
        for(int i = 0; i < this.rows; i++){
            for(int j = 0; j < this.columns; j++){
                data[i][j] = minimum + (maximum - minimum) * rand.nextDouble();
            }
        }
    }

    public void printMatrix(){
        for(int i = 0; i < this.rows; i++){
            for(int j = 0; j < this.columns; j++){
                System.out.format("%-8.2f", data[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static Matrix addMatrix(Matrix matrix1, Matrix matrix2) throws MatrixException {
        if(matrix1.rows != matrix2.rows || matrix1.columns != matrix2.columns){
           throw new MatrixException("Can not add the two matrix due to improper dimensions!\n");
        }

        Matrix sum = new Matrix(matrix1.rows, matrix1.columns);

        for(int i = 0; i < matrix1.rows; i++){
            for(int j = 0; j < matrix1.columns; j++){
                sum.data[i][j] = matrix1.data[i][j] + matrix2.data[i][j];
            }
        }
        return sum;
    }

    public static Matrix multiplyMatrix(Matrix matrix1, Matrix matrix2) throws MatrixException {
        if(matrix1.rows != matrix2.rows || matrix1.columns != matrix2.columns){
            throw new MatrixException("Can not multiply the two matrix due to improper dimensions!\n");
        }

        Matrix product = new Matrix(matrix1.rows, matrix2.columns);
        for(int i = 0; i < product.rows; i++){
            for(int j = 0; j < product.columns; j++){
                for(int k = 0; k < matrix1.columns; k++){
                    product.data[i][j] += matrix1.data[i][k] * matrix2.data[k][j];
                }
            }
        }
        return product;
    }

    public static Matrix transposeMatrix(Matrix matrix){
        Matrix transpose = new Matrix(matrix.columns, matrix.rows);

        for(int i = 0; i < transpose.rows; i++){
            for(int j = 0; j < transpose.columns; j++){
                transpose.data[i][j] = matrix.data[j][i];
            }
        }

        return transpose;
    }
}

