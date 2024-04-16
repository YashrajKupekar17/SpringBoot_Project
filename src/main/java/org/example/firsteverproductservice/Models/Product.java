package org.example.firsteverproductservice.Models;

import lombok.Getter;
import lombok.Setter;
import org.example.firsteverproductservice.Models.Category;

@Getter
@Setter
public class Product {
    private Long id;
    private String title;
    private String description;
    private Double price;
    private Category category;
    private String image;
}
