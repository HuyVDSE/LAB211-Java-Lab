/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manage;

import student.Student;
import java.util.ArrayList;
import semester.Semester;

/**
 *
 * @author nhoxr
 */
public class Validation {

    /**
     * this method use to check the student is exist in the list or not
     *
     * @param list
     * @param id
     * @return true if exist, false if not
     */
    public static boolean isExistStudent(ArrayList<Student> list, String id) {
	if (list.isEmpty()) {
	    return false;
	}
	for (int i = 0; i < list.size(); i++) {
	    if (list.get(i).getId().equalsIgnoreCase(id)) { //kt String ko phan biet hoa thuong
		return true;
	    }
	}
	return false;
    }

    /**
     * this method use to check the course is exist in the list or not
     *
     * @param list
     * @param courseName
     * @return true if exist, false if not
     */
    public static boolean isExistCourse(ArrayList<String> list, String courseName) {
	if (list.isEmpty()) {
	    return false;
	}
	for (int i = 0; i < list.size(); i++) {
	    if (list.get(i).equals(courseName)) {
		return true;
	    }
	}
	return false;
    }

    /**
     * this method use to check the semester is exist in the list or not
     *
     * @param seList
     * @param semesterId
     * @return
     */
    public static boolean isExistSemester(ArrayList<Semester> seList, int semesterId) {
	if (seList.isEmpty()) {
	    return false;
	}
	for (int i = 0; i < seList.size(); i++) {
	    if (seList.get(i).getId() == semesterId) {
		return true;
	    }
	}
	return false;
    }

    /**
     * this method use to check the name is valid or not base on Regex String
     * check
     *
     * @param name
     * @return true if match, false or not
     */
    public static boolean isValidName(String name) {
	if (name.isEmpty()) {
	    return false;
	}
	return name.matches("^[a-zA-Z\\s]*$");
	//^: begin String, $: end String
	//a-z: lower case from a to z
	//A-Z: upper case from A to Z
	//*: one or more character match
	//'\\s': accept the space in String
    }

    /**
     * this method use to check the id is valid or not base on Regex String
     * check
     *
     * @param id
     * @return true if match, false or not
     */
    public static boolean isValidStudentID(String id) {
	if (id.isEmpty()) {
	    return false;
	}
	return id.matches("^[a-zA-Z0-9]*$");
	//^: begin String, $: end String
	//a-z: lower case from a to z
	//A-Z: upper case from A to Z
	//0-9: character from 0 to 9
	//*: one or more character match
    }

    /**
     * this method use to check
     *
     * @param courseList
     * @return
     */
    public static boolean isFullCourse(ArrayList<String> courseList) {
	return courseList.size() == 3;
    }

//    public static void main(String[] args) {
//	String name = "Van Duc Huy";
//	System.out.println(isValidName(name));
//	String num = "012398345475";
//	System.out.println(isValidStudentID(num));
//    }
}
