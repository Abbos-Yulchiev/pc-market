package uz.pdp.pcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.pcmarket.entity.Detail;

@Projection(types = Detail.class)
public interface CustomDetail {

    Integer getId();

    Integer getProductId();

    Integer getFeatureId();

    String getValue();
}
