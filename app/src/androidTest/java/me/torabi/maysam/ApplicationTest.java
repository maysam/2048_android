package me.torabi.maysam;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.test.FlakyTest;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    @FlakyTest
    public void testing_matrix_rotate_left() {
        int[][] before = {{1,2},{3,4}};
        int[][] after = {{2,4},{1,3}};
        int[][] result = MatrixOperations.rotateLeft(before);
        assertEquals(MatrixOperations.stringify(result), MatrixOperations.stringify(after));
    }

    @FlakyTest
    public void testing_matrix_rotate_right() {
        int[][] after = {{1,2},{3,4}};
        int[][] before = {{2,4},{1,3}};
        int[][] result = MatrixOperations.rotateRight(before);
        assertEquals(MatrixOperations.stringify(result), MatrixOperations.stringify(after));
    }

    @FlakyTest
    public void testing_matrix_rotate_all() {
        int[][] before = {{1,2},{3,4}};
        int[][] result = MatrixOperations.rotateRight(MatrixOperations.rotateRight(MatrixOperations.rotateRight(MatrixOperations.rotateRight(before))));
        assertEquals(MatrixOperations.stringify(result), MatrixOperations.stringify(before));
        result = MatrixOperations.rotateLeft(MatrixOperations.rotateLeft(MatrixOperations.rotateLeft(MatrixOperations.rotateLeft(before))));
        assertEquals(MatrixOperations.stringify(result), MatrixOperations.stringify(before));
    }


    @FlakyTest
    public void testing_process_1() {
        int[][] before = {{1,1},{2,2}};
        int[][] after = {{2,0},{4,0}};
        int[][] result;
        result = MatrixOperations.process(before);
        assertEquals(MatrixOperations.stringify(result), MatrixOperations.stringify(after));
    }
}