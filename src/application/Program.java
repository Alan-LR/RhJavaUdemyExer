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

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		System.out.print("Entre com o nome do departamento: ");
		String departmentName = sc.nextLine();
		Department dep = new Department(departmentName);
		System.out.println("Entre com os dados do trabalhador: ");
		System.out.print("Nome: ");
		String workerName = sc.nextLine();
		System.out.print("Level: ");
		String workerLevel = sc.nextLine();
		System.out.print("Salário base: ");
		Double workerSalary = sc.nextDouble();
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), workerSalary, dep);
		
		System.out.print("Digite a quantidade de contratos do trabalhador: ");
		int n = sc.nextInt();
		sc.nextLine();
		
		for(int i=1; i<=n; i++) {
			System.out.println("Entre com o contrato de número " + i + "°");
			System.out.print("Entre com uma data (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(sc.next());
			System.out.print("Valor por hora: ");
			double valuePerHour = sc.nextDouble();
			System.out.print("Quantidade de horas: ");
			int hours = sc.nextInt();
			sc.nextLine();
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			worker.addContract(contract);			
		}
		System.out.println();
		System.out.println("Entre com o mês e ano para calcular o salário (MM/YYYY): ");
		String monthAndYear = sc.next();
		//vamos recortar as strings de mês e ano e converte-las para int:
		//pegamos a possição das strings com monthAndYear.substring e convertemos com Integer.parseInt
		int month = Integer.parseInt(monthAndYear.substring(0,2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		System.out.println("Nome: " + worker.getName());
		System.out.println("Departamento: " + worker.getDepartment().getName());
		System.out.println("No mês " + monthAndYear + " o funcionario recebeu: " +  worker.income(year, month) );
		
		
		//System.out.println("informações do empregado: " + worker);
		
		sc.close();

	}

}
