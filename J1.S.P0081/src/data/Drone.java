/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.Random;

/**
 *
 * @author nhoxr
 */
public class Drone extends Bee {

    public Drone(int healthPoint, String kind) {
	super(healthPoint, kind);
    }

    @Override
    public int damage() {
	Random ranDamage = new Random();
	int max = 80;
	int min = 0;
	int currentPoint = healthPoint - ranDamage.nextInt((max - min) + 1);
	return currentPoint;
    }
}
