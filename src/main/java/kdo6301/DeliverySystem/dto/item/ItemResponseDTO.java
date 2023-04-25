package kdo6301.DeliverySystem.dto.item;

import kdo6301.DeliverySystem.domain.Item;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class ItemResponseDTO {

    private Long id;
    @NotEmpty
    private String itemName;

    @NotNull
    private Integer price;

    @NotNull
    private Integer quantity;

    public ItemResponseDTO(Long id, String itemName, Integer price, Integer quantity) {
        this.id = id;
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public static ItemResponseDTO toResponseDto(Item item)
    {
        return new ItemResponseDTO(item.getId(), item.getItemName(), item.getPrice(), item.getQuantity());
    }

    public static ItemUpdateDto toUpdateDto(ItemResponseDTO itemResponseDTO) {
        return new ItemUpdateDto(itemResponseDTO.getId(), itemResponseDTO.getItemName(), itemResponseDTO.getPrice(), itemResponseDTO.getQuantity());
    }
}
