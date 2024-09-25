package com.cris.manejo_de_reservas.api;

import com.cris.manejo_de_reservas.services.aerolinea.AerolineaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/0.1/aerolineas")
public class AerolineaController {

    private final AerolineaService aerolineaService;

    public AerolineaController(AerolineaService aerolineaService) {
        this.aerolineaService = aerolineaService;
    }

    
}
