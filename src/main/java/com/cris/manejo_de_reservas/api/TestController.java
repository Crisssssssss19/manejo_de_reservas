package com.cris.manejo_de_reservas.api;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
@CrossOrigin(origins = "http://localhost:5173")
public class TestController {
    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public String test(){
        return "Tienes acceso";
    }
}