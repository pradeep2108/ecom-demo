package com.online.ecomshop.service;

import com.online.ecomshop.model.Products;

import java.util.Optional;

public interface ProductService {

    Products createNewPorduct(Products product);

    Products updateProduct(Products product);

    Products findProductByBrand(String brandName);

    void deleteProductById(int id);
}
