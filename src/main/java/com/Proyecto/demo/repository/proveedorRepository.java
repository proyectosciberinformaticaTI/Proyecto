package com.Proyecto.demo.repository;

import com.Proyecto.demo.model.tb_proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface proveedorRepository extends JpaRepository<tb_proveedor,Integer> {

}
