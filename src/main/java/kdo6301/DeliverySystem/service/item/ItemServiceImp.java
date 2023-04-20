package kdo6301.DeliverySystem.service.item;

import kdo6301.DeliverySystem.domain.Item;
import kdo6301.DeliverySystem.repository.item.ItemQueryRepository;
import kdo6301.DeliverySystem.repository.item.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ItemServiceImp implements ItemService {
    private final ItemRepository itemRepository;
    private final ItemQueryRepository queryRepository;
    private final EntityManager em;

    @Override
    public Item save(Item item)
    {
        return itemRepository.save(item);
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
    public Optional<Item> findById(Long id) {
        Optional<Item> findItem = itemRepository.findById(id);
        return findItem;
    }


    // 동적 쿼리
    @Override
    public List<Item> findItems(ItemSearchCond cond){
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
