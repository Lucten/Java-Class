package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class DataWorker {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter department's name:");
		String department = sc.nextLine();
		System.out.println("Enter worker data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Level: ");
		String level = sc.nextLine();
		System.out.print("Base salary: ");
		double baseSalary = sc.nextDouble();
		
		Worker worker = new Worker(name, WorkerLevel.valueOf(level), baseSalary, new Department(department));
		
		System.out.print("How many contracts to this worker?");
		int n =sc.nextInt();
		HourContract contract;
		
		for (int i = 1; i<=n; i++) {
			System.out.printf("Enter contract #%d data:\n", i);
			System.out.print("Date (DD/MM/YYYY): ");
			Date date = sdf.parse(sc.next());
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			System.out.print("Duration (hour): ");
			int hours = sc.nextInt();
			contract = new HourContract(date, valuePerHour, hours);
			worker.addContract(contract);
		}
		
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		sdf = new SimpleDateFormat("MM/yyyy");
		String monthAndYear = sc.next();
		int month =Integer.parseInt( monthAndYear.substring(0, 2));
		int year  = Integer.parseInt(monthAndYear.substring(3));
		System.out.print(worker);
		System.out.println("Income for " + monthAndYear + ": $" + String.format("%.2f", worker.income(year, month)));
		sc.close();
	}

}
