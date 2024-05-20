package kiosco.kiosco.service;

import kiosco.kiosco.model.Producto;
import kiosco.kiosco.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements IProductoService{

    @Autowired
    IProductoRepository prodRepo;

    @Override
    public Producto obtenerProductoPorId(Long id) {
        return prodRepo.findById(id).orElse(null);
    }

    @Override
    public List<Producto> obtenerProductos() {
        return prodRepo.findAll();
    }

    @Override
    public void guardarProducto(Producto producto) {
        prodRepo.save(producto);
    }

    @Override
    public void editarProducto(Long id, Producto nuevoProducto) {
        Producto producto = this.obtenerProductoPorId(id);
        if(producto != null){
            producto.setNombre(nuevoProducto.getNombre());
            producto.setDescripcion(nuevoProducto.getDescripcion());
            producto.setCosto(nuevoProducto.getCosto());
            producto.setVenta(nuevoProducto.getVenta());
            producto.setMarca(nuevoProducto.getMarca());
            producto.setVencimiento(nuevoProducto.getVencimiento());
            producto.setCantidad(nuevoProducto.getCantidad());
            producto.setProveedor((nuevoProducto.getProveedor()));
            this.guardarProducto(producto);
        }
        System.out.println("Error al editar producto");
    }

    @Override
    public void eliminarProductoPorId(Long id) {
        prodRepo.deleteById(id);
    }
}
