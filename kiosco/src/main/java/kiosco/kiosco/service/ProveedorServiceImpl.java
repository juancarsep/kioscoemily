package kiosco.kiosco.service;

import kiosco.kiosco.model.Proveedor;
import kiosco.kiosco.repository.IProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProveedorServiceImpl extends IProveedorService{

    @Autowired
    IProveedorRepository provRepo;


    @Override
    public Proveedor ObtenerProveedorPorId(Long id) {
        return provRepo.findById(id).orElse(null);
    }

    @Override
    public List<Proveedor> obtenerProveedores() {
        return provRepo.findAll();
    }

    @Override
    public void guardarProveedor(Proveedor proveedor) {
        provRepo.save(proveedor);
    }

    @Override
    public void editarProveedor(Long id, Proveedor nuevoProveedor) {
        Proveedor proveedor = this.ObtenerProveedorPorId(id);
        if(proveedor != null){
            proveedor.setNombre(nuevoProveedor.getNombre());
            proveedor.setDescripcion(nuevoProveedor.getDescripcion());
            proveedor.setEmail(nuevoProveedor.getEmail());
            proveedor.setTelefono(nuevoProveedor.getTelefono());
            proveedor.setDiaDeVisita(nuevoProveedor.getDiaDeVisita());
            proveedor.setMontoAPagar(nuevoProveedor.getMontoAPagar());
            this.guardarProveedor(proveedor);
        }
        System.out.println("Hubo un error al editar al proveedor");
    }

    @Override
    public void eliminarProveedorPorId(Long id) {
        provRepo.deleteById(id);
    }
}
