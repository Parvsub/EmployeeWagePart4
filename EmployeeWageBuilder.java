package EmployeeWagePartfour;

public class EmployeeWageBuilder {
    public static final int PartTime = 1;
    public static final int FullTime = 2;
    private final String company;
    private final int employeeRatePerHour;
    private final int numberOfWorkingDays;
    private final int maximumHoursPerMonth;
    private int totalEmployeeWage;

    public EmployeeWageBuilder(String company, int employeeRatePerHour, int numberOfWorkingDays,
                               int maximumHoursPerMonth) {
        this.company = company;
        this.employeeRatePerHour = employeeRatePerHour;
        this.numberOfWorkingDays = numberOfWorkingDays;
        this.maximumHoursPerMonth = maximumHoursPerMonth;
    }

    public void computeEmployeeWage() {
        int employeeHours = 0;
        int totalEmployeeHours = 0;
        int totalWorkingDays = 0;
        while (totalEmployeeHours <= maximumHoursPerMonth && totalWorkingDays < numberOfWorkingDays) {
            totalWorkingDays++;
            int employeeCheck = (int) Math.floor(Math.random() * 10) % 3;
            switch (employeeCheck) {
                case PartTime:
                    employeeHours = 4;
                    break;
                case FullTime:
                    employeeHours = 8;
                    break;
                default:
                    employeeHours = 0;
            }
            totalEmployeeHours += employeeHours;
            System.out.println("Day : " + totalWorkingDays + " employee Hours:" + employeeHours);
        }
        totalEmployeeWage = totalEmployeeHours + employeeRatePerHour;
    }
    @Override
    public String toString() {
        return "Total Employee Wage for Company: " + company + " is :" + totalEmployeeWage;
    }

    public static void main(String[] args) {

        EmployeeWageBuilder dMart = new EmployeeWageBuilder("DMart", 20, 2, 10);
        EmployeeWageBuilder reliance = new EmployeeWageBuilder("Reliance", 10, 4, 20);
        dMart.computeEmployeeWage();
        System.out.println(dMart);
        reliance.computeEmployeeWage();
        System.out.println(reliance);
    }
}