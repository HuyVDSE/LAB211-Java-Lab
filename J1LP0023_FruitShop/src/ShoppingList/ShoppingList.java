/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShoppingList;

import MyValidation.Validation;
import fruitList.FruitManager;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author nhoxr
 */
//dung HashTable de luu cac don hang cua nguoi dung
public class ShoppingList extends Hashtable<Integer, Customer> {

    private int idOrder = 1;//set default id order.

    /**
     * this method use to add oder to shopping list
     *
     * @param fruitList
     */
    public void addOrder(FruitManager fruitList) {
	//create variable
	boolean isValid;
	String name;
	Scanner sc = new Scanner(System.in);

	//order list
	ListOrder listOrder = new ListOrder();
	listOrder.addOrder(fruitList);
	if (listOrder.isEmpty()) {
	    return;
	}

	//input customer info
	do {
	    System.out.print("Input name: ");
	    name = sc.nextLine();
	    isValid = Validation.isValidName(name);
	    if (!isValid) {
		System.out.println("Invalid Name!!");
	    }
	} while (!isValid);

	//put this order to HashMap
	this.put(idOrder, new Customer(idOrder, name, listOrder));
	System.out.println("Thanks for buying!!");
	idOrder++;
    }

    public void printAllOrder() {
	if (this.isEmpty()) {
	    System.out.println("The Order List is empty!!");
	    return;
	}
	Set set = this.keySet();
	Iterator it = set.iterator();
	while (it.hasNext()) {
	    Customer cus = this.get(it.next());
	    System.out.println("ID: " + cus.getId() + ", Customer: " + cus.getName());
	    //every customer has they own order list
	    //use a loop to get all of this
	    for (ListOrder listOrder : cus.getList()) {
		listOrder.displayOrder();
	    }
	    System.out.println("");
	}
    }
}
