package data;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author nhoxr
 */
public abstract class Bee {

    protected int healthPoint;
    protected String kind;

    public Bee(int healthPoint, String kind) {
	this.healthPoint = healthPoint;
	this.kind = kind;
    }

    public String getKind() {
	return kind;
    }

    public void setKind(String kind) {
	this.kind = kind;
    }

    public int getHealthPoint() {
	return healthPoint;
    }

    public void setHealthPoint(int healthPoint) {
	this.healthPoint = healthPoint;
    }

    public abstract int damage();
}
