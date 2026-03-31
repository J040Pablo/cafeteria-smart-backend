package com.smartcafe.smartcafe.service;

import com.smartcafe.smartcafe.dto.ProductRequestDTO;
import com.smartcafe.smartcafe.dto.ProductResponseDTO;
import com.smartcafe.smartcafe.model.Product;
import com.smartcafe.smartcafe.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductResponseDTO createProduct(ProductRequestDTO dto) {

        Product product = new Product();
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setStock(dto.getStock());

        Product saved = productRepository.save(product);

        return new ProductResponseDTO(
                saved.getId(),
                saved.getName(),
                saved.getPrice(),
                saved.getStock()
        );
    }

    public List<ProductResponseDTO> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(p -> new ProductResponseDTO(
                        p.getId(),
                        p.getName(),
                        p.getPrice(),
                        p.getStock()
                ))
                .toList();
    }

    public ProductResponseDTO getById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        return new ProductResponseDTO(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getStock()
        );
    }

    public ProductResponseDTO update(Long id, ProductRequestDTO dto) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setStock(dto.getStock());

        Product updateProduct = productRepository.save(product);

        return new ProductResponseDTO(
                updateProduct.getId(),
                updateProduct.getName(),
                updateProduct.getPrice(),
                updateProduct.getStock()
        );
    }

    public void delete(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        productRepository.delete(product);
    }
}
