package com.learn.java8.streams;

import com.learn.java8.streams.data.StudentDataBase;
import com.learn.java8.streams.data.Student;
import com.learn.java8.streams.data.Bike;
import org.junit.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelStream {

    @Test
    public void testParallelStream1(){
        long sum1 = IntStream.rangeClosed(1,10000)
                .sum();
        System.out.println("ParallelStream.testParallelStream1:"+sum1);
    }

    @Test
    public void testParallelStream2(){
        //used FOrk/join framework , creates multiple threads,
        //Number of threads created = number of processors in the machine
        System.out.println(Runtime.getRuntime().availableProcessors());
        long sum1 = IntStream.rangeClosed(1,10000)
                .parallel()//split the data into multiple parts concurrently
                .sum();
        System.out.println("ParallelStream.testParallelStream2:"+sum1);
    }

    @Test
    public void testParallelStream3(){
        long startTime = System.currentTimeMillis();
        StudentDataBase.getAllStudents()
                .stream()
                .parallel()
                .map(Student::getActivities)
                .flatMap(list->list.stream())
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        long endTime = System.currentTimeMillis();

        System.out.println("ParallelStream.testParallelStream3:Parallel:"+(endTime-startTime));
    }

    @Test
    public void testParallelStream4(){
        long startTime = System.currentTimeMillis();
        StudentDataBase.getAllStudents()
                .stream()
                .map(Student::getActivities)
                .flatMap(list->list.stream())
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        long endTime = System.currentTimeMillis();

        System.out.println("ParallelStream.testParallelStream3:Sequential:"+(endTime-startTime));
    }

    @Test
    public void testParallelStream5(){
        Sum sum= new Sum();
        //if u have immutable variable do not perform parrallel operation
        //expected 500500
        IntStream.rangeClosed(1,1000)
                .parallel()
                .forEach(sum::performSum);//concurrently access the variable n updating the variable
        System.out.println("Sum:"+sum.getTotal());//461531- diffresult every time

    }
}

class Sum {

    private int total;

    public int getTotal(){
        return total;
    }

    public void setTotal(int total){
        this.total = total;
    }

    public void performSum(int input){
        total+=input;
    }

}
