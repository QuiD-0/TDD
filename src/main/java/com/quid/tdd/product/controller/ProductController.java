package com.quid.tdd.product.controller;

import com.quid.tdd.product.controller.model.AddProductRequest;
import com.quid.tdd.product.controller.model.ProductResponse;
import com.quid.tdd.product.controller.model.UpdateProductRequest;
import com.quid.tdd.product.usecase.ProductFindUseCase;
import com.quid.tdd.product.usecase.ProductSaveUseCase;
import com.quid.tdd.product.usecase.ProductUpdateUseCase;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductSaveUseCase productSaveUsecase;
    private final ProductUpdateUseCase productUpdateUseCase;
    private final ProductFindUseCase productFindUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addProduct(@RequestBody AddProductRequest request) {
        productSaveUsecase.addProduct(request);
    }

    @GetMapping("/{id}")
    public ProductResponse getProduct(@PathVariable(name = "id") Long id) {
        return productFindUseCase.findProduct(id);
    }

    @GetMapping
    public List<ProductResponse> getAllProducts() {
        return productFindUseCase.findAllProducts();
    }

    @PutMapping
    public void updateProduct(@RequestBody UpdateProductRequest request) {
        productUpdateUseCase.updateProduct(request);
    }
}
