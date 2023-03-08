package com.quid.tdd.product;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.quid.tdd.ApiTest;
import com.quid.tdd.product.domain.DiscoundPolicy;
import com.quid.tdd.product.controller.model.AddProductRequest;
import com.quid.tdd.product.usecase.ProductSaveUseCase;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

public class ProductApiTest extends ApiTest {

    @Autowired
    ProductSaveUseCase productService;

    @Test
    void 상품등록() {
        final AddProductRequest request = new AddProductRequest("상품명", 1000, DiscoundPolicy.NONE);

        final ExtractableResponse<Response> response = RestAssured.given().log().all()
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .body(request)
            .when().post("/api/v1/products")
            .then().log().all()
            .extract();

        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }

}