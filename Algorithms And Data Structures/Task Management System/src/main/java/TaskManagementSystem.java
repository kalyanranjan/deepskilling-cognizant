import java.util.Scanner;

class Task {
    int taskId;
    String taskName;
    String status;
    Task next;

    public Task(int taskId, String taskName, String status){
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
        this.next = null;
    }

    public void display(){
        System.out.println("Task ID: " + taskId);
        System.out.println("Task Name: " + taskName);
        System.out.println("Status: " + status);
        System.out.println();
    }
}

public class TaskManagementSystem {
    private static Task head = null;

    public static void addTask(int taskId, String taskName, String status) {
        Task newTask = new Task(taskId, taskName, status);

        if(head == null){
            head = newTask;
        }

        else{
            Task current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = newTask;
        }
    }

    public static void searchTask(int taskId) {
        Task current = head;

        while (current != null) {
            if(current.taskId == taskId){
                System.out.println("\nFound: " + current.taskName + " | Status: " + current.status);
                return;
            }
            current = current.next;
        }

        System.out.println("\nTask Not Found");
    }

    public static void deleteTask(int taskId) {
        if(head == null){
            return;
        }

        if(head.taskId == taskId){
            head = head.next;
            return;
        }

        Task current = head;

        while(current.next != null){
            if(current.next.taskId == taskId){
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    public static void traverse() {
        Task current = head;

        if(current == null) {
            System.out.println("\nList Is Empty");
        }

        while(current != null){
            System.out.println("\nID: " + current.taskId + " | Name: " + current.taskName + " | Status: " + current.status);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        System.out.println("\n --- Task Management System ---");

        while(running){
            System.out.println("\n1. Add");
            System.out.println("2. Search");
            System.out.println("3. Delete");
            System.out.println("4. Traverse");
            System.out.println("5. Exit");

            System.out.print("\nEnter Your Choice: ");
            int choice = sc.nextInt();

            switch(choice){
                case 1:
                    System.out.print("\nEnter Task ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Task Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Status: ");
                    String status = sc.nextLine();

                    addTask(id, name, status);
                    break;

                case 2:
                    System.out.print("\nEnter Task ID To Search: ");
                    searchTask(sc.nextInt());
                    break;

                case 3:
                    System.out.print("\nEnter Task ID To Delete: ");
                    deleteTask(sc.nextInt());
                    break;

                case 4:
                    traverse();
                    break;

                case 5:
                    running = false;
                    break;
            }
        }
        sc.close();
    }
}
