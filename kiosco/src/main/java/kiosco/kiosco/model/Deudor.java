package kiosco.kiosco.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Deudor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombre;
    private String descripcion;
    private String numero;
    @OneToMany
    private List<Deuda> deudas;
    @OneToMany
    private List<Pago> pagos;

    public double saldoTotalAdeudado(){
        double total = 0;

        for(Deuda deuda : deudas){
            if(!deuda.isCancelada()){
                total += deuda.obtenerSaldoAdeudado();
            }
        }


        return  total;
    }




}
