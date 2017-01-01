package prapul;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class PermanentEmp extends Employee {

	Employee per = new Employee();

	static int leaves, balance_leaves, paid_leave, sick_leave, casual_leave,
			gcasual, gpaid, gsick, tsick, tpaid, tcasual;
	static double basic, hra, pfa;
	static char type_of_leave;
	static BufferedReader input = new BufferedReader(new InputStreamReader(
			System.in));

	PermanentEmp() throws IOException{
		System.out.println("Enter you employee ID");
		empId = Integer.parseInt(input.readLine());
		System.out.println("Enter your name");
		empName = input.readLine();
		System.out.println("Enter your basic salary");
		basic = Double.parseDouble(input.readLine()); 
		hra = (50 / 100) * basic;
		pfa = (12 / 100) * basic;
		Scanner inpu = new Scanner(System.in);
		gsick = 5;
		gpaid = 30;
		gcasual = 20;
		System.out.println("Enter type of leave you want to avail:");
		System.out.println("Enter c for casual leave, p for paid leave and s for sick leave");
		type_of_leave = inpu.next().charAt(0);
		switch (type_of_leave) {
		case 'c':
			System.out.println("The maximum number of casual leaves available for a year is " + gcasual);
			System.out.println("Enter the number of casual leaves that you require");
			casual_leave = Integer.parseInt(input.readLine());  
			break;
		case 'p':
			System.out.println("The maximum number of paid leaves available for a year is " + gpaid);
			System.out.println("Enter the number of paid leaves that you require");
			paid_leave = Integer.parseInt(input.readLine());
			break;
		case 's':
			System.out.println("The maximum number of sick leaves available for a year is " + gsick);
			System.out.println("Enter the number of sick leaves that you require");
			sick_leave = Integer.parseInt(input.readLine()); 
			break;
		default:
			System.out.println("Wrong choice");
		}
	}

	void print_leave_details() {
		System.out.println("Employee ID: " + empId);
		System.out.println("Employee Name: " + empName);
		System.out.println("You are a permanent employee");
		System.out.println("Casual leaves: " + casual_leave);
		System.out.println("Sick leaves: " + sick_leave);
		System.out.println("Paid leaves: " + paid_leave);
	}

	@Override
	void calculate_balance_leaves() throws IOException {
			leaves = casual_leave + sick_leave + paid_leave;
			total_leaves = gsick + gpaid + gcasual;
			balance_leaves = total_leaves - leaves;
			System.out.println("You have " + balance_leaves + " " + type_of_leave + " balance leaves");
	}

	@Override
	boolean avail_leave(int no_of_leaves, char type_of_leave)
			throws IOException {
		switch (PermanentEmp.type_of_leave) {
		case 'c':
			System.out.println("Enter the number of casual leaves you have already taken");
			tcasual = Integer.parseInt(input.readLine());
			casual_leave += tcasual;
			break;
		case 'p':
			System.out.println("Enter the number of paid leaves you have already taken");
			tpaid = Integer.parseInt(input.readLine());
			paid_leave += tpaid;
			break;
		case 's':
			System.out.println("Enter the number of sick leaves you have already taken");
			tsick = Integer.parseInt(input.readLine());
			sick_leave += tsick;
			break;
		default:
			System.out.println("Wrong choice");
		}
		if (casual_leave >= gcasual || gpaid - paid_leave >= gpaid || gsick - sick_leave >= gsick) {
			System.out.println("No more leaves can be granted");
			return false;
		}
	    else {
	    	System.out.println("You are eligible for leaves");
			return true;
		}
	}
	@Override
	void calculate_salary() {
		total_salary = basic + hra - pfa;
		System.out.println("Your total salary will be " + total_salary);
	}
}
