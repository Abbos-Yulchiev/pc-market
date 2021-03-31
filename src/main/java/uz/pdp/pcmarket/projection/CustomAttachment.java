package uz.pdp.pcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.pcmarket.entity.Attachment;

@Projection(types = Attachment.class)
public interface CustomAttachment {

    Integer getIid();

    String getName();

    Integer getSize();

    String getExtension();

    String getPath();

    String getDescription();
}
