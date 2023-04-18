package kdo6301.DeliverySystem.service.item;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class ItemUpdateDto {

    private String itemName;
    private Integer price;
    private Integer quantity;

    public ItemUpdateDto() {}

    public ItemUpdateDto(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
