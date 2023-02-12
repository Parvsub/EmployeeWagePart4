package EmployeeWagePartfour;

public class EmployeeWage{
    static final int FullTime = 2;
    static final int PartTime = 1;
    static final int WagePerHour = 20;

    void employeeSwitchCase(int EmployeeWorkingHours, int EmployeeWage) {
        double employeeCheck = Math.floor(Math.random() * 10) % 3;
        switch ((int) employeeCheck) {
            case PartTime -> EmployeeWorkingHours = 4;
            case FullTime -> EmployeeWorkingHours = 8;
            default -> EmployeeWorkingHours = 0;
        }
        EmployeeWage = EmployeeWorkingHours * WagePerHour;
        System.out.println("EmployeeWage: " + EmployeeWage);
    }

    public static void main(String[] args) {
        EmployeeWage switchCase = new EmployeeWage();
        switchCase.employeeSwitchCase(0, 0);
    }
}
