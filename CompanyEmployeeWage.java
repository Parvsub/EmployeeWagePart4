package EmployeeWagePartfour;

import java.util.ArrayList;
import java.util.HashMap;

interface IEmployeeWageComputation
{
    public void addCompany(String companyName, int wagePerHr, int maxWorkingDays, int maxWorkingHrs);

    public void calculateTotalWage();

    public int getTotalEmpWage(String companyName);
}

class CompanyEmpWage
{
    // instance constants
    final String Companyname;
    final int WagePerHour;
    final int maximumWorkingDays;
    final int maximumWorkingHours;
    // instance variable
    int totalEmpWage;

    //parameterized constructor to get and set the values
    CompanyEmpWage(String companyName, int wagePerHr, int maxWorkingDays, int maxWorkingHrs)
    {
        Companyname = companyName;
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
    public String toString() {
        System.out.println("Details of " + Companyname + " employee");
        System.out.println("-----------------------------------------------------");
        System.err.println("Wage per hour:" + WagePerHour);
        System.out.println("Maximum working days:" + maximumWorkingDays);
        System.out.println("Maximum working hours:" + maximumWorkingHours);
        return "Total wage for a month of " + Companyname + " employee is " + totalEmpWage + "\n";
    }
}

class EmployeeWageComputation implements IEmployeeWageComputation
{
    // class constants
    public static final int PART_TIME = 1;
    public static final int FULL_TIME = 2;
    // instance variables

    //references of companyempwage objects are stored in arraylist
    ArrayList<CompanyEmpWage> companies;
    //companyname is mapped with total employee wage
    HashMap<String, Integer> totalEmpWages;

    //defalut constructor
    public EmployeeWageComputation()
    {
        companies = new ArrayList<>();
        totalEmpWages = new HashMap<>();
    }

    //it creats companyempwage objects and add to the arraylist
    public void addCompany(String companyName, int wagePerHr, int maxWorkingDays, int maxWorkingHrs)
    {
        CompanyEmpWage company = new CompanyEmpWage(companyName, wagePerHr, maxWorkingDays, maxWorkingHrs);
        companies.add(company);
        totalEmpWages.put(companyName, 0);
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
        System.out.println("Computation of total wage of " + companyEmpWage.Companyname + " employee");
        System.out.println("-----------------------------------------------------");
        System.out.printf("%4s\t%4s\t%2s\t%4s\n", "Day", "Workinghrs", "Wage", "Total working hrs");

        int workingHrs, totalWage = 0;
        for (int day = 1, totalWorkingHrs = 0; day <= companyEmpWage.maximumWorkingDays
                && totalWorkingHrs <= companyEmpWage.maximumWorkingHours; day++, totalWorkingHrs += workingHrs)
        {
            int empType = generateEmployeeType();
            workingHrs = getWorkingHrs(empType);
            int wage = workingHrs * companyEmpWage.WagePerHour;
            totalWage += wage;
            System.out.printf("%4d\t%5d\t%10d\t%10d\n", day, workingHrs, wage, totalWorkingHrs + workingHrs);
        }
        totalEmpWages.put(companyEmpWage.Companyname, totalWage);
        return totalWage;
    }

    public int getTotalEmpWage(String companyName)
    {
        return totalEmpWages.get(companyName);
    }

    public static void main(String args[])
    {
        EmployeeWageComputation employeeWageComputation = new EmployeeWageComputation();
        employeeWageComputation.addCompany("Qsonic", 4, 30, 100);
        employeeWageComputation.addCompany("TechMahindra", 5, 40, 170);
        employeeWageComputation.addCompany("Tesla", 19, 10, 150);
        employeeWageComputation.calculateTotalWage();
        String query = "Qsonic";
        int totalWage = employeeWageComputation.getTotalEmpWage(query);
        System.out.println("Total Employee Wage for " + query + " company is " + totalWage);
    }
}

