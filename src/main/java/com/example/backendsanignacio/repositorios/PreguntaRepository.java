package com.example.backendsanignacio.repositorios;


import com.example.backendsanignacio.modelos.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PreguntaRepository extends JpaRepository<Pregunta, Long> {

    @Query("SELECT p FROM Pregunta p ORDER BY FUNCTION('RANDOM') LIMIT 25")
    List<Pregunta> obtener25PreguntasAleatorias();




}
