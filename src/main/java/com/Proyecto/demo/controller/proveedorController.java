package com.Proyecto.demo.controller;


import com.Proyecto.demo.exception.ModeloNotFoundException;
import com.Proyecto.demo.model.tb_proveedor;
import com.Proyecto.demo.service.proveedorServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/proveedor")
@Api(value = "Servicio REST para los proveedor")
public class proveedorController {




    private proveedorServiceImpl clientService;


    @GetMapping
    public ResponseEntity<List<tb_proveedor>> listar(){
        List<tb_proveedor> proveedor = new ArrayList<>();
        proveedor = clientService.listado();
        return new ResponseEntity<List<tb_proveedor>>(proveedor, HttpStatus.OK);
    }




@PostMapping
@ApiOperation("REGISTRAR PROVEEDOR")
@ApiResponses({
        @ApiResponse(code = 200, message = "ok"),
        @ApiResponse(code = 404, message = "Not found"),
        @ApiResponse(code = 500, message = "Internal server error")
})
@ResponseStatus(HttpStatus.CREATED)
    public String registrar(@Valid @RequestBody tb_proveedor proveedor) {

       tb_proveedor resul = clientService.registrar(proveedor);

        if (resul.toString().length()>0){
            return "Se insertaron correctamente los datos de la tabla cliente";
        }else {
            return "Los datos de la tabla cliente no fueron insertados ";
        }
        // URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(que.getId_tb_cliente()).toUri();


    }




    @GetMapping("/{id}")
    public tb_proveedor listaporIdProveedor(@PathVariable Integer id) {

        return clientService.listadoporId(id);
    }








    @PutMapping
    @ApiOperation("ACTUALIZAR PROVEEDOR")
    @ApiResponses({
            @ApiResponse(code = 200, message = "ok"),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    @ResponseStatus(HttpStatus.CREATED)
    public String actualizar(
            //   @PathVariable Integer id
            @RequestBody tb_proveedor cliente
    ) {


        //  tb_cliente re= clientService.getTotalid(id);
        tb_proveedor resul = clientService.actualizar(cliente);

        if (resul.toString().length()>1){
            return "Se actualizaron correctamente los datos de la tabla cliente";
        }else {
            return "Los datos de la tabla cliente no fueron actualizados ";
        }
        // URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(que.getId_tb_cliente()).toUri();


    }



    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void eliminar(@PathVariable Integer id) {
        tb_proveedor pr = clientService.listadoporId(id);
        if (pr == null) {
            throw new ModeloNotFoundException("ID: " + id);
        } else {

            clientService.eliminar(id);
        }
    }




}


