package demoCalculator;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Math operations in Calculator class")
class CalculatorTest {

    Calculator calculator;

    @BeforeAll
    static void setup() {
        System.out.println("Executing @BeforeAll method.");
    }

    @AfterAll
    static void cleanup() {
        System.out.println("Executing @AfterAll method.");
    }

    @BeforeEach
    void beforeEachTestMethod() {
        calculator = new Calculator();
        System.out.println("Executing @BeforeEach method.");
    }

    @AfterEach
    void afterEachTestMethod() {
        System.out.println("Executing @AfterEach method.");
    }

    // test<System Under Test>_<Condition or State Change>_<Expected Result>
    @DisplayName("Test 4/2 = 2")
    @Test
    void testIntegerDivision_WhenFourIsDividedByTwo_ShouldReturnTwo() {
        System.out.println("Running Test 4/2 = 2");
        // Arrange
        int dividend = 4;
        int division = 2;
        int expectedResult = 2;
        // Act
        int actualResult = calculator.integerDivision(dividend, division);
        //Assert
        assertEquals(expectedResult, actualResult, "4/2 didn't produce 2");
    }

    //@Disabled("TODO: Still need to work on it.")
    @DisplayName("Division by zero")
    @Test
    void testIntegerDivision_WhenDividendIsDividedByZero_ShouldThrowArithmeticException() {
        System.out.println("Running Division by zero");
        //Arrange
        int dividend = 4;
        int divisor = 0;
        String expectedExceptionMethod = "/ by zero";
        //Act
        ArithmeticException actualException = assertThrows(ArithmeticException.class, () -> {
            //Act && Assert
            calculator.integerDivision(dividend, divisor);
        }, "Division by zero should throw an Arithmetic exception");
        //Assert
        assertEquals(expectedExceptionMethod, actualException.getMessage(), "Unexpected exception message");
    }

    @DisplayName("Test integer subtraction (minuend, subtrahend, expectedResult")
    @ParameterizedTest
//    @MethodSource()
//    @CsvSource({
//            "7,3,4",
//            "24,1,23",
//            "54,1,53"
//    })
//    @CsvSource({
//            "apple, orange",
//            "apple, ''",
//            "apple,"
//    })
    @CsvFileSource(resources = "/integerSubtraction.csv")
    void integerSubtraction(int minuend, int subtrahend, int expectedResult) {
        System.out.println("Running Test " + minuend + "-" + subtrahend + "=" + expectedResult + "");
        int actualResult = calculator.integerSubtraction(minuend, subtrahend);
        assertEquals(expectedResult, actualResult,
                () -> minuend + "-" + subtrahend + " did not produce " + expectedResult);
    }

//    private static Stream<Arguments> integerSubtraction() {
//        return Stream.of(
//                Arguments.of(7, 3, 4),
//                Arguments.of(24, 1, 23),
//                Arguments.of(54, 1, 53)
//        );
//    }
}