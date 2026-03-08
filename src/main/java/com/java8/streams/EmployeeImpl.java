package com.java8.streams;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeImpl {

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee(1, "Surya", 25, "IT", 60000),
                new Employee(2, "Mahesh", 30, "HR", 50000),
                new Employee(3, "Kiran", 28, "IT", 75000),
                new Employee(4, "Anil", 35, "Finance", 90000),
                new Employee(5, "Suresh", 40, "IT", 120000),
                new Employee(6, "Ravi", 22, "HR", 40000),
                new Employee(7, "John", 29, "Finance", 85000),
                new Employee(8, "Sam", 31, "IT", 95000)
                );

        // Print all employees
        List<Employee> allEmployees = employees.stream().toList();
        //System.out.println("1. allEmployees);

        // Extract all Employee names
        List<String> allEmployeesNames = employees.stream().map(Employee::getName).toList();
        //System.out.println("2. " + allEmployeesNames);

        //Extract all employee salaries
        List<Double> allEmployeesSalaries = employees.stream().map(Employee::getSalary).toList();
        //System.out.println("3. " + allEmployeesSalaries);

        //Extract employees whose salary is greater than 75000
        List<Employee> highSalaryEmployees = employees.stream().filter(e -> e.getSalary() > 75000).toList();
        //System.out.println(highSalaryEmployees);

        //Filter employees from IT department
        List<Employee> itEmployees = employees.stream().filter(emp -> "IT".equals(emp.getDepartment())).toList();
        //System.out.println(itEmployees);

        //Total Employee count
        long employeesCount = employees.stream().count();
        long employeesCount1 = employees.size();
        //System.out.println(employeesCount);

        //HR employees count
        long hrEmployeeCount = employees.stream().filter(emp -> "HR".equals(emp.getDepartment())).count();
        ///System.out.println(hrEmployeeCount);

        //Highest salary employee
        //Highest Salary Employee max
        //Lowest Salary Employee min
        Employee highestSalaryEmployee = employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).findFirst().orElse(null);
        Employee max = employees.stream().max(Comparator.comparing(Employee::getSalary)).orElse(null);
        Employee min = employees.stream().min(Comparator.comparing(Employee::getSalary)).orElse(null);
        //System.out.println(highestSalaryEmployee);
        //System.out.println(max);
        //System.out.println(min);

        //Average salary
        double empAvgSalary = employees.stream().mapToDouble(Employee::getSalary).average().orElse(0);
        //System.out.println(empAvgSalary);

        //Total salary using SUM
        double sum = employees.stream().mapToDouble(Employee::getSalary).sum();
        //System.out.println(sum);

        //Total Salary using reduce
        double reduce = employees.stream().mapToDouble(Employee::getSalary).reduce(0, Double::sum);
       // System.out.println(reduce);

        //Group employees by Department
        Map<String, List<Employee>> collect = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        //System.out.println(collect);

        //Count Employees by Department
        Map<String, Long> collect1 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        //System.out.println(collect1);

        //Average Salary Per Department
        Map<String, Double> collect2 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(collect2);

        // Highest Salary Employee Per Department
        employees.stream()
    }


}
