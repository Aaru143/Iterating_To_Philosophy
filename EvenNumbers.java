//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: P07 - Iterating To Philosophy
// Files: EvenNumber.java, FiniteIterator.java, Generator.java, NextWikiLink.java,
// InfiniteIterator.java, TestDriver.java (all in UTF-8)
// Course: CS 300, SPRING-2019
//
// Author: Aarushi Gupta
// Email: gupta232@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: (name of your pair programming partner)
// Partner Email: (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// ___ Write-up states that pair programming is allowed for this assignment.
// ___ We have both read and understand the course Pair Programming Policy.
// ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: (identify each person and describe their help in detail)
// Online Sources: (identify each URL and describe their assistance in detail)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import java.util.Iterator;

public class EvenNumbers implements Iterator<Integer> {

  private Integer userInput; // stores the userInput
  private boolean hasNextvalue; // stores the value returned by hasNext()
  private int numberOfnext = 1; // stores the number of time next() is called, initially = 1

  /**
   * Constructor of the class
   * 
   * @param Integer userInput
   * @return void
   */
  public EvenNumbers(Integer userInput) {
    this.userInput = userInput;
  }

  /**
   * The hasNext() method should always return true
   * 
   * @param
   * @return boolean hasNextValue
   */
  public boolean hasNext() {
    this.hasNextvalue = true;
    return hasNextvalue; // always returns true
  }

  /**
   * The next() method returns the userInput when called for the first time. Each subsequent call of
   * the next() method returns the smallest even number greater than the previous one
   * 
   * @param
   * @return Integer userInput
   */
  public Integer next() {
    // checks if the value returned from hasNext() true
    if (this.hasNext() == true) {
      if (this.numberOfnext == 1) { // checks that the method next() is called for the first time
        this.numberOfnext++; // increases the number of times next() is called
        return this.userInput;
      } else {
        // if the value of numberOfnext not equal to 1 then returns the next even number
        this.userInput += 2; // stores next even number
        this.numberOfnext++;
        return this.userInput;
      }
    } else
      // if the value of hasNext() is false then returns null
      System.out.print("The value returned by hasNext()" + this.hasNext());
    return null;
  }
}
