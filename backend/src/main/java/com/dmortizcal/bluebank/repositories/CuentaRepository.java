package com.dmortizcal.bluebank.repositories;

import com.dmortizcal.bluebank.entitys.Cliente;
import com.dmortizcal.bluebank.entitys.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Long> {
    List<Cuenta> findAllByCliId(Cliente cliente);
}
