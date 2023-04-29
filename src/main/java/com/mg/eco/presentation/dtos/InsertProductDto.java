package com.mg.eco.presentation.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record InsertProductDto (@NotEmpty String productName, @NotEmpty String productDesc, @NotNull BigDecimal productPrice, byte[] productImage){
}
