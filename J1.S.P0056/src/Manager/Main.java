/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import InputAndCheck.*;
import data.Worker;

/**
 *
 * @author nhoxr
 */
public class Main {

    public static void main(String[] args) {
	Cabinet cage = new Cabinet();
	boolean isValid = true;
	int choice;
	cage.initWorkerData();
	do {
	    System.out.println("=========== Worker Management ===========");
	    System.out.println("1. Add Worker");
	    System.out.println("2. Up Salary");
	    System.out.println("3. Down Salary");
	    System.out.println("4. Display Information Salary");
	    System.out.println("5. Exit");
	    choice = Input.getAChoice("Choice: ", "Wrong choice!!");
	    switch (choice) {
		case 1:
		    cage.addWorker();
		    break;
		case 2:
		    Worker updateWorkerUp = cage.getWorkerToUpdate();
		    do {
			isValid = cage.updateSalary(updateWorkerUp, 1);
		    } while (!isValid);
		    cage.updateHistory(updateWorkerUp, "UP");
		    break;
		case 3:
		    Worker updateWorkerDown = cage.getWorkerToUpdate();
		    do {
			cage.updateSalary(updateWorkerDown, 0);
		    } while (!isValid);
		    cage.updateHistory(updateWorkerDown, "DOWN");
		    break;
		case 4:
		    cage.sortByID();
		    cage.printHistorySalary();
		    break;
	    }
	} while (choice != 5);
    }
}
