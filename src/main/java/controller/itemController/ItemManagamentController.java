package controller.itemController;

import db.Dbconnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemManagamentController implements ItemManagemantService{
    @Override
    public void addDetails(Item item) {
        Connection connection = null;
        try {
            connection = Dbconnection.getDbconnection().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("Insert into item values (?,?,?,?,?)");


            preparedStatement.setObject(1,item.getItemCode());
            preparedStatement.setObject(2,item.getDescription());
            preparedStatement.setObject(3,item.getPacksize());
            preparedStatement.setObject(4,item.getUnitPrice());
            preparedStatement.setObject(5,item.getQtyOnHand());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



    }

    @Override
    public void removeDetails(Item item) {

    }

    @Override
    public void UpdateDetail(Item item) {

    }

    @Override
    public ObservableList<Item> getAllDetails() {

        ObservableList<Item>items = FXCollections.observableArrayList();

        try {
            Connection connection = Dbconnection.getDbconnection().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("Select * from item");
            ResultSet resultSet= preparedStatement.executeQuery();

            while (resultSet.next()){
             items.add(new Item(
                     resultSet.getString("ItemCode"),
                     resultSet.getString("Description"),
                     resultSet.getString("PackSize"),
                     resultSet.getDouble("UnitPrice"),
                     resultSet.getInt("QtyOnHand")
             ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return items;
    }
}
