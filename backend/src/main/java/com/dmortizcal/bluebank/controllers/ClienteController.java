package com.dmortizcal.bluebank.controllers;

import com.dmortizcal.bluebank.entitys.Cliente;
import com.dmortizcal.bluebank.repositories.ClienteRepository;
import com.dmortizcal.bluebank.utils.NoEncontrado;
import com.dmortizcal.bluebank.utils.Respuesta;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    private final ClienteRepository repository;

    public ClienteController(ClienteRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findOne(@PathVariable Long id) {
        Cliente cliente = repository.findById(id).orElseThrow(() -> new NoEncontrado("Cliente", String.valueOf(id)));

        return ResponseEntity.ok(cliente);
    }

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Cliente cliente) {
        cliente = repository.save(cliente);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(cliente.getCliId()).toUri();

        return ResponseEntity
                .created(location)
                .body(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Cliente cliente, @PathVariable Long id) {
        repository.findById(id).map(_cliente -> {
            _cliente = cliente;
            return repository.save(_cliente);
        }).orElseThrow(() -> new NoEncontrado("Ciudades ", String.valueOf(id)));

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(cliente.getCliId()).toUri();

        return ResponseEntity
                .created(location)
                .body(cliente);
    }

    @DeleteMapping("id")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        repository.deleteById(id);

        return ResponseEntity.ok().body(Respuesta.mensage("El item ha sido borrado"));
    }
}
