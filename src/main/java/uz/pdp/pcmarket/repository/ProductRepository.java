package uz.pdp.pcmarket.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import uz.pdp.pcmarket.entity.Product;
import uz.pdp.pcmarket.projection.CustomProduct;

@RepositoryRestResource(path = "product", collectionResourceRel = "list", excerptProjection = CustomProduct.class)
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @RestResource(path = "byName")
    Page<Product> findAllByName(@Param("name") String name, Pageable pageable);

    @RestResource(path = "byPrice")
    Page<Product> findAllByPrice(@Param("price") Integer price, Pageable pageable);


    @Query(value = "select p.name, p.price, p.description  from product p join category c on p.category_id = c.id where c.name = :name;", nativeQuery = true)
    Page<Product> getByCategoryId(@Param("name") String name, @Param("pageable") Pageable pageable);
}
