package com.dmortizcal.bluebank.repositories;

import com.dmortizcal.bluebank.entitys.Movimientos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientosRepository extends JpaRepository<Movimientos, Long> {
}
