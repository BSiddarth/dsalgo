package java8Programes;

import java.util.*;
import java.util.stream.Collectors;

class Employee {
    int empId;
    String empName;
    String empCity;
    String empCountry;
    double empSalary;
    String empDepartmentName;

    public Employee(int empId, String empName, String empCity, String empCountry, double empSalary, String empDepartmentName) {
        this.empId = empId;
        this.empName = empName;
        this.empCity = empCity;
        this.empCountry = empCountry;
        this.empSalary = empSalary;
        this.empDepartmentName = empDepartmentName;
    }

    @Override
    public String toString() {
        return "java8Programes.Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empCity='" + empCity + '\'' +
                ", empCountry='" + empCountry + '\'' +
                ", empSalary=" + empSalary +
                ", empDepartmentName='" + empDepartmentName + '\'' +
                '}';
    }
}

public class EmployeeManagement {
    public static void main(String[] args) {
        // Creating a list of employees
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Alice", "New York", "USA", 55000, "HR"));
        employees.add(new Employee(2, "Bob", "Los Angeles", "USA", 60000, "IT"));
        employees.add(new Employee(3, "Aria", "Chicago", "USA", 65000, "Finance"));
        employees.add(new Employee(4, "Ethan", "New York", "USA", 50000, "IT"));
        employees.add(new Employee(5, "Amelia", "Chicago", "USA", 75000, "HR"));

        // 1. Sort the employees by name
        List<Employee> sortedByName = employees.stream()
                .sorted(Comparator.comparing(emp -> emp.empName))
                .collect(Collectors.toList());
        System.out.println("Sorted Employees by Name:");
        sortedByName.forEach(System.out::println);

        // 2. Filter employees whose name starts with 'A'
        List<Employee> startsWithA = employees.stream()
                .filter(emp -> emp.empName.startsWith("A"))
                .collect(Collectors.toList());
        System.out.println("\nEmployees whose name starts with 'A':");
        startsWithA.forEach(System.out::println);

        // 3. Calculate total salary of all employees
        double totalSalary = employees.stream()
                .mapToDouble(emp -> emp.empSalary)
                .sum();
        System.out.println("\nTotal Salary of All Employees: $" + totalSalary);

        // 4. Count total employees in a specific city (e.g., "New York")
        String city = "New York";
        long countByCity = employees.stream()
                .filter(emp -> emp.empCity.equals(city))
                .count();
        System.out.println("\nTotal Employees in " + city + ": " + countByCity);
    }
}

