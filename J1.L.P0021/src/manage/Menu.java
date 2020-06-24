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
public class Menu {

    /**
     * menu view method
     *
     * @return choice number
     */
    public static int menu() {
	int choice = 0;
	boolean valid; //flag to check valid input
	do {
	    valid = true; //reset the flag in the loop
	    System.out.println("\n1. Create Student");
	    System.out.println("2. Find/Sort Student");
	    System.out.println("3. Update/Delete Student");
	    System.out.println("4. Report");
	    System.out.println("5. Exit");
	    System.out.print("Choice: ");
	    try {
		Scanner sc = new Scanner(System.in);
		choice = sc.nextInt();
	    } catch (Exception e) {
		System.out.println("Not accept character!!");
		valid = false;
	    }
	} while (!valid || choice < 1 || choice > 5);
	return choice;
    }

    /**
     * update menu view method
     *
     * @return choice number
     */
    public static int updateMenu() {
	int choice = 0;
	boolean valid; //flag to check valid input
	do {
	    valid = true; //reset the flag in the loop
	    System.out.println("\n1. Update name");
	    System.out.println("2. Add semester");
	    System.out.println("3. Delete semester");
	    System.out.println("4. Add course");
	    System.out.println("5. Delete course");
	    System.out.println("6. Back to main menu");
	    System.out.print("Choice: ");
	    try {
		Scanner sc = new Scanner(System.in);

		choice = sc.nextInt();
	    } catch (Exception e) {
		System.out.println("Not accept character!!");
		valid = false;
	    }
	} while (!valid || choice < 1 || choice > 6);
	return choice;
    }
}
