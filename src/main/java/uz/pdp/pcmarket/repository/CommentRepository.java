package uz.pdp.pcmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.pcmarket.entity.Comment;
import uz.pdp.pcmarket.projection.CustomComment;

@RepositoryRestResource(path = "comment", collectionResourceRel = "list", excerptProjection = CustomComment.class)
public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
