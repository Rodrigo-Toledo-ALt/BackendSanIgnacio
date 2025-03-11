package com.example.backendsanignacio.modelos;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "imagenes", schema = "sanignacio")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Imagen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String url;
}
