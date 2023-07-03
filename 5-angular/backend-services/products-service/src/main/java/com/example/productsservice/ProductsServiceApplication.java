package com.example.productsservice;

import com.fasterxml.jackson.annotation.*;
import lombok.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.time.*;
import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
class Product{
    private int id;
    private String name;
    private double price;
    private String currencyCode;
    private String description;
    @JsonProperty("is_available")
    private boolean available;
    private String imagePath;
    private LocalDateTime makeDate;
}

@RestController
@CrossOrigin(origins = {
        "http://localhost:4200",
})
class ProductSController{
    @GetMapping("/api/v1/products")
    public ResponseEntity<?> getProducts(){
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Laptop", 100.0, "INR", "Product 1 description", true, "assets/images/Laptop.png", LocalDateTime.now()));
        products.add(new Product(2, "Mobile", 200.0, "INR", "Product 2 description", true, "assets/images/Mobile.png", LocalDateTime.now()));
        return ResponseEntity.ok(products);
    }
}

@SpringBootApplication
public class ProductsServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductsServiceApplication.class, args);
    }
}
