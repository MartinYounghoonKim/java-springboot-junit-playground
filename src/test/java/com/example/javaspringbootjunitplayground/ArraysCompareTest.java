package com.example.javaspringbootjunitplayground;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class ArraysCompareTest {

    @Test
    void test_array_equal() {
        int[] numbers = {12, 3, 4, 1};
        int[] expected = {1, 3, 4, 12};

        Arrays.sort(numbers);

        assertArrayEquals(expected, numbers);
    }
    // Junit4 에서는 @Test(expected=NullPointerException.class) 와 같은 방법으로 exception 을 테스트하면 되었다.
    // 하지만 JUnit5 에서는 assertThrows 메소드를 통해 exception 테스트를 해야 한다.
    @Test()
    void test_exception() {
        int[] numbers = null;
        assertThrows(NullPointerException.class, () -> {
            Arrays.sort(numbers);
        });
    }

    // JUnit4 에서는 @Test(timeout=1000) 와 같은 방법으로 테스트를 한다.
    // 만약 에러 발생 시에는 "execution exceeded timeout of 12 ms by 1 ms" 와 같은 메세지를 나오는 것을 확인할 수 있다.
    @Test()
    public void test_sort_performance() {
        int numbers[] = {12, 23, 4};
        assertTimeout(Duration.ofMillis(1_000), () -> {
            for (int i = 0; i < 1000_000; i++) {
                numbers[0] = i;
                Arrays.sort(numbers);
            }
        });
    }
}
