package com.learn.java8.streams;

import com.learn.java8.streams.data.StudentDataBase;
import com.learn.java8.streams.data.Student;
import com.learn.java8.streams.data.Bike;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class StreamTerminal {

    @Test
    public void testTerminalJoining1(){
        String names = StudentDataBase.getAllStudents().stream()
                .map(Student::getName)
                .collect(Collectors.joining(","));
        System.out.println("StreamTerminal.testTerminalJoining1:"+names);
    }

    @Test
    public void testTerminalJoining2(){
        String names = StudentDataBase.getAllStudents().stream()
                .map(Student::getName)
                .collect(Collectors.joining(",","Names:(",")"));
        System.out.println("StreamTerminal.testTerminalJoining2:"+names);
    }

    @Test
    public void testTerminalCounting(){
        long count = StudentDataBase.getAllStudents().stream()
                .filter(s->s.getGpa()>3.9)
                .collect(Collectors.counting());
        System.out.println("StreamTerminal.testTerminalCounting:"+count);
    }

    @Test
    public void testTerminalMapping1(){
        List<String> names = StudentDataBase.getAllStudents().stream()
                .filter(s->s.getGpa()>3.9)
                .collect(Collectors.mapping(Student::getName,toList()));
        System.out.println("StreamTerminal.testTerminalMapping1:"+names);
    }

    @Test
    public void testTerminalMaxBy1(){
        //returns biggest on the property based in comparator
        Optional<Student> student = StudentDataBase.getAllStudents().stream()
                .collect(Collectors.maxBy(Comparator.comparing(s->s.getGpa())));
        System.out.println("StreamTerminal.testTerminalMaxBy1:"+student.get());

        Optional<Student> student2 = StudentDataBase.getAllStudents()
                .stream()
                .reduce((s1,s2)-> (s1.getGpa() > s2.getGpa()) ? s1 :s2);
        System.out.println("StreamTerminal.testTerminalMaxBy1:"+student2.get());
    }

    @Test
    public void testTerminalMinBy1(){
        //returns biggest on the property based in comparator
        Optional<Student> student = StudentDataBase.getAllStudents().stream()
                .collect(Collectors.minBy(Comparator.comparing(s->s.getGpa())));
        System.out.println("StreamTerminal.testTerminalMinBy1:"+student.get());

        Optional<Student> student2 = StudentDataBase.getAllStudents()
                .stream()
                .reduce((s1,s2)-> (s1.getGpa() < s2.getGpa()) ? s1 :s2);
        System.out.println("StreamTerminal.testTerminalMinBy1:"+student2.get());

    }


}
