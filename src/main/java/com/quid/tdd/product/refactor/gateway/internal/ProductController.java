package com.quid.tdd.product.refactor.gateway.internal;

import com.quid.tdd.product.refactor.usecase.SaveProduct;
import com.quid.tdd.product.refactor.domain.Product;
import com.quid.tdd.product.refactor.usecase.FindProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ProductController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<Product> create(Product product);

    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<List<Product>> findAll(Product product);

    @RestController
    @RequestMapping("api/v2/product")
    @RequiredArgsConstructor
    class ProductHttpController implements ProductController{
        private final FindProduct findProduct;
        private final SaveProduct saveProduct;

        @Override
        @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
        public ResponseEntity<Product> create(Product product){
            return ResponseEntity.accepted().body(saveProduct.save(product));
        }

        @Override
        @GetMapping
        @ResponseStatus(HttpStatus.ACCEPTED)
        public ResponseEntity<List<Product>> findAll(Product product){
            return ResponseEntity.ok(findProduct.findAll());
        }
    }
}
