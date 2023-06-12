package com.learn.java8.streams;

import com.learn.java8.streams.data.StudentDataBase;
import com.learn.java8.streams.data.Student;
import com.learn.java8.streams.data.Bike;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamsReduce {

    //reduce is a terminal operation.Used to reduce the contents of a stream to a single value
    //First param: default
    //Second param : BinaryOperator
    @Test
    public void testReduce1() {
        List<Integer> intList = Arrays.asList(1, 3, 5, 7);

        int result = intList.stream()
                .reduce(1, (a, b) -> a * b);
        System.out.println("StreamsReduce.testReduce:" + result);
    }

    @Test
    public void testReduce2() {
        List<Integer> intList = Arrays.asList(1, 3, 5, 7);

        int result = intList.stream()
                .reduce(0, (a, b) -> a * b);// be carefull what is your inital param
        System.out.println("StreamsReduce.testReduce:" + result);
    }

    @Test
    public void testReduce3() {
        List<Integer> intList = Arrays.asList(1, 3, 5, 7);

        Optional<Integer> result = intList.stream()
                .reduce((a, b) -> a * b);// without first param it returns optional
        System.out.println("StreamsReduce.testReduce:" + result.get());
    }

    @Test
    public void testReduce4() {
        Optional<Student> student =
                StudentDataBase.getAllStudents().stream()
                        .reduce(((s1, s2) -> (s1.getGpa() > s2.getGpa()) ? s1 : s2));
        System.out.println("StreamsReduce.testReduce:" + student.get());
    }

    @Test
    public void testReduce5() {
        long sum =
                StudentDataBase.getAllStudents().stream()
                        .map(Student::getNoteBooks)
                        .reduce(0, (a, b) -> a + b);
        System.out.println("StreamsReduce.testReduce:" + sum);
    }

    @Test
    public void testReduce6() {
        long sum =
                StudentDataBase.getAllStudents().stream()
                        .map(Student::getNoteBooks)
                        .reduce(0, Integer::sum);
        System.out.println("StreamsReduce.testReduce:" + sum);
    }

    @Test
    public void testReduce7() {
        long sum =
                StudentDataBase.getAllStudents().stream()
                        .filter(student -> student.getGradeLevel() >= 3)
                        .map(Student::getNoteBooks)
                        .reduce(0, Integer::sum);
        System.out.println("StreamsReduce.testReduce:" + sum);
    }

    @Test
    public void testReduce8() {
        long sum =
                StudentDataBase.getAllStudents().stream()
                        .filter(student -> student.getGradeLevel() >= 3)
                        .filter(student -> student.getGender().equals("female"))
                        .map(Student::getNoteBooks)
                        .reduce(0, Integer::sum);
        System.out.println("StreamsReduce.testReduce:" + sum);
    }

    @Test
    public void testReduce9() {
        List<String> letters = Arrays.asList("a", "b", "c", "d", "e");
        String result = letters
                .stream()
                .reduce("", (partialString, element) -> partialString + element);
        System.out.println("StreamsReduce.testReduce9:" + result);
        Assert.assertEquals("abcde", result);
    }

    @Test
    public void testReduce10() {
        List<String> letters = Arrays.asList("a", "b", "c", "d", "e");
        String result = letters
                .stream()
                .reduce("", String::concat);
        System.out.println("StreamsReduce.testReduce9:" + result);
        Assert.assertEquals("abcde", result);
    }

    @Test
    public void testReduce11() {
        String result = Stream.of("java", "c", "c#", "python")
                .reduce("Languages:", (x, y) -> x + " | " + y);
        System.out.println("StreamsReduce.testReduce:" + result);
        //result:StreamsReduce.testReduce:Languages: | java | c | c# | python
    }

    @Test
    public void testReduce12() {
       // It performs a reduction on the elements of the given stream, using given identity value, \
        // an accumulation function and combining functions. The identity value must be an identity for
        // the combiner function. Combiner is a function which aggregates results of the accumulator.
        // Combiner is called only in a parallel mode to reduce results of accumulators from different threads.
        Integer arrSum = Stream.of(10, 20, 30, 40, 50)
                .parallel()
                .reduce(0, (x, y) -> x + y, (p, q) -> {
                    System.out.println("combiner called");
                    return p + q;
                });
        System.out.println(arrSum);
    }
}
