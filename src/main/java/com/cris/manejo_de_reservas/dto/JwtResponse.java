package com.cris.manejo_de_reservas.dto;

import java.util.List;

public record JwtResponse(String token, String type, Long id, String username, List<String> roles) {
}
