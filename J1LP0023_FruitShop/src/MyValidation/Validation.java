/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyValidation;

import fruitList.Fruit;
import java.util.ArrayList;

/**
 *
 * @author nhoxr
 */
public class Validation {
    
    /**
     * this method use to check exist ID in the list
     * @return true if exist, false if not
     */
    public static boolean isExistFruitId(String id, ArrayList<Fruit> fruitsList) {
	for (Fruit fruit : fruitsList) {
	    if (fruit.getId().equals(id)) {
		return true;
	    }
	}
	return false;
    }
    
    /**
     * this method use to check the id is valid or not
     * @param id
     * @return true if valid, false if not
     */
    public static boolean isValidId(String id) {
	return id.matches("^[A-Z0-9]+$");
    } 
    
    public static boolean isValidName(String name) {
	return name.matches("^[a-zA-Z\\s]+$");
    }
    
    public static boolean isValidQuantity(String quantity) {
	return quantity.matches("^[0-9]+$");
    }
    
    public static boolean isValidPrice(String price) {
	return price.matches("^[0-9]+$");
    }
    
    public static boolean isValidOrigin(String origin) {
	return origin.matches("^[a-zA-Z0-9]+$");
    }
}
