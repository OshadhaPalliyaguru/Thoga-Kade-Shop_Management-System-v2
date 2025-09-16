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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Customer;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class CustomerManagementController implements Initializable {


    public JFXTextField salaryTxt;
    public JFXComboBox city;
    public ToggleGroup titleGroup;
    ObservableList<Customer>customers = FXCollections.observableArrayList();
    @FXML
    private Button addnewbtn;

    @FXML
    private JFXTextField address;

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
    private JFXComboBox<?> province;

    @FXML
    private Button removebtn;

    @FXML
    private JFXTextField salary;

    @FXML
    private Button updatebtn;

    public TableColumn colcustomerid;
    public TableColumn colTitle;
    public TableColumn colName;
    public TableColumn coldob;
    public TableColumn colSalary;
    public TableColumn coladdress;
    public TableColumn colcity;
    public TableColumn colProvince;
    public TableColumn colPostalcode;

    @FXML
    void add(ActionEvent event) {

    }

    @FXML
    void remove(ActionEvent event) {

    }

    @FXML
    void update(ActionEvent event) {
int number;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colcustomerid.setCellValueFactory(new PropertyValueFactory<>("custId"));
        colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        coldob.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colSalary.setCellFactory(new PropertyValueFactory<>("salary"));
        coladdress.setCellFactory(new PropertyValueFactory<>("address"));
        colcity.setCellFactory(new PropertyValueFactory<>("city"));
        colProvince.setCellFactory(new PropertyValueFactory<>("province"));
        colPostalcode.setCellValueFactory(new PropertyValueFactory<>("postalcode"));

        loadcustomertble();

    }

    private void loadcustomertble(){

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
    }
}
