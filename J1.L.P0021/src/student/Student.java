/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

import java.util.Comparator;
import semester.SemesterManage;

/**
 *
 * @author nhoxr
 */
public class Student {

    private String id;
    private String name;
    private SemesterManage semesterList;

    public Student(String id, String name, SemesterManage semesterList) {
	this.id = id;
	this.name = name;
	this.semesterList = semesterList;
    }

    public Student(String id, String name) {
	this.id = id;
	this.name = name;

    }

    public String getId() {
	return id;
    }

    public void setId(String id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public SemesterManage getSemesterList() {
	return semesterList;
    }

    public void setSemester(SemesterManage semesterList) {
	this.semesterList = semesterList;
    }

    /**
     * this method use to compare student by their name and this will sort by
     * ascending name. ex: a->z
     */
    public static Comparator<Student> compareName = new Comparator<Student>() {
	@Override
	public int compare(Student s1, Student s2) {
	    if (s1.getName().compareTo(s2.getName()) > 0) {
	    //ham compareTo() dung de so sanh 2 String voi nhau
		return 1;//1 la thay doi vi tri
	    } else if (s1.getName().compareTo(s2.getName()) == 0) {
		return 0;//0 la giu nguyen
	    }
	    return -1;//-1 ko thay doi vi tri
	}
    };

}
