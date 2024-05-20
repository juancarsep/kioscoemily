package kiosco.kiosco.service;

import kiosco.kiosco.model.Producto;

import java.util.List;

public interface IProductoService {
    public Producto obtenerProductoPorId(Long id);
    public List<Producto> obtenerProductos();
    public void guardarProducto(Producto producto);
    public void editarProducto(Long id, Producto nuevoProducto);
    public void eliminarProductoPorId(Long id);
}
