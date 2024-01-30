package com.dmortizcal.bluebank.controllers;

import com.dmortizcal.bluebank.entitys.Ciudades;
import com.dmortizcal.bluebank.repositories.CiudadesRepository;
import com.dmortizcal.bluebank.utils.NoEncontrado;
import com.dmortizcal.bluebank.utils.Respuesta;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/ciudades")
public class CiudadesController {

    private final CiudadesRepository repository;

    public CiudadesController(CiudadesRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findOne(@PathVariable Long id) {
        Ciudades ciudad = repository.findById(id).orElseThrow(() -> new NoEncontrado("Ciudades", String.valueOf(id)));

        return ResponseEntity.ok(ciudad);
    }

    @GetMapping("/")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Ciudades ciudad) {
        ciudad = repository.save(ciudad);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(ciudad.getCiuId()).toUri();

        return ResponseEntity
                .created(location)
                .body(ciudad);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Ciudades ciudad, @PathVariable Long id) {
        repository.findById(id).map(_ciudad -> {
            _ciudad = ciudad;
            return repository.save(_ciudad);
        }).orElseThrow(() -> new NoEncontrado("Ciudades ", String.valueOf(id)));

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(ciudad.getCiuId()).toUri();

        return ResponseEntity
                .created(location)
                .body(ciudad);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        repository.deleteById(id);

        return ResponseEntity.ok().body(Respuesta.mensage("El item ha sido borrado"));
    }
}
