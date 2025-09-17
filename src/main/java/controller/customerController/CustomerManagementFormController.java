package controller.customerController;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import db.Dbconnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Customer;

import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class CustomerManagementFormController implements Initializable {




        ObservableList<Customer> customers = FXCollections.observableArrayList();

        @FXML
        private Button addnewbtn;

        @FXML
        private JFXTextField address;

        @FXML
        private Button back;

        @FXML
        private JFXComboBox<String> city;

        @FXML
        private TableColumn<?, ?> colName;

        @FXML
        private TableColumn<?, ?> colPostalcode;

        @FXML
        private TableColumn<?, ?> colProvince;

        @FXML
        private TableColumn<?, ?> colSalary;

        @FXML
        private TableColumn<?, ?> colTitle;

        @FXML
        private TableColumn<?, ?> coladdress;

        @FXML
        private TableColumn<?, ?> colcity;

        @FXML
        private TableColumn<?, ?> colcustomerid;

        @FXML
        private TableColumn<?, ?> coldob;

        @FXML
        private TableView<Customer> custable;

        @FXML
        private DatePicker dateofbirth;

        @FXML
        private JFXTextField idtxt;

        @FXML
        private JFXRadioButton miss;

        @FXML
        private JFXRadioButton mr;

        @FXML
        private JFXRadioButton ms;

        @FXML
        private JFXTextField namrtxt;

        @FXML
        private JFXTextField postalcode;

        @FXML
        private JFXComboBox<String> province;

        @FXML
        private Button removebtn;

        @FXML
        private JFXTextField salary;

        @FXML
        private Button updatebtn;

        @FXML
        private JFXComboBox<String> titlecombox;

        @FXML



        CustomerManagamentService customerManagamentService = new CustomerManagementController();


        @FXML
        void add(ActionEvent event) {
            Customer cus = new Customer(
                    idtxt.getText(),
                    titlecombox.getValue(),
                    namrtxt.getText(),
                    dateofbirth.getValue(),
                    Double.parseDouble(salary.getText()),
                    address.getText(),
                    city.getValue(),
                    province.getValue(),
                    postalcode.getText()
            );



            customerManagamentService.addCustomerDetails(cus);

            loadcustomertble();
        }



        @FXML
        void remove(ActionEvent event) {
            Customer cus = new Customer(
                    idtxt.getText(),
                    titlecombox.getValue(),
                    namrtxt.getText(),
                    dateofbirth.getValue(),
                    Double.parseDouble(salary.getText()),
                    address.getText(),
                    city.getValue(),
                    province.getValue(),
                    postalcode.getText()
            );
customerManagamentService.deleteCustomer(cus);
            loadcustomertble();

        }

        @FXML
        void update(ActionEvent event) {

        }



        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {

            colcustomerid.setCellValueFactory(new PropertyValueFactory<>("custId"));
            colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
            colName.setCellValueFactory(new PropertyValueFactory<>("name"));
            coldob.setCellValueFactory(new PropertyValueFactory<>("dob"));
            colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
            coladdress.setCellValueFactory(new PropertyValueFactory<>("address"));
            colcity.setCellValueFactory(new PropertyValueFactory<>("city"));
            colProvince.setCellValueFactory(new PropertyValueFactory<>("province"));
            colPostalcode.setCellValueFactory(new PropertyValueFactory<>("postalcode"));

            loadcustomertble();

            ObservableList<String> provinceList = FXCollections.observableArrayList(
                    "Western",
                    "Central",
                    "Southern",
                    "North",
                    "Eastern",
                    "North Western",
                    "North Central",
                    "Uva",
                    "Sabaragamuwa"

            );
            province.setItems(provinceList);
            ObservableList<String> cityList = FXCollections.observableArrayList(
                    "Western",
                    "Central",
                    "Southern",
                    "North",
                    "Eastern",
                    "North Western",
                    "North Central",
                    "Uva",
                    "Sabaragamuwa"

            );
            city.setItems(cityList);

            ObservableList<String> gettitleList = FXCollections.observableArrayList("Mr.", "Ms.", "Mrs.", "Miss.");
            titlecombox.setItems(gettitleList);

            custable.getSelectionModel().selectedItemProperty().addListener((observableValue, customer, t1) -> {
                if(t1 !=null){
                    setSelectedValue(t1);
                }
            });

            idtxt.setText("0");


        }



        private void loadcustomertble(){

            customers.clear();
            custable.setItems(customerManagamentService.getAllDetails());


        }

        private void setSelectedValue(Customer cus){
            idtxt.setText(cus.getCustId());
            titlecombox.setValue(cus.getTitle());
            namrtxt.setText(cus.getName());
            dateofbirth.setValue(cus.getDob());
            salary.setText(String.valueOf(cus.getSalary()));
            address.setText(cus.getAddress());
            city.setValue(cus.getCity());
            province.setValue(cus.getProvince());
            postalcode.setText(cus.getPostalcode());

        }
    }


