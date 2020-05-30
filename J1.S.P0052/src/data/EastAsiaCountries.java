/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author nhoxr
 */
public class EastAsiaCountries extends Country{
    private String countryTerrain;

    public EastAsiaCountries(String countryTerrain) {
	this.countryTerrain = countryTerrain;
    }

    public EastAsiaCountries(String countryCode, String countryName, float totalArea, String countryTerrain) {
	super(countryCode, countryName, totalArea);
	this.countryTerrain = countryTerrain;
    }

    @Override
    public void display() {
	System.out.printf("|%-10s|%-15s|%-10.1f|%-10s|\n", countryCode, countryName, totalArea, countryTerrain);
    }
}
