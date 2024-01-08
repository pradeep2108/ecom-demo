package com.online.ecomshop.service;

import com.online.ecomshop.model.Products;

public interface ProductService {

    Products createNewPorduct(Products product);

    Products updateProduct(Products product);

    Products findProductByBrand(String brandName);

    void deleteProductById(int id);

//    String findByVariant(String variant);
}
