package com.learn.java8.streams;

import com.learn.java8.streams.data.StudentDataBase;
import com.learn.java8.streams.data.Student;
import com.learn.java8.streams.data.Bike;
import org.junit.Test;

import java.util.Comparator;

public class StreamFilterOperations {

    @Test
    public void testDistinct(){

        StudentDataBase.getAllStudents().stream()
                .flatMap(list->list.getActivities().stream())
                .distinct()
                .forEach(System.out::println);
    }

    @Test
    public void testCount(){

         long count = StudentDataBase.getAllStudents().stream()
                .flatMap(list->list.getActivities().stream())
                .distinct()
                .count();
        System.out.println("StreamFilterOperations.testDistinct2:"+count);

    }

    @Test
    public void testSorted(){

        StudentDataBase.getAllStudents().stream()
                .flatMap(list->list.getActivities().stream())
                .distinct()
                .sorted()
                .forEach(System.out::println);
    }

    @Test
    public void testSorted2(){
        System.out.println("Students sorted by GPA");
        StudentDataBase.getAllStudents().stream()
                .distinct()
                .sorted(Comparator.comparing(Student::getGpa))
                .forEach(System.out::println);
    }

    @Test
    public void testSorted3(){
        System.out.println("Students sorted by Name");
        StudentDataBase.getAllStudents().stream()
                .distinct()
                .sorted(Comparator.comparing(Student::getName))
                .forEach(System.out::println);
    }

    @Test
    public void testSorted4(){
        System.out.println("Students sorted by Name Reveresed" );
        StudentDataBase.getAllStudents().stream()
                .distinct()
                .sorted(Comparator.comparing(Student::getName).reversed())
                .forEach(System.out::println);
    }



}
