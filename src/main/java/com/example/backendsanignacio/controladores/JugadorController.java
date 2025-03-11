package com.example.backendsanignacio.controladores;

import com.example.backendsanignacio.modelos.Jugador;
import com.example.backendsanignacio.servicios.JugadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jugadores")
@RequiredArgsConstructor
public class JugadorController {

    private final JugadorService usuarioPuntuacionService;

    @PostMapping("/guardar")
    public ResponseEntity<Jugador> guardarPuntuacion(@RequestBody Jugador usuarioPuntuacion) {
        return ResponseEntity.ok(usuarioPuntuacionService.guardarPuntuacion(usuarioPuntuacion));
    }

    @GetMapping("/top10")
    public ResponseEntity<List<Jugador>> obtenerTop10Jugadores() {
        return ResponseEntity.ok(usuarioPuntuacionService.obtenerTop10Jugadores());
    }
}
