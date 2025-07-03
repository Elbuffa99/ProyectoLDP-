package com.example.ProyectoLdp.service;

import com.example.ProyectoLdp.interfacesService.IReservaService;
import com.example.ProyectoLdp.interfaces.IReserva;
import com.example.ProyectoLdp.interfaces.MesaRepository;
import com.example.ProyectoLdp.modelo.Mesa;
import com.example.ProyectoLdp.interfaces.ClienteRepository;
import com.example.ProyectoLdp.modelo.Cliente;
import com.example.ProyectoLdp.modelo.Horario;
import java.time.LocalDate;
import com.example.ProyectoLdp.modelo.Reserva;
import com.example.ProyectoLdp.interfaces.IHorario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService implements IReservaService {
	@Autowired
	private MesaRepository mesaRepo;

	@Autowired
	private IReserva data;

	@Autowired
	private IHorario horarioRepo;
	
    @Autowired	
    private IReserva reservaRepository;

	@Autowired
	private ClienteRepository clienteRepo;
	

	@Override
	public List<Reserva> listar() {
	    return (List<Reserva>) data.findAll();
	}

	@Override
	public Optional<Reserva> buscarPorId(int id) {
	    return data.findById(id);
	}

	@Override
	public Reserva guardar(Reserva r) {
	    boolean esNueva = r.getId_reserva() == 0;
	    System.out.println("ID Horario recibido: " + (r.getHorario() != null ? r.getHorario().getId_horario() : "null"));

	    // Validación de entidades persistentes
	    Cliente clienteBD = clienteRepo.findById(r.getCliente().getId_cliente())
	            .orElseThrow(() -> new IllegalArgumentException("El cliente no existe"));

	    Horario horarioBD = horarioRepo.findById(r.getHorario().getId_horario())
	            .orElseThrow(() -> new IllegalArgumentException("El horario no existe"));

	    Mesa mesaBD = mesaRepo.findById(r.getMesa().getId_mesa())
	            .orElseThrow(() -> new IllegalArgumentException("La mesa seleccionada no existe"));

	    boolean yaExiste = data.existsByMesaHorarioFecha(mesaBD.getId_mesa(), horarioBD.getId_horario(), r.getFecha());

	    if (esNueva && yaExiste) {
	        throw new IllegalStateException("Ya existe una reserva para esta mesa, horario y fecha.");
	    }

	    if (!esNueva) {
	        Reserva reservaExistente = data.findById(r.getId_reserva())
	                .orElseThrow(() -> new IllegalArgumentException("La reserva no existe"));

	        boolean cambioMesa = reservaExistente.getMesa().getId_mesa() != mesaBD.getId_mesa();
	        boolean cambioHorario = reservaExistente.getHorario().getId_horario() != horarioBD.getId_horario();
	        boolean cambioFecha = !reservaExistente.getFecha().equals(r.getFecha());

	        if ((cambioMesa || cambioHorario || cambioFecha) && yaExiste) {
	            throw new IllegalStateException("Ya existe una reserva para esta mesa, horario y fecha.");
	        }
	    }

	    // Asignar entidades persistentes
	    r.setCliente(clienteBD);
	    r.setHorario(horarioBD);
	    r.setMesa(mesaBD);

	    return data.save(r);
	}
	

	@Override
	public void eliminar(int id) {
	    Optional<Reserva> reservaOpt = data.findById(id);
	    if (reservaOpt.isPresent()) {
	        Reserva reserva = reservaOpt.get();
	        Mesa mesa = reserva.getMesa();

	        Optional<Mesa> mesaOpt = mesaRepo.findById(mesa.getId_mesa());
	        if (mesaOpt.isPresent()) {
	            Mesa mesaBD = mesaOpt.get();
	            mesaBD.setEstado(Mesa.EstadoMesa.disponible);
	            mesaRepo.save(mesaBD);
	        }
	    }

	    data.deleteById(id);
	}
	
	@Override
	public List<Reserva> obtenerReservasDeHoy() {
	    return reservaRepository.findByFecha(LocalDate.now());
	}
	
	@Override
	public List<Mesa> obtenerMesasOcupadas(LocalDate fecha, int idHorario) {
	    return data.findMesasOcupadasEnHorario(fecha, idHorario);
	}

}
