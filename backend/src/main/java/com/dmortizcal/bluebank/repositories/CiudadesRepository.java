package com.dmortizcal.bluebank.repositories;

import com.dmortizcal.bluebank.entitys.Ciudades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CiudadesRepository  extends JpaRepository<Ciudades, Long> {
}
