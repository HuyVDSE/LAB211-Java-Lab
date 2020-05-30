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
public class Square extends TwoDementionalShape {

    private double edge;

    public Square(double edge) {
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
	return edge * edge;
    }

    @Override
    public void print() {
	System.out.printf("|Square     |%6.1f|\n", getArea());
    }
}
