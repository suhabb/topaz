package com.learn.java8.streams;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class NumericStream {

    @Test
    public void testIntStream1(){
        List<Integer> intList = Arrays.asList(1,4,8,5,6,10);
        int result = intList.stream()
                .reduce(0,(a,b)->a+b);
        System.out.println("IntStream.testIntStream1:"+result);
        //unboxing to convert Integer to int
    }

    @Test
    public void testIntStream2(){
        long sum = IntStream.rangeClosed(1,6).sum();
        System.out.println("NumericStream.testIntStream2:"+sum);
    }

    @Test
    public void testIntStream3(){
        long sum = IntStream.range(1,50).count();//returns elements from 1 to 49
        long sum2 = IntStream.rangeClosed(1,50).count();//returns element from 1 to 50
        System.out.println("NumericStream.testIntStream2:range:"+sum);
        System.out.println("NumericStream.testIntStream2:rangeClosed:"+sum2);
    }
}
