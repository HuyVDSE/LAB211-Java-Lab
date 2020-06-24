/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manage;

import java.util.Scanner;

/**
 * this class use to check the input of user
 *
 * @author nhoxr
 */
public class Inputter {

    private static Scanner sc;

    /**
     * this method use to check the semester is valid or not if semester id is
     * positive it will valid
     *
     * @return semester id
     */
    public static int inputSemester() {
	int semesterID = 0;
	boolean valid; //flag to check the semester input is valid or not
	do {
	    try {
		valid = true;
		System.out.print("Enter Semester ID: ");
		sc = new Scanner(System.in);
		semesterID = sc.nextInt();
		if (semesterID < 1) {
		    System.out.println("Semester must be positive!!");
		    valid = false;
		}
	    } catch (Exception e) {
		System.out.println("Semester must be positive!!");
		valid = false;
	    }
	} while (!valid);
	return semesterID;
    }

    /**
     * this method use to check the input student name is valid or not
     *
     * @return Student name
     */
    public static String inputStudentName() {
	String name;
	boolean valid; //flag to check the valid name input
	do {
	    System.out.print("Enter name: ");
	    sc = new Scanner(System.in);
	    name = sc.nextLine();
	    valid = Validation.isValidName(name);
	    if (!valid) {
		System.out.println("Name isn't valid!!");
	    }
	} while (!valid);
	return name;
    }

    /**
     * this method use to check the input id is valid or not
     *
     * @return Student id
     */
    public static String inpuIdStudent() {
	String id;
	boolean valid; //flag to check the valid id input
	do {
	    System.out.print("Enter id: ");
	    sc = new Scanner(System.in);
	    id = sc.nextLine();
	    valid = Validation.isValidStudentID(id);
	    if (!valid) {
		System.out.println("Id isn't valid!!");
	    }
	} while (!valid);
	return id;
    }

    /**
     * this method use to input course and return String course name base on
     * number user input
     * @return String "course name"
     */
    public static String inputCourse() {
	int courseChoice = 0;
	boolean valid; //flag to check the valid course choice input
	do {
	    valid = true;
	    System.out.println("Choice course");
	    System.out.println("1. Java");
	    System.out.println("2. .Net");
	    System.out.println("3. C/C++");
	    System.out.print("Choice: ");
	    try {
		sc = new Scanner(System.in);
		courseChoice = sc.nextInt();

		//check the exception
		if (courseChoice < 1 || courseChoice > 3) {
		    System.out.println("Please choice from 1 to 3!!");
		    valid = false;
		}
	    } catch (Exception e) {
		System.out.println("Not accept character!!");
		valid = false;
	    }
	} while (!valid);

	switch (courseChoice) {
	    case 1:
		return "Java";
	    case 2:
		return ".Net";
	    case 3:
		return "C/C++";
	}
	return null;
    }

}
