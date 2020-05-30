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
public class Circle extends TwoDementionalShape {

    private double radius;

    public Circle(double radius) {
	this.radius = radius;
    }

    public double getRadius() {
	return radius;
    }

    public void setRadius(double radius) {
	this.radius = radius;
    }

    @Override
    public double getArea() {
	return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public void print() {
	System.out.printf("|Circle     |%6.1f|\n", getArea());
    }
}
