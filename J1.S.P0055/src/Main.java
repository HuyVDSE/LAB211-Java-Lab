/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nhoxr
 */
public class Main {

    public static void main(String[] args) {
	DoctorManagement cage = new DoctorManagement();
	int choice;
	cage.initDoctorData();
	System.out.println("J1.S.P0055: 73 Points");
	do {
	    System.out.println("======== Doctor Management ========");
	    System.out.println("1. Add Doctor");
	    System.out.println("2. Update Doctor");
	    System.out.println("3. Delete Doctor");
	    System.out.println("4. Search Doctor");
	    System.out.println("5. Exit");
	    choice = Input.getAnInteger("Choice: ", "Wrong choice!!");
	    switch (choice) {
		case 1:
		    System.out.println("----- Add Doctor -----");
		    cage.addDoctor();
		    break;
		case 2:
		    System.out.println("----- Update Doctor -----");
		    cage.updateDoctor();
		    break;
		case 3:
		    System.out.println("----- Delete Doctor -----");
		    cage.deleteDoctor();
		    break;
		case 4:
		    System.out.println("----- Search Doctor -----");
		    cage.searchDoctor();
		    break;
	    }
	} while (choice != 5);
    }
}
