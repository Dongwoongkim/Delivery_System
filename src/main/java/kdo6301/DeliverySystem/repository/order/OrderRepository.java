package kdo6301.DeliverySystem.repository.order;

import com.querydsl.jpa.impl.JPAQueryFactory;
import kdo6301.DeliverySystem.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}