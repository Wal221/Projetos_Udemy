package Aula1.application;

import Aula1.Entities.Department;
import Aula1.Entities.HourContract;
import Aula1.Entities.Worker;
import Aula1.Entities.enums.WorkerLevel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //para dar a forma da minha Data
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter department ' s name: ");
        String departmentName= sc.nextLine();
        System.out.println("Enter worker data: ");
        System.out.print("Name: ");
        String workerName= sc.nextLine();

        System.out.print("Level: ");
        String workerLevel= sc.nextLine();

        System.out.print("Base Salary ");
        double baseSalary = sc.nextDouble();

        Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel),baseSalary
                        ,new Department(departmentName)); //Tem de instancia um novo departamento, que ele que vai esta
                                                          // associado a minha clse Worke

        System.out.println("How many contracts to this worker? ");
        int n = sc.nextInt();

        for(int i =1; i<=n; i++){
            System.out.println("Enter contract #" + i + " data:");
            System.out.print("Date (DD/MM/YYYY): ");
            Date contractDate = sdf.parse(sc.next());

            System.out.print("Value per hour: ");
            double valuePerHour = sc.nextDouble();

            System.out.print("Duration (hours): ");
            int hours = sc.nextInt();
            HourContract contract = new HourContract(contractDate,valuePerHour,hours);
             worker.addContract(contract); //Estou adicionando um novo contrato na lista
                                           // de contratos. Fazendo o meu contrato esta associado ao meu
                                            // trabalhador.
        }
        System.out.println();
        System.out.print("Enter month year to calculate income (MM/YYYY): ");
         String monthAndYear = sc.next();
          int month = Integer.parseInt( monthAndYear.substring(0, 2));

          int year= Integer.parseInt(monthAndYear.substring(3));
        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartment().getName());
        System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year,month)));




        sc.close();
    }

}
