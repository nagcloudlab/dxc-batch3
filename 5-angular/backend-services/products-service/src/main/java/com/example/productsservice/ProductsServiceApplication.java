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

@Data
@AllArgsConstructor
@NoArgsConstructor
class Review{
    private int id;
    private String author;
    private int stars;
    private String body;
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

@RestController
@CrossOrigin(origins = {
        "http://localhost:4200",
})
class ReviewsController{

    static Map<Integer, List<Review>> reviews = new HashMap<>();
    static {
        List<Review> reviews1 = new ArrayList<>();
        reviews1.add(new Review(1, "John Doe", 5, "Product 1 description"));
        reviews1.add(new Review(2, "Jane Doe", 4, "Product 2 description"));
        reviews.put(1,reviews1);
        List<Review> reviews2 = new ArrayList<>();
        reviews2.add(new Review(3, "John Doe", 5, "Product 1 description"));
        reviews2.add(new Review(4, "Jane Doe", 4, "Product 2 description"));
        reviews.put(2,reviews2);
    }

    @GetMapping("/api/v1/{productId}/reviews")
    public ResponseEntity<?> getReviews(@PathVariable int productId){
        return ResponseEntity.ok(reviews.get(productId));
    }
    @PostMapping("/api/v1/{productId}/reviews")
    public ResponseEntity<?> addReview(@PathVariable int productId,@RequestBody Review review){
        // add id
        reviews.get(productId).add(review);
        return ResponseEntity.ok(review);
    }

}

@SpringBootApplication
public class ProductsServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductsServiceApplication.class, args);
    }
}
