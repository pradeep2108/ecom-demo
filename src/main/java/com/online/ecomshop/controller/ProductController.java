package com.online.ecomshop.controller;

import com.online.ecomshop.model.Products;
import com.online.ecomshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ecom")
public class ProductController {


    @Autowired
    private ProductService productService;
    @PostMapping("/addproduct/products")
    public ResponseEntity<?> createNewPorduct(@RequestBody Products products){

        try{
            Products newProduct =  productService.createNewPorduct(products);
            return new ResponseEntity<Products>(newProduct, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("find/brand/{brandName}")
    public ResponseEntity<?> findProductByBrandName(@PathVariable String brandName){

        try{
            Products product  = productService.findProductByBrand(brandName);
            return new ResponseEntity<Products>(product, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateproduct")
    public ResponseEntity<?> updateProduct(@RequestBody Products products){
        try{
            Products updateProduct = productService.updateProduct(products);
            return new ResponseEntity<Products>(updateProduct,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    @DeleteMapping("delete/product/{id}")
    public ResponseEntity<?> deleteProductByID(@PathVariable int id){
        try{
            productService.deleteProductById(id);
            return  new ResponseEntity<String>("Product deleted successfully", HttpStatus.OK);
        }catch (Exception e){

            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);

        }

    }
}
