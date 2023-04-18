package kdo6301.DeliverySystem.repository.item;

import kdo6301.DeliverySystem.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ItemRepository extends JpaRepository<Item, Long> {

    void deleteAll();

}
