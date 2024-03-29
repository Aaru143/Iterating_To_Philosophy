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

import java.io.IOException;
import java.util.Scanner;
import java.util.function.Function;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class NextWikiLink implements Function<String, String> {

  /**
   * Returns the link attribute of the wiki page
   * 
   * @param String t
   * @return String
   */
  @Override
  public String apply(String t) {
    try {
      // Download a Wikipedia page, using t in their internal link format: /wiki/Some_Subject
      Document doc = Jsoup.connect("https://en.wikipedia.org" + t).get();
      // Use .css selector to retrieve a collection of links from this page's description
      // "p a" selects links within paragraphs
      // ":not([title^='Help'])" skips pronunciations
      // ":not(sup a)" skips citations
      Elements links = doc.select("p a:not([title^='Help']):not(sup a)");
      // return the link attribute from the first element of this list
      return links.get(0).attr("href");
      // Otherwise return an appropriate error message:
    } catch (IOException | IllegalArgumentException e) {
      return "FAILED to find wikipedia page: " + t;
    } catch (IndexOutOfBoundsException e) {
      return "FAILED to find a link in wikipedia page: " + t;
    }
  }

  /**
   * Acts as a driver for the application
   * 
   * @param String[] args
   * @return void
   */
  public static void main(String[] args) {

    // Implement your own Wikipedia crawling application here.
    Scanner scanner = new Scanner(System.in);

    // prompt the user to enter a topic name
    // prepend "/wiki/" to the user's input, and replace spaces with underscores
    System.out.print("Enter a wikipedia page topic: ");
    String userTopic = "/wiki/" + scanner.nextLine();
    userTopic = userTopic.replace(" ", "_");

    // prompt the user to enter the number of iterations to follow
    System.out.print("Enter the number of pages you'd like to step through: ");
    int userNumber = scanner.nextInt();


    // use a for-each loop to iterate through the number of links requested
    Generator<String> userGen = new Generator<String>(userTopic, new NextWikiLink(), userNumber);
    for (String i : userGen) {
      if (i.startsWith("FAILED")) {
        System.out.println("FAILED to find wikipedia page: " + userTopic);
        break;
      }
      System.out.println(i);
    }
    scanner.close(); // closes the scanner
  }
}
