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
public class Deuda {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private double monto;
    @ManyToOne
    private Deudor deudor;
    @OneToOne
    private Pago pago;
    @Column
    @Temporal(TemporalType.DATE)
    private LocalDate fecha;

    private boolean cancelada;

    public double obtenerSaldoAdeudado(){
        return this.monto - this.pago.getMonto();
    }

    public void pagar(double montoAPagar){
        if(!this.cancelada){
            this.pago.setMonto(montoAPagar);
            this.pago.setFecha(LocalDate.now());
            if(this.monto == this.pago.getMonto()){
                this.cancelada = true;
                System.out.println("La factura fue cancelada en su totalidad");
            }
            System.out.println("Pago aplicado, el monto restante por pagar es: " + this.obtenerSaldoAdeudado());
        }else{
            System.out.println("Esta factura ya fue cancelada");
        }

    }

}
