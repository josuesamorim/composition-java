package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Departament;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;


public class Main {

	public static void main(String[] args) throws ParseException { {
		Scanner scan = new Scanner(System.in);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter departament's name.");
		String departamentName = scan.nextLine();
		
		System.out.println("Enter worker data.");
		
		System.out.print("Name: ");
		String workerName = scan.nextLine();
		
		System.out.print("Level: ");
		String workerLevel = scan.nextLine();
		
		System.out.print("Base Salary: ");
		double baseSalary = scan.nextDouble();
		
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Departament(departamentName));
		
		System.out.print("How many contracts? ");
		int contracts = scan.nextInt();
		
		for(int i = 1; i <= contracts; i++) {
		System.out.println("Enter the contract #" + i + " data.");
		System.out.print("Date DD/MM/YYYY.");
		Date contractDate = simpleDateFormat.parse(scan.next());
		System.out.print("Value per hour.");
		double valuePerHour = scan.nextDouble();
		System.out.print("Duration hours.");
		int hours = scan.nextInt();
		
		HourContract contract = new HourContract(contractDate, valuePerHour, hours);
		worker.addContract(contract);
		
		}
		
		System.out.println();
		System.out.print("Enter month and year to calculate the income (MM/YYYY).");
		String monthAndYear = scan.next();
		int month = Integer.parseInt(monthAndYear.substring(0,2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		System.out.println("Name: " + worker.getName());
		System.out.println("Departament " + worker.getDepartament().getName());
		System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));
		
		scan.close();
		
	
		
	}
}}
