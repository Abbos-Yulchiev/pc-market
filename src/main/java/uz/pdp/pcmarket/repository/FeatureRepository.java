package uz.pdp.pcmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.pcmarket.entity.Feature;
import uz.pdp.pcmarket.projection.CustomFeature;

@RepositoryRestResource(path = "feature", collectionResourceRel = "list", excerptProjection = CustomFeature.class)
public interface FeatureRepository extends JpaRepository<Feature, Integer> {
}
