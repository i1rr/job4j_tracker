package ru.job4j.stream;

import org.junit.Test;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class IntegerMatrixTest {
    @Test
    public void matrixToIntList() {
        Integer[][] integerMatrix = {
                {1, 2, 3},
                {2, 4, 6},
                {3, 6, 9}
        };
        List<Integer> intList = List.of(1, 2, 3, 2, 4, 6, 3, 6, 9);
        assertThat(IntegerMatrix.matToList(integerMatrix), is(intList));
    }
}