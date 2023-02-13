package EmployeeWagePartfour;

import java.util.ArrayList;
import java.util.HashMap;

interface IEmployeeWageComputation
{
    public void addCompany(String companyName, int wagePerHr, int maxWorkingDays, int maxWorkingHrs);

    public void calculateTotalWage();
}

class CompanyEmpWage
{
    // instance constants
    final String Companynane;
    final int WagePerHour;
    final int maximumWorkingDays;
    final int maximumWorkingHours;
    // instance variable
    int totalEmpWage;

    CompanyEmpWage(String companyName, int wagePerHr, int maxWorkingDays, int maxWorkingHrs)
    {
        Companynane = companyName;
        WagePerHour = wagePerHr;
        maximumWorkingDays = maxWorkingDays;
        maximumWorkingHours = maxWorkingHrs;
        totalEmpWage = 0;
    }

    void setTotalEmployeeWage(int totalEmpWage)
    {
        this.totalEmpWage = totalEmpWage;
    }

    @Override
    public String toString()
    {
        System.out.println("Details of " + Companynane+ " employee");
        System.out.println("-----------------------------------------------------");
        System.err.println("Wage per hour:" + WagePerHour);
        System.out.println("Maximum working days:" + maximumWorkingDays);
        System.out.println("Maximum working hours:" + maximumWorkingHours);
        return "Total wage for a month of " + Companynane + " employee is " + totalEmpWage + "\n";
    }
}

class EmployeeWageComputation implements IEmployeeWageComputation
{
    // class constants
    public static final int PART_TIME = 1;
    public static final int FULL_TIME = 2;
    // instance variables
    ArrayList<CompanyEmpWage> companies;
    HashMap<String, Integer> totalEmpWages;

    public EmployeeWageComputation()
    {
        companies = new ArrayList<>();
        totalEmpWages = new HashMap<>();
    }

    public void addCompany(String companyName, int wagePerHr, int maxWorkingDays, int maxWorkingHrs)
    {
        CompanyEmpWage company = new CompanyEmpWage(companyName, wagePerHr, maxWorkingDays, maxWorkingHrs);
        companies.add(company);
        totalEmpWages.put(companyName,0);
    }

    int generateEmployeeType()
    {
        return (int) (Math.random() * 100) % 3;
    }

    int getWorkingHrs(int empType)
    {
        switch (empType)
        {
            case FULL_TIME:
                return 8;
            case PART_TIME:
                return 4;
            default:
                return 0;
        }
    }

    public void calculateTotalWage()
    {
        for (CompanyEmpWage company : companies)
        {
            int totalWage = calculateTotalWage(company);
            company.setTotalEmployeeWage(totalWage);
            System.out.println(company);
        }
    }

    int calculateTotalWage(CompanyEmpWage companyEmpWage)
    {
        System.out.println("Computation of total wage of " + companyEmpWage.Companynane + " employee");
        System.out.println("-----------------------------------------------------");
        System.out.printf("%5s     %5s     %5s     %5s\n", "Day", "Workinghrs", "Wage", "Total working hrs");

        int workingHrs, totalWage = 0;
        for (int day = 1, totalWorkingHrs = 0; day <= companyEmpWage.maximumWorkingDays
                && totalWorkingHrs <= companyEmpWage.maximumWorkingHours; day++, totalWorkingHrs += workingHrs)
        {
            int empType = generateEmployeeType();
            workingHrs = getWorkingHrs(empType);
            int wage = workingHrs * companyEmpWage.WagePerHour;
            totalWage += wage;
            System.out.printf("%5d       %5d      %5d      %5d\n", day, workingHrs, wage, totalWorkingHrs + workingHrs);
        }
        totalEmpWages.put(companyEmpWage.Companynane, totalWage);
        return totalWage;
    }

    void printTotalEmpWages()
    {
        System.out.println("The Companies and their total Employee Wages are:");
        for (String companyName : totalEmpWages.keySet())
        {
            System.out.println(companyName + ": " + totalEmpWages.get(companyName));
        }

    }

    public static void main(String args[])
    {
        EmployeeWageComputation employeeWageComputation = new EmployeeWageComputation();
        employeeWageComputation.addCompany("Microsoft", 4, 30, 100);
        employeeWageComputation.addCompany("Google", 5, 40, 170);
        employeeWageComputation.addCompany("Amazon", 19, 10, 150);
        employeeWageComputation.calculateTotalWage();
        employeeWageComputation.printTotalEmpWages();
    }
}