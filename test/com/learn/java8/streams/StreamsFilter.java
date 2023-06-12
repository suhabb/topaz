package com.learn.java8.streams;

import com.learn.java8.streams.data.StudentDataBase;
import com.learn.java8.streams.data.Student;
import com.learn.java8.streams.data.Bike;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

public class StreamsFilter {

    @Test
    public void testFilterStream(){
        List<Student> studentList = StudentDataBase.getAllStudents();

        List<Student> filterList = studentList.stream()
                .filter(s -> s.getGpa() > 2.0)
                .peek(s->{
                    System.out.println("StreamsFilter.testFilterStream:"+s.getGpa());
                })
                .collect(Collectors.toList());
        filterList.forEach(System.out::println);
    }
}
