package CustomEventDemo.model;

import org.springframework.context.ApplicationEvent;

import java.time.Clock;
import java.util.ArrayList;
import java.util.List;

public class OrderCreatedEvent extends ApplicationEvent {

    private List<Long> allProductIDs = new ArrayList<>();

    public OrderCreatedEvent(Object source) {
        super(source);
    }


    public List<Long> getAllProductIDs() {
        return allProductIDs;
    }

    public OrderCreatedEvent setAllProductIDs(List<Long> allProductIDs) {
        this.allProductIDs = allProductIDs;
        return this;
    }

    public OrderCreatedEvent addProductId(Long productID) {
        this.allProductIDs = allProductIDs;
        return this;
    }
}
