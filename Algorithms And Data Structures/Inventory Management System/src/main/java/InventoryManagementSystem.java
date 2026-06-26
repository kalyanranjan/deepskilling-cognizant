import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Product {
    private final int productId;
    private String productName;
    private int quantity;
    private double price;

    public Product(int productId, String productName, int quantity, double price){
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public void update(String productName, int quantity, double price){
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public void display(){
        System.out.println("Product ID: " + productId);
        System.out.println("Product Name: " + productName);
        System.out.println("Quantity: " + quantity);
        System.out.println("Price: " + price);
    }
}

public class InventoryManagementSystem {

    private final Map<Integer, Product> inventory = new HashMap<>();
    private final Scanner sc = new Scanner(System.in);

    public void addProduct(){
        System.out.print("\nEnter Product ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Product Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Quantity: ");
        int quantity = sc.nextInt();

        System.out.print("Enter Price: ");
        double price = sc.nextDouble();

        inventory.put(id, new Product(id, name, quantity, price));
        System.out.println("\nProduct Added Successfully");
    }

    public void updateProduct() {
        System.out.print("\nEnter Product ID To Update: ");
        int id = sc.nextInt();
        sc.nextLine();

        Product product = inventory.get(id);

        if(product == null){
            System.out.println("\nProduct Not Found");
            return;
        }

        System.out.print("Enter New Product Name: ");
        String name = sc.nextLine();

        System.out.print("Enter New Quantity: ");
        int quantity = sc.nextInt();

        System.out.print("Enter New Price: ");
        double price = sc.nextDouble();

        product.update(name, quantity, price);
        System.out.println("\nProduct Updated Successfully");
    }

    public void deleteProduct() {
        System.out.print("\nEnter Product ID To Delete: ");
        int id = sc.nextInt();

        if(inventory.remove(id) != null){
            System.out.println("\nProduct Deleted Successfully");
        }
        else {
            System.out.println("\nProduct Not Found");
        }
    }

    public void displayProducts(){
        if(inventory.isEmpty()){
            System.out.println("\nNo Products Available");
            return;
        }

        System.out.println("\n--- Available Products ---\n");

        for(Product product : inventory.values()){
            product.display();
            System.out.println();
        }
    }

    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();

        while (true) {
            System.out.println("\n--- Inventory Management System ---\n");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. View Products");
            System.out.println("5. Exit");

            System.out.print("\nEnter Your Choice: ");
            int choice = ims.sc.nextInt();

            switch(choice){
                case 1:
                    ims.addProduct();
                    break;
                case 2:
                    ims.updateProduct();
                    break;
                case 3:
                    ims.deleteProduct();
                    break;
                case 4:
                    ims.displayProducts();
                    break;
                case 5:
                    ims.sc.close();
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}