package com.online.ecomshop.model;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Products {

    @Id
    @SequenceGenerator(name ="product_id" , sequenceName ="product_id" , initialValue = 1000, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_id" )
    private int id;
    private String brand;
    private String model;
    private String category;
    private String variant;
    private String storage;
    private double price;

    public Products() {}

    public Products(int id, String brand, String model, String category, String variant, String storage, double price) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.category = category;
        this.variant = variant;
        this.storage = storage;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
