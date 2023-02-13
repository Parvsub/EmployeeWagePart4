package EmployeeWagePartfour;

public class EmployeeBuilderArray {
public static final int PartTime = 1;
public static final int FullTime = 2;
private int numberOfCompany = 0;
private CompanyEmployeeWage[] companyEmployeeWageArray;
public EmployeeBuilderArray() {
    companyEmployeeWageArray = new CompanyEmployeeWage[5];
}
private void addCompanyEmployeeWage(String company, int employeeRatePerHour, int numberOfWorkingDays,
                                    int maximumHoursPerMonth) {
    companyEmployeeWageArray[numberOfCompany] = new CompanyEmployeeWage(company, employeeRatePerHour, numberOfWorkingDays,
            maximumHoursPerMonth);
    numberOfCompany++;
}
private void computeEmployeeWage(){
    for (int i = 0; i < numberOfCompany; i++){
        companyEmployeeWageArray[i].setTotalEmployeeWage(this.computeEmployeeWage(companyEmployeeWageArray[i]));
        System.out.println(companyEmployeeWageArray[i]);
    }
}
private int computeEmployeeWage(CompanyEmployeeWage companyEmployeeWage){
        int employeeHours = 0;
        int totalEmployeeHours = 0;
        int totalWorkingDays = 0;
        while (totalEmployeeHours <= CompanyEmployeeWage.maximumHoursPerMonth && totalWorkingDays <
                CompanyEmployeeWage.numberOfworkingDays) {
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
    return totalEmployeeHours * companyEmployeeWage.employeeRatePerHour;
}

    public static void main(String[] args) {
        EmployeeBuilderArray employeeWageBuilder = new EmployeeBuilderArray();
        employeeWageBuilder.addCompanyEmployeeWage("DMart",20,
                2,10);
        employeeWageBuilder.addCompanyEmployeeWage("Reliance", 10,
                4,20);
        employeeWageBuilder.computeEmployeeWage();
  }
}