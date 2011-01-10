package katas.stringcalculator;

public class StringCalculator {
   public static final String DEFAULT_DELIMITERS = "[,\\n]";
   public static final int RESULT_FOR_NO_NUMBERS_TO_SUM = 0;
   
   public int add(String numbersToAdd) {
      String delimiterPattern = getDelimiterPattern(numbersToAdd);
      String numbers = getNumbersWithoutDelimiterDefinition(numbersToAdd);
      return sumOfNumbers(numbers, delimiterPattern);
   }

   private String getDelimiterPattern(String numbersToAdd) {
      if (hasADelimiterDefinition(numbersToAdd)) {
         return String.valueOf(numbersToAdd.charAt(2));
      }
      return DEFAULT_DELIMITERS;
   }

   private boolean hasADelimiterDefinition(String numbersToAdd) {
      return numbersToAdd.startsWith("//");
   }

   private String getNumbersWithoutDelimiterDefinition(String numbersToAdd) {
      if (hasADelimiterDefinition(numbersToAdd)) {
         return numbersToAdd.substring(4);
      }
      return numbersToAdd;
   }

   private int sumOfNumbers(String numbersToAdd, String delimiterPattern) throws NumberFormatException {
      if (hasAnyNumber(numbersToAdd)) {
         return totalSumOfNumbers(numbersToAdd, delimiterPattern);
      }
      return RESULT_FOR_NO_NUMBERS_TO_SUM;
   }

   private boolean hasAnyNumber(String numbersToAdd) {
      return !numbersToAdd.isEmpty();
   }

   private int totalSumOfNumbers(String numbersToAdd, String delimiterPattern) throws NumberFormatException {
      String[] numbers = numbersToAdd.split(delimiterPattern, 0);
      checkIfThereAreNegativeNumbers(numbers);
      return sumPositiveNumbers(numbers);
   }

   private int sumPositiveNumbers(String[] numbers) throws NumberFormatException {
      int total = 0;
      for (String number : numbers) {
         total += Integer.parseInt(number);
      }
      return total;
   }

   private void checkIfThereAreNegativeNumbers(String[] numbers) {
      String negativeNumbers = stringWithNegativeNumbersConcatenated(numbers);
      throwExceptionIfThereAreNegativeNumbers(negativeNumbers);
   }

   private String stringWithNegativeNumbersConcatenated(String[] numbers) throws NumberFormatException {
      String negativeNumbers = "";
      for (String number : numbers) {
         if (Integer.parseInt(number) < 0) {
            negativeNumbers += " " + number;
         }
      }
      return negativeNumbers;
   }

   private void throwExceptionIfThereAreNegativeNumbers(String negativeNumbers) throws NegativeNotAllowedException {
      if (!negativeNumbers.isEmpty()) {
         throw new NegativeNotAllowedException("negatives not allowed" + negativeNumbers);
      }
   }
}
