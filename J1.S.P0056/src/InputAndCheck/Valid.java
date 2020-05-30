/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InputAndCheck;

import data.Worker;
import java.util.ArrayList;

/**
 *
 * @author nhoxr
 */
public class Valid {

    public static boolean checkExistID(String id, ArrayList<Worker> workerList) {
	for (int i = 0; i < workerList.size(); i++) {
	    if (workerList.get(i).getId().equals(id)) {
		return true;
	    }
	}
	return false;
    }

    public static boolean isValidID(String id) {
	return id.matches("^[a-zA-Z0-9]*$");
    }

    public static boolean isValidName(String name) {
	return name.matches("^[a-zA-Z\\s]*$");
    }

    public static boolean isValidLocation(String location) {
	return location.matches("^[a-zA-Z0-9\\s,.]*$");
    }

    public static boolean isValidSalary(int salary) {
	return salary > 0;
    }

    public static boolean isValidAge(int age) {
	return age >= 18 && age <= 50;
    }
}
