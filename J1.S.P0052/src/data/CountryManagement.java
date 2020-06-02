/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author nhoxr
 */
public class CountryManagement extends ArrayList<EastAsiaCountries> {

    EastAsiaCountries next;

    public boolean checkDuplicate(String id) {
	for (int i = 0; i < this.size(); i++) {
	    if (this.get(i).getCountryCode().equalsIgnoreCase(id)) {
		System.out.println("ID is duplicate!!");
		return true;
	    }
	}
	return false;
    }

    public void addCountry() {
	String code, name, terrain;
	float totalArea;
	do {
	    code = Input.getString("Enter code of country: ", "Code can't empty!!");
	} while (checkDuplicate(code));
	name = Input.getString("Enter name of country: ", "Name can't empty!!");
	totalArea = Input.getAFloat("Enter total Area: ", "Total can't lower than 0 or wrong type data!!");
	terrain = Input.getString("Enter terrain of country: ", "Terrain can't empty!!");
	next = new EastAsiaCountries(code, name, totalArea, terrain);
	this.add(next);
	System.out.println("Country info added successful!!");
    }

    public void displayAllCountryInfo() {
	if (this.isEmpty()) {
	    System.out.println("Nothing to show!!");
	} else {
	    System.out.println("Last input country");
	    System.out.println("|ID        |Name           |Total Area|Terrain   |");
	    for (EastAsiaCountries x : this) {
		x.display();
	    }
	}
    }

    public void displayCountrySortByName() {
	if (this.isEmpty()) {
	    System.out.println("Nothing to show!!");
	} else {
	    Collections.sort(this, compareName);
	    System.out.println("Here is the country list");
	    System.out.println("|ID        |Name           |Total Area|Terrain   |");
	    for (EastAsiaCountries x : this) {
		x.display();
	    }
	}
    }

    /**
     *use to find country, required user input name of country
     * @param name
     * @return Country
     */
    public EastAsiaCountries searchCountryByName(String name) {
	for (int i = 0; i < this.size(); i++) {
	    if (this.get(i).getCountryName().equalsIgnoreCase(name)) {
		return this.get(i);
	    }
	}
	return null;
    }

    public void searchCountry() {
	if (this.isEmpty()) {
	    System.out.println("Nothing to show!!");
	} else {
	    String name = Input.getString("Enter name of country: ", "Name can't empty!!");
	    EastAsiaCountries x = searchCountryByName(name);
	    if (x == null) {
		System.out.println("Not found!!");
	    } else {
		System.out.println("Here is the country your want to find");
		System.out.println("|ID        |Name           |Total Area|Terrain   |");
		x.display();
	    }
	}
    }

    public static Comparator compareName = new Comparator() {
	@Override
	public int compare(Object o1, Object o2) {
	    EastAsiaCountries e1 = (EastAsiaCountries) o1;
	    EastAsiaCountries e2 = (EastAsiaCountries) o2;
	    return e1.getCountryName().compareTo(e2.getCountryName());
	}
    };

    public void initCountryData() {
	this.add(new EastAsiaCountries("VN", "Viet Nam", 100, "Nice"));
	this.add(new EastAsiaCountries("PH", "Philipping", 120, "Nice"));
	this.add(new EastAsiaCountries("TH", "Thailand", 150, "Nice"));
	this.add(new EastAsiaCountries("ML", "Malaysia", 130, "Nice"));
	this.add(new EastAsiaCountries("SG", "Singapore", 30, "Nice"));
	this.add(new EastAsiaCountries("LAO", "Lao", 60, "Hard"));
    }
}
