

/**
 * SubjectComparator.java 1.0 Apr 2, 2017
 *
 * Copyright (c) 2017 Ryan Lehman All Rights Reserved
 */

package com.ryan.college;

import java.util.Comparator;

/**
 * Allows courses to be sorted by subject by comparing based on subject name
 *
 * @author Ryan Lehman
 * 
 * @version 1.0
 *
 */
public class SubjectComparator implements Comparator<Object> {

  /**
   * Compares the courses by subject name
   * 
   * @return courses sorted by by subject name
   */
  @Override
  public int compare(Object aCourse1, Object aCourse2) {
    Course course1 = (Course) aCourse1;
    Course course2 = (Course) aCourse2;
    return course1.getSubject().compareTo(course2.getSubject());

  }

}
