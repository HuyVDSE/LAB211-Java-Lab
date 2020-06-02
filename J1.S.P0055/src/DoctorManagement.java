
import java.util.ArrayList;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author nhoxr
 */
public class DoctorManagement extends ArrayList<Doctor> {

    public boolean checkDuplicated(String code) {
	for (int i = 0; i < this.size(); i++) {
	    if (this.get(i).getCode().equalsIgnoreCase(code)) {
		System.out.println("ID is duplicated!!");
		return true;
	    }
	}
	return false;
    }

    public void addDoctor() {
	String code, name, specialization;
	int availability;
	do {
	    code = Input.getString("Enter doctor code: ", "Doctor code can't empty!!");
	} while (checkDuplicated(code));
	name = Input.getString("Enter doctor name: ", "Name can't empty");
	specialization = Input.getString("Enter doctor specialization: ", "Specialization can't empty!!");
	availability = Input.getAnInteger("Enter doctor availability: ", "Availability can't empty!!");
	this.add(new Doctor(code, name, specialization, availability));
	System.out.println("Doctor info added successful!!");
    }

    public Doctor findDoctorByID(String id) {
	for (int i = 0; i < this.size(); i++) {
	    if (this.get(i).getCode().equalsIgnoreCase(id)) {
		return this.get(i);
	    }
	}
	return null;
    }

    public void updateDoctor() {
	if (this.isEmpty()) {
	    System.out.println("The list is empty!!");
	} else {
	    String id, name, spec, availability;
	    int tmpAvailability;
	    boolean isValid = true;
	    id = Input.getString("Enter doctor code: ");
	    Doctor x = findDoctorByID(id);
	    if (x == null) {
		System.out.println("Not found!!");
	    } else {
		name = Input.getString("Enter doctor name: ");
		if (!name.isEmpty()) {
		    x.setName(name);
		}
		spec = Input.getString("Enter specialization: ");
		if (!spec.isEmpty()) {
		    x.setSpecialization(spec);
		}
		do {
		    availability = Input.getString("Enter Availibility: ");
		    isValid = Input.validAvailability(availability);
		} while (!isValid);
		tmpAvailability = Integer.parseInt(availability);
		x.setAvailability(tmpAvailability);
		System.out.println("Update successfull!!");
	    }
	}
    }

    public void deleteDoctor() {
	if (this.isEmpty()) {
	    System.out.println("The list is empty!!");
	} else {
	    String id = Input.getString("Enter doctor code: ", "code can't empty!!");
	    Doctor x = findDoctorByID(id);
	    if (x == null) {
		System.out.println("Not found!!");
	    } else {
		this.remove(x);
		System.out.println("Remove doctor successful");
	    }
	}
    }

    public void searchDoctor() {
	ArrayList<Doctor> listDoctorFoundByName = new ArrayList<>();
	if (this.isEmpty()) {
	    System.out.println("The list is empty!!");
	} else {
	    String name = Input.getString("Enter name: ");
	    listDoctorFoundByName = listDoctorFindByName(this, name);
	    if (listDoctorFoundByName.isEmpty()) {
		System.out.println("Not found!!");
	    } else {
		System.out.println("Here is the doctor you want to find");
		System.out.println("|Code |Name           |Specialization |Availability|");
		for (int i = 0; i < listDoctorFoundByName.size(); i++) {
		    listDoctorFoundByName.get(i).print();
		}
	    }
	}
    }

    public ArrayList<Doctor> listDoctorFindByName(ArrayList<Doctor> listDoctor,String name) {
	ArrayList<Doctor> lDoctor = new ArrayList<>();
	for (int i = 0; i < listDoctor.size(); i++) {
	    if (listDoctor.get(i).getName().contains(name)) {
		lDoctor.add(listDoctor.get(i));
	    }
	}
	return lDoctor;
    }

    public void initDoctorData(){
	this.add(new Doctor("DOC 1", "Nguyen Van A", "Nice", 3));
	this.add(new Doctor("DOC 2", "Tran Thanh Son", "Nice", 5));
	this.add(new Doctor("DOC 3", "Thanh Van B", "Nice", 2));
	this.add(new Doctor("DOC 4", "Hoang Trung Son", "Nice", 1));
	this.add(new Doctor("DOC 5", "Tran Thi Dung", "Nice", 4));
	this.add(new Doctor("DOC 6", "Nguyen Van Hau", "Nice", 1));
    }
}
