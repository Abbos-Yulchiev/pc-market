package uz.pdp.pcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.pcmarket.entity.Comment;

import java.util.Date;

@Projection(types = Comment.class)
public interface CustomComment {

    Integer getId();

    Integer getUserId();

    String getMessage();

    Date getDate();

    Integer getMark();

    Integer getProductId();
}
