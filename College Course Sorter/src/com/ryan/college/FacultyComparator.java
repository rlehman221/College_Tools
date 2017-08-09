

/**
 * FacultyComparator.java 1.0 Apr 9, 2017
 *
 * Copyright (c) 2017 Ryan Lehman All Rights Reserved
 */

package com.ryan.college;

import java.util.Comparator;

/**
 * Allows courses to be sorted by faculty by comparing based on faculty name
 *
 * @author Ryan Lehman
 * 
 * @version 1.0
 *
 */
public class FacultyComparator implements Comparator<Object> {

  /**
   * Compares the courses by faculty name
   * 
   * @return courses sorted by by faculty name
   */
  @Override
  public int compare(Object aCourse1, Object aCourse2) {
    Course course1 = (Course) aCourse1;
    Course course2 = (Course) aCourse2;
    return course1.getFaculty().compareTo(course2.getFaculty());

  }

}
