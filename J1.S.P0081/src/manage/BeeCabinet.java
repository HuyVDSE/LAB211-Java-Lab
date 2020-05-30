/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manage;

import data.*;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author nhoxr
 */
public class BeeCabinet {

    ArrayList<Bee> beeList = new ArrayList<>();
    ArrayList<HistoryDamage> dmgHistory = new ArrayList<>();

    public void createBeeList() {
	beeList.clear();
	dmgHistory.clear();
	Bee bee;
	int point = 100, kind;
	for (int i = 0; i < 10; i++) {
	    Random ranBee = new Random();
	    kind = ranBee.nextInt(3);
	    switch (kind) {
		case 1:
		    //kind = 1: create Drone Bee
		    beeList.add(new Drone(point, "DRONE"));
		case 2:
		    //kind = 2: create Queen Bee
		    beeList.add(new Queen(point, "QUEEN"));
		case 3:
		    //kind = 3: create Worker Bee
		    beeList.add(new Worker(point, "WORKER"));
	    }
	}
	for (int i = 0; i < 10; i++) {
	    bee = beeList.get(i);
	    dmgHistory.add(new HistoryDamage(bee, "ALIVE", 100));
	}
	printHistoryDmg();
    }

    public void damageBee() {
	Bee bee;
	int currentPoint;
	for (int i = 0; i < 10; i++) {
	    bee = beeList.get(i);
	    currentPoint = bee.damage();
	    dmgHistory.get(i).setCurrentPoint(currentPoint);
	    if (bee.getKind().equalsIgnoreCase("DRONE") && currentPoint < 70) {
		dmgHistory.get(i).setStatus("DEAD");
	    }
	    if (bee.getKind().equalsIgnoreCase("QUEEN") && currentPoint < 20) {
		dmgHistory.get(i).setStatus("DEAD");
	    }
	    if (bee.getKind().equalsIgnoreCase("WORKER") && currentPoint < 50) {
		dmgHistory.get(i).setStatus("DEAD");
	    }
	}
    }

    public void printHistoryDmg() {
	for (HistoryDamage x : dmgHistory) {
	    x.printHistoryDamge();
	}
    }
}
