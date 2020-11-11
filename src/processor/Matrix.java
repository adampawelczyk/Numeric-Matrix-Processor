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

    public Matrix mulByMatrix(Matrix m) {
        Matrix mul = new Matrix(this.rows, m.columns);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < m.columns; j++) {
                mul.matrix[i][j] = mulMatricesCell(this, m, i, j);
            }
        }
        return mul;
    }

    private double mulMatricesCell(Matrix a, Matrix b, int row, int col) {
        double cell = 0;
        for (int i = 0; i < b.rows; i++) {
            cell += a.matrix[row][i] * b.matrix[i][col];
        }
        return cell;
    }

    public Matrix transpose() {
        Matrix m = new Matrix(this.columns, this.rows);
        for (int i = 0; i < this.columns; i++) {
            for (int j = 0; j < this.rows; j++) {
                m.matrix[j][i] = this.matrix[i][j];
            }
        }
        return m;
    }
}
