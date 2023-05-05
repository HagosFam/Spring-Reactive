package com.springReactive.controller;

import com.springReactive.dto.ProductDto;
import com.springReactive.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    // which is the default
    @GetMapping
    public Flux<ProductDto> productDtoFlux() {
        return productService.getProducts();
    }

    @GetMapping("/{id}")
    public Mono<ProductDto> getProduct(@PathVariable String id) {
        return productService.getProduct(id);
    }

//    @GetMapping("/{id}")
//    public Flux<ProductDto> getProductBetweenRange(@RequestParam("min") double min, @RequestParam("max") double max ) {
//        return productService.getProductInRange(min, max);
//    }

    @PostMapping
    public Mono<ProductDto> saveProduct( @RequestBody  Mono<ProductDto> productDto){
        return productService.saveProduct(productDto);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteProduct(@PathVariable String id) {
      return   productService.deleteProduct(id);
    }




}
