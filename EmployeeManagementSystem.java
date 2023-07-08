package employeemanagementsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeManagementSystem {
    private static List<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Employee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Search Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    addEmployee(scanner);
                    break;
                case 2:
                    viewEmployees();
                    break;
                case 3:
                    updateEmployee(scanner);
                    break;
                case 4:
                    searchEmployee(scanner);
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
        scanner.close();
    }

    private static void addEmployee(Scanner scanner) {
        System.out.print("Enter employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        // Check if the ID already exists
        if (isDuplicateId(id)) {
            System.out.println("Employee ID already exists. Please enter a unique ID.");
            System.out.println();
            return;
        }

        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();

        System.out.print("Enter employee age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        System.out.print("Enter employee designation: ");
        String designation = scanner.nextLine();

        Employee employee = new Employee(id, name, age, designation);
        employees.add(employee);

        System.out.println("Employee added successfully!");
        System.out.println();
    }

    private static boolean isDuplicateId(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return true; // ID already exists
            }
        }
        return false; // ID is unique
    }


    private static void viewEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            System.out.println("Employee List:");
            for (Employee employee : employees) {
                System.out.println("ID: " + employee.getId());
                System.out.println("Name: " + employee.getName());
                System.out.println("Age: " + employee.getAge());
                System.out.println("Designation: " + employee.getDesignation());
                System.out.println();
            }
        }
    }

    private static void updateEmployee(Scanner scanner) {
        System.out.print("Enter employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        Employee employee = findEmployeeById(id);
        if (employee == null) {
            System.out.println("Employee not found.");
        } else {
            System.out.println("Employee Details:");
            System.out.println("ID: " + employee.getId());
            System.out.println("Name: " + employee.getName());
            System.out.println("Age: " + employee.getAge());
            System.out.println("Designation: " + employee.getDesignation());

            System.out.println("Enter new details:");

            System.out.print("Enter employee name: ");
            String name = scanner.nextLine();

            System.out.print("Enter employee age: ");
            int age = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            System.out.print("Enter employee designation: ");
            String designation = scanner.nextLine();

            employee.setName(name);
            employee.setAge(age);
            employee.setDesignation(designation);

            System.out.println("Employee updated successfully!");
            System.out.println();
        }
    }

    private static void searchEmployee(Scanner scanner) {
        System.out.print("Enter employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        Employee employee = findEmployeeById(id);
        if (employee == null) {
            System.out.println("Employee not found.");
        } else {
            System.out.println("Employee Details:");
            System.out.println("ID: " + employee.getId());
            System.out.println("Name: " + employee.getName());
            System.out.println("Age: " + employee.getAge());
            System.out.println("Designation: " + employee.getDesignation());
            System.out.println();
        }
    }

    private static Employee findEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }
}
