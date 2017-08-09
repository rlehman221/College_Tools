

/**
 * TitleComparator.java 1.0 Apr 2, 2017
 *
 * Copyright (c) 2017 Ryan Lehman All Rights Reserved
 */

package com.ryan.college;

import java.util.Comparator;

/**
 * Allows courses to be sorted by title by comparing based on title name
 *
 * @author Ryan Lehman
 * 
 * @version 1.0
 *
 */
public class TitleComparator implements Comparator<Object> {

  /**
   * Compares the courses by title name
   * 
   * @return courses sorted by title name
   */
  @Override
  public int compare(Object aCourse1, Object aCourse2) {
    Course course1 = (Course) aCourse1;
    Course course2 = (Course) aCourse2;
    return course1.getTitle().compareTo(course2.getTitle());

  }

}
