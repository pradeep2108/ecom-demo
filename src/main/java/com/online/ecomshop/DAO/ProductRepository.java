package com.online.ecomshop.DAO;

import com.online.ecomshop.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Products,Integer> {

    String findByVariant(String variant);
    Optional<Products> findByBrand(String brandName);
}
