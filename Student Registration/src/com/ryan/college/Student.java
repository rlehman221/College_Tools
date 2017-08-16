

/**
 * Student.java 1.0 Apr 16, 2017
 *
 * Copyright (c) 2017 Ryan Lehman All Rights Reserved
 */
package com.ryan.college;

import java.util.Scanner;

/**
 * A class that represents a student object
 *
 * @author Ryan Lehman
 * 
 * @version 1.0
 *
 */
public class Student {
  private int idNum;

  private String letter;
  private int year;

  /**
   * Creates the year of the student along with there id number and a letter to see if they get
   * registered
   *
   */
  public Student() {
    year = 0;
    idNum = 0;
    letter = "";
  }

  /**
   * Extracts the data in the file selected to create an object of a student for each student found
   * in the file
   *
   * @param in which is scanned in from the file selected
   */
  public void extractData(Scanner in) {
    while (in.hasNext()) {

      in.useDelimiter(" ");

      letter = (in.next());

      if (in.hasNext()) {

        year = Integer.parseInt(in.next());
      }
      if (in.hasNext()) {

        idNum = Integer.parseInt(in.next());
      }

    }

  }

  /**
   * Obtains the student id number and returns it in the form of a integer
   * 
   * @return the idNum which represents an id number
   */
  public int getIdNum() {
    return idNum;
  }

  /**
   * Obtains the student associated letter and returns it
   * 
   * @return the letter which represents a letter
   */
  public String getLetter() {
    return letter;
  }

  /**
   * Obtains the student year and returns it in the form of a integer
   * 
   * @return the year which represents the students year
   */
  public int getYear() {
    return year;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return ("" + year + " " + idNum);
  }

}
