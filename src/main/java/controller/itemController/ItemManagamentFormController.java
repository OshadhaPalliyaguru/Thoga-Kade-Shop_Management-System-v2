package controller.itemController;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Item;

import java.net.URL;
import java.util.ResourceBundle;

public class ItemManagamentFormController implements Initializable {


    ObservableList<Item>items = FXCollections.observableArrayList();

    ItemManagemantService itemManagemantService = new ItemManagamentController();

    @FXML
    private Button addbtn;

    @FXML
    private Button back;

    @FXML
    private TableColumn<?, ?> coldescription;

    @FXML
    private TableColumn<?, ?> colinstock;

    @FXML
    private TableColumn<?, ?> colitemcode;

    @FXML
    private TableColumn<?, ?> colpacksize;

    @FXML
    private TableColumn<?, ?> colunitprice;

    @FXML
    private JFXTextArea descriptiontxt;

    @FXML
    private JFXTextField itemCodeid;

    @FXML
    private JFXTextField packsizetxt;

    @FXML
    private JFXTextField qtyonhandtxt;

    @FXML
    private Button removebtn;

    @FXML
    private TableView<Item> tbleitems;

    @FXML
    private JFXTextField unitpricetxt;

    @FXML
    private Button updatebtn;

    @FXML
    void btnadd(ActionEvent event) {
        Item item = new Item(
                itemCodeid.getText(),
                descriptiontxt.getText(),
                packsizetxt.getText(),
                Double.parseDouble(unitpricetxt.getText()),
                Integer.parseInt(qtyonhandtxt.getText())
        );

        itemManagemantService.addDetails(item);

        loadDetails();


    }

    @FXML
    void btnremove(ActionEvent event) {

    }

    @FXML
    void btnupdate(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        colitemcode.setCellValueFactory(new PropertyValueFactory<>("ItemCode"));
        colitemcode.setCellValueFactory(new PropertyValueFactory<>("Description"));
        colitemcode.setCellValueFactory(new PropertyValueFactory<>("PackSize"));
        colitemcode.setCellValueFactory(new PropertyValueFactory<>("UnitPrice"));
        colitemcode.setCellValueFactory(new PropertyValueFactory<>("QtyOnHand"));
        loadDetails();
    }

    private void loadDetails(){
        items.clear();
        tbleitems.setItems(itemManagemantService.getAllDetails());
    }
}
