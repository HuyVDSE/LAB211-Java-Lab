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
public class Tetrahedron extends ThreeDimentionalShape {

    private double side;

    public Tetrahedron() {
    }

    public Tetrahedron(double side) {
	this.side = side;
    }

    public double getSide() {
	return side;
    }

    public void setSide(double side) {
	this.side = side;
    }

    @Override
    public double getArea() {
	return Math.sqrt(3) * Math.pow(side, 2);
    }

    @Override
    public double getVolume() {
	return Math.pow(side, 3) / (6 * Math.sqrt(2));
    }

    @Override
    public void print() {
	System.out.printf("|Tetrahedron|%6.1f|%6.1f|\n", getArea(), getVolume());
    }
}
