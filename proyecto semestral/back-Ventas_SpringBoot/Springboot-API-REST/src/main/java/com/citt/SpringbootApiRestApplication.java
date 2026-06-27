package com.citt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping; // <--- Importa esto
import org.springframework.web.bind.annotation.RestController; // <--- Importa esto

@SpringBootApplication
@RestController // <--- Marca esta clase como controlador
public class SpringbootApiRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApiRestApplication.class, args);
    }

    // El endpoint de salud para AWS
    @GetMapping("/health")
    public String health() {
        return "OK";
    }
}