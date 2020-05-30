/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreeDimentional;

/**
 *
 * @author nhoxr
 */
public class Sphere extends ThreeDimentionalShape {

    private double radius;

    public Sphere() {
    }

    public Sphere(double radius) {
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
	return 4 * Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double getVolume() {
	return (4 / 3) * Math.PI * Math.pow(radius, 3);
    }

    @Override
    public void print() {
	System.out.printf("|Sphere     |%6.1f|%6.1f|\n", getArea(), getVolume());
    }
}
