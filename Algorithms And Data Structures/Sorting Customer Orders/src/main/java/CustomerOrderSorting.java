import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Order {
    private int orderId;
    private String customerName;
    private int totalPrice;

    public Order(int orderId, String customerName, int totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void display() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Total Price: " + totalPrice);
    }
}

public class CustomerOrderSorting {

    private static void swap(List<Order> orders, int i, int j){
        Order temp = orders.get(i);
        orders.set(i, orders.get(j));
        orders.set(j, temp);
    }

    public static void bubbleSort(List<Order> orders){
        int size = orders.size();

        for(int i = 0; i<size - 1; i++){
            boolean sorted = true;

            for(int j = 0; j<size - i - 1; j++){
                if(orders.get(j).getTotalPrice() > orders.get(j + 1).getTotalPrice()){
                    swap(orders, j , j + 1);
                    sorted = false;
                }
            }

            if(sorted){
                break;
            }
        }
    }

    public static void quickSort(List<Order> orders, int left, int right){
        if(left >= right) {
            return;
        }

        int pivotIndex = partition(orders, left, right);

        quickSort(orders, left, pivotIndex - 1);
        quickSort(orders, pivotIndex + 1, right);
    }

    private static int partition(List<Order> orders, int left, int right){
        int randomIndex = left + (int) (Math.random() * (right - left + 1));

        swap(orders, randomIndex, right);

        int priceAtPivot = orders.get(right).getTotalPrice();

        for(int i = left; i<right; i++){
            if(orders.get(i).getTotalPrice() <= priceAtPivot){
                swap(orders, i, left);
                left++;
            }
        }

        swap(orders, left, right);
        return left;
    }

    public static void displayOrders(List<Order> orders){
        System.out.println("\n--- Customer Orders ---\n");
        for(Order order: orders){
            order.display();
            System.out.println();
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Order> orders = new ArrayList<>();

        orders.add(new Order(1, "Kalyan", 10500));
        orders.add(new Order(2, "Vikash", 15275));
        orders.add(new Order(3, "Ranjan",  10000));

        System.out.println("\n --- Sorting Customer Orders --- \n");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Quick Sort");
        System.out.println("3. Exit");

        System.out.print("\nChoose The Algorithm To Sort Orders By Their Total Price: ");
        int choice = sc.nextInt();

        switch(choice){
            case 1:
                bubbleSort(orders);
                displayOrders(orders);
                break;
            case 2:
                quickSort(orders, 0, orders.size() - 1);
                displayOrders(orders);
                break;
            case 3:
                System.out.println("Exiting ...");
                return;
            default:
                System.out.println("Invalid Choice");
        }
        sc.close();
    }
}
