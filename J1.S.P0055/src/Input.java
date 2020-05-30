
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * -
 *
 * @author nhoxr
 */
public class Input {

    private static Scanner sc = new Scanner(System.in);

    public static String getString(String msg) {
	String tmp;
	while (true) {
	    System.out.print(msg);
	    tmp = sc.nextLine();
	    return tmp;
	}
    }

    public static String getString(String msg, String errorMsg) {
	String tmp;
	while (true) {
	    System.out.print(msg);
	    tmp = sc.nextLine().trim();
	    if (tmp.length() == 0 || tmp.isEmpty()) {
		System.out.println(errorMsg);
	    } else {
		return tmp;
	    }
	}
    }

    public static int getAnInteger(String msg, String errorMsg) {
	int tmp = 0;
	do {
	    System.out.print(msg);
	    try {
		tmp = Integer.parseInt(sc.nextLine());
		if (tmp <= 0) {
		    System.out.println(errorMsg);
		} else {
		    return tmp;
		}
	    } catch (Exception e) {
		System.out.println(errorMsg);
	    }
	} while (true);
    }

    public static boolean validAvailability(String availability) {
	return availability.matches("^[0-9]*$");
    }
}
