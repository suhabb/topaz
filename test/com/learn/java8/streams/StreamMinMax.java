package com.learn.java8.streams;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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
}
