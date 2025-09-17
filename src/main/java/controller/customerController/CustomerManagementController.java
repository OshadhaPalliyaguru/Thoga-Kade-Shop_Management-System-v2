package controller.customerController;

import db.Dbconnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Customer;

import java.sql.*;
import java.time.LocalDate;

public class CustomerManagementController implements CustomerManagamentService {


    @Override
    public void addCustomerDetails(Customer cus){
        String SQL = "INSERT INTO customer (CustID , CustTitle, CustName, DOB ,salary,CustAddress, City, Province, PostalCode) VALUES(?,?,?,?,?,?,?,?,?);";

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/thogakade","root","3690");
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setObject(1,cus.getCustId());
            preparedStatement.setObject(2,cus.getTitle() );
            preparedStatement.setObject(3,cus.getName());
            preparedStatement.setObject(4,cus.getDob());
            preparedStatement.setObject(5,cus.getSalary());
            preparedStatement.setObject(6,cus.getAddress());
            preparedStatement.setObject(7,cus.getCity());
            preparedStatement.setObject(8,cus.getProvince());
            preparedStatement.setObject(9,cus.getPostalcode());


            preparedStatement.executeUpdate();



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
  public ObservableList<Customer> getAllDetails(){
        ObservableList<Customer>customers = FXCollections.observableArrayList();

      try {
          Connection connection = Dbconnection.getDbconnection().getConnection();
          PreparedStatement preparedStatement = connection.prepareStatement("Select * from customer");
          ResultSet resultSet = preparedStatement.executeQuery();

          while (resultSet.next()){
              customers.add(new Customer(
                      resultSet.getString("custId"),
                      resultSet.getString("custtitle"),
                      resultSet.getString("custname"),
                      resultSet.getDate("dob").toLocalDate(),
                      resultSet.getDouble("salary"),
                      resultSet.getString("custaddress"),
                      resultSet.getString("city"),
                      resultSet.getString("province"),
                      resultSet.getString("postalcode")


              ));
          }




      } catch (SQLException e) {
          throw new RuntimeException(e);
      }

        return customers;
  }

    @Override
    public void deleteCustomer(Customer cus) {

        try {
            Connection connection = Dbconnection.getDbconnection().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("Delete from Customer Where custId = ?");


            preparedStatement.setObject(1,cus.getCustId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
