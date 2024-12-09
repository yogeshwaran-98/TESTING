import com.example.tests.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TryTest {

    private Calculator calculator;

    //ADDITION
    @DisplayName("Test Addition - Correct args")
    @Test
    void testAddition_ReturnAnswer(){
        Calculator calculator = new Calculator();

        int ans = calculator.integerAddition(10,15);

        assertEquals(ans , 25 , "Answers dont match");
    }

    @DisplayName("Test Addition - Negative number")
    @Test
    void testAddition_ShouldReturnExceptionForNegativeVal(){
        Calculator calculator = new Calculator();

        IllegalArgumentException exc = assertThrows(IllegalArgumentException.class , () -> {
            calculator.integerAddition(10 , -10);
        });
    }


    //SUBTRACTION
    @DisplayName("Test Subtraction - Correct args")
    @Test
    void testSubtraction_ReturnAnswer(){
        Calculator calculator = new Calculator();

        int ans = calculator.integerSub(10 , 5);

        assertEquals(ans , 5 , "Answer should match");
    }

    @DisplayName("Test Subtraction- Negative number")
    @Test
    void testSubtraction_ShouldReturnExceptionForNegativeVal(){
        Calculator calculator = new Calculator();

        IllegalArgumentException exc = assertThrows(IllegalArgumentException.class , () -> {
            calculator.integerSub(10 , -5);
        });
    }

    @Test
    void testDivision_ReturnAnswer(){
        Calculator calculator = new Calculator();
        int ans = calculator.integerDivision(4,2);

        assertEquals(ans , 2,"Wrong answer");
    }

    @Test
    void testDivision_ThrowException_ForGreaterDivisor(){
        Calculator calculator = new Calculator();
        IllegalArgumentException error = assertThrows(IllegalArgumentException.class , () -> {
            int ans = calculator.integerDivision(2,4);
        }, "Should have thrown illegal argument exception error");
    }

    @ParameterizedTest
    @MethodSource
    void testDivision_multiplecases(int dividend , int divisor , int res){
        Calculator calculator = new Calculator();

        int ans = calculator.integerDivision(dividend , divisor);

        assertEquals(ans , res , "Error - not working");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class , () -> {
            calculator.integerDivision(divisor , dividend );
        } , "Should have thrown illegalargs excp");
    }

    private static Stream<Arguments> testDivision_multiplecases(){
        return Stream.of(
                Arguments.of(4,2,2),
                Arguments.of(6,3,2)
        );
    }

    @ParameterizedTest
    @CsvSource({"4,2,2" , "6,3,2" , "8,2,4"})
    void testDivision_csvsource(int dividend , int divisor , int res){
        Calculator calculator = new Calculator();

        int ans = calculator.integerDivision(dividend , divisor );

        assertEquals(ans , res , "Both should be equal");

    }

}
