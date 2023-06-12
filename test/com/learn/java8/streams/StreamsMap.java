package com.learn.java8.streams;

import com.learn.java8.streams.data.Student;
import com.learn.java8.streams.data.StudentDataBase;
import org.junit.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamsMap {

    @Test
    public void testMap(){
        List<Student> studentList = StudentDataBase.getAllStudents();
        List<String> nameList = studentList.stream()
                .map(Student::getName)
                .collect(Collectors.toList());
        nameList.stream().forEach(System.out::println);
    }

    @Test
    public void testMap2(){
        List<Student> studentList = StudentDataBase.getAllStudents();
        Set<String> nameList = studentList.stream()
                .map(Student::getName)
                .map(String::toUpperCase)
                .collect(Collectors.toSet());
        nameList.stream().forEach(System.out::println);
    }


}
