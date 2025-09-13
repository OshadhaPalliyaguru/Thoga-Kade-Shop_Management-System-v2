package controller.dashboardController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardController {

    Stage customermanagementStage = new Stage();
    @FXML
    private Button customerbtn;

    @FXML
    private Button itembtn;

    @FXML
    private Button orderbtn;

    @FXML
    void customer(ActionEvent event) {
        try {
            customermanagementStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/customerManagementUi.fxml"))));
            customermanagementStage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void item(ActionEvent event) {

    }

    @FXML
    void order(ActionEvent event) {

    }

}
