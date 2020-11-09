package processor;
import java.util.Scanner;

public class Matrix {
    private double[][] matrix;
    private int rows;
    private int columns;

    public Matrix(int row, int col) {
        matrix = new double[row][col];
        rows = row;
        columns = col;
    }

    public int getRows() {
        return this.rows;
    }

    public int getColumns() {
        return this.columns;
    }

    public void fillMatrix() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                this.matrix[i][j] = scanner.nextDouble();
            }
        }
    }

    public void printMatrix() {
        for (double[] row : this.matrix) {
            for (double element : row) {
                System.out.print(element + " ");
            }
            System.out.print('\n');
        }
    }

    public Matrix add(Matrix m) {
        Matrix sum = new Matrix(this.rows, this.columns);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                sum.matrix[i][j] = this.matrix[i][j] + m.matrix[i][j];
            }
        }
        return sum;
    }

    public Matrix mulByNumber(double cons) {
        Matrix mul = new Matrix(this.rows, this.columns);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                mul.matrix[i][j] = this.matrix[i][j] * cons;
            }
        }
        return mul;
    }
}
