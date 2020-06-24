/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manage;

import java.util.ArrayList;
import java.util.Collections;
import student.StudentManagement;
import java.util.Scanner;
import student.Student;

/**
 *
 * @author nhoxr
 */
public class Main {

    /**
     * this method use to add student to the list, it require user input at
     * least 3 student, it also ask user want to input more.
     *
     * @param studentList
     */
    public void createStudent(StudentManagement studentList) {
	String userChoice = "Y";

	do {
	    System.out.println("");
	    studentList.addStudent();
	    if (studentList.size() >= 2) {
		do {
		    System.out.print("Do you want to add more student(Y/N): ");
		    Scanner sc = new Scanner(System.in);
		    userChoice = sc.nextLine().toUpperCase().trim();
		    //if userChoice != Y and N => return the loop
		} while (!userChoice.equals("Y") && !userChoice.equals("N"));
	    }
	} while (userChoice.equals("Y") || studentList.size() < 2);
    }

    /**
     * this method use to return student list and sort it by ascending Name
     *
     * @param studentList
     * @param name input from user
     */
    public void findAndSort(StudentManagement studentList, String name) {
	ArrayList<Student> listFound = studentList.searchStudentByName(name);
	if (listFound.isEmpty()) {
	    System.out.println("Not have student match!!");
	} else {
	    //sort list found after print to screen
	    Collections.sort(listFound, Student.compareName);
	    for (Student student : listFound) {
		studentList.printStudent(student);
	    }
	}
    }

    public void updateDeleteStudent(StudentManagement studentList, Student selectStudent) {
	Scanner sc;
	String userChoice;

	//loop check if user want to update or delete student
	do {
	    System.out.print("Do you want to Update(U) or Delete(D) this student: ");
	    sc = new Scanner(System.in);
	    userChoice = sc.nextLine().toUpperCase().trim();
	} while (!userChoice.equals("U") && !userChoice.equals("D"));

	//execute code
	if (userChoice.equals("D")) {
	    if (studentList.deleteStudent(selectStudent)) {
		System.out.println("Student is deleted!!");
	    } else {
		System.out.println("Delete failed!!");
	    }
	} else {
	    studentList.updateStudentInfo(selectStudent);
	}
    }

    public static void main(String[] args) {
	Main mainApp = new Main();
	StudentManagement cage = new StudentManagement();
	int userChoice;
	cage.initData(cage);
	do {
	    System.out.println("----STUDENT MANAGEMENT----");
	    userChoice = Menu.menu();
	    switch (userChoice) {
		case 1: //create new student
		    System.out.println("-----Create Student-----");
		    mainApp.createStudent(cage);
		    break;
		case 2: //Find and sort
		    System.out.println("-----Find and Sort-----");
		    System.out.print("Enter name: ");
		    Scanner sc = new Scanner(System.in);
		    String name = sc.nextLine();
		    mainApp.findAndSort(cage, name);
		    break;
		case 3: //update/delete student
		    System.out.println("-----Update/Delete Student-----");
		    String id = Inputter.inpuIdStudent();
		    Student selectStudent = cage.getStudentById(id);
		    if (selectStudent == null) {
			System.out.println("Student not exist!!");
		    } else {
			mainApp.updateDeleteStudent(cage, selectStudent);
		    }
		    break;
		case 4: //print report
		    cage.printReport();
		    break;
		case 5:
		    System.out.println("Good bye!!");
		    break;
	    }
	} while (userChoice != 5);
    }
}
