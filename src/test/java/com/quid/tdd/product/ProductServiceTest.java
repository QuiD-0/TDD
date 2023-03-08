package com.quid.tdd.product;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductServiceTest {

    ProductRepository productRepository;
    ProductPort productPort;
    ProductService productService;

    @BeforeEach
    void setUp() {
        productRepository = new ProductRepository();
        productPort = new ProductAdapter(productRepository);
        productService = new ProductService(productPort);
    }

    @Test
    void 상품등록() {
        final AddProductRequest request = new AddProductRequest("상품명", 1000, DiscoundPolicy.NONE);
        productService.addProduct(request);
    }

}