package kdo6301.DeliverySystem.service.item;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class ItemUpdateDto {

    @NotEmpty
    private String itemName;
    @NotNull
    private Integer price;

    @NotNull
    private Integer quantity;

    public ItemUpdateDto() {}

    public ItemUpdateDto(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
