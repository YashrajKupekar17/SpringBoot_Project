package org.example.firsteverproductservice.Controller;

import org.example.firsteverproductservice.Dtos.ExceptionDto;
import org.example.firsteverproductservice.Dtos.FakeStoreProductDto;
import org.example.firsteverproductservice.Models.Product;
import org.example.firsteverproductservice.Service.FakeStoreProductService;
import org.example.firsteverproductservice.Service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
//        ResponseEntity<Product> responseEntity = null;
//        try {
//            Product product =  productService.getProductById(id);
//           responseEntity = new ResponseEntity<>(product, HttpStatus.OK);
//           return responseEntity;
//        }catch (RuntimeException exception){
//            ExceptionDto dto = new ExceptionDto();
//            dto.setMessage("Something went wrong");
//            dto.setResolution("Go to hell");
//            ResponseEntity<ExceptionDto> response = new ResponseEntity<>(dto,HttpStatus.BAD_REQUEST);
//            return response;
//        }
        return productService.getProductById(id);
    }
    @GetMapping()
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
}
