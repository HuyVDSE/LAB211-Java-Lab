/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShoppingList;

import java.util.ArrayList;

/**
 *
 * @author nhoxr
 */
public class Customer {
    private int id;
    private String name;
    private ArrayList<ListOrder> list = new ArrayList<>();

    public Customer(int id, String name, ListOrder listOrder) {
	this.id = id;
	this.name = name;
	list.add(listOrder);
    }

    public void setId(int id) {
	this.id = id;
    }

    public int getId() {
	return id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public ArrayList<ListOrder> getList() {
	return list;
    }

    public void setList(ArrayList<ListOrder> list) {
	this.list = list;
    }    
}
