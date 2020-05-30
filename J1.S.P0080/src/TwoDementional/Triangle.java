/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TwoDementional;

/**
 *
 * @author nhoxr
 */
public class Triangle extends TwoDementionalShape {

    private double a;
    private double b;
    private double c;

    public Triangle() {
    }

    public Triangle(double a, double b, double c) {
	this.a = a;
	this.b = b;
	this.c = c;
    }

    public double getA() {
	return a;
    }

    public void setA(double a) {
	this.a = a;
    }

    public double getB() {
	return b;
    }

    public void setB(double b) {
	this.b = b;
    }

    public double getC() {
	return c;
    }

    public void setC(double c) {
	this.c = c;
    }

    @Override
    public double getArea() {
	double s, area = 0;
	if ((a + b) > c && (a + c) > b && (c + b) > a) {
	    s = (a + b + c) / 2;
	    area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
	} else {
	    System.out.println("Triangle Area not exist!!");
	}
	return area;
    }

    @Override
    public void print() {
	System.out.printf("|Triangle   |%6.1f|\n", getArea());
    }
}
