package prapul;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class TemporaryEmp extends Employee {
	static int leaves, sick_leave, gsick, tsick, balance_leaves;
	static double basic;
	static char type_of_leave;
	static BufferedReader in = new BufferedReader(new InputStreamReader(
			System.in));

	TemporaryEmp() throws IOException {
		System.out.println("Enter you employee ID");
		empId = Integer.parseInt(in.readLine());
		System.out.println("Enter your name");
		empName = in.readLine();
		System.out.println("Enter your basic salary");
		basic = Double.parseDouble(in.readLine());  
		Scanner inp = new Scanner(System.in);
		System.out.println("Do you want a sick leave? Enter 'y' for yes and 'n' for no");
		char yn = inp.next().charAt(0);
		type_of_leave = 's';
		gsick = 25;
		if(yn=='y'||yn=='Y'){
			System.out.println("The maximum number of sick leaves available for a year is " + gsick);
			System.out.println("Enter the number of sick leaves you require");
			sick_leave = Integer.parseInt(in.readLine());
			System.out.println("Enter the number of sick leaves you have already taken");
			tsick = Integer.parseInt(in.readLine());
			sick_leave = sick_leave + tsick;
			}
		else{
			System.out.println("Here are the details..");
		}
	}

	void print_leave_details() {
		System.out.println("Employee ID: " + empId);
		System.out.println("Employee Name: " + empName);
		System.out.println("You are a temporary employee");
		System.out.println("Sick leaves: " + sick_leave);
	}

	@Override
	void calculate_balance_leaves() throws IOException {
		if (avail_leave(leaves, type_of_leave)) {
			balance_leaves = gsick - sick_leave;
			System.out.println("You have " + balance_leaves + " balance leaves");
		}
	}

	@Override
	boolean avail_leave(int no_of_leaves, char type_of_leave)
			throws IOException {
		if (gsick - sick_leave >= gsick) {
			System.out.println("You are not eligible for sick leaves");
			return false;
		} else {
			System.out.println("sick leave granted");
			return true;
		}
	}

	@Override
	void calculate_salary() {
		total_salary = basic;
		System.out.println("Your total salary is: " + total_salary);
	}
}
