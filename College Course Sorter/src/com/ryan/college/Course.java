
/**
 * Course.java 1.0 Mar 31, 2017
 *
 * Copyright (c) 2017 Ryan Lehman All Rights Reserved
 */
package com.ryan.college;

import java.util.Scanner;

/**
 * An object representation of a course with criteria
 *
 *
 * @author Ryan Lehman
 * 
 * @version 1.0
 *
 */
public class Course {

  private String building;
  private String crossList;
  private String dayTime;
  private String faculty;
  private int newRoom;
  private int number;
  private String oldRoomLetter;
  private String room;
  private String section;
  private String startDate;
  private String subject;
  private String term;
  private String title;

  /**
   * Initializes the categories found in each course
   *
   */
  public Course() {
    term = "";
    subject = "";
    number = 0;
    newRoom = 0;
    oldRoomLetter = "";
    section = new String();
    crossList = new String();
    title = new String();
    faculty = new String();
    building = new String();
    room = "";
    startDate = "";
    dayTime = new String();

  }

  /**
   * Extracts data from the file given and assigns each course with specific details for each
   * category
   * 
   * @param in which represents the scanner to check the file for each line
   */
  public void extractData(Scanner in) {
    while (in.hasNext()) {
      in.useDelimiter(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");

      term = (in.next());
      subject = (in.next());
      number = Integer.parseInt(in.next());
      section = (in.next());
      crossList = (in.next());
      title = (in.next());

      if (title.startsWith("\"")) {
        String newTitle = title.substring(1, title.length() - 1);
        title = "";
        title = newTitle;
      }

      faculty = (in.next());
      building = (in.next());
      room = (in.next()); // Integer.parseInt(in.next());

      if (Character.isLetter(room.charAt(room.length() - 1))) {
        oldRoomLetter = room.substring(room.length() - 1);
        String newRoomString = room.substring(0, room.length() - 1);
        newRoom = Integer.parseInt(newRoomString);
      } else {
        newRoom = Integer.parseInt(room);
      }

      startDate = (in.next());
      dayTime = (in.next());
    }

  }

  /**
   * Extracts and returns the building in the present course
   * 
   * @return building representing a string of the present building
   */
  public String getBuilding() {
    return building;
  }

  /**
   * Extracts and returns the dayTime in the present course
   * 
   * @return dayTime representing a string for the current dayTime in the course
   */
  public String getDayTime() {
    return dayTime;
  }

  /**
   * Extracts and returns the faculty in the present course while also temporally making each term
   * uppercase to sort with
   *
   * @return tamperedFaculty representing the upper case version of the present faculty
   */
  public String getFaculty() {
    String tamperedFaculty = faculty.toUpperCase();
    return tamperedFaculty;
  }

  /**
   * Extracts and returns the room in the present course
   * 
   * @return room representing the room for each building
   */
  public Integer getNewRoom() {
    return newRoom;
  }

  /**
   * Extracts and returns the room letter if present in the current course
   *
   * @return oldRoomLetter represents a string that was attached to some rooms
   */
  public String getRoomLetter() {
    return oldRoomLetter;
  }

  /**
   * Extracts and returns the subject in the present course
   * 
   * @return subject representing a string of the current subject in the course
   */
  public String getSubject() {
    return subject;
  }

  /**
   * Extracts and returns the title in the present course
   * 
   * @return title representing a string for the current title in the course
   */
  public String getTitle() {
    return title;
  }

  /**
   * Overrides the toString method to customize towards each course printed
   * 
   * @return formatted course
   */
  @Override
  public String toString() {
    String newSubject = subject.trim();
    String newTitle = title.trim();
    String newBuilding = building.trim();
    String newDayTime = dayTime.trim();
    String newFaculty = faculty.trim();
    if (subject.length() > 5) {
      newSubject = subject.substring(0, 29);
    }
    if (title.length() > 33) {
      newTitle = title.substring(0, 29);
    }

    if (dayTime.length() > 34) {
      newDayTime = dayTime.substring(0, 20);
    }
    if (building.length() > 6) {
      newBuilding = building.substring(0, 29);
    }
    if (faculty.length() > 20) {
      newFaculty = faculty.substring(0, 16);
    }

    return String.format("%-11s%-38s%-34s%-15s%-10s%-25s", "Sub: " + newSubject,
                         "Title: " + newTitle, " Day/Time: " + newDayTime, "  Bldg: " + newBuilding,
                         "Rm: " + newRoom + oldRoomLetter, " Fac: " + newFaculty);

  }

}
