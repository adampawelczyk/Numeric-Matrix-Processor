package processor;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        while (true) {
            menu();
            System.out.print("Your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter size of first matrix: ");
                    int matrixARows = scanner.nextInt();
                    int matrixAColumns = scanner.nextInt();
                    Matrix matrixA = new Matrix(matrixARows, matrixAColumns);
                    System.out.println("Enter first matrix:");
                    matrixA.fillMatrix();

                    System.out.print("Enter size of second matrix: ");
                    int matrixBRows = scanner.nextInt();
                    int matrixBColumns = scanner.nextInt();
                    Matrix matrixB = new Matrix(matrixBRows, matrixBColumns);
                    System.out.println("Enter second matrix:");
                    matrixB.fillMatrix();

                    if (matrixA.getRows() == matrixB.getRows() && matrixA.getColumns() == matrixB.getColumns()) {
                        Matrix matrixC = matrixA.add(matrixB);
                        System.out.println("The result is:");
                        matrixC.printMatrix();
                    } else {
                        System.out.println("Matrices sizes are not equal.");
                    }
                }
                case 2 -> {
                    System.out.print("Enter size of matrix: ");
                    int matrixRows = scanner.nextInt();
                    int matrixColumns = scanner.nextInt();
                    Matrix matrix = new Matrix(matrixRows, matrixColumns);
                    System.out.println("Enter matrix:");
                    matrix.fillMatrix();
                    System.out.print("Enter constant: ");
                    double cons = scanner.nextDouble();
                    matrix = matrix.mulByNumber(cons);
                    System.out.println("The result is:");
                    matrix.printMatrix();
                }
                case 3 -> {
                    System.out.print("Enter size of first matrix: ");
                    int matrixARows = scanner.nextInt();
                    int matrixAColumns = scanner.nextInt();
                    Matrix matrixA = new Matrix(matrixARows, matrixAColumns);
                    System.out.println("Enter first matrix:");
                    matrixA.fillMatrix();

                    System.out.print("Enter size of second matrix: ");
                    int matrixBRows = scanner.nextInt();
                    int matrixBColumns = scanner.nextInt();
                    Matrix matrixB = new Matrix(matrixBRows, matrixBColumns);
                    System.out.println("Enter second matrix:");
                    matrixB.fillMatrix();

                    if (matrixA.getColumns() == matrixB.getRows()) {
                        Matrix matrixC = matrixA.mulByMatrix(matrixB);
                        System.out.println("The result is:");
                        matrixC.printMatrix();
                    } else {
                        System.out.println("Number of columns in one matrix should be equal to number of rows in second matrix.");
                    }
                }
                case 4 -> {
                    System.out.print("Enter matrix size: ");
                    int matrixARows = scanner.nextInt();
                    int matrixAColumns = scanner.nextInt();
                    Matrix matrixA = new Matrix(matrixARows, matrixAColumns);
                    matrixA.fillMatrix();

                    Matrix matrixB = matrixA.transpose();
                    System.out.println("The result is:");
                    matrixB.printMatrix();
                }
                case 5 -> {
                    System.out.print("Enter size of matrix: ");
                    int matrixRows = scanner.nextInt();
                    int matrixColumns = scanner.nextInt();
                    Matrix matrix = new Matrix(matrixRows, matrixColumns);
                    System.out.println("Enter matrix:");
                    matrix.fillMatrix();

                    double det = Matrix.calculateDeterminant(matrix);
                    System.out.println("The result is:");
                    System.out.println(det);
                }
                case 0 -> System.exit(0);

                default -> System.out.println("Unknown option!");

            }
            System.out.println();
        }
    }

    public static void menu() {
        System.out.println("1. Add matrices");
        System.out.println("2. Multiply matrix by a constant");
        System.out.println("3. Multiply matrices");
        System.out.println("4. Transpose matrix");
        System.out.println("5. Calculate determinant");
        System.out.println("0. Exit");
    }
}
