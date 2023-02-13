package EmployeeWagePartfour;

public class CompanyEmployeeWage {
    public static int numberOfworkingDays;
    public final String company;
    public final int employeeRatePerHour;
    public final int numberOfWorkingDays;
    public static  int maximumHoursPerMonth;
    public int totalEmployeeWage;
    public CompanyEmployeeWage(String company, int employeeRatePerHour, int numberOfWorkingDays,
                               int maximumHoursPerMonth) {
        this.company = company;
        this.employeeRatePerHour = employeeRatePerHour;
        this.numberOfWorkingDays = numberOfWorkingDays;
        this.maximumHoursPerMonth = maximumHoursPerMonth;
    }

    public void setTotalEmployeeWage(int totalEmployeeWage) {
        this.totalEmployeeWage = totalEmployeeWage;
    }
    @Override
    public String toString(){
    return "Total Employee Wage for Company: "+company+" is: "+totalEmployeeWage;
    }
}

