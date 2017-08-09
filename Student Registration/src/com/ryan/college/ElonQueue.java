

/**
 * ElonQueue.java 1.0 Apr 16, 2017
 *
 * Copyright (c) 2017 Ryan Lehman All Rights Reserved
 */
package com.ryan.college;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * A Queue class that implements a customized queue with add and offer methods manuplicted
 *
 * @author Ryan Lehman
 * 
 * @version 1.0
 *
 */
public class ElonQueue extends LinkedList<Student> {

  /**
   * Creates constructors
   *
   */
  public ElonQueue() {
    // don't need
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.util.LinkedList#add(java.lang.Object)
   */
  @Override
  public boolean add(Student aE) {
    int counter = 0;

    int indexCounter = this.size();

    ListIterator<Student> studentIterator = this.listIterator(this.size());
    try {
      if (indexCounter == 0) {

        add(indexCounter, aE);

        return true;
      }
      while (studentIterator.hasPrevious()) {

        Student movingStudent = studentIterator.previous();

        if (aE.getYear() == movingStudent.getYear()) {

          add(indexCounter, aE);
          return true;
        }

        indexCounter--;
      }
      if (counter == 0) {
        indexCounter = this.size();
        add(indexCounter, aE);
        return true;
      }

    } catch (RuntimeException e) {
      e.printStackTrace();
    }
    return true;
  }

  @Override
  public boolean offer(Student aE) {
    int counter = 0;
    int indexCounter = this.size();

    ListIterator<Student> studentIterator = this.listIterator(this.size());

    if (indexCounter == 0) {

      add(indexCounter, aE);

      return true;
    }
    while (studentIterator.hasPrevious()) {

      Student movingStudent = studentIterator.previous();

      if (aE.getYear() == movingStudent.getYear()) {

        add(indexCounter, aE);
        return true;
      }

      indexCounter--;
    }
    if (counter == 0) {
      indexCounter = this.size();
      add(indexCounter, aE);
      return true;
    }
    return false;
  }

}
