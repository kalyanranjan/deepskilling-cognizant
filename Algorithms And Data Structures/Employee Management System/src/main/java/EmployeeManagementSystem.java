import java.util.Scanner;

class Employee {
    private int employeeId;
    private String name;
    private String position;
    private int salary;

    public Employee(int employeeId, String name, String position, int salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void display() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Position: " + position);
        System.out.println("Salary: " + salary);
    }
}

public class EmployeeManagementSystem {
    static Employee[] employees = new Employee[100];
    static int employeeCount = 0;

    public static void addEmployee(Scanner sc){
        if(employeeCount < employees.length){
            System.out.print("\nEnter Employee ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Employee Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Position: ");
            String position = sc.nextLine();

            System.out.print("Enter Salary: ");
            int salary = sc.nextInt();

            if(salary < 0){
                System.out.println("\nSalary Cannot Be Negative !");
                return;
            }

            employees[employeeCount] = new Employee(id, name, position, salary);
            employeeCount++;

            System.out.println("\nEmployee Added");
        }
        else {
            System.out.println("\nEmployees List Is Full");
        }
    }

    public static void deleteEmployee(Scanner sc){
        System.out.print("\nEnter ID To Delete Employee: ");
        int id = sc.nextInt();

        boolean found = false;

        for(int i = 0; i<employeeCount; i++){
            if(employees[i].getEmployeeId() == id){
                for(int j = i; j<employeeCount - 1; j++){
                    employees[j] = employees[j + 1];
                }

                employees[employeeCount - 1] = null;
                employeeCount--;

                found = true;
                System.out.println("\nEmployee Deleted");
                break;
            }
        }

        if(!found){
            System.out.println("\nNot Found");
        }
    }

    public static void searchEmployee(Scanner sc){
        System.out.print("\nEnter ID To Search Employee: ");
        int id = sc.nextInt();

        boolean found = false;

        for(int i = 0; i<employeeCount; i++){
            if(employees[i].getEmployeeId() == id){
                employees[i].display();
                found = true;
                break;
            }
        }

        if(!found){
            System.out.println("\nNot Found");
        }
    }

    public static void displayEmployees(){
        if(employeeCount == 0){
            System.out.println("\nNo Employees");
        }
        else {
            for(int i = 0; i<employeeCount; i++){
                employees[i].display();
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n--- Employee Management System ---\n");

        while (true) {
            System.out.println("\n1. Add Employee");
            System.out.println("2. Search Employee");
            System.out.println("3. Display All");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");

            System.out.print("\nEnter Choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addEmployee(sc);
                    break;
                case 2:
                    searchEmployee(sc);
                    break;
                case 3:
                    displayEmployees();
                    break;
                case 4:
                    deleteEmployee(sc);
                    break;
                case 5:
                    sc.close();
                    return;
                default:
                    System.out.println("\nInvalid Choice");
            }
        }
    }
}
