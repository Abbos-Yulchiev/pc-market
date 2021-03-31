package uz.pdp.pcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.pcmarket.entity.CardInfo;

@Projection(types = CardInfo.class)
public interface CustomCardInfo {

    Integer getId();

    Integer getProductId();

    Integer getCardId();

    Integer getQuantity();
}
