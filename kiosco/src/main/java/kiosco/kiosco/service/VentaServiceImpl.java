package kiosco.kiosco.service;

import kiosco.kiosco.model.Venta;
import kiosco.kiosco.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VentaServiceImpl implements IVentaService{

    @Autowired
    IVentaRepository ventaRepo;

    @Override
    public void guardarVenta(Venta venta) {
        ventaRepo.save(venta);
    }

    @Override
    public Venta buscarVentaPorId(Long id) {
        return ventaRepo.findById(id).orElse(null);
    }

    @Override
    public List<Venta> buscarTodasLasVentas() {
        return ventaRepo.findAll();
    }

    @Override
    public void editarVenta(Long id, Venta ventaNueva) {
        Venta venta = this.buscarVentaPorId(id);
        if(venta != null){
            venta.setPrecioTotal(ventaNueva.getPrecioTotal());
            venta.setFecha(ventaNueva.getFecha());
            venta.setProductos(ventaNueva.getProductos());
            ventaRepo.save(venta);
        }
    }

    @Override
    public void eliminarVenta(Long id) {
        ventaRepo.deleteById(id);
    }

    @Override
    public List<Venta> buscarVentaEnFecha(LocalDate fecha) {
        return List.of();
    }

    @Override
    public List<Venta> buscarventaEntreFechas(LocalDate fechaInial, LocalDate fechaFinal) {
        return List.of();
    }
}
