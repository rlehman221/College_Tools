

/**
 * CourseSelectionMain.java 1.0 Mar 31, 2017
 *
 * Copyright (c) 2017 Ryan Lehman All Rights Reserved
 */

package com.ryan.college;

import javax.swing.SwingUtilities;

/**
 * Start each class or interface with summary description line
 *
 * @author Ryan Lehman
 * 
 * @version 1.0
 *
 */
public class Main {

  /**
   * Driver method to start application by creating instance of Controller along with the interface
   * and starting it by calling its go method.
   *
   * @param args
   */
  public static void main(String[] args) {

    SwingUtilities.invokeLater(new Runnable() {

      @Override
      public void run() {
        CourseController controller = new CourseController();
        controller.go();
        System.exit(0);
      }
    });
  }

}
