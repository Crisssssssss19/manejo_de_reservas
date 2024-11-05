package com.cris.manejo_de_reservas.dto;

import java.util.Set;

public record SignupRequest(String username, String password, String email, Set<String> roles) {
}
