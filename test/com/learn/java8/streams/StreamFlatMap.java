package com.learn.java8.streams;


import com.learn.java8.streams.data.StudentDataBase;
import com.learn.java8.streams.data.Student;
import com.learn.java8.streams.data.Bike;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamFlatMap {

    //https://www.geeksforgeeks.org/difference-between-map-and-flatmap-in-java-stream/
    @Test
    public void testFlatMap(){

        List<String> collect = StudentDataBase.getAllStudents().stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .collect(Collectors.toList());
        collect.stream().forEach(System.out::println);

    }

    @Test
    public void flatMap2(){
        List<Integer> list1 = Arrays.asList(1,2,3);
        List<Integer> list2 = Arrays.asList(4,5,6);
        List<Integer> list3 = Arrays.asList(7,8,9);

        List<List<Integer>> listOfLists = Arrays.asList(list1, list2, list3);

        List<Integer> listOfAllIntegers = listOfLists.stream()
                .flatMap(list -> list.stream())
                .collect(Collectors.toList());
        System.out.println(listOfAllIntegers);
    }

    //https://mkyong.com/java8/java-8-flatmap-example/
    @Test
    public void testFlatMap3(){

        Set<String> collect = StudentDataBase.getAllStudents().stream()
               // .map(Student::getActivities)
                .flatMap(list->list.getActivities().stream())
                .collect(Collectors.toSet());
        collect.stream().forEach(System.out::println);

    }

    @Test
    public void testFlatMap4() {

        Set<String> collect = StudentDataBase.getAllStudents().stream()
                // .map(Student::getActivities)
                .flatMap(list -> list.getActivities().stream())
                .filter(s -> s.contains("soccer"))
                .collect(Collectors.toSet());
        collect.stream().forEach(System.out::println);

    }

}
