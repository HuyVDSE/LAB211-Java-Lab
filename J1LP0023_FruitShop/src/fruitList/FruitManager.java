/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fruitList;

import MyValidation.Inputter;
import MyValidation.Validation;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author nhoxr
 */
public class FruitManager extends ArrayList<Fruit> {

    /**
     * this method use to add fruit to list
     */
    public void addFruit() {
	Scanner sc;
	String id, name, origin, userChoice, quantity, price;
	boolean isExist;
	do {
	    //check exist ID fruit
	    do {
		id = Inputter.inputFruitId();
		isExist = Validation.isExistFruitId(id, this);
	    } while (isExist);

	    //input other fruits info
	    name = Inputter.inputName();
	    price = Inputter.inputFruitPrice();
	    quantity = Inputter.inputFruitQuantity();
	    origin = Inputter.inputFruitOrigin();

	    //create fruit object
	    Fruit fruit = new Fruit(id, name, Long.parseLong(price), Integer.parseInt(quantity), origin);
	    //add this obj to list
	    this.add(fruit);

	    //ask user want to add more fruits
	    do {
		System.out.print("Do you want to continue(Y/N): ");
		sc = new Scanner(System.in);
		userChoice = Character.toString(sc.nextLine().charAt(0)).toUpperCase();
	    } while (!userChoice.equals("Y") && !userChoice.equals("N"));
	} while (userChoice.equals("Y"));
    }

    /**
     * this method will go through the list and get id of fruit one by one, if
     * id input exist in list return true else return false.
     *
     * @param id
     * @return true if exist, false if not.
     */
    public boolean findFruitById(String id) {
	for (Fruit fruit : this) {
	    if (fruit.getId().equalsIgnoreCase(id)) {
		return true;
	    }
	}
	return false;
    }

    /**
     * this method use to find fruit in list by id
     *
     * @param id
     * @return fruit if exist, null if not.
     */
    public Fruit findFruit(String id) {
	for (Fruit x : this) {
	    if (x.getId().equalsIgnoreCase(id)) {
		return x;
	    }
	}
	return null;
    }

//    /**
//     * this method use to display fruit to user screen
//     */
//    public void display() {
//	if (this.isEmpty()) {
//	    System.out.println("Fruits list is empty!!");
//	} else {
//	    System.out.println("|ID        |Name        |Origin    |Quantity|    Price    |");
//	    for (Fruit f : this) {
//		System.out.printf("|%-10s|%-12s|%-10s|%-8d|%10dVND|\n",
//			f.getId(), f.getName(), f.getOrigin(), f.getPrice(), f.getQuantity());
//	    }
//	}
//    }

    /**
     * this method use to display fruit list for customer choose
     *
     * @return list of available fruit in shop
     */
    public ArrayList<Fruit> displayForCustomer() {
	ArrayList<Fruit> listTemp = new ArrayList<>();
	//neu danh sach fruit hien tai trong thi tra ve list tam empty
	if (this.isEmpty()) {
	    return listTemp;
	} else {
	    System.out.println("|ID        |Name        |Origin    |Quantity|    Price    |");
	    //set ID for list
	    int item = 1;
	    for (int i = 0; i < this.size(); i++) {
		Fruit tmp = this.get(i);
		//kt xem trong list co san pham vao co so luong > 0 de them vao list
		if (tmp.getQuantity() > 0) {
		    listTemp.add(tmp);
		    System.out.printf("|%-10s|%-12s|%-10s|%-8d|%10dVND|\n",
			    item++, tmp.getName(),tmp.getOrigin(), tmp.getQuantity(), tmp.getPrice());
		}
	    }
	}
	return listTemp;
    }

    public void initData() {
	this.add(new Fruit("1", "Coconut", 1000, 100, "Vietnam"));
	this.add(new Fruit("2", "Orange", 3000, 150, "US"));
	this.add(new Fruit("3", "Apple", 1500, 80, "Thailand"));
	this.add(new Fruit("4", "Grape", 4200, 20, "France"));
    }

//    public static void main(String[] args) {
//	FruitManager cage = new FruitManager();
//	cage.initData();
//	ArrayList<Fruit> tmp = cage.displayForCustomer();
////	cage.display();
//    }
}
