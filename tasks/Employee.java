package tasks;

import java.util.Scanner;

class Employee {
    private int empId;
    private String empName;
    private double sal;
    private int yearsWorked;

    // Constructor
    public Employee(int empId, String empName, double sal, int yearsWorked) {
        this.empId = empId;
        this.empName = empName;
        this.sal = sal;
        this.yearsWorked = yearsWorked;
    }

    // Method to get employee details
    public void getEmployeeDetails() {
        System.out.println("Employee ID: " + empId);
        System.out.println("Employee Name: " + empName);
        System.out.println("Salary: " + sal);
        System.out.println("Years Worked: " + yearsWorked);
    }

    // Method to set employee details
    public void setEmployeeDetails(int empId, String empName, double sal, int yearsWorked) {
        this.empId = empId;
        this.empName = empName;
        this.sal = sal;
        this.yearsWorked = yearsWorked;
    }

    // Method to check loan eligibility
    public double getLoanEligibility() {
        if (yearsWorked <= 5) {
            return 0;
        } else if (sal >= 15_00_000) {
            return 7_00_000;
        } else if (sal >= 10_00_000) {
            return 5_00_000;
        } else if (sal >= 6_00_000) {
            return 2_00_000;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Employee ID: ");
        int empId = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter Employee Name: ");
        String empName = scanner.nextLine();
        System.out.print("Enter Salary: ");
        double sal = scanner.nextDouble();
        System.out.print("Enter Years Worked: ");
        int yearsWorked = scanner.nextInt();

        Employee emp = new Employee(empId, empName, sal, yearsWorked);
        emp.getEmployeeDetails();
        System.out.println("Loan Eligibility: " + emp.getLoanEligibility());
    }
}
