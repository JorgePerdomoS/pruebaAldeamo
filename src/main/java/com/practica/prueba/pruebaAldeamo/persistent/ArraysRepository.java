package com.practica.prueba.pruebaAldeamo.persistent;

import com.practica.prueba.pruebaAldeamo.entity.ArraysEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArraysRepository extends JpaRepository<ArraysEntity, Long> {
}
