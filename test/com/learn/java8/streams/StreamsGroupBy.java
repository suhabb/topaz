package com.learn.java8.streams;

import com.learn.java8.streams.data.StudentDataBase;
import com.learn.java8.streams.data.Student;
import com.learn.java8.streams.data.Bike;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toSet;

public class StreamsGroupBy {

    @Test
    public void streamGroupBy1() {
        //Output of group is always gonna be a Map
        Map<String, List<Student>> map = StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(Student::getGender));
        System.out.println("StreamsGroupBy.streamGroupBy1:" + map);
    }

    @Test
    public void streamGroupBy2() {
        //Output of group is always gonna be a Map
        Map<String, List<Student>> map = StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(student -> student.getGpa() > 3.8 ? "OUSTANDING" : "AVERAGE"));
        System.out.println("StreamsGroupBy.streamGroupBy2:custom-key:" + map);
    }

    @Test
    public void streamGroupBy3(){
        //Output of group is always gonna be a Map
        Map<Integer, Map<String,List<Student>>> map = StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(Student::getGradeLevel,
                        Collectors.groupingBy(student->student.getGpa()>3.8?"OUTSTANDING":"AVERAGE")));
        System.out.println("StreamsGroupBy.streamGroupBy3:"+map);
    }

    @Test
    public void streamGroupBy4(){
        //Output of group is always gonna be a Map
        Map<String,Integer> map = StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(Student::getName,Collectors.summingInt(Student::getNoteBooks)));
        System.out.println("StreamsGroupBy.streamGroupBy4:"+map);
    }

    @Test
    public void streamGroupBy5(){
        //Output of group is always gonna be a Map
        LinkedHashMap<String, Set<Student>> map = StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(Student::getGender,
                        LinkedHashMap::new, Collectors.toSet()));
        System.out.println("StreamsGroupBy.streamGroupBy5:"+map);
    }

    @Test
    public void streamGroupBy6(){
        //Output of group is always gonna be a Map
        Map<Integer, Optional<Student>> map = StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(Student::getGradeLevel,
                        Collectors.maxBy(Comparator.comparing(Student::getGpa))));
        System.out.println("StreamsGroupBy.streamGroupBy6" +
                ":"+map);
    }

    @Test
    public void streamGroupBy7(){
        //Output of group is always gonna be a Map
        Map<Integer, Student> map = StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(Student::getGradeLevel,
                        collectingAndThen(Collectors.maxBy(Comparator.comparing(Student::getGpa)),Optional::get)));
        System.out.println("StreamsGroupBy.streamGroupBy7" +
                ":"+map);
    }

    @Test
    public void testPartitioningBy8(){

        Map<Boolean, List<Student>> map = StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.partitioningBy(s->s.getGpa() > 3.5));
        System.out.println("StreamsGroupBy.streamGroupBy8" +
                ":"+map);
    }

    @Test
    public void testPartitioningBy9(){

        Map<Boolean, Set<Student>> map = StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.partitioningBy(s->s.getGpa() > 3.5,toSet()));
        System.out.println("StreamsGroupBy.streamGroupBy9" +
                ":"+map);
    }
    @org.junit.jupiter.api.Test
    public void givenString_concat_returnString() {
        List<Book> books = Arrays.asList(
                new Book(1, "Modern Java Recipes", 49.99),
                new Book(2, "Java 8 in Action", 49.99),
                new Book(3, "Java SE8 for the Really Impatient", 39.99),
                new Book(4, "Functional Programming in Java", 27.64),
                new Book(5, "Making Java Groovy", 45.99),
                new Book(6, "Gradle Recipes for Android", 23.76));
        Map<Integer, Book> collect = books.stream()
                .collect(Collectors.toMap(Book::getId, Function.identity()));
        collect.forEach((key,book)->{
            System.out.println("AppTest.givenString_concat_returnString:"+key+":"+book.getName());
        });

        List<String> strings = Arrays.asList("this", "is", "a", "long", "list", "of",
                "strings", "to", "use", "as", "a", "demo");
        Map<Integer, List<String>> lengthMap = strings.stream()
                .collect(Collectors.groupingBy(String::length));
        lengthMap.forEach((key,value)->{
            System.out.println("AppTest.givenString_concat_returnString:"+key+":"+value);
        });
    }

}

