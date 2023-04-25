package kdo6301.DeliverySystem.dto.item;

import kdo6301.DeliverySystem.domain.Item;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class ItemDTO {

    private Long id;
    @NotEmpty
    private String itemName;

    @NotNull
    private Integer price;

    @NotNull
    private Integer quantity;

    public ItemDTO(Long id, String itemName, Integer price, Integer quantity) {
        this.id = id;
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public static ItemDTO toDto(Item item)
    {
        return new ItemDTO(item.getId(), item.getItemName(), item.getPrice(), item.getQuantity());
    }
}
