package CustomEventDemo.service;

import CustomEventDemo.model.OrderCreatedEvent;
import CustomEventDemo.model.OrderDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderService.class);
    private final ApplicationEventPublisher applicationEventPublisher;

    public OrderService(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void createOrder(OrderDTO orderDTO) {
        LOGGER.info("Order was created");
        OrderCreatedEvent orderCreatedEvent = new OrderCreatedEvent(this)
                .setAllProductIDs(orderDTO.getAllProductIDs());

        applicationEventPublisher.publishEvent(orderCreatedEvent);
    }
}
