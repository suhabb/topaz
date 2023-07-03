package com.learn.java8.streams;

import com.learn.java8.streams.data.Student;
import com.learn.java8.streams.data.StudentDataBase;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
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


class Book {
    private int id;
    private String name;
    private double price;

    public Book(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    // ... other methods ...
}