package EmployeeWagePartfour;

public class EmployeeWage {
    static final int FullTime = 2;
    static final int PartTime = 1;
    static final int WagePerHour = 20;

    void employeeMonthWage(int WorkingDayPerMonth, int EmployeeWorkingHours, int EmployeeWage, int MonthlyEmployeeWage) {
        for (int i = 0; i < WorkingDayPerMonth; i++) {
            double employeecheck = Math.floor(Math.random() * 10) % 3;
            switch ((int) employeecheck) {
                case PartTime:
                    EmployeeWorkingHours = 4;
                    break;
                case FullTime:
                    EmployeeWorkingHours = 8;
                    break;
                default:
                    EmployeeWorkingHours = 0;
            }

            EmployeeWage = EmployeeWorkingHours * WagePerHour;
            MonthlyEmployeeWage += EmployeeWage;
            System.out.println("EmployeeWage: " + EmployeeWage);
        }
        System.out.println("MonthlyEmployeeWage: " + MonthlyEmployeeWage);
    }

    public static void main(String[] args) {
        EmployeeWage employeeMonth = new EmployeeWage();
        employeeMonth.employeeMonthWage(20, 0, 0, 0);
    }
}
