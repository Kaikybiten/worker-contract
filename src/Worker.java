import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Worker {
    private String name;

    private Department department;
    private WorkerLevel level;

    private double baseSalary;
    private List<HourContract> contracts = new ArrayList<>();

    public Worker(String name, Department department, WorkerLevel level, double baseSalary){
        this.name = name;
        this.department = department;
        this.baseSalary = baseSalary;
        this.level = level;
    }

    public String getName(){
        return this.name;
    }
    public void setName(String value){
        this.name = value;
    }

    public WorkerLevel getLevel() {
        return level;
    }
    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    public double getBaseSalary() {
        return baseSalary;
    }
    public void increaseSalary(double increase){
        if (increase > 0){
            baseSalary += increase;
            return;
        }
        System.out.println("Increase must be positive.");
    }

    public Department getDepartment() {
        return department;
    }
    public void setDepartment(Department department) {
        this.department = department;
    }

    public void addContract(HourContract contract){
        this.contracts.add(contract);
    }

    public void removeContract(HourContract contract){
        boolean hasContract = this.contracts.remove(contract);
        if (!hasContract){
            System.out.println("Contract not found.");
            return;
        }
            System.out.println("Contract successfully removed.");
    }

    public double income(int month, int year) {
        double totalIncome = this.baseSalary;
        for (HourContract ct : contracts) {

            int contractYear = ct.getDate().getYear();
            int contractMonth = ct.getDate().getMonthValue();

            if (contractYear == year && contractMonth == month) {
                totalIncome += ct.totalValue();
            }
        }
        return totalIncome;
    }

    @Override
    public String toString() {
        return "\nName: " + this.name +
                (this.department != null ? this.department : "No department");
    }
}
