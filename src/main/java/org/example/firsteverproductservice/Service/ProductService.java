package org.example.firsteverproductservice.Service;

import org.example.firsteverproductservice.Models.Product;
import org.springframework.stereotype.Component;

import java.util.List;


public interface ProductService {
    Product getProductById(Long id);
    List<Product> getAllProducts();
}
