package com.example.backendsanignacio.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class RespuestaDTO {
    private String texto;
    private boolean esCorrecta;
}
