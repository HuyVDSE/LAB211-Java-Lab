/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semester;

import course.CourseList;

/**
 *
 * @author nhoxr
 */
public class Semester {
    private int id;
    private CourseList listCourse;

    public Semester(int id, CourseList listCourse) {
	this.id = id;
	this.listCourse = listCourse;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public CourseList getListCourse() {
	return listCourse;
    }

    public void setListCourse(CourseList listCourse) {
	this.listCourse = listCourse;
    }
}
