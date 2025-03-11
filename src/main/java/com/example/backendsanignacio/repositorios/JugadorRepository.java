package com.example.backendsanignacio.repositorios;

import com.example.backendsanignacio.modelos.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Long> {

    // Obtener el top 10 de usuarios con mejor puntuación (y menor tiempo en caso de empate)
    List<Jugador> findTop10ByOrderByPuntuacionDescTiempoAsc();
}
