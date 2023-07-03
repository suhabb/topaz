package com.learn.java8.streams;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

public class StreamMinMax {

    @Test
    public void testMinMax1() {

        List<Integer> integerList = Arrays.asList(6, 72, 8, 5, 45, 87);
        long max = integerList.stream()
                .reduce(0, Integer::max);
        System.out.println("StreamMinMax.testMinMax1:" + max);

    }

    @Test
    public void testMinMax2() {

        List<Integer> integerList = Arrays.asList(6, 72, 8, 5, 45, 87);
        Optional<Integer> min = integerList.stream()
                .reduce((a, b) -> a < b ? a : b);
        System.out.println("StreamMinMax.testMinMax1:" + min.get());

    }

    @Test
    public void testMinMax3() {
        List<Integer> list = Arrays.asList(10, 20, 30, 40, 50);
        int actualSum = list.stream()
                .mapToInt(Integer::intValue)
                .sum();
        assertEquals(150, actualSum);

        Integer reduce = list.stream()
                .reduce(0, (a, b) -> a + b);
        assertEquals(150, reduce.intValue());

        Integer reduce1 = list.stream()
                .reduce(0, Integer::sum);
        assertEquals(150, reduce1.intValue());

        Integer collect = list.stream()
                .collect(Collectors.summingInt(Integer::intValue));
        assertEquals(Integer.valueOf(150), collect);

        Integer collect2 = list.stream()
                .filter(x -> x > 30)
                .collect(Collectors.summingInt(Integer::intValue));
        assertEquals(Integer.valueOf(90), collect2);
    }


    @Test
    public void testEMployee() {
        List<Employee> employees = Arrays.asList(
                new Employee("Cersei", 250_000, "Lannister"),
                new Employee("Jamie", 150_000, "Lannister"),
                new Employee("Tyrion", 1_000, "Lannister"),
                new Employee("Tywin", 1_000_000, "Lannister"),
                new Employee("Jon Snow", 75_000, "Stark"),
                new Employee("Robb", 120_000, "Stark"),
                new Employee("Eddard", 125_000, "Stark"),
                new Employee("Sansa", 0, "Stark"),
                new Employee("Arya", 1_000, "Stark"));
        Employee defaultEmployee =
                new Employee("A man (or woman) has no name", 0, "Black and White");

         int max = employees.stream()
                .max(Comparator.comparing(Employee::getSalary)).get().getSalary();

         employees.stream()
                         .collect(Collectors.maxBy(Comparator.comparingInt(Employee::getSalary)));
         employees.stream()
                         .mapToInt(Employee::getSalary)
                                 .max();

         //create unmodifiable list or immutable list
         employees.stream()
                         .collect(Collectors.collectingAndThen(toList(),
                                 Collections::unmodifiableList));
         assertEquals(1_000_000,max);


         //non-null
         employees.stream()
                 .filter(Objects::isNull)
                 .collect(Collectors.toList());

    }
}

class Employee {
    private String name;
    private Integer salary;
    private String department;

    public Employee(String name, Integer salary, String department) {
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public Integer getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }
    // ... other methods ...
}
