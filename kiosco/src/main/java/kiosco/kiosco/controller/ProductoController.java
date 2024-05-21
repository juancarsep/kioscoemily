package kiosco.kiosco.controller;

import kiosco.kiosco.model.Producto;
import kiosco.kiosco.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoController {
    @Autowired
    IProductoService prodService;

    @PostMapping("/producto")
    public void guardarProducto(@RequestBody Producto producto){
        prodService.guardarProducto(producto);
    }

    @GetMapping("/producto/{id}")
    public Producto obtenerProductoPorId(@PathVariable Long id){
        return prodService.obtenerProductoPorId(id);
    }

    @GetMapping("/productos")
    public List<Producto> obtenerProductos(){
        return prodService.obtenerProductos();
    }

    @PutMapping("/producto/{id}")
    public void editarProducto(@PathVariable Long id,
                               @RequestBody Producto productoNuevo){
        prodService.editarProducto(id, productoNuevo);
    }

    @DeleteMapping("/producto/{id}")
    public void eliminarProducto(@PathVariable Long id){
        prodService.eliminarProductoPorId(id);
    }

}
