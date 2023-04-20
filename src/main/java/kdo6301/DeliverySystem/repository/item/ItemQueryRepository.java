package kdo6301.DeliverySystem.repository.item;


import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kdo6301.DeliverySystem.domain.Item;
import kdo6301.DeliverySystem.service.item.ItemSearchCond;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

import static kdo6301.DeliverySystem.domain.QItem.item;

@Repository
@RequiredArgsConstructor
public class ItemQueryRepository {
    private final JPAQueryFactory query;

    public List<Item> findItems(ItemSearchCond cond)
    {
        String itemName = cond.getItemName();
        Integer maxPrice = cond.getMaxPrice();

        return query.select(item)
                .from(item)
                .where(likeItemName(itemName), maxPrice(maxPrice))
                .fetch();
    }

    private BooleanExpression maxPrice(Integer maxPrice) {
        if (maxPrice != null) {
            return item.price.loe(maxPrice);
        }
        return null;
    }

    private BooleanExpression likeItemName(String itemName) {

        if(StringUtils.hasText(itemName))
        {
            return item.itemName.like('%' + itemName + '%');
        }
        return null;
    }
}
