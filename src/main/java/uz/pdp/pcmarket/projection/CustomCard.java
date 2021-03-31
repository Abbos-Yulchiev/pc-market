package uz.pdp.pcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.pcmarket.entity.Card;

import java.util.Date;

@Projection(types = Card.class)
public interface CustomCard {

    Integer getId();

    Integer getUserId();

    Date getCreatedDate();
}
