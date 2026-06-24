public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public String findCustomerById(int id) {
        if (id == 1) {
            return "Kalyan";
        }
        else if (id == 2) {
            return "Ranjan";
        }
        else {
            return "Customer Not Found";
        }
    }
}