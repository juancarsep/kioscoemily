package kiosco.kiosco.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombre;
    private String descripcion;
    private double costo;
    private double venta;
    private int cantidad;
    private String marca;
    @Column
    @Temporal(TemporalType.DATE)
    private LocalDate vencimiento;
    @OneToOne
    private Proveedor proveedor;
}
