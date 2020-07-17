/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShoppingList;

import MyValidation.Inputter;
import fruitList.Fruit;
import fruitList.FruitManager;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author nhoxr
 */
public class ListOrder extends ArrayList<Fruit> {

    public void addOrder(FruitManager fruitList) {
	int choice;
	int quantity;
	String yesOrNo;
	boolean isValid;

	Scanner sc = new Scanner(System.in);

	do {
	    //print list fruit available for customer
	    ArrayList<Fruit> listFruitAvailable = fruitList.displayForCustomer();
	    if (listFruitAvailable.isEmpty()) {
		System.out.println("Out of fruits!!");
		return;
	    }

	    //check if user choose wrong index of Item in list fruit
	    do {
		choice = Integer.parseInt(Inputter.inputNumber());
		if (choice > listFruitAvailable.size() || choice <= 0) {
		    System.out.println("Your choose isn't correct!!");
		    isValid = false;
		} else {
		    isValid = true;
		}
	    } while (!isValid);

	    //because the list is print from 1 so choice index must be - 1
	    Fruit fruit = listFruitAvailable.get(choice - 1);
	    //print fruit have choose
	    System.out.println("Your selected: " + fruit.getName());

	    //a loop for user input quantity to buy
	    do {
		quantity = Integer.parseInt(Inputter.inputFruitQuantity());
		//if quantity user input large than available quantity => input again =))
		if (quantity > fruit.getQuantity()) {
		    System.out.println("Please input lower or equal quantity of this fruit!!");
		    isValid = false;
		} else {
		    isValid = true;
		}
	    } while (!isValid);

	    //check the fruit is exist in list or not
	    int pos = findFruitById(fruit.getId());
	    if (pos > -1) { //if this fruit exist in the list => update the quantity
		Fruit fruitExisted = this.get(pos);
		fruitExisted.setQuantity(fruitExisted.getQuantity() + quantity);
	    } else { //add this fruit to list
		this.add(new Fruit(fruit.getId(), fruit.getName(), fruit.getPrice(), quantity, fruit.getOrigin()));
	    }

	    //set the quantity again in the main fruit list
	    //change quantity through find id function in master list
	    Fruit fruitTmp = fruitList.findFruit(fruit.getId());
	    fruitTmp.setQuantity(fruitTmp.getQuantity() - quantity);

	    //continue loop
	    //ask user want to buy more fruit
	    do {
		System.out.print("Do you want to order now(Y/N): ");
		yesOrNo = Character.toString(sc.nextLine().charAt(0)).toUpperCase();
		//prevent user input wrong
		//if not equal alert user and ask to input again
		if (!yesOrNo.equals("Y") && !yesOrNo.equals("N")) {
		    System.out.println("Y or N, y or n only");
		}
	    } while (!yesOrNo.equals("Y") && !yesOrNo.equals("N"));
	} while (yesOrNo.equals("N"));
	displayOrder();
    }

    /**
     * this method use to print the order form for the customer
     */
    public void displayOrder() {
	long total = 0;
	System.out.println("|Name      |Quantity|    Price    |     Amount     |");
	for (Fruit x : this) {
	    //tong gia tien = tich gia tung san pham cong lai
	    total += x.getQuantity() * x.getPrice();
	    System.out.printf("|%-10s|%8d|%10dVND|%13dVND|\n",
		    x.getName(), x.getQuantity(), x.getPrice(), x.getQuantity() * x.getPrice());
	}
	System.out.println("Total: " + total + "VND");
    }

    /**
     * this method will go through this list and find the fruit object match
     * with input id.
     *
     * @param id
     * @return fruit index if exist in list, -1 if not
     */
    public int findFruitById(String id) {
	if (this.isEmpty()) {
	    return -1;
	}
	for (int i = 0; i < this.size(); i++) {
	    if (this.get(i).getId().equals(id)) {
		return i;
	    }
	}
	//not match with any other id => so return -1
	return -1;
    }
}
