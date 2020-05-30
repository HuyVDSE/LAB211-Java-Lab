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
public class Cube extends ThreeDimentionalShape {

    private double edge;

    public Cube() {
    }

    public Cube(double edge) {
	this.edge = edge;
    }

    public double getEdge() {
	return edge;
    }

    public void setEdge(double edge) {
	this.edge = edge;
    }

    @Override
    public double getArea() {
	return 6 * Math.pow(edge, 2);
    }

    @Override
    public double getVolume() {
	return Math.pow(edge, 3);
    }

    @Override
    public void print() {
	System.out.printf("|Cube       |%6.1f|%6.1f|\n", getArea(), getVolume());
    }
}
