package kdo6301.DeliverySystem.service.order;

import kdo6301.DeliverySystem.domain.Order;
import kdo6301.DeliverySystem.repository.order.OrderRepository;

public interface OrderService {
    public Order save(Order order);
}
