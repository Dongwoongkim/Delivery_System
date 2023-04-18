package kdo6301.DeliverySystem.service.item;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class ItemSearchCond {
    private String itemName;
    private Integer maxPrice;

}
