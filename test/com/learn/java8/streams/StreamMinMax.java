package com.learn.java8.streams;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class StreamMinMax {

    @Test
    public void testMinMax1() {

        List<Integer> integerList = Arrays.asList(6, 72, 8, 5, 45, 87);
        long max = integerList.stream()
                .reduce(0, Integer::max);
        System.out.println("StreamMinMax.testMinMax1:" + max);

    }

    @Test
    public void testMinMax2() {

        List<Integer> integerList = Arrays.asList(6, 72, 8, 5, 45, 87);
        Optional<Integer> min = integerList.stream()
                .reduce((a, b) -> a < b ? a : b);
        System.out.println("StreamMinMax.testMinMax1:" + min.get());

    }

    @Test
    public void testMinMax3() {
        List<Integer> list = Arrays.asList(10, 20, 30, 40, 50);
        int actualSum = list.stream()
                .mapToInt(Integer::intValue)
                .sum();
        assertEquals(150, actualSum);

        Integer reduce = list.stream()
                .reduce(0, (a, b) -> a + b);
        assertEquals(150, reduce.intValue());

        Integer reduce1 = list.stream()
                .reduce(0, Integer::sum);
        assertEquals(150, reduce1.intValue());

        Integer collect = list.stream()
                .collect(Collectors.summingInt(Integer::intValue));
        assertEquals(Integer.valueOf(150), collect);

        Integer collect2 = list.stream()
                .filter(x -> x > 30)
                .collect(Collectors.summingInt(Integer::intValue));
        assertEquals(Integer.valueOf(90), collect2);
    }
}
