package controller.itemController;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ItemManagamentFormController {

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
    private TableView<?> tbleitems;

    @FXML
    private JFXTextField unitpricetxt;

    @FXML
    private Button updatebtn;

    @FXML
    void btnremove(ActionEvent event) {

    }

    @FXML
    void btnupdate(ActionEvent event) {

    }

}
