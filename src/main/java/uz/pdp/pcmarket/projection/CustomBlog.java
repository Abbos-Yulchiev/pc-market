package uz.pdp.pcmarket.projection;


import org.springframework.data.rest.core.config.Projection;
import uz.pdp.pcmarket.entity.Blog;

@Projection(types = Blog.class)
public interface CustomBlog {


    Integer getId();

    String getTitle();

    String getBody();

    Integer getAttachment();
}
