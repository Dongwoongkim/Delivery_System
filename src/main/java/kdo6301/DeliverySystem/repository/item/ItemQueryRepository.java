package kdo6301.DeliverySystem.repository.item;


import com.querydsl.jpa.impl.JPAQueryFactory;
import kdo6301.DeliverySystem.domain.Item;
import kdo6301.DeliverySystem.service.item.ItemSearchCond;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ItemQueryRepository {
    private final JPAQueryFactory query;

    public ItemQueryRepository(EntityManager em)
    {
        this.query = new JPAQueryFactory(em);
    }

}
