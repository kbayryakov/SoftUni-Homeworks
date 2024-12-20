package CompanyRoster;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static java.util.stream.Collectors.groupingBy;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Employee> employees = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            double salary = Double.parseDouble(input[1]);
            String position = input[2];
            String dept = input[3];
            Employee employee = null;

            if (input.length == 4) {
                employee = new Employee(name, salary, position, dept);
            } else if (input.length == 5) {
                if (input[4].matches("\\d+")) {
                    int age = Integer.parseInt(input[4]);
                    employee = new Employee(name, salary, position, dept, age);
                } else {
                    String email = input[4];
                    employee = new Employee(name, salary, position, dept, email);
                }
            } else if (input.length == 6) {
                String email = input[4];
                int age = Integer.parseInt(input[5]);
                employee = new Employee(name, salary, position, dept, email, age);
            }

            employees.add(employee);
        }

        Map<String, List<Employee>> departments = employees.stream().collect(groupingBy(Employee::getDepartment));

        Map.Entry<String, List<Employee>> highDeptSalary = departments.entrySet().stream().sorted((e1, e2) -> {
            double e1AvgSalary = e1.getValue().stream().mapToDouble(Employee::getSalary).average().getAsDouble();
            double e2AvgSalary = e1.getValue().stream().mapToDouble(Employee::getSalary).average().getAsDouble();
            return Double.compare(e2AvgSalary, e1AvgSalary);
        }).findFirst().orElse(null);

        System.out.printf("Highest Average Salary: %s\n", highDeptSalary.getKey());
        highDeptSalary.getValue()
                .stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(System.out::println);
    }
}
