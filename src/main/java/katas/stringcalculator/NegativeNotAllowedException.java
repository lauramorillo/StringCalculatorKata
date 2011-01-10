package katas.stringcalculator;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Laura
 */
public class NegativeNotAllowedException extends RuntimeException{

   public NegativeNotAllowedException(String message) {
      super(message);
   }

}
