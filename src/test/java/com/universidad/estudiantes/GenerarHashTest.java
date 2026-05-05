package com.universidad.estudiantes;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

class GenerarHash {
    @Test
    void generarHashAdmin() {
        PasswordEncoder encoder = new BCryptPasswordEncoder(12);
        System.out.println("Encoded: " + encoder.encode("admin123"));
        // Copiar el hash resultante para el INSERT de MySQL
    }
}