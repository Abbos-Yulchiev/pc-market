package uz.pdp.pcmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.pcmarket.entity.CardInfo;
import uz.pdp.pcmarket.projection.CustomCardInfo;


@RepositoryRestResource(path = "cardInfo", collectionResourceRel = "list", excerptProjection = CustomCardInfo.class)
public interface CardInfoRepository extends JpaRepository<CardInfo, Integer> {
}
