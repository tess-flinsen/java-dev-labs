package lab1;
public class MatrixUtils {

    public static void printMatrix(Matrix matrix) {
        for (byte[] row : matrix.getData()) {
            for (byte element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
