

/**
 * QueueController.java 1.0 Apr 16, 2017
 *
 * Copyright (c) 2017 Ryan Lehman All Rights Reserved
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
public class QueueController {
  private Model model;
  private GUI view;

  /**
   * Creates connections to the instances of the needed classes to allow the controller to use there
   * methods
   *
   */
  public QueueController() {
    view = new GUI();
    model = new Model();
  }

  /**
   * Manages interaction between the instances to scan a file. Then allow the students to be put
   * into a queue and then queued into an array list if needed
   *
   */
  public void go() {
    Scanner input = null;
    boolean valid6 = true;
    int rangeCounter = 0;
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
    ArrayList<Student> registeredList = model.getRegistered();
    view.displayList(registeredList);
  }

}
