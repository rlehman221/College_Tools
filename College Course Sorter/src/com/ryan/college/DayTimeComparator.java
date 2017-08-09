

/**
 * DayTimeComparator.java 1.0 Apr 9, 2017
 *
 * Copyright (c) 2017 Ryan Lehman All Rights Reserved
 */

package com.ryan.college;

import java.util.Comparator;

/**
 * Allows courses to be sorted by day and time by comparing based on day and time name
 *
 * @author Ryan Lehman
 * 
 * @version 1.0
 *
 */
public class DayTimeComparator implements Comparator<Object> {

  /**
   * Compares the courses by day and time name
   * 
   * @return courses sorted by day and time name
   */
  @Override
  public int compare(Object aCourse1, Object aCourse2) {
    Course course1 = (Course) aCourse1;
    Course course2 = (Course) aCourse2;

    return ((course1.getDayTime()).compareTo(course2.getDayTime()));

  }

}
