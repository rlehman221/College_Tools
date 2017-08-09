

/**
 * CourseView.java 1.0 Mar 31, 2017
 *
 * Copyright (c) 2017 Ryan Lehman All Rights Reserved
 */

package com.ryan.college;

import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

/**
 * A JOptionPane interface to allow the user to read and enter data
 *
 * @author Ryan Lehman
 * 
 * @version 1.0
 *
 */
public class CourseView {

  private File inputFile;

  /**
   * Displays and error prompt if a file is not in the right format
   * 
   * @param fileName String representing the invalid message
   */
  public void displayError(String fileName) {
    String title = "Invalid File";
    // JOptionPane.showOptDialog(null, dataTable, title, JOptionPane.QUESTION_MESSAGE);
    JOptionPane.showOptionDialog(null, "The file " + fileName + " is not in proper format.", title,
                                 JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, null,
                                 "ok");
  }

  /**
   * Displays a list of options for the file inputed to be sorted by and prompts the user to pick
   * one
   * 
   * @return userSelection representing the sorting method in which to sort the data
   */
  public String displayList() {
    String[] selections = { "Building and Room", "Day and Time", "Faculty", "Subject", "Title" };
    // JOptionPane.showOptDialog(null, dataTable, title, JOptionPane.QUESTION_MESSAGE);
    String userSelection =
      (String) JOptionPane.showInputDialog(null, "Select critera to sort quotes by:",
                                           "Sort Criteria", JOptionPane.QUESTION_MESSAGE, null,
                                           selections, selections[0]);
    if (userSelection == null) {
      System.exit(0);
    }

    return userSelection;
  }

  /**
   * Displays the data pulled from the file in a sorted fashion that the user had choosen
   * 
   * @param aNew1 which represents the courses from the file selected grouped into a list
   * @param aSortedBy which represents the sorting method used in the form of a string
   *
   */
  public void disyplayGrid(ArrayList<Course> aNew1, String aSortedBy) {
    UIManager.put("OptionPane.messageFont",
                  new FontUIResource(new Font("Monospaced", Font.PLAIN, 12)));

    UIManager.put("OptionPane.font", new FontUIResource(new Font("Monospaced", Font.PLAIN, 12)));

    UIManager.put("Label.font", new FontUIResource(new Font("Monospaced", Font.PLAIN, 12)));

    UIManager.put("List.font", new FontUIResource(new Font("Monospaced", Font.PLAIN, 12)));
    Course bigList[] = new Course[aNew1.size()];
    for (int i = 0; i < bigList.length; i++) {
      bigList[i] = aNew1.get(i);

    }

    Object showGrid =
      (Object) JOptionPane.showInputDialog(null, "Sorted quotes by " + aSortedBy,
                                           "Course Selection", JOptionPane.QUESTION_MESSAGE,
                                           null, bigList, bigList[0]);
    if (showGrid == null) {
      System.exit(0);
    }
  }

  /**
   * Returns the value of the file that was taken
   * 
   * @return File representing the file selected
   */
  public File getInputFile() {
    return inputFile;
  }

  /**
   * Opens the JOptionChooser to have the user choose which file to open
   * 
   * @return a scanner representation of the file selected
   * @throws FileNotFoundException if file selected is not in the right format
   */
  public Scanner openFile() throws FileNotFoundException {
    inputFile = null;
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("Select Course Data File");

    if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
      inputFile = fileChooser.getSelectedFile();
    } else {
      System.exit(0);
    }

    Scanner in = new Scanner(inputFile);
    return in;
  }
}
