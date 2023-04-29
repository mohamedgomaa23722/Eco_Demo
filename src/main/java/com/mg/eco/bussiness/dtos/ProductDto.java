package com.mg.eco.bussiness.dtos;

import java.math.BigDecimal;

public record ProductDto(Integer productId, String productName, String productDesc, BigDecimal productPrice, byte[] productImage) {
}
