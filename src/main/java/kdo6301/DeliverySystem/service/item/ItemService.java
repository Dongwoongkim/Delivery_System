package kdo6301.DeliverySystem.service.item;

import kdo6301.DeliverySystem.domain.Item;

import java.util.List;
import java.util.Optional;

public interface ItemService {
    public Item save(Item item);

    public void update(Long itemId, ItemUpdateDto itemUpdateDto);

    public Optional<Item> findById(Long id);

    public List<Item> findItems(ItemSearchCond cond);
}
