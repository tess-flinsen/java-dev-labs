package lab1;
public class Matrix {
    private byte[][] data;

    public Matrix(byte[][] data) {
        if (data == null || data.length == 0 || data[0].length == 0) {
            throw new IllegalArgumentException("Matrix cannot be empty.");
        }
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] < Byte.MIN_VALUE || data[i][j] > Byte.MAX_VALUE) {
                    throw new ArithmeticException("Overflow: matrix element out of byte range at position (" + i + ", " + j + ")");
                }
            }
        }
        this.data = data;
    }

    public byte[][] getData() {
        return data;
    }

    public Matrix multiplyByConstant(byte constant) {
        byte[][] result = new byte[data.length][data[0].length];
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                int product = (constant * data[i][j]);
                if (product < Byte.MIN_VALUE || product > Byte.MAX_VALUE) {
                    throw new ArithmeticException("Overflow: result out of byte range at position (" + i + ", " + j + ")");
                }
                result[i][j] = (byte) product;
            }
        }
        return new Matrix(result);
    }
}