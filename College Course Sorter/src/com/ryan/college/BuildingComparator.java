/**
 * Allows courses to be sorted by building and room by comparing based on building name and room
 * number
 *
 * @author Ryan Lehman
 * 
 * @version 1.0
 *
 */

package com.ryan.college;

import java.util.Comparator;

public class BuildingComparator implements Comparator<Object> {

  /**
   * Compares the courses by building name and then if they are the same building by room number
   * 
   * @return courses sorted by building and then room number
   */
  @Override
  public int compare(Object aCourse1, Object aCourse2) {
    Course course1 = (Course) aCourse1;
    Course course2 = (Course) aCourse2;
    if (((course1.getBuilding()).compareTo(course2.getBuilding())) == 0) {
      if (((course1.getNewRoom()).compareTo(course2.getNewRoom())) == 0) {
        return ((course1.getRoomLetter()).compareTo(course2.getRoomLetter()));
      } else {
        return ((course1.getNewRoom()).compareTo(course2.getNewRoom()));
      }
    }
    return ((course1.getBuilding()).compareTo(course2.getBuilding()));

  }

}
