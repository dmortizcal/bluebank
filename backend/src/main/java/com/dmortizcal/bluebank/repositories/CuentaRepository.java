package com.dmortizcal.bluebank.repositories;

import com.dmortizcal.bluebank.entitys.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentaRepository  extends JpaRepository<Cuenta, Long> {
}
