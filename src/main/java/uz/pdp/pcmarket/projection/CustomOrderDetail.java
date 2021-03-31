package uz.pdp.pcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.pcmarket.entity.OrderDetail;

@Projection(types = OrderDetail.class)
public interface CustomOrderDetail {

    Integer getId();

    Integer getProductId();
}
