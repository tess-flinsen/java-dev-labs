package lab1;
public class MatrixOperations {
    public static int sumMaxElementsInEvenRows(Matrix matrix) {
        int sum = 0;
        byte[][] data = matrix.getData();
        if (data.length < 2) {
            throw new ArithmeticException("No even rows found for calculating the sum of max elements.");
        }
        for (int i = 1; i < data.length; i += 2) { // Even rows: marix[1] - second row, matrix[3] - fourth row, ...
            byte max = data[i][0];
            for (int j = 1; j < data[i].length; j++) {
                if (data[i][j] > max) {
                    max = data[i][j];
                }
            }
            sum += max;
        }
        return sum;
    }

    public static int sumMinElementsInOddRows(Matrix matrix) {
        int sum = 0;
        byte[][] data = matrix.getData();
        for (int i = 0; i < data.length; i += 2) { // Odd rows: marix[0] - first row, matrix[2] - third row, ...
            byte min = data[i][0];
            for (int j = 1; j < data[i].length; j++) {
                if (data[i][j] < min) {
                    min = data[i][j];
                }
            }
            sum += min;
        }
        return sum;
    }
}
