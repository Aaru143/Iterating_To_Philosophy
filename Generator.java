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
import java.util.function.Function;

public class Generator<T> implements Iterable<T> {

  // <T> is a generic type parameter to the class
  private T firstValue; // stores the firstValue provided by the user
  private Function<T, T> generateNextFromLast; // stores the function
  private int userLength = 0; // stores the length entered by user initially = 0

  /**
   * Constructor of the class
   * 
   * @param T firstValue, Function<T, T> generateNextFromLast
   * @return
   */
  public Generator(T firstValue, Function<T, T> generateNextFromLast) {
    this.firstValue = firstValue;
    this.generateNextFromLast = generateNextFromLast;
  }

  /**
   * Constructor of the class
   * 
   * @param T firstValue, Function<T, T> generateNextFromLast, int length
   * @return
   */
  public Generator(T firstValue, Function<T, T> generateNextFromLast, int length) {
    this.firstValue = firstValue;
    this.generateNextFromLast = generateNextFromLast;
    this.userLength = length;
  }

  /**
   * Calls the constructor InfiniteIterator() or FiniteIterator() based on the arguments passed to
   * the Generator()
   * 
   * @param
   * @return Iterator<T>
   */
  @Override
  public Iterator<T> iterator() {
    if (this.userLength == 0) { // if no length is entered by user, then calls constructor of
                                // InfiniteIterator<T>
      return new InfiniteIterator<T>(firstValue, generateNextFromLast);
    } else {
      // if some length is entered by the user, then calls constructor of FiniteIterator<T>
      return new FiniteIterator<T>(new InfiniteIterator<T>(firstValue, generateNextFromLast),
          this.userLength);
    }
  }
}


