package com.smartcafe.smartcafe.controller;

import java.util.List;
import com.smartcafe.smartcafe.dto.ProductRequestDTO;
import com.smartcafe.smartcafe.dto.ProductResponseDTO;

import com.smartcafe.smartcafe.service.ProductService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ProductResponseDTO createProduct(@RequestBody @Valid ProductRequestDTO dto) {
        return productService.createProduct(dto);
    }

    @GetMapping
    public List<ProductResponseDTO> getAllProducts() {
        return productService.getAllProducts();
    }
}