package controller.customerController;

import javafx.collections.ObservableList;
import model.Customer;

public interface CustomerManagamentService {

void addCustomerDetails(Customer cus);

ObservableList<Customer>getAllDetails();

void deleteCustomer(Customer cus);

}
