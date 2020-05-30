/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author nhoxr
 */
public class HistoryDamage {
    private Bee bee;
    private String status;
    private int currentPoint;

    public HistoryDamage(Bee bee, String status, int currentPoint) {
	this.bee = bee;
	this.status = status;
	this.currentPoint = currentPoint;
    }

    public Bee getBee() {
	return bee;
    }

    public void setBee(Bee bee) {
	this.bee = bee;
    }

    public String getStatus() {
	return status;
    }

    public void setStatus(String status) {
	this.status = status;
    }

    public int getCurrentPoint() {
	return currentPoint;
    }

    public void setCurrentPoint(int currentPoint) {
	this.currentPoint = currentPoint;
    }

    public void printHistoryDamge() {
	System.out.printf("|%-6s|%6d|%5s|\n", bee.getKind(), currentPoint, status);
    }
}
