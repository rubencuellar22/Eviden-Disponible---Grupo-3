package com.grupotres.back_personal_disponible.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupotres.back_personal_disponible.model.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {

}
