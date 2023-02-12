package EmployeeWagePartfour;

public class EmployeeWage {
            void AddPartTime(int FullTime, int PartTime, int WagePerHour, int EmployeeHours, int EmployeeWage){
            double employeeCheck = Math.floor(Math.random() * 10) % 3;
            if (employeeCheck == FullTime) {
                EmployeeHours = 8;
            }
            else if (employeeCheck == PartTime){
                EmployeeHours = 4;
            }
            else {
                EmployeeHours = 0;
            }
            EmployeeWage = EmployeeHours * WagePerHour;
            System.out.println("employeeWage : "+EmployeeWage);
        }

            public static void main(String[] args) {
            EmployeeWage partTimeEmployee = new EmployeeWage();
            partTimeEmployee.AddPartTime(2,1,20,0,0);
        }
    }

