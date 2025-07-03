package com.example.ProyectoLdp.interfacesService;

import com.example.ProyectoLdp.modelo.Mesa;
import com.example.ProyectoLdp.modelo.Reserva;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IReservaService {
List<Reserva> listar();
Optional<Reserva> buscarPorId(int id);
Reserva guardar(Reserva r);
void eliminar(int id);	
List<Reserva> obtenerReservasDeHoy();
List<Mesa> obtenerMesasOcupadas(LocalDate fecha, int idHorario);
}
