package kdo6301.DeliverySystem.service.order;

import kdo6301.DeliverySystem.domain.Order;
import kdo6301.DeliverySystem.repository.order.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImp implements OrderService{

    private final OrderRepository orderRepository;

    @Override
    public Order save(Order order) {
        return null;
    }
}
