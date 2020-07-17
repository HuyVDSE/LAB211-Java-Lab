/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyValidation;

import java.util.Scanner;

/**
 *
 * @author nhoxr
 */
public class Inputter {
    
    public static String inputFruitId() {
	Scanner sc;
	String fruitId;
	while (true) {	    
	    try {
		System.out.print("Enter fruit id: ");
		sc = new Scanner(System.in);
		fruitId = sc.nextLine();
		if (!Validation.isValidId(fruitId)) {
		    throw new Exception();
		}
		return fruitId;
	    } catch (Exception e) {
		System.out.println("Not valid fruit ID!!");
	    }
	}
    }
    
    public static String inputName() {
	Scanner sc;
	String fruitName;
	while (true) {	    
	    try {
		System.out.print("Enter Fruit Name: ");
		sc = new Scanner(System.in);
		fruitName = sc.nextLine();
		if (!Validation.isValidName(fruitName)) {
		    throw new Exception();
		}
		return fruitName;
	    } catch (Exception e) {
		System.out.println("Not valid fruit name!!");
	    }
	}
    }
    
    public static String inputFruitPrice() {
	Scanner sc;
	String price;
	while (true) {	    
	    try {
		System.out.print("Enter price: ");
		sc = new Scanner(System.in);
		price = sc.nextLine();
		if (!Validation.isValidPrice(price)) {
		    throw new Exception();
		}
		return price;
	    } catch (Exception e) {
		System.out.println("Not valid price!!");
	    }
	}
    }
    
    public static String inputFruitQuantity() {
	Scanner sc;
	String quantity;
	while (true) {	    
	    try {
		System.out.print("Enter quantity: ");
		sc = new Scanner(System.in);
		quantity = sc.nextLine();
		if (!Validation.isValidQuantity(quantity)) {
		    throw new Exception();
		}
		return quantity;
	    } catch (Exception e) {
		System.out.println("Not valid quantity!!");
	    }
	}
    }
    
    public static String inputFruitOrigin() {
	Scanner sc;
	String origin;
	while (true) {	    
	    try {
		System.out.print("Enter Fruit Origin: ");
		sc = new Scanner(System.in);
		origin = sc.nextLine();
		if (!Validation.isValidOrigin(origin)) {
		    throw new Exception();
		}
		return origin;
	    } catch (Exception e) {
		System.out.println("Not valid origin name!!");
	    }
	}
    }
    
    public static String inputNumber() {
	Scanner sc;
	String num;
	while (true) {	    
	    try {
		System.out.print("Enter number: ");
		sc = new Scanner(System.in);
		num = sc.nextLine();
		if (!Validation.isValidQuantity(num)) {
		    throw new Exception();
		}
		return num;
	    } catch (Exception e) {
		System.out.println("Not valid number!!");
	    }
	}
    }
//    public static void main(String[] args) {
//	String id = Inputter.inputFruitPrice();
//	System.out.println(id);
//    }
}
