/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

import course.CourseList;
import java.util.ArrayList;
import manage.Inputter;
import manage.Menu;
import manage.Validation;
import semester.Semester;
import semester.SemesterManage;

/**
 *
 * @author nhoxr
 */
public class StudentManagement {

    ArrayList<Student> stuList = new ArrayList<>(); //create a list to store student

    /**
     * this method use to return number of element of student list
     *
     * @return size of the list
     */
    public int size() {
	return stuList.size();
    }

    public void addStudent() {
	boolean isExist; //flag to know the student is exist or not
	String id;

	do {
	    id = Inputter.inpuIdStudent();
	    isExist = Validation.isExistStudent(stuList, id);
	    if (isExist) {
		System.out.println("Student is exist!!");
	    }
	    if (!Validation.isValidStudentID(id)) {
		System.out.println("ID student is not valid!!");
	    }
	} while (isExist || Validation.isValidStudentID(id) == false);
	//neu hoc sinh da ton tai hoac Id ko hop le => loop

	String name = Inputter.inputStudentName();

	//create semester for student
	SemesterManage semester = new SemesterManage();
	semester.addSemester();

	//create new student 
	Student s = new Student(id, name, semester);
	stuList.add(s);
    }

    /**
     * this method use to search student by name input, regardless of uppercase
     * or lowercase letters
     *
     * @param name
     * @return list of student found
     */
    public ArrayList<Student> searchStudentByName(String name) {
	ArrayList<Student> listStudentFound = new ArrayList<>();
	for (Student s : stuList) {
	    if (s.getName().toLowerCase().contains(name)) {
		listStudentFound.add(s);
	    } else if (s.getName().toUpperCase().contains(name)) {
		listStudentFound.add(s);
	    }
	}
	return listStudentFound;
    }

    /**
     * this method use to delete student based on object student parameter
     *
     * @param student
     * @return true if have student, false if null
     */
    public boolean deleteStudent(Student s) {
	return stuList.remove(s);
    }

    /**
     * this method will go through the list, if student id equal id input =>
     * return this student, if not return null
     *
     * @param id
     * @return student object, null if not exist in list
     */
    public Student getStudentById(String id) {
	for (Student student : stuList) {
	    if (student.getId().equalsIgnoreCase(id)) {
		return student;
	    }
	}
	return null;
    }

    /**
     * this method use to print student info, include Id, Name, Semester list
     * and also course name in every semester of student.
     *
     * @param student
     */
    public void printStudent(Student student) {
	System.out.println("ID: " + student.getId() + ", Name: " + student.getName());

	//traverse semester studentList to print each semester
	SemesterManage semesterList = student.getSemesterList();
	semesterList.printSemesterList();
    }

    /**
     * this method use to update Student info include Name, add/delete semester,
     * add/delete course based on student object
     *
     * @param student
     */
    public void updateStudentInfo(Student student) {
	int userChoice;

	do {
	    //print student info
	    System.out.println("");
	    printStudent(student);

	    //print update menu
	    userChoice = Menu.updateMenu();
	    boolean isDelete; //flag to check the semester is deleted or not
	    int semesterId; //variable to use in func 3, 4, 5
	    Semester selectSemester;

	    switch (userChoice) {
		case 1: //update student name
		    String name = Inputter.inputStudentName();
		    student.setName(name);
		    System.out.println("Updated!");
		    break;
		case 2: //add semester
		    student.getSemesterList().addSemester();
		    break;
		case 3: //delete semester
		    semesterId = Inputter.inputSemester();
		    //true if student has this semester, false if not
		    isDelete = student.getSemesterList().deleteSemester(semesterId);
		    if (isDelete) {
			System.out.println("Semester is deleted!");
		    } else {
			System.out.println(student.getName() + " hasn't learned this semester!!");
		    }
		    break;
		case 4: //add course
		    semesterId = Inputter.inputSemester();
		    //this var will receive the semester of this student based on id semester input
		    selectSemester = student.getSemesterList().searchSemesterById(semesterId);
		    if (selectSemester != null) {
			selectSemester.getListCourse().addCourse();
		    } else {
			System.out.println(student.getName() + " hasn't learned this semester!!");
		    }
		    break;
		case 5: //delete course
		    semesterId = Inputter.inputSemester();
		    //this var will receive the semester of this student based on id semester input
		    selectSemester = student.getSemesterList().searchSemesterById(semesterId);
		    if (selectSemester != null) {
			String courseName = Inputter.inputCourse();
			isDelete = selectSemester.getListCourse().deleteCourse(courseName);
			if (isDelete) {
			    System.out.println("Course is deleted!");
			} else {
			    System.out.println(student.getName() + " hasn't learned this course!!");
			}
		    } else {
			System.out.println(student.getName() + " hasn't learned this semester!!");
		    }
		    break;
	    }
	} while (userChoice != 6);
    }

    public void printReport() {
	int javaCount, netCount, cCount;
	//loop go through the student list and get one by one student
	for (int i = 0; i < stuList.size(); i++) {
	    javaCount = netCount = cCount = 0; //set default value
	    Student student = stuList.get(i);
	    SemesterManage semesterList = student.getSemesterList();
	    //loop go through the semester list => single Student have many Semesters
	    for (int j = 0; j < semesterList.size(); j++) {
		Semester semester = semesterList.getSemester(j);
		CourseList courseList = semester.getListCourse();
		//loop go through the course list => single Semester have many Courses
		for (int k = 0; k < courseList.size(); k++) {
		    String courseName = courseList.getCourse(k);
		    switch (courseName) {
			case "Java":
			    javaCount++;
			    break;
			case ".Net":
			    netCount++;
			    break;
			case "C/C++":
			    cCount++;
			    break;
		    }
		}
	    }
	    if (javaCount > 0) {
		System.out.printf("%-10s | %-20s | Java | %d\n", student.getId(), student.getName(), javaCount);
	    }
	    if (netCount > 0) {
		System.out.printf("%-10s | %-20s | .NET | %d\n", student.getId(), student.getName(), netCount);
	    }
	    if (cCount > 0) {
		System.out.printf("%-10s | %-20s | C/C++ | %d\n", student.getId(), student.getName(), cCount);
	    }
	}
    }

    public void initStudent(Student s) {
	stuList.add(s);
    }
    
    /**
     * this method use to import data to student list
     * @param studentList 
     */
    public void initData(StudentManagement studentList) {
	CourseList course1 = new CourseList();
	course1.initCourse();
	Semester semester1 = new Semester(1, course1);
	SemesterManage seList1 = new SemesterManage();
	seList1.initSemester(semester1);
	Student s1 = new Student("SE001", "Le Anh Khoa", seList1);
	studentList.initStudent(s1);
	CourseList course2 = new CourseList();
	course2.initCourse();
	Semester semester2 = new Semester(2, course2);
	SemesterManage seList2 = new SemesterManage();
	seList2.initSemester(semester2);
	Student s2 = new Student("SE002", "Hoang Van Truong", seList2);
	studentList.initStudent(s2);
    }
}
