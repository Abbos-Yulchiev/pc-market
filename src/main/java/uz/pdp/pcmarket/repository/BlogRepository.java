package uz.pdp.pcmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.pcmarket.entity.Blog;
import uz.pdp.pcmarket.projection.CustomBlog;

@RepositoryRestResource(path = "blog", collectionResourceRel = "list", excerptProjection = CustomBlog.class)
public interface BlogRepository extends JpaRepository<Blog, Integer> {
}
