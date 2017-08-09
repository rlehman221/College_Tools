

/**
 * Courses.java 1.0 Mar 31, 2017
 *
 * Copyright (c) 2017 Ryan Lehman All Rights Reserved
 */

package com.ryan.college;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Object representing a group of courses pulled together to sort
 *
 * @author Ryan Lehman
 * 
 * @version 1.0
 *
 */
public class Courses {
  private ArrayList<Course> courseList;
  private int loopCounter = 0;

  /**
   * Initialize a list of courses to be inserted into
   *
   */
  public Courses() {
    courseList = new ArrayList<Course>();
  }

  /**
   * Sorts the courses list based on building names and if needed room numbers
   *
   */
  public void Buildingsorting() {

    Collections.sort(courseList, new BuildingComparator());

  }

  /**
   * Sorts the courses list based on dayTime
   *
   */
  public void dayTimesorting() {

    Collections.sort(courseList, new DayTimeComparator());

  }

  /**
   * Sorts the courses list based on faculty names
   *
   */
  public void Facultysorting() {

    Collections.sort(courseList, new FacultyComparator());

  }

  /**
   * Scans through the data pulled and creates course objects to be put into an array list
   *
   * @param in which represents a scanner for the file selected
   */
  public void findingLine(Scanner in) {
    loopCounter = 0;
    while (in.hasNextLine()) {
      Course first = new Course();

      String line = in.nextLine();
      Scanner lineScanner = new Scanner(line);
      if (loopCounter != 0) {
        first.extractData(lineScanner);
        courseList.add(first);

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
   * Pulls the courses stored and returns them as an array list
   *
   * @return courseList representing the total courses pulled from the data collected
   */
  public ArrayList<Course> getCourses() {
    return courseList;
  }

  /**
   * Sorts the courses list based on each subjects name
   *
   */
  public void SubjectSort() {

    Collections.sort(courseList, new SubjectComparator());

  }

  /**
   * Sorts the courses list based on each titles name
   *
   */
  public void TitleSort() {
    Collections.sort(courseList, new TitleComparator());

  }

}
