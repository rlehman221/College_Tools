

/**
 * Model.java 1.0 Apr 18, 2017
 *
 * Copyright (c) 2017 Ryan Lehman All Rights Reserved
 */
package com.ryan.college;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Model's the CustomQueue being created along with popping out the registered students
 *
 * @author Ryan Lehman
 * 
 * @version 1.0
 *
 */
public class Model {
  private Queue queue;
  private ArrayList<Student> registered;

  /**
   * Creates a queue for the students and an ArrayList for the students that are registered
   *
   */
  public Model() {
    queue = new CustomQueue();
    registered = new ArrayList<Student>();
  }

  /**
   * Scans through the data pulled and adds students to be put into a CustomQueue or an array list
   *
   * @param in which represents a scanner for the file selected
   */
  public void findingLine(Scanner in) {
    int loopCounter = 0;
    while (in.hasNextLine()) {
      Student first = new Student();

      String line = in.nextLine();
      Scanner lineScanner = new Scanner(line);
      if (loopCounter > 0) {
        first.extractData(lineScanner);
        if (first.getLetter().equals("E")) {

          queue.add(first);

        } else {

          Student student = (Student) queue.poll();
          registered.add(student);

        }

      }
      loopCounter++;
    }

    in.close();
    if (loopCounter < 1) {
      throw new RuntimeException();
    }

    System.out.println("Extraction completed");
    loopCounter = 0;

  }

  /**
   * Obtains the registered list of students
   * 
   * @return list of registered students
   *
   */
  public ArrayList<Student> getRegistered() {
    return registered;
  }

}
