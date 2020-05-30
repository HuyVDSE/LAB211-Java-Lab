/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manage;

import java.util.Scanner;

/**
 *
 * @author nhoxr
 */
public class main {

    public static void main(String[] args) {
	BeeCabinet cage = new BeeCabinet();
	Scanner sc = new Scanner(System.in);
	int choice = 0;
	do {
	    System.out.println("----BEE----");
	    System.out.println("1. Create new bee list.");
	    System.out.println("2. Damage bee.");
	    System.out.println("3. Quit");
	    System.out.print("Choice: ");
	    try {
		choice = Integer.parseInt(sc.nextLine());
	    } catch (Exception e) {
		System.out.println("Wrong format");
	    }
	    switch (choice) {
		case 1:
		    cage.createBeeList();
		    break;
		case 2:
		    cage.damageBee();
		    cage.printHistoryDmg();
		    break;
	    }
	} while (choice != 3);
    }
}
