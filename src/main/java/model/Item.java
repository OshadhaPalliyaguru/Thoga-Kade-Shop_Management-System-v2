package model;


import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class Item {

    String itemCode;
    String description;
    String packsize;
    Double unitPrice;
    int qtyOnHand;
}
