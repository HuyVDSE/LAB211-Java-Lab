/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.Comparator;
/**
 *
 * @author nhoxr
 */
public class HisorySalary {

    private int newSalary;
    private Worker worker;
    private String status;
    private String updateDate;

    public HisorySalary(Worker worker, String status, String updateDate) {
	this.worker = worker;
	this.status = status;
	this.updateDate = updateDate;
	newSalary = worker.getSalary();
    }

    public Worker getWorker() {
	return worker;
    }

    public void setWorker(Worker worker) {
	this.worker = worker;
    }

    public String getStatus() {
	return status;
    }

    public void setStatus(String status) {
	this.status = status;
    }

    public String getDate() {
	return updateDate;
    }

    public void setDate(String updateDate) {
	this.updateDate = updateDate;
    }

    public int getNewSalary() {
	return newSalary;
    }

    public void setNewSalary(int newSalary) {
	this.newSalary = newSalary;
    }

    public static Comparator<HisorySalary> compareIdWorker = new Comparator<HisorySalary>() {
	@Override
	public int compare(HisorySalary hs1, HisorySalary hs2) {
	    String firstID = hs1.getWorker().getId();
	    String secondID = hs2.getWorker().getId();
	    if (firstID.compareTo(secondID) > 0) {
		return 1;
	    } else if (firstID.compareTo(secondID) == 0) {
		return 0;
	    } else {
		return -1;
	    }
	}
    };
}
