package kiosco.kiosco.controller;

import kiosco.kiosco.model.Venta;
import kiosco.kiosco.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class VentaController {

    @Autowired
    IVentaService ventaServ;


    @PostMapping("/venta")
    public void guardarVenta(@RequestBody Venta venta){
        ventaServ.guardarVenta(venta);
    }

    @GetMapping("/venta/{id}")
    public Venta obtenerVentaPorId(@PathVariable Long id){
        return ventaServ.buscarVentaPorId(id);
    }

    @GetMapping("/ventas")
    public List<Venta> obtenerVentas(){
        return ventaServ.buscarTodasLasVentas();
    }

    @PutMapping("/venta/{id}")
    public void editarVenta(@PathVariable Long id,
                            @RequestBody Venta venta){
        ventaServ.editarVenta(id, venta);
    }

    @DeleteMapping("/venta/{id}")
    public void eliminarVenta(@PathVariable Long id){
        ventaServ.eliminarVenta(id);
    }

    @GetMapping("/ventasEnFecha/{fecha}")
    public List<Venta> obtenerVentasEnFecha(@PathVariable LocalDate fecha){
        return ventaServ.buscarVentaEnFecha(fecha);
    }

    @GetMapping("/ventasEnFecha/{fecha1}/{fecha2}")
    public List<Venta> obtenerVentasEntreFechas(@PathVariable LocalDate fecha1,
                                                @PathVariable LocalDate fecha2){
        return ventaServ.buscarventaEntreFechas(fecha1, fecha2);
    }

}
