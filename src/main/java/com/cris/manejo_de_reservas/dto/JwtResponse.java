package com.cris.manejo_de_reservas.dto;

import java.util.List;

public record JwtResponse(String token, String type, String username, List<String> roles) {
}
