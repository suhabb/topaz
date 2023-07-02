package junit5;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private Calculator calculator;


    @BeforeAll
    static void setUp() {
        //connect to database
        //class annotation
        //runs before any test is executed
        System.out.println("CalculatorTest.BeforeAll");
    }

    @BeforeEach
    public void beforeEach() {
        //method executed before  in each method in test class
        //shared obejct creation
        System.out.println("CalculatorTest.beforeEach");
        calculator = new Calculator();
    }

    @DisplayName("4/2 test method")
    @Test
    public void test() {

        assertEquals(2, 2);
        System.out.println("CalculatorTest.test");

    }

    @DisplayName("4/2 test method")
    @Test
    public void test2() {

        assertEquals(2, 2, () -> "test message");
        System.out.println("CalculatorTest.test2");

    }

    @DisplayName("4/2 test method")
    @Test
    @Disabled("Todo unit test")
    public void testDisabled() {
        assertEquals(2, 2, () -> "test failed");
    }

    @DisplayName("Assert exception")
    @Test
    public void throwException() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(5, 0));
    }


    @ParameterizedTest
    @MethodSource("addTestParams")//method name below
    public void testAddParams(int a, int b, int expectedResult) {
        int actualResult = calculator.add(a, b);
        assertEquals(expectedResult, actualResult);

    }

    private static Stream<Arguments> addTestParams() {
        return Stream.of(
                Arguments.of(2, 3, 5),
                Arguments.of(4, 4, 8),
                Arguments.of(2, 4, 6)
        );
    }

    @ParameterizedTest
    @CsvSource({
            "2,2,4",
            "4,6,10",
            "3,6,9"
    })//
    public void testAddParamsCsv(int a, int b, int expectedResult) {
        int actualResult = calculator.add(a, b);
        assertEquals(expectedResult, actualResult);

    }

    @AfterEach
    public void aftereach() {
        // The @AfterEach annotation will make a method execute after each @Test method.
        // Not after each Test class.

        //method executed after  in each method in test class shared object creation
        System.out.println("CalculatorTest.afterEach:AfterEach");
    }


    @AfterAll
    static void destroy() {

        // @After all annotation is used to make a method execute after all
        // test methods finish their execution. At the very end.
        System.out.println("CalculatorTest.destroy:AfterAll");
    }
}
