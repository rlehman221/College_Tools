

/**
 * CourseController.java 1.0 Mar 31, 2017
 *
 * Copyright (c) 2017 Ryan Lehman Rights Reserved
 */

package com.ryan.college;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Allows for the GUI and model to connect with each other
 *
 * @author Ryan Lehman
 * 
 * @version 1.0
 *
 */
public class CourseController {
  private Courses model;
  private CourseView view;

  /**
   * Creates connections to the instances of the needed classes to allow the controller to use there
   * methods
   *
   */
  public CourseController() {
    view = new CourseView();
    model = new Courses();

  }

  /**
   * Manages interaction between the instances to gain the sorting method and scan a file. Sorts
   * through the data using methods and logs this into a table formed from strings
   *
   */
  public void go() {
    int counter = 0;

    Scanner input = null;
    boolean valid6 = true;
    int rangeCounter = 0;
    String selection;

    while (valid6) {
      if (rangeCounter > 0) {
        File new1 = view.getInputFile();
        String newName = new1.getName();
        view.displayError(newName);
      }
      try {
        rangeCounter++;
        input = view.openFile();
        model.findingLine(input);

        valid6 = false;

      } catch (FileNotFoundException e1) {
        e1.printStackTrace();
      } catch (Exception e2) {
        System.out.println("Exception" + e2.getMessage());
      }
    }
    while (counter == 0) {
      String sortedBy = "";
      selection = view.displayList();
      if (selection.equals("Subject")) {
        model.SubjectSort();
        sortedBy = "Subject";
      }
      if (selection.equals("Title")) {
        model.TitleSort();
        sortedBy = "Title";
        ;
      }
      if (selection.equals("Building and Room")) {
        model.Buildingsorting();
        sortedBy = "Building and Room";

      }
      if (selection.equals("Faculty")) {
        model.Facultysorting();
        sortedBy = "Faculty";

      }

      if (selection.equals("Day and Time")) {
        model.dayTimesorting();
        sortedBy = "Day and Time";

      }
      ArrayList<Course> new1 = new ArrayList<Course>();
      new1 = model.getCourses();

      view.disyplayGrid(new1, sortedBy);

    }
  }

}
