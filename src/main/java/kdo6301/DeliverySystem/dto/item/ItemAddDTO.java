package kdo6301.DeliverySystem.dto.item;

import kdo6301.DeliverySystem.domain.Order;
import lombok.Data;

import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class ItemAddDTO {

    @NotBlank(message = "{error.itemName}")
    private String itemName;

    @NotNull(message = "{error.price}")
    private Integer price;

    @NotNull(message = "{error.quantity}")
    private Integer quantity;

    @OneToMany
    private List<Order> orders;

    public ItemAddDTO() {
    }

    public ItemAddDTO(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
