package com.Proyecto.demo.service;


import com.Proyecto.demo.model.tb_proveedor;
import com.Proyecto.demo.repository.proveedorRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class proveedorServiceImpl {



private proveedorRepository dao;



public List<tb_proveedor> listado(){

    return dao.findAll();

}


public tb_proveedor registrar( tb_proveedor re){

    String fecha = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());

    re.setFecha(fecha);

    return dao.save(re);

}



    public tb_proveedor actualizar( tb_proveedor re){

        return dao.save(re);

    }


    public tb_proveedor listadoporId(int re){



        Optional<tb_proveedor> opt = dao.findById(re);
        return opt.isPresent() ? opt.get() : new tb_proveedor();

    }




    public void eliminar(int idProveedor) {

        dao.deleteById(idProveedor);
    }





}
