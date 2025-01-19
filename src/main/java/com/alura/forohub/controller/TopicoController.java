package com.alura.forohub.controller;
import com.alura.forohub.Topico;
import com.alura.forohub.TopicoRequest;
import com.alura.forohub.service.TopicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
@Validated
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @GetMapping
    public List<Topico> listarTodos(){
        return topicoService.listarTodos();
    }

    @GetMapping("/{id}")
        public ResponseEntity<Topico> obtenerPorId(@PathVariable Long id){
        return topicoService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<String> registrarTopico(@Valid @RequestBody TopicoRequest request) {
        // Aquí procesas los datos del DTO y los guardas en la base de datos (lógica pendiente).
        return ResponseEntity.status(HttpStatus.CREATED).body("Tópico registrado con éxito");
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        try{
            topicoService.eliminar(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Topico> actualizar(@PathVariable Long id, @RequestBody Topico topico) {
        try {
            Topico topicoActualizado = topicoService.actualizar(id, topico);
            return ResponseEntity.ok(topicoActualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
