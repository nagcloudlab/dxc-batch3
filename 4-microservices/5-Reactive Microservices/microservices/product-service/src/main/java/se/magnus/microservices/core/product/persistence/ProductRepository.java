package se.magnus.microservices.core.product.persistence;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface ProductRepository extends ReactiveCrudRepository<ProductEntity, String> {
  Mono<ProductEntity> findByProductId(int productId);
}

/*
  Async Streams
    - Mono ( 0 - 1 item )
    - Flux ( 0 - 1 item )
 */