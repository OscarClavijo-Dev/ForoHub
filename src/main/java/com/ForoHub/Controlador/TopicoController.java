package com.ForoHub.Controlador;

import com.ForoHub.Modelo.*;
import com.ForoHub.Repository.TopicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @GetMapping
    public Page<DatosListadoTopico> listar(
            @PageableDefault(size = 10, sort = "fechaCreacion") Pageable paginacion) {
        return topicoRepository.findAll(paginacion).map(DatosListadoTopico::new);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> registrar(@RequestBody @Valid List<DatosRegistroTopico> datosList) {
        List<Topico> topicos = datosList.stream().map(datos -> {
            Topico topico = new Topico();
            topico.setTitulo(datos.titulo());
            topico.setMensaje(datos.mensaje());
            topico.setAutor(datos.autor());
            topico.setCurso(datos.curso());
            topico.setStatus(datos.status());
            topico.setFechaCreacion(LocalDateTime.now());
            return topico;
        }).toList();

        topicoRepository.saveAll(topicos);
        return ResponseEntity.ok("Topicos guardados correctamente");
    }


    @GetMapping("/{id}")
    public ResponseEntity<DatosDetalleTopico> detalle(@PathVariable Long id) {
        var topico = topicoRepository.findById(id);

        if (topico.isPresent()) {
            return ResponseEntity.ok(new DatosDetalleTopico(topico.get()));
        } else {
            return ResponseEntity.notFound().build();
        }

    }


    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody @Valid DatosActualizarTopico datos) {
        var topicoOptional = topicoRepository.findById(id);
        if (topicoOptional.isPresent()) {
            var topico = topicoOptional.get();
            topico.setTitulo(datos.titulo());
            topico.setMensaje(datos.mensaje());
            return ResponseEntity.ok(new DatosDetalleTopico(topico));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        var topicoOptional = topicoRepository.findById(id);
        if (topicoOptional.isPresent()) {
            topicoRepository.deleteById(id);
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }


}
