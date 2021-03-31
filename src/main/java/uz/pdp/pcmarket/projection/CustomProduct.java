package uz.pdp.pcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.pcmarket.entity.Product;

@Projection(types = Product.class)
public interface CustomProduct {

    Integer getId();

    String getName();

    String getDescription();

    Integer getCategoryId();

    Integer getPrice();

    Integer getAttachmentId();
}
