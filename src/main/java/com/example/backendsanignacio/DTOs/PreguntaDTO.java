package com.example.backendsanignacio.DTOs;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class PreguntaDTO {

    private String titulo;
    private String imagenUrl;
    private String tipo;
    private List<RespuestaDTO> respuestas;


}
