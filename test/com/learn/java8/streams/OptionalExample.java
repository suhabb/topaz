package com.learn.java8.streams;


import com.learn.java8.streams.data.StudentDataBase;
import com.learn.java8.streams.data.Student;
import com.learn.java8.streams.data.Bike;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class OptionalExample {

    @org.junit.jupiter.api.Test
    public void testOptional1(){
        Optional<String> hello = Optional.ofNullable("Hello");
        System.out.println("OptionalExample.testOptional1:"+hello.get());
    }

    @Test
    public void testOptional2() {
        Optional<String> hello = Optional.ofNullable(null);
        System.out.println("OptionalExample.testOptional1:" + hello);//return optional.empty
    }


    @Test
    public void testOptional3() {
        Optional<String> hello = Optional.ofNullable(null);
        System.out.println("OptionalExample.testOptional1:" + hello.isPresent());//return true or false
    }

    @Test
    public void testOptional4() {
        Optional<String> hello = Optional.of("Hello");
        System.out.println("OptionalExample.testOptional1:" + hello);//OptionalExample.testOptional1:Optional[Hello]
    }

    @Test
    public void testOptional5() {
        String name = StudentDataBase.getOptionalStudent()
                .filter(s->s.getGpa()>5)//to get empty
                .map(Student::getName)
                .orElse("John Doe");
        System.out.println("OptionalExample.testOptional5:"+name);
    }

    @Test
    public void testOptional6() {
        String name = StudentDataBase.getOptionalStudent()
                .filter(s->s.getGpa()>5)
                .map(Student::getName)
                .orElseGet(()->"John Doe");
        System.out.println("OptionalExample.testOptional5:"+name);
    }
    @Test
    public void testOptional7() {
        String name = StudentDataBase.getOptionalStudent()
                .filter(s->s.getGpa()>5)
                .map(Student::getName)
                .orElseThrow(()->new RuntimeException("Empty Name"));
    }

    @Test
    public void testOptional8() {
        StudentDataBase.getOptionalStudent()
                .filter(s->s.getGpa()>3)
                .ifPresent(student -> System.out.println(student.getName()));
        System.out.println("OptionalExample.testOptional8:");
    }

    @Test
    public void testOptional9() {
        Optional<String> name = StudentDataBase.getOptionalStudent()
                .filter(s->s.getGpa()>3)
                .map(Student::getName);
        System.out.println("OptionalExample.testOptional8:"+name);
    }

    @Test
    public void testOptional10() {
        Optional<String> name = StudentDataBase.getOptionalStudent()
                .filter(s->s.getGpa()>3)
                .flatMap(Student::getBike)// get of type Bike optional //returns Optional<Bike>
                .map(Bike::getName);//get bike name
        System.out.println("OptionalExample.testOptional8:BikeName:"+name.get());
    }






}
