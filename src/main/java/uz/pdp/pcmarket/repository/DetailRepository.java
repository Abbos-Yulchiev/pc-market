package uz.pdp.pcmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.pcmarket.entity.Detail;
import uz.pdp.pcmarket.projection.CustomDetail;

@RepositoryRestResource(path = "detail", collectionResourceRel = "list", excerptProjection = CustomDetail.class)
public interface DetailRepository extends JpaRepository<Detail, Integer> {
}
