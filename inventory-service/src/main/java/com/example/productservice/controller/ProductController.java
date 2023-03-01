package com.example.productservice.controller;

import com.example.productservice.dto.ProductDTO;
import com.example.productservice.dto.ProductRequest;
import com.example.productservice.service.ProductService;
import com.example.productservice.utils.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/product")
public class ProductController {
    private static final Logger log = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @PostMapping()
    public ResponseEntity<ApiResponse<Void>> createProduct(@Valid @RequestBody ProductRequest productRequest){
        log.info("Request to ProductController.createProduct: {}",productRequest);
        productService.createProduct(productRequest);
        return ResponseEntity.ok(ApiResponse.success());
    }

    @GetMapping()
    public ResponseEntity<ApiResponse<List<ProductDTO>>> getAll(){
        log.info("Request to ProductController.getAll");
        return ResponseEntity.ok(ApiResponse.success(productService.getAll()));
    }
}
