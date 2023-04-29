package com.mg.eco.presentation.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.sql.Date;


public record InsertUserDto(@NotEmpty String firstName, @NotEmpty String lastName, @NotEmpty String email,
                            @NotEmpty String password, byte[] image,
                            @NotEmpty String phone, @NotNull(message = "Please Enter birthday") Date birthdate) {
}
