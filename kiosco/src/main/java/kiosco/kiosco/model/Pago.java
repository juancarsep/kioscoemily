package kiosco.kiosco.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.processing.Generated;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private double monto;
    @ManyToOne
    private Deudor deudor;
    @OneToOne
    private Deuda deuda;
    @Column
    @Temporal(TemporalType.DATE)
    private LocalDate fecha;

}
