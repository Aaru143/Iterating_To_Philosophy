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

public class FiniteIterator<newType> implements Iterator<newType> {

  // newType is a generic type parameter to the class
  private int userLength; // stores the length entered by user
  private InfiniteIterator<newType> userInput; // stores the userInput
  private int numOfCalls = 0; // stores the number of time next() is called, initially = 0

  /**
   * Constructor of the class
   * 
   * @param InfiniteIterator<newType> userInput, int userLength
   * @return void
   */
  public FiniteIterator(InfiniteIterator<newType> userInput, int userLength) {
    this.userLength = userLength;
    this.userInput = userInput;
  }

  /**
   * The hasNext() method returns false when the number of times next() method called is equal to
   * the userLength else returns true
   * 
   * @param
   * @return boolean
   */
  @Override
  public boolean hasNext() {
    // checks if the number of time next() called equal to userLength
    if (this.numOfCalls == this.userLength)
      return false; // returns false if the two values are equal
    else
      return true; // returns true if the values are not equal
  }

  /**
   * The next() method returns the value from userInput.next() when called each time, where
   * userInput is of type InfiniteIterator<newType>. It increases the number of times next() is
   * called by 1 each time
   * 
   * @param
   * @return newType
   */
  @Override
  public newType next() {
    this.numOfCalls++; // increase the number of times by 1 when the next() method is called
    return this.userInput.next();
  }
}
