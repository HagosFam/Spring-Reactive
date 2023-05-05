package com.springReactive.service;
import com.springReactive.dto.ProductDto;
import com.springReactive.repo.ProductRepository;
import com.springReactive.util.ProductAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Range;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class ProductService {
private ProductRepository repository;
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

//    @Autowired
//    ProductRepository repository;

    public Flux<ProductDto> getProducts(){
        return repository.findAll().map(ProductAdapter::getProductDto);
    }

    public Mono<ProductDto> getProduct(String id){
        return repository.findById(id).map(ProductAdapter::getProductDto);
    }

//    public Flux<ProductDto> getProductInRange(double min,double max){
//        return repository.findPriceBetween(Range.closed(min,max));
//    }

    public Mono<ProductDto> saveProduct(Mono<ProductDto> productDtoMono){
        System.out.println("service method called ...");
        return  productDtoMono.map(ProductAdapter::getProduct)
                .flatMap(repository::insert)
                .map(ProductAdapter::getProductDto);
    }

    public Mono<ProductDto> updateProduct(Mono<ProductDto> productDtoMono,String id){
        return repository.findById(id)
                .flatMap(p->productDtoMono.map(ProductAdapter::getProduct)
                        .doOnNext(e->e.setId(id)))
                .flatMap(repository::save)
                .map(ProductAdapter::getProductDto);

    }

    public Mono<Void> deleteProduct(String id){
        return repository.deleteById(id);
    }
}