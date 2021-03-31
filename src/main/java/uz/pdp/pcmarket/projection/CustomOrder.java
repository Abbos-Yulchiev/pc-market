package uz.pdp.pcmarket.projection;


import org.springframework.data.rest.core.config.Projection;
import uz.pdp.pcmarket.entity.Order;

import java.sql.Date;

@Projection(types = Order.class)
public interface CustomOrder {

    Integer getId();

    Integer getUserId();

    Date getDataOrdered();

    Date getDateRequired();

    String getStatus();
}
