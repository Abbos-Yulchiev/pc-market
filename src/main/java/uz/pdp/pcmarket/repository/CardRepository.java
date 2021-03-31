package uz.pdp.pcmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.pcmarket.entity.Card;
import uz.pdp.pcmarket.projection.CustomCard;

@RepositoryRestResource(path = "card", collectionResourceRel = "list", excerptProjection = CustomCard.class)
public interface CardRepository extends JpaRepository<Card, Integer> {
}
