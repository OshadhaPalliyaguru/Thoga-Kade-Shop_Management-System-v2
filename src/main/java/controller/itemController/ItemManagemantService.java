package controller.itemController;

import javafx.collections.ObservableList;
import model.Item;

public interface ItemManagemantService {

    void addDetails(Item item);
    void removeDetails(Item item);
    void UpdateDetail(Item item);

    ObservableList<Item>getAllDetails();
}
