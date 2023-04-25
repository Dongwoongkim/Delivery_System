package kdo6301.DeliverySystem.service.item;

import kdo6301.DeliverySystem.domain.Item;
import kdo6301.DeliverySystem.dto.item.ItemAddDTO;
import kdo6301.DeliverySystem.dto.item.ItemResponseDTO;
import kdo6301.DeliverySystem.dto.item.ItemSearchDTO;
import kdo6301.DeliverySystem.dto.item.ItemUpdateDto;
import kdo6301.DeliverySystem.repository.item.ItemQueryRepository;
import kdo6301.DeliverySystem.repository.item.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

import static kdo6301.DeliverySystem.dto.item.ItemResponseDTO.toResponseDto;

@Service
@RequiredArgsConstructor
@Transactional
public class ItemServiceImp implements ItemService {
    private final ItemRepository itemRepository;
    private final ItemQueryRepository queryRepository;
    private final EntityManager em;

    @Override
    public void save(ItemAddDTO itemAddDTO)
    {
        itemRepository.save(new Item(
                itemAddDTO.getItemName(),
                itemAddDTO.getPrice(),
                itemAddDTO.getQuantity()));
    }

    @Override
    public void update(Long itemId, ItemUpdateDto itemUpdateDto)
    {
        Item item = itemRepository.findById(itemId).orElseThrow();
        item.setItemName(itemUpdateDto.getItemName());
        item.setPrice(itemUpdateDto.getPrice());
        item.setQuantity(itemUpdateDto.getQuantity());
    }

    @Override
    public Optional<ItemResponseDTO> findById(Long id) {
        Optional<Item> itemOptional = itemRepository.findById(id);
        if (itemOptional.isPresent()) {
            Item item = itemOptional.get();
            return Optional.of(toResponseDto(item));
        } else {
            return Optional.empty();
        }
    }

    // 동적 쿼리
    @Override
    public List<Item> findItems(ItemSearchDTO cond){
        return queryRepository.findItems(cond);
    }

    public List<Item> findAll()
    {
        return itemRepository.findAll();
    }

    public void deleteAll()
    {
        em.createNativeQuery("TRUNCATE TABLE item restart identity").executeUpdate();
    }
}
