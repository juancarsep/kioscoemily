package kiosco.kiosco.service;

import kiosco.kiosco.model.Proveedor;

import java.util.List;

public interface IProveedorService {
    public Proveedor ObtenerProveedorPorId(Long id);
    public List<Proveedor> obtenerProveedores();
    public void guardarProveedor(Proveedor proveedor);
    public void editarProveedor(Long id, Proveedor nuevoProveedor);
    public void eliminarProveedorPorId(Long id);
}
