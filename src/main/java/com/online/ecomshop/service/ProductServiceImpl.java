package com.online.ecomshop.service;

import com.online.ecomshop.DAO.ProductRepository;
import com.online.ecomshop.model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements  ProductService{

    @Autowired
    ProductRepository productRepository;

    /**
     * Creates a new product and saves it to the database.
     *
     * This method checks if the given product variant already exists in the database.
     * If the variant is not found, the product is saved to the database. If the variant
     * already exists, an exception is thrown with a descriptive message.
     *
     * @return The created product if successfully saved, or null if an exception occurs.
     *
     * @throws Exception If the product variant already exists in the database.
     */
    @Override
    public Products createNewPorduct(Products product) {
        String variant = product.getVariant();

           try{
               if (!productRepository.findByVariant(variant).isEmpty()){
                   throw new Exception("variant already exists " + variant);
               }
               return productRepository.save(product);
           } catch (Exception e) {
               e.printStackTrace();
              return null;
           }
    }

    /**
     * Updates an existing product in the database.
     *
     * This method attempts to update a product by checking if the provided product's ID
     * exists in the database. If the ID is found, the product is updated. If the ID is not
     * found, an exception is thrown with a descriptive message.
     *
     * @return The updated product if the update is successful, or null if the product ID is not found.
     *
     * @throws Exception If the provided product ID is not found in the database.
     */
    @Override
    public Products updateProduct(Products products) {
        try{
            // Check if the product ID exists in the database
            if(productRepository.findById(products.getId()).isPresent()){
                // Product ID found, update the product in the database
               return  productRepository.save(products);
            }else {
                // Product ID not found, throw an exception
                throw new Exception("product id not found ");

            }
        } catch (Exception e) {
            // Handle the exception (print stack trace for now)
            e.printStackTrace();
            return null;
        }
    }


    /**
     * Finds a product by its brand name in the database.
     *
     * This method attempts to find a product based on the provided brand name. If a product with
     * the given brand name is found, it is returned. If no product is found, an exception is thrown
     * with a descriptive message indicating that the brand is not found.
     *
     * @return The product with the specified brand name if found.
     *
     * @throws RuntimeException If an unexpected exception occurs during the database query.
     *                         If no product is found with the provided brand name.
     */

    @Override
    public Products findProductByBrand(String brandName) {
        try{
            // Attempt to find a product with the given brand name
            Optional<Products> productsOptional = productRepository.findByBrand(brandName);

            // Check if a product with the given brand name is found
            if (productsOptional.isPresent()){
                return productsOptional.get();
            }else {
                // Throw an exception if no product is found
                throw new Exception("No such Brand found");
            }
        } catch (Exception e) {
            // Wrap and rethrow any unexpected exception as a runtime exception
            throw new RuntimeException("Error while finding product by brand", e);
        }
    }

    @Override
    public void deleteProductById(int id) {

        try{
            Optional<Products> productsOptional = productRepository.findById(id);

            if(productsOptional.isPresent()){
                productRepository.deleteById(id);
            }else {
                throw new Exception("No such ID found");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error while deleting product", e);
        }

    }


}
