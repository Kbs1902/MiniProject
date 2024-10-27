import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManagementSystem {
    private static ArrayList<Employee> employees = new ArrayList<>();
    private static int nextId = 1; // To keep track of the next available ID

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Employee Management System ---");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee Salary");
            System.out.println("3. Delete Employee");
            System.out.println("4. Display Employees");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: // Add Employee
                    System.out.print("Enter Employee Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Employee Salary: ");
                    double salary = scanner.nextDouble();
                    employees.add(new Employee(name, nextId++, salary));
                    System.out.println("Employee added successfully.");
                    break;

                case 2: // Update Employee Salary
                    System.out.print("Enter Employee ID to update salary: ");
                    int idToUpdate = scanner.nextInt();
                    boolean foundForUpdate = false;
                    for (Employee emp : employees) {
                        if (emp.id == idToUpdate) {
                            System.out.print("Enter new salary: ");
                            emp.salary = scanner.nextDouble();
                            System.out.println("Salary updated successfully.");
                            foundForUpdate = true;
                            break;
                        }
                    }
                    if (!foundForUpdate) {
                        System.out.println("Employee not found.");
                    }
                    break;

                case 3: // Delete Employee
                    System.out.print("Enter Employee ID to delete: ");
                    int idToDelete = scanner.nextInt();
                    boolean foundForDelete = false;
                    for (int i = 0; i < employees.size(); i++) {
                        if (employees.get(i).id == idToDelete) {
                            employees.remove(i);
                            System.out.println("Employee deleted successfully.");
                            foundForDelete = true;
                            break;
                        }
                    }
                    if (!foundForDelete) {
                        System.out.println("Employee not found.");
                    }
                    break;

                case 4: // Display Employees
                    System.out.println("Employee List:");
                    for (Employee emp : employees) {
                        emp.display();
                    }
                    break;

                case 5: // Exit
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}