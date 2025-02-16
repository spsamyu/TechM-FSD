package tasks;

public class MatrixMultiply {
    static int[][] multiply(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];
        Thread[] threads = new Thread[n];
        for (int i = 0; i < n; i++) {
            int row = i;
            threads[i] = new Thread(() -> {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        C[row][j] += A[row][k] * B[k][j];
                    }
                }
            });
            threads[i].start();
        }
        return C;
    }
}
