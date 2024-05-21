package kiosco.kiosco.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @OneToMany
    private List<Producto> productos;
    private double precioTotal;
    @Column
    @Temporal(TemporalType.DATE)
    private LocalDate fecha;

    public Venta (List<Producto> productos, LocalDate fecha){
        this.productos = productos;

        this.fecha = fecha;
        this.setPrecioTotal(calcularPrecioTotal());
    }

    public double calcularPrecioTotal(){
        double total = 0;

        for(Producto producto : productos){
            total += producto.getVenta();
        }

        return total;
    }

    public double calcularGanancia(){
        double costo = 0;
        double venta = 0;

        for(Producto producto : productos){
            costo += producto.getCosto();
            venta += producto.getVenta();
        }

        double ganancia = venta - costo;

        return ganancia;
    }

}
