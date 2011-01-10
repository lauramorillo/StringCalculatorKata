package katas.stringcalculator;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.*;

public class StringCalculatorTest {
   private StringCalculator stringCalculator;

   @Rule
   public ExpectedException negativeNumberExpectedException = ExpectedException.none();

   @Before
   public void instantiateStringCalculatorClass() {
      stringCalculator = new StringCalculator();
   }

   @Test
   public void returnsZeroWhenReceivesAnEmptyString() {
      assertEquals(0, stringCalculator.add(""));
   }

   @Test
   public void returnsTheNumberWhenReceivesOneNumber() {
      assertEquals(1, stringCalculator.add("1"));
   }

   @Test
   public void returnsTheSumOfTwoNumbersWhenReceivesTwoNumbersSeparatedWithAComa() {
      assertEquals(3, stringCalculator.add("1,2"));
   }

   @Test
   public void returnsTheSumOfTheNumbersWhenReceivesAnyAmountOfNumbersSeparatedWithComas() {
      assertEquals(10, stringCalculator.add("3,4,1,2"));
   }

   @Test
   public void retursTheSumOfTheNumbersWhenReceivesAnyAmountOfNumbersSeparatedWithNewLines() {
      assertEquals(10, stringCalculator.add("3,4\n1,2"));
   }

   @Test
   public void supportsUsingDifferentDelimiters() {
      assertEquals(3, stringCalculator.add("//;\n1;2"));
   }

   @Test
   public void throwsAnExcepcionWhenReceivesANegativeNumber() {
      negativeNumberExpectedException.expect(NegativeNotAllowedException.class);
      negativeNumberExpectedException.expectMessage("negatives not allowed -2");
      
      stringCalculator.add("2,-2");
   }

   @Test
   public void throwsAnExceptionWhenReceivesNegativeNumbersAndTheyAppearInTheExceptionMessage() {
      negativeNumberExpectedException.expect(NegativeNotAllowedException.class);
      negativeNumberExpectedException.expectMessage("negatives not allowed -3 -2");
      
      stringCalculator.add("-3,-2");
   }

}
