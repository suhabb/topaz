package com.learn.java8.streams;


import com.learn.java8.streams.data.StudentDataBase;
import com.learn.java8.streams.data.Student;
import com.learn.java8.streams.data.Bike;
import org.junit.Test;

public class StreamMatch {


    @Test
    public void testMatchAll(){
        boolean allMatch = StudentDataBase.getAllStudents().stream()
                .allMatch(student -> student.getGpa() > 2);
        System.out.println(allMatch);

    }

    @Test
    public void testMatchAny(){
        boolean anyMatch = StudentDataBase.getAllStudents().stream()
                .anyMatch(student -> student.getGpa() > 2);
        System.out.println(anyMatch);

    }

    @Test
    public void testMatchNone(){
        boolean noneMatch = StudentDataBase.getAllStudents().stream()
                .noneMatch(student -> student.getGpa() > 2);
        System.out.println(noneMatch);

    }
}
