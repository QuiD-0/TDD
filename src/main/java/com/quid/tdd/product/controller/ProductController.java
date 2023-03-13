package com.quid.tdd.product.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import com.quid.tdd.product.controller.model.AddProductRequest;
import com.quid.tdd.product.controller.model.ProductResponse;
import com.quid.tdd.product.controller.model.UpdateProductRequest;
import com.quid.tdd.product.domain.Product;
import com.quid.tdd.product.usecase.ProductCreateUseCase;
import com.quid.tdd.product.usecase.ProductFindUseCase;
import com.quid.tdd.product.usecase.ProductUpdateUseCase;
import java.util.List;
import lombok.RequiredArgsConstructor;
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
@RequestMapping("/products")
public class ProductController {

    private final ProductCreateUseCase productSaveUsecase;
    private final ProductUpdateUseCase productUpdateUseCase;
    private final ProductFindUseCase productFindUseCase;

    @PostMapping
    @ResponseStatus(CREATED)
    public void addProduct(@RequestBody AddProductRequest request) {
        productSaveUsecase.addProduct(request);
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public ProductResponse getProduct(@PathVariable(name = "id") Long id) {
        Product product = productFindUseCase.findProduct(id);
        return ProductResponse.of(product);
    }

    @GetMapping
    @ResponseStatus(OK)
    public List<ProductResponse> getAllProducts() {
        List<Product> allProducts = productFindUseCase.findAllProducts();
        return ProductResponse.listOf(allProducts);
    }

    @PutMapping
    @ResponseStatus(OK)
    public void updateProduct(@RequestBody UpdateProductRequest request) {
        productUpdateUseCase.updateProduct(request);
    }
}
