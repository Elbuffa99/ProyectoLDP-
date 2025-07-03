package com.example.ProyectoLdp.interfaces;

import com.example.ProyectoLdp.modelo.Mesa;
import com.example.ProyectoLdp.modelo.Reserva;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;
import java.util.List;

public interface IReserva extends CrudRepository<Reserva, Integer> {

    @Query("SELECT COUNT(r) > 0 FROM Reserva r WHERE r.mesa.id_mesa = :mesaId AND r.horario.id = :horarioId AND r.fecha = :fecha")
    boolean existsByMesaHorarioFecha(@Param("mesaId") int mesaId, @Param("horarioId") int horarioId, @Param("fecha") LocalDate fecha);

    List<Reserva> findByFecha(LocalDate fecha);
    
    @Query("SELECT r.mesa FROM Reserva r WHERE r.fecha = :fecha AND r.horario.id_horario = :idHorario")
    List<Mesa> findMesasOcupadasEnHorario(@Param("fecha") LocalDate fecha, @Param("idHorario") int idHorario);


}
