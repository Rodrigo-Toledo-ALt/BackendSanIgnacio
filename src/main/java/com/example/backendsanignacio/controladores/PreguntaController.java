package com.example.backendsanignacio.controladores;

import com.example.backendsanignacio.DTOs.PreguntaDTO;
import com.example.backendsanignacio.servicios.PreguntaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pregunta")
@AllArgsConstructor
public class PreguntaController {

    @Autowired
    private final PreguntaService preguntaService;


    @GetMapping("/aleatorias")
    public List<PreguntaDTO> obtenerPreguntasAleatorias() {
        return preguntaService.obtener25PreguntasAleatorias();
    }

}
