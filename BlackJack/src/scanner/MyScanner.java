package scanner;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MyScanner {
	private static Scanner sc = new Scanner(System.in);

	public static boolean getYN(String mesege) {
		Pattern pattern = Pattern.compile("y|n");
		boolean flag = true;
		String ch = "";
		while (flag) {
			try {
				System.out.println(mesege);
				ch = sc.next(pattern);
				flag = false;
			} catch (NoSuchElementException e) {
				sc.next();
				System.err.println(" \"Y\" ore \"N\" only,Try agen please!");
			}
		}
		if (ch.toLowerCase().equals("y"))
			return true;
		return false;
	}

	public static int menuChoice(int min, int max) {
		boolean swch;
		int choice = 0;
		do {
			swch = false;
			try {
				choice = sc.nextInt();
				if (choice < min || choice > max) {
					System.out.println("Only numbers from " + min + " to "
							+ max + "!");
					swch = true;
					// sc.next();
				}
			} catch (InputMismatchException exc) {
				System.err.println("Input Mismatch Exception!");
				System.out.println("Only numbers from " + min + " to " + max
						+ "!");
				swch = true;
				sc.next();
			}
		} while (swch);
		return choice;
	}

	public static int inputIntNumbers() {
		boolean swch;
		int choice = 0;
		do {
			swch = false;
			try {
				choice = sc.nextInt();

			} catch (InputMismatchException exc) {
				System.err.println("Input Mismatch Exception!");
				System.out.println("Only integer numbers !");
				swch = true;
				sc.next();
			}
		} while (swch);
		return choice;
	}

	public static String inputName() {
		boolean swch;
		String name = "";
		do {
			swch = false;
			try {
				System.out.println("Enter Name : ");
				name = sc.next();
			} catch (InputMismatchException exc) {
				System.out
						.println("Input Mismatch Exception! Please try agen! ");
				swch = true;
				sc.next();
			}
		} while (swch);
		return name;
	}

	public static void close() {
		sc.close();
	}
}
