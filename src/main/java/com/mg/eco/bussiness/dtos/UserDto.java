package com.mg.eco.bussiness.dtos;

import java.util.Date;

public record UserDto(Integer id, String firstName, String lastName, String password, String email, byte[] image,
                      String phone,
                      Date birthdate) {
}
