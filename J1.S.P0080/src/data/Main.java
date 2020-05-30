/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import ThreeDimentional.*;
import TwoDementional.*;

/**
 *
 * @author nhoxr
 */
public class Main {

    public static void main(String[] args) {
	System.out.println("J1.S.P0080: 60 Points\n");
	createShapeData();
    }

    public static void createShapeData() {
	Shape dsShape[] = new Shape[8];
	dsShape[0] = new Circle(5);
	dsShape[1] = new Square(4);
	dsShape[2] = new Triangle(3, 4, 5);
	dsShape[3] = new Cube(7);
	dsShape[4] = new Sphere(6);
	dsShape[5] = new Tetrahedron(8);
	dsShape[6] = new Cube(6);
	dsShape[7] = new Sphere(4);

	System.out.println("Shape Information");
	System.out.println("|Shape      |Area  |Volume|");
	for (Shape x : dsShape) {
	    x.print();
	}
    }
}
