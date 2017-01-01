package prapul;

import java.io.IOException;
import java.util.Scanner;

public class Employee {
    static char tp;
	int empId, total_leaves;
	double total_salary;
	String empName;
	
	public static void main(String args[]) throws IOException{
		Scanner tpinp = new Scanner(System.in);
		System.out.println("Enter p if you are a permanent employee and t if you are a temporary employee");
		tp = tpinp.next().charAt(0);
		if(tp=='p'||tp=='P'){
		PermanentEmp emp1 = new PermanentEmp();	
		emp1.avail_leave(PermanentEmp.balance_leaves, PermanentEmp.type_of_leave);
		emp1.print_leave_details();
		emp1.calculate_balance_leaves();
		emp1.calculate_salary();
		}
		else if(tp=='t'||tp=='T'){
			TemporaryEmp emp2 = new TemporaryEmp();	
			emp2.avail_leave(TemporaryEmp.balance_leaves, TemporaryEmp.type_of_leave);
			emp2.print_leave_details();
			emp2.calculate_balance_leaves();
			emp2.calculate_salary();
		}
		else{
			System.out.println("You are not an employee");
		}
	}
	void calculate_balance_leaves() throws IOException {
	}

	boolean avail_leave(int no_of_leaves, char type_of_leave)
			throws IOException {
			return true;
	}

	void calculate_salary() {

	}
}