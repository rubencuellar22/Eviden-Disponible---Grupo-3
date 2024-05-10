package com.grupotres.back_personal_disponible.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class EmpleadoProvisional {
    private String nombre;
    private String status;
    private Date bench;
}
