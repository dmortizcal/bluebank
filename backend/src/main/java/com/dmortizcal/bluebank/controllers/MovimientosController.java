package com.dmortizcal.bluebank.controllers;

import com.dmortizcal.bluebank.entitys.Movimientos;
import com.dmortizcal.bluebank.repositories.MovimientosRepository;
import com.dmortizcal.bluebank.utils.NoEncontrado;
import com.dmortizcal.bluebank.utils.Respuesta;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/movimientos")
public class MovimientosController {
    private final MovimientosRepository repository;

    public MovimientosController(MovimientosRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findOne(@PathVariable Long id) {
        Movimientos movimientos = repository.findById(id).orElseThrow(() -> new NoEncontrado("Movimientos", String.valueOf(id)));

        return ResponseEntity.ok(movimientos);
    }

    @GetMapping("/")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Movimientos movimientos) {
        movimientos = repository.save(movimientos);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(movimientos.getCiuId()).toUri();

        return ResponseEntity
                .created(location)
                .body(movimientos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Movimientos movimientos, @PathVariable Long id) {
        repository.findById(id).map(_movimientos -> {
            _movimientos = movimientos;
            return repository.save(_movimientos);
        }).orElseThrow(() -> new NoEncontrado("Movimientos ", String.valueOf(id)));

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(movimientos.getCiuId()).toUri();

        return ResponseEntity
                .created(location)
                .body(movimientos);
    }

    @DeleteMapping("id")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        repository.deleteById(id);

        return ResponseEntity.ok().body(Respuesta.mensage("El item ha sido borrado"));
    }
}