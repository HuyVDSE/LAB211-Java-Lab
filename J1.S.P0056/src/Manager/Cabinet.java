/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import data.HisorySalary;
import data.Worker;
import java.util.ArrayList;
import InputAndCheck.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
/**
 *
 * @author nhoxr
 */
public class Cabinet {

    ArrayList<Worker> workerList = new ArrayList<>();
    ArrayList<HisorySalary> HistoryList = new ArrayList<>();

    public void addWorker() {
	String id, name, location;
	int age, salary;
	System.out.println("----------- ADD NEW WORKER ------------");
	do {
	    id = Input.inputID();
	} while (Valid.checkExistID(id, workerList));
	name = Input.inputName();
	age = Input.inputAge();
	salary = Input.inputSalary();
	location = Input.inputLocation();
	workerList.add(new Worker(id, name, age, salary, location));
	System.out.println("Add worker successful");
    }

    public Worker searchByID(String id) {
	for (int i = 0; i < workerList.size(); i++) {
	    if (workerList.get(i).getId().equalsIgnoreCase(id)) {
		return workerList.get(i);
	    }
	}
	return null;
    }

    public Worker getWorkerToUpdate() {
	String id = Input.inputID();
	Worker updateWorker = searchByID(id);
	if (updateWorker != null) {
	    System.out.println("Current salary: " + updateWorker.getSalary());
	}
	return updateWorker;
    }

    public boolean updateSalary(Worker updateWorker, int upDown) {
	int newSalary;
	if (updateWorker != null) {
	    newSalary = Input.inputSalary();
	    //1 mean up salary, 0 mean down salary
	    if (((newSalary > updateWorker.getSalary()) && upDown == 1)
		    || ((newSalary < updateWorker.getSalary()) && upDown == 0)) {
		updateWorker.setSalary(newSalary);
		System.out.println("Update successful!!");
		return true;
	    }
	    if ((newSalary <= updateWorker.getSalary()) && upDown == 1) {
		System.out.println("New Salary must greater than current salary");
		return false;
	    }
	    if ((newSalary >= updateWorker.getSalary()) && upDown == 0) {
		System.out.println("New Salary must less than current salary");
		return false;
	    }
	} else {
	    System.out.println("Not found!!");
	}
	return false;
    }

    public void updateHistory(Worker updateWorker, String status) {
	if (updateWorker != null) {
	    HistoryList.add(new HisorySalary(updateWorker, status, getCurrentDate()));
	}
    }

    public String getCurrentDate() {
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	Calendar calendar = Calendar.getInstance();
	return dateFormat.format(calendar.getTime());
    }

    public void printHistorySalary() {
	HisorySalary tmpHistory;
	Worker tmpWorker;
	System.out.println("--------------- Display Information Salary ----------------");
	System.out.printf("%-10s %-20s %-10s %-15s %-15s %-15s\n",
		"Code", "Name", "Age", "Salary", "Status", "Date");
	for (int i = 0; i < HistoryList.size(); i++) {
	    tmpHistory = HistoryList.get(i);
	    tmpWorker = tmpHistory.getWorker();
	    System.out.printf("%-10s %-20s %-10d %-15d %-15s %-15s\n",
		    tmpWorker.getId(), tmpWorker.getName(), tmpWorker.getAge(),
		    tmpHistory.getNewSalary(), tmpHistory.getStatus(), tmpHistory.getDate());
	}
    }

    public void sortByID() {
	Collections.sort(HistoryList, HisorySalary.compareIdWorker);
    }

    public void initWorkerData() {
	workerList.add(new Worker("W1", "Nguyen Van Hau", 28, 150, "VN"));
	workerList.add(new Worker("W2", "Tran Thai Ha", 40, 200, "SG"));
	workerList.add(new Worker("W3", "Tran Hoang Sang", 30, 120, "VN"));
	workerList.add(new Worker("W4", "Ly My Han", 20, 100, "PH"));
	workerList.add(new Worker("W5", "Nguyen Khoi Nguyen", 25, 220, "VN"));
    }
}
