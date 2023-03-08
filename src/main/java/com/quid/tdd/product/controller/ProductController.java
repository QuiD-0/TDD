package com.quid.tdd.product.controller;

import com.quid.tdd.product.controller.model.AddProductRequest;
import com.quid.tdd.product.usecase.ProductSaveUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductSaveUseCase productSaveUsecase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addProduct(@RequestBody AddProductRequest request) {
        productSaveUsecase.addProduct(request);
    }

}