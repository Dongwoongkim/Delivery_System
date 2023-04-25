package kdo6301.DeliverySystem.service.item;

import kdo6301.DeliverySystem.domain.Item;
import kdo6301.DeliverySystem.dto.item.ItemAddDTO;
import kdo6301.DeliverySystem.dto.item.ItemResponseDTO;
import kdo6301.DeliverySystem.dto.item.ItemSearchDTO;
import kdo6301.DeliverySystem.dto.item.ItemUpdateDto;

import java.util.List;
import java.util.Optional;

public interface ItemService {
    public void save(ItemAddDTO itemAddDTO);

    public void update(Long itemId, ItemUpdateDto itemUpdateDto);

    public Optional<ItemResponseDTO> findById(Long id);

    public List<Item> findItems(ItemSearchDTO cond);
}
