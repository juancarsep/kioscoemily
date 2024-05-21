package kiosco.kiosco.controller;

import kiosco.kiosco.model.Proveedor;
import kiosco.kiosco.service.IProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProveedorController {

    @Autowired
    IProveedorService provService;

    @PostMapping("/proveedor")
    public void guardarProveedor(@RequestBody Proveedor proveedor){
        provService.guardarProveedor(proveedor);
    }

    @GetMapping("/proveedor/{id}")
    public Proveedor obtenerProveedor(@PathVariable Long id){
        return provService.ObtenerProveedorPorId(id);
    }

    @GetMapping("/proveedores")
    public List<Proveedor> obtenerProveedores(){
        return provService.obtenerProveedores();
    }

    @PutMapping("/proveedor/{id}")
    public void editarProveedor(@PathVariable Long id,
                                @RequestBody Proveedor proveedorNuevo){
        provService.editarProveedor(id, proveedorNuevo);
    }

    @DeleteMapping("/proveedor/{id}")
    public void eliminarProveedor(@PathVariable Long id){
        provService.eliminarProveedorPorId(id);
    }

}
