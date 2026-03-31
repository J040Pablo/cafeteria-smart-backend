package com.smartcafe.smartcafe.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ProductRequestDTO {

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank
    @Positive(message = "Price must be greater than 0")
    private Double price;

    @NotNull
    @Min(value = 0, message = "Stock cannot be negative")
    private Integer stock;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }
}
