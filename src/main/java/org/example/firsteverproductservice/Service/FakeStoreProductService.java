package org.example.firsteverproductservice.Service;

import org.example.firsteverproductservice.Dtos.FakeStoreProductDto;
import org.example.firsteverproductservice.Models.Product;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class FakeStoreProductService implements ProductService{

    @Override
    public Product getProductById(Long id) {
        //Calls the fakeStore API to get the product By Id
        //FakeStore Provides its API but to call it we use object of RestTemplate
//        throw new RuntimeException("Some thing is Wrong");
        RestTemplate restTemplate = new RestTemplate();
       FakeStoreProductDto fakeStoreProductDto =  restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDto.class);
       if(fakeStoreProductDto==null){
           return null;
       }
       return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);
    }
    public List<Product> getAllProducts(){
        RestTemplate restTemplate = new RestTemplate();
        FakeStoreProductDto[] fakeStoreProductDtos =  restTemplate.getForObject("https://fakestoreapi.com/products" , FakeStoreProductDto[].class);
        List<Product> products = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto1 : fakeStoreProductDtos){
            products.add(convertFakeStoreProductDtoToProduct(fakeStoreProductDto1));

        }
        return products;

    }
    private Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto){
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImage(fakeStoreProductDto.getImage());
        return product;
    }

}
