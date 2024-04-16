package org.example.firsteverproductservice.Controller;

import org.example.firsteverproductservice.Dtos.FakeStoreProductDto;
import org.example.firsteverproductservice.Models.Product;
import org.example.firsteverproductservice.Service.FakeStoreProductService;
import org.example.firsteverproductservice.Service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//this will enable it to host HTTP APIs
@RequestMapping("/products")
// this url will get to Product Controller
public class ProductController {
    private ProductService productService;
    ProductController(ProductService productService){
        this.productService=productService;
    }
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id){

        return productService.getProductById(id);
    }
    @GetMapping()
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
}
