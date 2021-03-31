package uz.pdp.pcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.pcmarket.entity.Feature;

@Projection(types = Feature.class)
public interface CustomFeature {

    Integer getId();

    String getName();

    String getType();

    Integer getCategoryId();
}
