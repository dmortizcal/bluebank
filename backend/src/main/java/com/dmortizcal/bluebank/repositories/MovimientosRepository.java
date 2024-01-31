package com.dmortizcal.bluebank.repositories;

import com.dmortizcal.bluebank.entitys.Cuenta;
import com.dmortizcal.bluebank.entitys.Movimientos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovimientosRepository extends JpaRepository<Movimientos, Long> {
    List<Movimientos> findAllByCueIdOrderByMovFechaDesc(Cuenta cuenta);
}
