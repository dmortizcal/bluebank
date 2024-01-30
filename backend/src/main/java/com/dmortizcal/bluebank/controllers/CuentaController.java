package com.dmortizcal.bluebank.controllers;

import com.dmortizcal.bluebank.entitys.Cliente;
import com.dmortizcal.bluebank.entitys.Cuenta;
import com.dmortizcal.bluebank.repositories.ClienteRepository;
import com.dmortizcal.bluebank.repositories.CuentaRepository;
import com.dmortizcal.bluebank.utils.NoEncontrado;
import com.dmortizcal.bluebank.utils.Respuesta;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Random;

@RestController
@RequestMapping("/api/cuenta")
public class CuentaController {

    private final CuentaRepository repository;
    private final ClienteRepository clienteRepository;

    public CuentaController(CuentaRepository repository,
                            ClienteRepository clienteRepository) {
        this.repository = repository;
        this.clienteRepository = clienteRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findOne(@PathVariable Long id) {
        Cuenta cuenta = repository.findById(id).orElseThrow(() -> new NoEncontrado("Cuenta", String.valueOf(id)));

        return ResponseEntity.ok(cuenta);
    }

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("allByClient/{id}")
    public ResponseEntity<?> getAllByCliId(@PathVariable Long id) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new NoEncontrado("Cliente", String.valueOf(id)));

        return ResponseEntity.ok(repository.findAllByCliId(cliente));
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Cuenta cuenta) {
        cuenta.setCueNumero(generarCueNumero());
        cuenta = repository.save(cuenta);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(cuenta.getCiuId()).toUri();

        return ResponseEntity
                .created(location)
                .body(cuenta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Cuenta cuenta, @PathVariable Long id) {
        repository.findById(id).map(_cuenta -> {
            _cuenta = cuenta;
            return repository.save(_cuenta);
        }).orElseThrow(() -> new NoEncontrado("Cuenta ", String.valueOf(id)));

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(cuenta.getCiuId()).toUri();

        return ResponseEntity
                .created(location)
                .body(cuenta);
    }

    @DeleteMapping("id")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        repository.deleteById(id);

        return ResponseEntity.ok().body(Respuesta.mensage("El item ha sido borrado"));
    }

    private String generarCueNumero() {
        Random random = new Random();
        StringBuilder cueNumero = new StringBuilder(10);
        for (int i = 0; i < 10; i++) {
            cueNumero.append(random.nextInt(10));
        }
        return cueNumero.toString();
    }
}
