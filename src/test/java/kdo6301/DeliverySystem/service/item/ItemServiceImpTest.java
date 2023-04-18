package kdo6301.DeliverySystem.service.item;

import kdo6301.DeliverySystem.domain.Item;
import kdo6301.DeliverySystem.repository.item.ItemRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class ItemServiceImpTest {

    @Autowired
    ItemRepository itemRepository;

    @Test
    void save() {
        itemRepository.save(new Item("test", 1000, 10));
    }

}