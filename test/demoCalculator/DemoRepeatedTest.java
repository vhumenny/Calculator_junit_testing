package demoCalculator;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DemoRepeatedTest {

    Calculator calculator;

    @BeforeEach
    void beforeEachTestMethod() {
        calculator = new Calculator();
        System.out.println("Executing @BeforeEach method.");
    }

    @DisplayName("Division by zero")
    @RepeatedTest(value = 3, name = "{displayName}. Repetition {currentRepetition} of {totalRepetitions}")
    void testIntegerDivision_WhenDividendIsDividedByZero_ShouldThrowArithmeticException(
            RepetitionInfo repetitionInfo, TestInfo testInfo) {
        System.out.println("Running " + testInfo.getTestMethod().get().getName());
        System.out.println("Repetition #" + repetitionInfo.getCurrentRepetition() +
                " of " + repetitionInfo.getTotalRepetitions());
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
}
