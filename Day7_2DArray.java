/*
Day 7: 2D Array Operations Reference
-------------------------------------

This file contains Java implementations of various 2D array (matrix) operations, 
each with a clear definition provided as comments above each method.

Each method uses sample data for easy demonstration and understanding.
Copy, run, and modify as needed for assignments or learning purposes!
*/

import java.util.Scanner;

public class Day7_2DArrayReference {

    // Column Sum
    // Definition: Calculates and prints the sum of each column in a matrix.
    public static void columnSum(int[][] arr) {
        for (int j = 0; j < arr[0].length; j++) {
            int sum = 0;
            for (int[] ints : arr) sum += ints[j];
            System.out.println("Sum of Column " + j + ": " + sum);
        }
    }

    // Row Sum
    // Definition: Calculates and prints the sum of each row in a matrix.
    public static void rowSum(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = 0; j < arr[0].length; j++) sum += arr[i][j];
            System.out.println("Sum of Row " + i + ": " + sum);
        }
    }

    // Main Diagonal Sum
    // Definition: Calculates the sum of the main diagonal (top-left to bottom-right).
    public static void mainDiagonalSum(int[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) sum += arr[i][i];
        System.out.println("Main Diagonal Sum: " + sum);
    }

    // Minor Diagonal Sum
    // Definition: Calculates the sum of the minor diagonal (top-right to bottom-left).
    public static void minorDiagonalSum(int[][] arr) {
        int sum = 0, n = arr.length;
        for (int i = 0; i < n; i++) sum += arr[i][n - 1 - i];
        System.out.println("Minor Diagonal Sum: " + sum);
    }

    // Transpose of Matrix
    // Definition: Prints the transpose of the matrix (rows become columns).
    public static void transpose(int[][] arr) {
        System.out.println("Transpose:");
        for (int j = 0; j < arr[0].length; j++) {
            for (int[] ints : arr) System.out.print(ints[j] + " ");
            System.out.println();
        }
    }

    // Row and Column to Zero (centered)
    // Definition: Sets the middle row and column to zero and prints the result.
    public static void rowColZero(int[][] arr) {
        int n = arr.length, mid = n / 2;
        System.out.println("Matrix with Middle Row and Column Zeroed:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print((i == mid || j == mid ? 0 : arr[i][j]) + " ");
            System.out.println();
        }
    }

    // Wave Traversal
    // Definition: Prints elements in a wave pattern column-wise.
    public static void waveTraversal(int[][] arr) {
        System.out.print("Wave Traversal: ");
        for (int j = 0; j < arr[0].length; j++) {
            if (j % 2 == 0) {
                for (int i = 0; i < arr.length; i++) System.out.print(arr[i][j] + " ");
            } else {
                for (int i = arr.length - 1; i >= 0; i--) System.out.print(arr[i][j] + " ");
            }
        }
        System.out.println();
    }

    // Spiral Traversal
    // Definition: Prints elements in spiral order starting from top-left corner.
    public static void spiralTraversal(int[][] arr) {
        int n = arr.length, m = arr[0].length;
        int top = 0, bottom = n - 1, left = 0, right = m - 1;
        System.out.print("Spiral Traversal: ");
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) System.out.print(arr[top][i] + " ");
            top++;
            for (int i = top; i <= bottom; i++) System.out.print(arr[i][right] + " ");
            right--;
            if (top <= bottom) for (int i = right; i >= left; i--) System.out.print(arr[bottom][i] + " ");
            bottom--;
            if (left <= right) for (int i = bottom; i >= top; i--) System.out.print(arr[i][left] + " ");
            left++;
        }
        System.out.println();
    }

    // Upper Bound Elements
    // Definition: Prints all elements on or above the main diagonal.
    public static void printUpperBound(int[][] arr) {
        System.out.print("Upper Bound Elements: ");
        for (int i = 0; i < arr.length; i++)
            for (int j = i; j < arr[0].length; j++)
                System.out.print(arr[i][j] + " ");
        System.out.println();
    }

    // Lower Bound Elements
    // Definition: Prints all elements on or below the main diagonal.
    public static void printLowerBound(int[][] arr) {
        System.out.print("Lower Bound Elements: ");
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j <= i; j++)
                System.out.print(arr[i][j] + " ");
        System.out.println();
    }

    // Matrix Addition
    // Definition: Adds two matrices and prints the result.
    public static void matrixAddition(int[][] a, int[][] b) {
        System.out.println("Matrix Addition:");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++)
                System.out.print((a[i][j] + b[i][j]) + " ");
            System.out.println();
        }
    }

    // Matrix Subtraction
    // Definition: Subtracts the second matrix from the first and prints the result.
    public static void matrixSubtraction(int[][] a, int[][] b) {
        System.out.println("Matrix Subtraction:");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++)
                System.out.print((a[i][j] - b[i][j]) + " ");
            System.out.println();
        }
    }

    // Diagonal Matrix Construction
    // Definition: Constructs a diagonal matrix from a given matrix (all non-diagonal elements set to zero).
    public static void diagonalMatrix(int[][] arr) {
        System.out.println("Diagonal Matrix:");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++)
                System.out.print((i == j ? arr[i][j] : 0) + " ");
            System.out.println();
        }
    }

    // Lower Triangular Matrix Check
    // Definition: Checks if a matrix is lower triangular (all elements above main diagonal are zero).
    public static void isLowerTriangular(int[][] arr) {
        boolean flag = true;
        for (int i = 0; i < arr.length; i++)
            for (int j = i + 1; j < arr[0].length; j++)
                if (arr[i][j] != 0) flag = false;
        System.out.println(flag ? "The given matrix is a lower triangular matrix." : "The given matrix is not a lower triangular matrix.");
    }

    // Upper Triangular Matrix Construction
    // Definition: Constructs an upper triangular matrix from a given matrix (all below diagonal set to zero).
    public static void upperTriangularMatrix(int[][] arr) {
        System.out.println("Upper Triangular Matrix:");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++)
                System.out.print((j >= i ? arr[i][j] : 0) + " ");
            System.out.println();
        }
    }

    // Tridiagonal Matrix Check
    // Definition: Checks if matrix is tridiagonal (non-zero only on main diagonal and adjacent diagonals).
    public static void isTridiagonal(int[][] arr) {
        boolean flag = true;
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[0].length; j++) {
                if (Math.abs(i - j) > 1 && arr[i][j] != 0) flag = false;
                if (Math.abs(i - j) <= 1 && arr[i][j] == 0) flag = false;
            }
        System.out.println(flag ? "The given matrix is a tridiagonal matrix." : "The given matrix is NOT a tridiagonal matrix.");
    }

    // Square Band Matrix Check
    // Definition: Checks if all nonzero elements are within a given bandwidth k around the diagonal.
    public static void isSquareBandMatrix(int[][] arr, int k) {
        boolean flag = true;
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[0].length; j++)
                if ((Math.abs(i - j) < k && arr[i][j] == 0) || (Math.abs(i - j) >= k && arr[i][j] != 0))
                    flag = false;
        System.out.println(flag ? "The given matrix is a square band matrix." : "The given matrix is NOT a square band matrix.");
    }

    // Sample data and demonstration
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        int[][] matrix2 = {
            {9, 8, 7},
            {6, 5, 4},
            {3, 2, 1}
        };
        int[][] lowerTri = {
            {1, 0, 0},
            {4, 5, 0},
            {7, 8, 9}
        };
        int[][] triDiag = {
            {1, 2, 0, 0},
            {3, 4, 5, 0},
            {0, 6, 7, 8},
            {0, 0, 9, 10}
        };
        int[][] bandMat = {
            {1, 2, 0, 0},
            {3, 4, 5, 0},
            {0, 6, 7, 8},
            {0, 0, 9, 10}
        };

        // Demonstrate each operation with sample data
        System.out.println("--- Column Sum ---");
        columnSum(matrix);
        System.out.println("\n--- Row Sum ---");
        rowSum(matrix);
        System.out.println("\n--- Main Diagonal Sum ---");
        mainDiagonalSum(matrix);
        System.out.println("\n--- Minor Diagonal Sum ---");
        minorDiagonalSum(matrix);
        System.out.println("\n--- Transpose ---");
        transpose(matrix);
        System.out.println("\n--- Row and Column to Zero (centered) ---");
        rowColZero(matrix);
        System.out.println("\n--- Wave Traversal ---");
        waveTraversal(matrix);
        System.out.println("\n--- Spiral Traversal ---");
        spiralTraversal(matrix);
        System.out.println("\n--- Upper Bound Elements ---");
        printUpperBound(matrix);
        System.out.println("\n--- Lower Bound Elements ---");
        printLowerBound(matrix);
        System.out.println("\n--- Matrix Addition ---");
        matrixAddition(matrix, matrix2);
        System.out.println("\n--- Matrix Subtraction ---");
        matrixSubtraction(matrix, matrix2);
        System.out.println("\n--- Diagonal Matrix ---");
        diagonalMatrix(matrix);
        System.out.println("\n--- Lower Triangular Matrix Check ---");
        isLowerTriangular(lowerTri);
        System.out.println("\n--- Upper Triangular Matrix ---");
        upperTriangularMatrix(matrix);
        System.out.println("\n--- Tridiagonal Matrix Check ---");
        isTridiagonal(triDiag);
        System.out.println("\n--- Square Band Matrix Check (k=2) ---");
        isSquareBandMatrix(bandMat, 2);

        // For input-based demo, uncomment below:
        /*
        Scanner in = new Scanner(System.in);
        System.out.print("Enter size of matrix: ");
        int n = in.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                arr[i][j] = in.nextInt();
        columnSum(arr);
        // ...call other functions as needed
        */
    }
}