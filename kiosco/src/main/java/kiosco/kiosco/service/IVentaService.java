package kiosco.kiosco.service;

import kiosco.kiosco.model.Venta;

import java.time.LocalDate;
import java.util.List;

public interface IVentaService {

    public void guardarVenta (Venta venta);
    public Venta buscarVentaPorId(Long id);
    public List<Venta> buscarTodasLasVentas();
    public void editarVenta(Long id, Venta ventaNueva);
    public void eliminarVenta(Long id);
    public List<Venta> buscarVentaEnFecha(LocalDate fecha);
    public List<Venta> buscarventaEntreFechas(LocalDate fechaInial, LocalDate fechaFinal);

}
