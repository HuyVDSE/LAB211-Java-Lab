/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InputAndCheck;

import java.util.Scanner;

/**
 *
 * @author nhoxr
 */
public class Input {

    public static String inputID() {
	String id;
	boolean isValid = true;
	do {
	    isValid = true;
	    System.out.print("Enter id: ");
	    Scanner sc = new Scanner(System.in);
	    id = sc.nextLine().toUpperCase();
	    isValid = Valid.isValidID(id);
	    if (!isValid) {
		System.out.println("Only allow alphabet and number!!");
	    }
	} while (!isValid);
	return id;
    }

    public static String inputName() {
	String name;
	boolean isValid = true;
	do {
	    isValid = true;
	    System.out.print("Enter name: ");
	    Scanner sc = new Scanner(System.in);
	    name = sc.nextLine().toUpperCase();
	    isValid = Valid.isValidName(name);
	    if (!isValid) {
		System.out.println("Only allow alphabet!!");
	    }
	} while (!isValid);
	return name;
    }

    public static String inputLocation() {
	String location;
	boolean isValid = true;
	do {
	    isValid = true;
	    System.out.print("Enter location: ");
	    Scanner sc = new Scanner(System.in);
	    location = sc.nextLine().toUpperCase();
	    isValid = Valid.isValidLocation(location);
	    if (!isValid) {
		System.out.println("Only allow alphabet, number and symbol!!");
	    }
	} while (!isValid);
	return location;
    }

    public static int inputSalary() {
	int salary = 0;
	boolean validSalary = true;
	do {
	    System.out.print("Enter salary: ");
	    Scanner sc = new Scanner(System.in);
	    try {
		salary = sc.nextInt();
		validSalary = Valid.isValidSalary(salary);
		if (!validSalary) {
		    System.out.println("Salary must be positive!!");
		}
	    } catch (Exception e) {
		System.out.println("Salary must be number!!");
		validSalary = false;
	    }
	} while (!validSalary);
	return salary;
    }

    public static int inputAge() {
	int age = 0;
	boolean validAge = true;
	do {
	    System.out.print("Enter age: ");
	    Scanner sc = new Scanner(System.in);
	    try {
		age = sc.nextInt();
		validAge = Valid.isValidAge(age);
		if (!validAge) {
		    System.out.println("Age must between 18 and 50!!");
		}
	    } catch (Exception e) {
		System.out.println("Age must be number!!");
		validAge = false;
	    }
	} while (!validAge);
	return age;
    }

    public static int getAChoice(String msg, String errorMsg) {
	int choice = 0;
	Scanner sc = new Scanner(System.in);
	do {
	    System.out.print(msg);
	    try {
		choice = Integer.parseInt(sc.nextLine());
		if (choice <= 0 && choice > 5) {
		    System.out.println(errorMsg);
		} else {
		    return choice;
		}
	    } catch (Exception e) {
		System.out.println(errorMsg);
	    }
	} while (true);
    }
}
