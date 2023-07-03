package com.learn.java8.streams;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ImmutableCollection {

    private Integer[] intArgs(int n) {
        return IntStream.rangeClosed(1, n)
                .boxed()
                .toArray(Integer[]::new);
    }

    @Test
    public void createImmutableList() {
        IntStream.rangeClosed(1, 10)
                .forEach(n -> {
                    List<Integer> intList = List.of(intArgs(n));
                    assertEquals(n, intList.size());
                    assertEquals(1, intList.get(0).intValue());
                    assertEquals(n, intList.get(intList.size() - 1).intValue());
                });
    }


    @Test
    public void showImmutabilityAdd() throws Exception {

        List<Integer> intList = List.of(1, 2, 3);

        Assertions.assertThrows(UnsupportedOperationException.class,
                () -> intList.add(99), "Should throw Unsupported exception");

    }

    @Test
    public void showImmutabilityClear() throws Exception {
        List<Integer> intList = List.of(1, 2, 3);
        Assertions.assertThrows(UnsupportedOperationException.class,
                () -> intList.clear(), "Should throw Unsupported exception");

    }

    @Test
    public void showImmutabilityRemove() throws Exception {
        List<Integer> intList = List.of(1, 2, 3);
        Assertions.assertThrows(UnsupportedOperationException.class,
                () -> intList.remove(0), "Should throw Unsupported exception");

    }

    @Test
    public void showImmutabilityReplace() throws Exception {
        List<Integer> intList = List.of(1, 2, 3);
        Assertions.assertThrows(UnsupportedOperationException.class,
                () -> intList.remove(0), "Should throw Unsupported exception");
    }
}