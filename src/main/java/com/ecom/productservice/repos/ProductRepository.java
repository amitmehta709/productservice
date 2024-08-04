package com.ecom.productservice.repos;

import com.ecom.productservice.models.Product;
import com.ecom.productservice.projections.ProductWithTitleAndDesc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    //This method is provided by JPA by default
//    @Override
//    Optional<Product> findById(Long id);

    Optional<Product> findByTitle(String title);


    //This method is provided by JPA by default
//    @Override
//    void delete (Product product);

    void deleteProductById(Long id);

    //This method is provided by JPA by default
//    @Override
//    Product save(Product product); // create and update

    //HQL
    @Query("select p.title as title, p.description as description from Product p where p.id=:id")
    ProductWithTitleAndDesc someRandomQuery(@Param("id") Long id);

    //SQL
    @Query(value = "select title, description from product where id = :id", nativeQuery = true)
    ProductWithTitleAndDesc someRandomQuery1(@Param("id") Long id);
}
