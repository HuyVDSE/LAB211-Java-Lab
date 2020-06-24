/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course;

import java.util.ArrayList;
import java.util.Scanner;
import manage.Validation;

/**
 *
 * @author nhoxr
 */
public class CourseList {

    private ArrayList<String> courseList;

    public CourseList() {
	courseList = new ArrayList<>();
    }

    public ArrayList<String> getList() {
	return courseList;
    }

    public void setList(ArrayList<String> list) {
	this.courseList = list;
    }

    public int size() {
	return courseList.size();
    }

    public int searchCourse(String courseName) {
	for (int i = 0; i < courseList.size(); i++) {
	    if (courseList.get(i).equals(courseName)) {
		return i;
	    }
	}
	return -1;
    }

    /**
     * this method use to change number(from 1 to 3) to <String> course name.
     *
     * @param id
     * @return course name, if user enter number out of range => return null
     */
    public String courseMapping(int id) {
	switch (id) {
	    case 1:
		return "Java";
	    case 2:
		return ".Net";
	    case 3:
		return "C/C++";
	}
	return null;
    }

    /**
     * this method use to add course and help user input more base on they type
     * Y(Yes) or N(No).
     */
    public void addCourse() {
	Scanner sc = new Scanner(System.in);
	boolean valid; //flag to check validation
	int courseChoice = 0;
	char addMore = 'N';
	do {
	    do {
		valid = true; //reset valid flag
		System.out.println("Choose course:");
		System.out.println("1. Java");
		System.out.println("2. .NET");
		System.out.println("3. C/C++");
		System.out.print("Your choice: ");
		try {
		    sc = new Scanner(System.in);
		    courseChoice = sc.nextInt();

		    if (courseChoice < 1 || courseChoice > 3) {
			throw new Exception("Choice is out of range!!");
		    } //if course is not valid, check by isExistCourse method => true if already learn
		    else if (Validation.isExistCourse(courseList, courseMapping(courseChoice)) == true) {
			throw new Exception("Already learn!!");
		    }
		} catch (Exception e) {
		    if (e.toString().contains("Choice is out of range!!")) {
			System.out.println("Please choose from 1 to 3");
		    } else if (e.toString().contains("Already learn")) {
			System.out.println("Already learn this course in this semester");
		    } else {
			System.out.println("Not accept character!!");
		    }
		    valid = false;
		}
	    } while (!valid);

	    //mapping the choice to course and add to the courseList
	    courseList.add(courseMapping(courseChoice));

	    //do add more course
	    do {
		System.out.print("Do you want to add more course(Y/N): ");
		sc = new Scanner(System.in);
		addMore = sc.next().charAt(0); //check the character at pos 1
		addMore = Character.toUpperCase(addMore);
	    } while (addMore != 'N' && addMore != 'Y'); //if the character different
							//two character N or Y, loop again

	    //check if the list has all course
	    if (Validation.isFullCourse(courseList) && addMore == 'Y') {
		System.out.println("Your are learn all course of this semester!!");
		addMore = 'N';
	    }
	} while (addMore == 'Y');
    }

    /**
     * this method use to delete the course based on name Course input.
     * @param course name
     * @return true if in the list has this course, false if not.
     */
    public boolean deleteCourse(String course) {
	int pos = searchCourse(course);
	if (pos != -1) {
	    courseList.remove(pos);
	    return true;
	}
	return false;
    }

    /**
     * this method will go through the course List and print all the course
     */
    public void printCourseList() {
	for (int i = 0; i < courseList.size(); i++) {
	    String course = courseList.get(i);
	    System.out.println(course + "\t");
	}
	System.out.println("");
    }

    public void initCourse() {
	courseList.add("Java");
	courseList.add(".Net");
    }
    
    /**
     * replace getIndex of ArrayList
     * @param index
     * @return Course name at index.
     */
    public String getCourse(int index) {
	return courseList.get(index);
    }
    
}
