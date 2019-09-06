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

import java.util.function.Function;

public class TestDriver {

  /**
   * Tests if the EvenNumber.java is implemented correctly. If correct returns true, otherwise
   * returns false and prints the relevant message
   * 
   * @param
   * @return boolean
   */
  public static boolean testEvenNumbers() {
    EvenNumbers it = new EvenNumbers(44); // passes the value "44" to the class constructor
    if (it.next() != 44) { // checks the value returned by next() method on first call
      System.out.println("The first call of EvenNumbers.next() "
          + "did not return the value passed into its constructor.");
      return false; // returns false if not correct
    }
    if (it.next() != 46) { // checks the value returned by next() after another call
      System.out.println(
          "The second call of EvenNumbers.next() " + "did not return the smallest even number, "
              + "that is larger than the previously returned number.");
      return false; // returns false if not correct
    }
    if (it.hasNext() != true) { // checks the value returned by hasNext() to be true
      System.out.println("EvenNumbers.next() returned false, " + "but should always return true.");
      return false; // returns false if value returned by hasNext() is not always true
    }
    return true; // returns true if all tests passed
  }

  /**
   * Tests if the InfiniteIterator.java is implemented correctly. If correct returns true, otherwise
   * returns false and prints the relevant message
   * 
   * @param
   * @return boolean
   */
  public static boolean testPowersOfTwo() {
    // creates a new InfiniteIterator of type <Integer>
    InfiniteIterator<Integer> it = new InfiniteIterator<Integer>(8, new NextPowerOfTwo());
    if (it.next() != 8) { // checks the value returned by next() method on first call
      System.out.println("The first call of InfiniteIterator.next() "
          + "did not return the number passed into its constructor.");
      return false;// returns false if not correct
    }
    if (it.next() != 16) { // checks the value returned by next() after another call
      System.out.println("The second call of InfiniteIterator.next() "
          + "did not return the smallest power of two number, "
          + "that is larger than the previously returned number.");
      return false;// returns false if not correct
    }
    if (it.hasNext() != true) {// checks the value returned by hasNext() to be true
      System.out
          .println("InfiniteIterator.next() returned false, " + "but should always return true.");
      return false;// returns false if value returned by hasNext() is not always true
    }
    return true;// returns true if all tests passed
  }

  /**
   * Tests if the InfiniteIterator.java is implemented correctly for Strings. If correct returns
   * true, otherwise returns false and prints the relevant message
   * 
   * @param
   * @return boolean
   */
  public static boolean testAddExtraSmile() {
    // creates a new InfiniteIterator of type <String>
    InfiniteIterator<String> it = new InfiniteIterator<>("Hello", new AddExtraSmile());
    if (!it.next().equals("Hello")) { // checks the value returned by next() method on first call
      System.out.println("The first call of InfiniteIterator.next() "
          + "did not return the string passed into its constructor.");
      return false;// returns false if not correct
    }
    if (!it.next().contains(" :)")) {
      System.out.println("The second call of InfiniteIterator.next() "
          + "did not return the a string with one more :), "
          + "than the previously returned string.");
      return false;// returns false if not correct
    }
    if (it.hasNext() != true) {// checks the value returned by hasNext() to be true
      System.out
          .println("InfiniteIterator.next() returned false, " + "but should always return true.");
      return false;// returns false if value returned by hasNext() is not always true
    }
    return true;// returns true if all tests passed
  }

  /**
   * Tests if the FiniteIterator.java is implemented correctly. If correct returns true, otherwise
   * returns false and prints the relevant message
   * 
   * @param
   * @return boolean
   */
  public static boolean testFiniteIterator() {
    // creates a new FiniteIterator of type <Integer>
    InfiniteIterator<Integer> infinite = new InfiniteIterator<>(2, new NextPowerOfTwo());
    FiniteIterator<Integer> it = new FiniteIterator<>(infinite, 8);
    String s = "";
    while (it.hasNext()) // runs until the value returned by hasNext() is true
      s += " " + it.next(); // concatenates the values returned by next()
    if (!s.equals(" 2 4 8 16 32 64 128 256")) {
      System.out.println("Repeatedly called the next() method of a FiniteIterator,"
          + "and the incorrect valuese were returned:" + s);
      return false; // returns false if the output is not as per expected standards
    }
    return true;// returns true if all tests passed
  }

  /**
   * Tests if the Generator.java is implemented correctly. If correct returns true, otherwise
   * returns false and prints the relevant message
   * 
   * @param
   * @return boolean
   */
  public static boolean testGenerator() {
    // creates a new Generator of type <Integer> which in turn should call the constructor of
    // FiniteIterator.java (as per the arguments passed)
    Generator<Integer> finite = new Generator<Integer>(2, new NextPowerOfTwo(), 4);
    String s = "";
    for (Integer i : finite) {
      s += " " + i; // concatenates the values returned by next()
    }
    if (!s.equals(" 2 4 8 16")) {
      System.out.println("Repeatedly called the next() method of a FiniteIterator,"
          + "and the incorrect valuese were returned:" + s);
      return false;// returns false if the output is not as per expected standards
    }
    return true;// returns true if all tests passed
  }

  /**
   * Calls all the methods and prints the values returned by them
   * 
   * @param
   * @return
   */
  public static void main(String[] args) {
    System.out.println(
        "The value returned after " + "calling testEvenNumbers() is: " + testEvenNumbers());

    System.out.println(
        "The value returned after " + "calling testPowersOfTwo() is: " + testPowersOfTwo());

    System.out.println(
        "The value returned after " + "calling testAddExtraSmile() is: " + testAddExtraSmile());

    System.out.println(
        "The value returned after " + "calling testFiniteIterator() is: " + testFiniteIterator());

    System.out
        .println("The value returned after " + "calling testGenerator() is: " + testGenerator());


  }
}


class NextPowerOfTwo implements Function<Integer, Integer> {
  @Override
  public Integer apply(Integer previous) {
    return 2 * previous;
  }
}


class AddExtraSmile implements Function<String, String> {
  @Override
  public String apply(String t) {
    return t + " :)";
  }
}
