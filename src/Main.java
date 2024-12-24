import java.util.Scanner;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.YearMonth;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter department's name: ");
        String department = input.nextLine();
        Department dep = new Department(department);

        System.out.println("Enter worker data:");

        System.out.print("Name: ");
        String name = input.nextLine();

        System.out.print("Base salary: ");
        double baseSalary = input.nextDouble();

        WorkerLevel level = null;

        while (level == null) {
            System.out.print("Level: ");
            String textLevel = input.next();

            switch (textLevel) {
                case "JUNIOR":
                    level = WorkerLevel.JUNIOR;
                    break;
                case "MID_LEVEL":
                    level = WorkerLevel.MID_LEVEL;
                    break;
                case "SENIOR":
                    level = WorkerLevel.SENIOR;
                    break;
                default:
                    System.out.println("Worker level not found.");
                    break;
            }
        }

        Worker worker = new Worker(name, dep, level, baseSalary);

        System.out.print("\nHow many contracts to this worker? ");
        int contractsQtd = input.nextInt();
        input.nextLine();

        for (int i = 0; i < contractsQtd; i++){
            System.out.println("\nEnter contract #" + (i+1) + " data");

            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            System.out.print("Date (DD/MM/YYYY): ");
            String dateInput = input.nextLine();
            LocalDate date = LocalDate.parse(dateInput, dateFormat);

            System.out.print("Value per hour: ");
            double valueHour = input.nextDouble();

            System.out.print("Duration (hours): ");
            int hours = input.nextInt();
            input.nextLine();

            worker.addContract(new HourContract(date, valueHour, hours));
        }

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/yyyy");
        System.out.print("\nEnter month and year to calculate income (MM/YYYY): ");
        String dateInput = input.nextLine();
        YearMonth date = YearMonth.parse(dateInput, dateFormat);

        int yearArgument = date.getYear();
        int monthArgument = date.getMonthValue();

        System.out.println(worker);
        double periodIncome = worker.income(monthArgument, yearArgument);
        System.out.printf("Income for %s: %f%n", dateInput,periodIncome);

        input.close();
    }
}