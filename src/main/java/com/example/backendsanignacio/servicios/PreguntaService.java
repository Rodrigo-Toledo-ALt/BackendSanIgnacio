package com.example.backendsanignacio.servicios;

import com.example.backendsanignacio.DTOs.PreguntaDTO;
import com.example.backendsanignacio.DTOs.RespuestaDTO;
import com.example.backendsanignacio.modelos.Imagen;

import com.example.backendsanignacio.modelos.Pregunta;

import com.example.backendsanignacio.repositorios.ImagenRepository;
import com.example.backendsanignacio.repositorios.PreguntaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PreguntaService {

    @Autowired
    private final PreguntaRepository preguntaRepository;

    @Autowired
    private final ImagenRepository imagenRepository;

    public List<PreguntaDTO> obtener25PreguntasAleatorias() {
        List<Pregunta> preguntas = preguntaRepository.obtener25PreguntasAleatorias();

        // Obtener todas las imágenes disponibles
        List<Imagen> imagenesDisponibles = imagenRepository.findAll();

        // Asegurar que haya 25 imágenes, reutilizando si hay menos de 25
        List<String> listaImagenes = generarListaDeImagenes(imagenesDisponibles, 25);

        // Mapear las preguntas y asignarles imágenes
        return preguntas.stream()
                .map(p -> new PreguntaDTO(
                        p.getTitulo(),
                        obtenerImagenAleatoria(listaImagenes),
                        p.getTipo().name(),
                        p.getRespuestas().stream()
                                .map(r -> new RespuestaDTO(r.getTexto(), r.getEsCorrecta()))
                                .collect(Collectors.toList())
                ))
                .collect(Collectors.toList());
    }

    /**
     * Genera una lista de URLs de imágenes asegurando que tenga el tamaño deseado.
     */
    private List<String> generarListaDeImagenes(List<Imagen> imagenes, int cantidad) {
        List<String> urls = imagenes.stream().map(Imagen::getUrl).collect(Collectors.toList());

        if (urls.isEmpty()) {
            throw new RuntimeException("No hay imágenes en la base de datos");
        }

        List<String> resultado = new ArrayList<>();
        while (resultado.size() < cantidad) {
            resultado.addAll(urls);
        }

        return resultado.subList(0, cantidad); // Recortar a exactamente 25 elementos
    }

    /**
     * Obtiene una imagen aleatoria de la lista.
     */
    private String obtenerImagenAleatoria(List<String> listaImagenes) {
        Collections.shuffle(listaImagenes);
        return listaImagenes.get(0);
    }
}
