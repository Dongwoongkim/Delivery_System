package kdo6301.DeliverySystem.domain;

import kdo6301.DeliverySystem.dto.item.ItemResponseDTO;
import kdo6301.DeliverySystem.dto.item.ItemUpdateDto;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Item {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="item_id")
    private Long id;
    private String itemName;

    private Integer price;

    private Integer quantity;

    @OneToMany
    private List<Order> orders;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public Item(Long id, String itemName, Integer price, Integer quantity) {
        this.id = id;
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public static Item toItem(ItemResponseDTO findItem) {
        return new Item(findItem.getId(), findItem.getItemName(), findItem.getPrice(), findItem.getQuantity());
    }

    public static Item toItem(ItemUpdateDto itemUpdateDto) {
        return new Item(itemUpdateDto.getId(), itemUpdateDto.getItemName(), itemUpdateDto.getPrice(), itemUpdateDto.getQuantity());
    }
}
