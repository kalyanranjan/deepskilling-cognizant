import java.util.Scanner;

class Product {
    private int productId;
    private String productName;
    private String category;

    public Product(int productId, String productName, String category){
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public int getProductId(){
        return productId;
    }

    public void display(){
        System.out.println("Product ID: " + productId);
        System.out.println("Product Name: " + productName);
        System.out.println("Category: " + category);
    }
}

public class ECommercePlatformSearchFunction {

    public static Product linearSearch(Product[] products, int targetProduct){
        for(Product product : products){
            if(product.getProductId() == targetProduct){
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, int targetProduct){
        int low = 0;
        int high = products.length - 1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            int midProductId = products[mid].getProductId();

            if(midProductId == targetProduct){
                return products[mid];
            }

            if(midProductId < targetProduct){
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        System.out.println("\n--- E-Commerce Platform Search ---\n");

        Product[] products = {
                new Product(1, "PlayStation 5", "Electronics"),
                new Product(2, "MacBook Pro", "Electronics"),
                new Product(3, "Atomic Habits", "Books"),
                new Product(4, "Bhagavad Gita", "Books")
        };

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Product ID To Search: ");
        int targetProduct = sc.nextInt();

        System.out.println("\nChoose The Algorithm To Use For The Search: ");
        System.out.println("1. Linear Search");
        System.out.println("2. Binary Search");

        System.out.print("\nEnter Your Choice: ");
        int choice = sc.nextInt();

        Product result;

        if(choice == 1){
            result = linearSearch(products, targetProduct);
        }
        else {
            result = binarySearch(products, targetProduct);
        }

        if(result != null){
            System.out.println("\n--- Product Found --- \n");
            result.display();
        }
        else {
            System.out.println("Product Not Found");
        }

        sc.close();
    }
}
