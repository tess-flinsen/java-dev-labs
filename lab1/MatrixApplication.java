package lab1;

public class MatrixApplication {

    public static void main(String[] args) {
        try {
            byte[][] B = {
                {1, 5, 10},
                {-12, 0, -20},
                {40, 7, 8}, 
            };
            byte a = 2;

            Matrix matrixB = new Matrix(B);
            System.out.println();
            System.out.println("Starting matrix:");
            MatrixUtils.printMatrix(matrixB);
            System.out.println();
            System.out.println("Constant: " + a);

            Matrix matrixC = matrixB.multiplyByConstant(a);
            System.out.println();
            System.out.println("Result of multiplying matrix by constant:");
            MatrixUtils.printMatrix(matrixC);
            System.out.println();

            int sumMinOddRows = MatrixOperations.sumMinElementsInOddRows(matrixC);
            System.out.println("Sum of minimum elements in odd rows: " + sumMinOddRows);

            int sumMaxEvenRows = MatrixOperations.sumMaxElementsInEvenRows(matrixC);
            System.out.println("Sum of maximum elements in even rows: " + sumMaxEvenRows);

        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());

        } catch (ArithmeticException e) {
            System.err.println("Error: " + e.getMessage());

        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        } 
    }
}
