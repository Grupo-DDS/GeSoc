package controllers;

import java.time.LocalDate;

public class pruebaControl {
	public static void main(String[] args) {

		// create a LocalDate object
		LocalDate date = LocalDate.parse("2018-12-24");

		// print instance
		System.out.println("LocalDate before" + " adding days: " + date);

		// add 15 days
		LocalDate returnvalue = date.plusDays(0);

		// print result
		System.out.println("LocalDate after " + " adding days: " + returnvalue);
	}
}
