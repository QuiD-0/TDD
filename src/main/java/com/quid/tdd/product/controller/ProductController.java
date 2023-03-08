package com.quid.tdd.product.controller;

import com.quid.tdd.product.domain.model.AddProductRequest;
import com.quid.tdd.product.usecase.ProductSaveUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductSaveUsecase productSaveUsecase;

    @PostMapping
    public void addProduct(@RequestBody AddProductRequest request) {
        productSaveUsecase.addProduct(request);
    }

}
