package com.example.backendsanignacio.modelos;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "respuestas", schema = "sanignacio")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pregunta_id", nullable = false)
    private Pregunta pregunta;

    @Column(nullable = false)
    private String texto;

    @Column(nullable = false)
    private Boolean esCorrecta;
}
