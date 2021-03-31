package uz.pdp.pcmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.pcmarket.entity.OrderDetail;
import uz.pdp.pcmarket.projection.CustomOrderDetail;

@RepositoryRestResource(path = "orderDetail", collectionResourceRel = "list", excerptProjection = CustomOrderDetail.class)
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {
}
