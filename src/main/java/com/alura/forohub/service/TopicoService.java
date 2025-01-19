package com.alura.forohub.service;

import com.alura.forohub.Curso;
import com.alura.forohub.Topico;
import com.alura.forohub.repository.CursoRepository;
import com.alura.forohub.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public List<Topico> listarTodos() {
        return topicoRepository.findAll();
    }

    public Optional<Topico> obtenerPorId(Long id) {
        return topicoRepository.findById(id);
    }

    public Topico crear(Topico topico) {
        // Buscar curso por nombre
        Curso curso = cursoRepository.findByNombre(topico.getCurso().getNombre())
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));
        topico.setCurso(curso);
        return topicoRepository.save(topico);
    }

    public Topico actualizar(Long id, Topico topicoActualizado) {
        return topicoRepository.findById(id)
                .map(topico -> {
                    topico.setTitulo(topicoActualizado.getTitulo());
                    topico.setMensaje(topicoActualizado.getMensaje());
                    topico.setStatus(topicoActualizado.getStatus());

                    // Actualizar curso si se envía un nuevo nombre
                    if (topicoActualizado.getCurso() != null) {
                        Curso curso = cursoRepository.findByNombre(topicoActualizado.getCurso().getNombre())
                                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));
                        topico.setCurso(curso);
                    }

                    return topicoRepository.save(topico);
                })
                .orElseThrow(() -> new RuntimeException("Tópico no encontrado"));
    }

    public void eliminar(Long id) {
        if (topicoRepository.existsById(id)) {
            topicoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Tópico no encontrado");
        }
    }
}
