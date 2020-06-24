/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semester;

import course.CourseList;
import java.util.ArrayList;
import java.util.Scanner;
import manage.Inputter;
import manage.Validation;

/**
 *
 * @author nhoxr
 */
public class SemesterManage {

    ArrayList<Semester> seList = new ArrayList<>();

    public int size() {
	return seList.size();
    }
    /**
     * this method use to add Semester to ArrayList and inside a Semester will
     * have course name it will call addCourse() method to do that
     */
    public void addSemester() {
	Scanner sc;
	String userChoice;
	boolean valid;
	do {
	    int semesterID;
	    do {
		semesterID = Inputter.inputSemester();
		valid = Validation.isExistSemester(seList, semesterID);
		//flag will check the semesterID is exist or not => true if exist
	    } while (valid);

	    //add course
	    CourseList courseList = new CourseList();
	    courseList.addCourse();

	    //create a new semester and add to list
	    Semester semester = new Semester(semesterID, courseList);
	    seList.add(semester);

	    //loop check user want to add more Semester or not
	    do {
		System.out.print("Do you want to add more semester(Y/N): ");
		sc = new Scanner(System.in);
		userChoice = sc.nextLine().toUpperCase();
	    } while (!userChoice.equals("Y") && !userChoice.equals("N"));
	} while (userChoice.equals("Y"));
    }

    /**
     * print list semester of student
     */
    public void printSemesterList() {
	for (Semester semester : seList) {
	    System.out.println("Semester id: " + semester.getId());

	    CourseList courseList = semester.getListCourse();
	    courseList.printCourseList();
	}
    }

    /**
     * this method use to search semester based on id semester input.
     *
     * @param semesterId input from user keyboard
     * @return index of semester in the list if found, -1 if not
     */
    public int searchSemester(int semesterId) {
	for (int i = 0; i < seList.size(); i++) {
	    if (seList.get(i).getId() == semesterId) {
		return i;
	    }
	}
	return -1;
    }

    /**
     * this method use to delete semester based on id semester input and it also
     * reuse searchSemester() method to do that work.
     *
     * @param semesterId
     * @return true if searchSemester return index different -1 and it will
     * delete this semester, false if index equal -1
     */
    public boolean deleteSemester(int semesterId) {
	int index = searchSemester(semesterId);
	if (index != -1) {
	    seList.remove(index);
	    return true;
	}
	return false;
    }
    
    /**
     * this method use to search semester base on Id semester input, this method
     * will go through the list and check if the id equal the id input or not.
     * @param semesterId
     * @return Semester if it exist in the list, null or not.
     */
    public Semester searchSemesterById(int semesterId) {
	//a loop for to through the list
	for (Semester semester : seList) {
	    if (semester.getId() == semesterId) {
		return semester;
	    }
	}
	return null;
    }

    public void initSemester(Semester semester) {
	seList.add(semester);
    }
    
    public Semester getSemester(int index) {
	return seList.get(index);
    }
}
