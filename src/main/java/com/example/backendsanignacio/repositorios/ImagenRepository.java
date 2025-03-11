package com.example.backendsanignacio.repositorios;

import com.example.backendsanignacio.modelos.Imagen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagenRepository extends JpaRepository<Imagen, Long> {
}
