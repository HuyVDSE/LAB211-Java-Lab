/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Run;

import MyValidation.Inputter;
import ShoppingList.ShoppingList;
import fruitList.FruitManager;

/**
 *
 * @author nhoxr
 */
public class Main {
    
    public static void main(String[] args) {
	int choice;
	FruitManager fruitList = new FruitManager();
	ShoppingList shoppingList = new ShoppingList();
	fruitList.initData();
	do {	    
	    System.out.println("\n====== FRUIT SHOP SYSTEM ======");
            System.out.println("1. Create Fruit");
            System.out.println("2. View orders");
            System.out.println("3. Shopping (for buyer)");
            System.out.println("4. Exit");
	    choice = Integer.parseInt(Inputter.inputNumber());
	    switch(choice) {
		case 1:
		    fruitList.addFruit();
		    break;
		case 2:
		    shoppingList.printAllOrder();
		    break;
		case 3:
		    shoppingList.addOrder(fruitList);
		    break;
		case 4:
		    System.out.println("Good bye!!");
		    break;
	    }
	} while (choice != 4);
    }
}
