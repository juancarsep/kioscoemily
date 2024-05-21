package kiosco.kiosco.repository;

import kiosco.kiosco.model.Venta;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IVentaRepository extends JpaRepository<Venta, Long> {

    @Query("SELECT v FROM Venta v WHERE v.fecha BETWEEN :fechaInicial AND :fechaFinal")
    List<Venta> buscarEntreFechas(@Param("fechaInicial") LocalDate fechaInicial, @Param("fechaFinal") LocalDate fechaFinal);

    @Query("SELECT v FROM Venta v WHERE v.fecha = :fecha")
    List<Venta> buscarPorFecha(@Param("fecha") LocalDate fecha);

}
