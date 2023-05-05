package com.springReactive.repo;

import com.springReactive.dto.ProductDto;
import com.springReactive.entity.Product;
import org.springframework.data.domain.Range;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ProductRepository extends ReactiveMongoRepository<Product, String> {
  //  Flux<ProductDto> findPriceBetween(Range<Double> priceRange);
}
