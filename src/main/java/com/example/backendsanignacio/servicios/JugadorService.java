package com.example.backendsanignacio.servicios;

import com.example.backendsanignacio.modelos.Jugador;
import com.example.backendsanignacio.repositorios.JugadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JugadorService {

    private final JugadorRepository usuarioPuntuacionRepository;

    public Jugador guardarPuntuacion(Jugador usuarioPuntuacion) {
        return usuarioPuntuacionRepository.save(usuarioPuntuacion);
    }

    public List<Jugador> obtenerTop10Jugadores() {
        return usuarioPuntuacionRepository.findTop10ByOrderByPuntuacionDescTiempoAsc();
    }
}
