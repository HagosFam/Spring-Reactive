package com.springReactive.util;

import com.springReactive.dto.ProductDto;
import com.springReactive.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter {
    public static ProductDto getProductDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setName(product.getName());
        productDto.setQty(product.getQty());
        productDto.setPrice(product.getPrice());
        return productDto;
    }

    public static Product getProduct(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setQty(productDto.getQty());
        return product;
    }

    //Getting product DTO list
    public static List<ProductDto> getProductDtoList(List<Product> products) {
        List<ProductDto> productDtos = new ArrayList<>();
        for(Product prod:products){
            productDtos.add(ProductAdapter.getProductDto(prod));
        }
        return productDtos;
    }
}
