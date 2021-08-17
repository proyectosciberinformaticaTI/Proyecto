package com.Proyecto.demo.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
public class tb_proveedor {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int idtb_proveedor;


@NotEmpty(message = "nombre proveedor no debe ser vacío")
private String nombre;


@NotEmpty(message = "direccion proveedor no debe ser vacío")
private String direccion;

private String fecha;





}
