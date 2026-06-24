public class CustomerService {
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void getCustomer(int id) {
        String customer = customerRepository.findCustomerById(id);

        if(customer.equals("Customer Not Found")){
            System.out.println(customer);
        }
        else {
            System.out.println("Customer Found: " + customer);
        }
    }
}