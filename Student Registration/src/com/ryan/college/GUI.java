

/**
 * GUI.java 1.0 Apr 16, 2017
 *
 * Copyright (c) 2017 Ryan Lehman All Rights Reserved
 */
package com.ryan.college;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * JOptionPane view that allows for user input and output
 *
 * @author Ryan Lehman
 * 
 * @version 1.0
 *
 */
public class GUI {
  private File inputFile;

  /**
   * Displays and error prompt if a file is not in the right format
   *
   * @param fileName
   */
  public void displayError(String fileName) {
    String title = "Invalid File";
    // JOptionPane.showOptDialog(null, dataTable, title, JOptionPane.QUESTION_MESSAGE);
    JOptionPane.showOptionDialog(null, "The file " + fileName + " is not in proper format.", title,
                                 JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, null,
                                 "ok");
  }

  /**
   * Takes in the registered list and prints this to the display
   *
   * @param aList that is a list of the registered students popped out of the queue
   */
  public void displayList(ArrayList<Student> aList) {
    String selections[] = new String[aList.size()];
    for (int i = 0; i < aList.size(); i++) {
      String student = aList.get(i).toString();
      selections[i] = student;
    }
    String userSelection =
      (String) JOptionPane.showInputDialog(null, "Select critera to sort quotes by:",
                                           "Sort Criteria", JOptionPane.QUESTION_MESSAGE, null,
                                           selections, selections[0]);
    if (userSelection == null) {
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
