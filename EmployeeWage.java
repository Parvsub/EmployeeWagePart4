package EmployeeWagePartfour;

public class EmployeeWage{
    static final int PartTime = 1;
    static final int FullTime = 2;

    public static int computeEmployeeWage(String company, int EmployeeRatePerHour,int NumberOfWorkingDays,
                                          int maximumHoursInMonth){
        int employeeHours = 0;
        int TotalEmployeeHours = 0;
        int TotalWorkingDays = 0;
        while (TotalEmployeeHours <= maximumHoursInMonth && TotalWorkingDays < NumberOfWorkingDays) {
            TotalWorkingDays++;
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
            TotalEmployeeHours += employeeHours;
            System.out.println("Day : " + TotalWorkingDays + " employee Hours:" + employeeHours);
        }
        int TotalEmployeeWage = TotalEmployeeHours * EmployeeRatePerHour;
        System.out.println("Total Employee Wage: " + TotalEmployeeWage);
        return TotalEmployeeWage;
    }

    public static void main(String[] args) {
        computeEmployeeWage("Swiggy", 20,2,10);
        computeEmployeeWage("Zomato", 10,4,20);
    }
}

