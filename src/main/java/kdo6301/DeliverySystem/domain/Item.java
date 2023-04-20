package kdo6301.DeliverySystem.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Item {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="item_id")
    private Long id;

    @NotBlank(message = "{error.itemName}")
    private String itemName;

    @NotNull(message = "{error.price}")
    private Integer price;

    @NotNull(message = "{error.quantity}")
    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
