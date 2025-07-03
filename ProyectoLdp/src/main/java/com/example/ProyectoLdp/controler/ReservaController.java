	package com.example.ProyectoLdp.controler;

	import com.example.ProyectoLdp.interfacesService.IReservaService;
import com.example.ProyectoLdp.modelo.Mesa;
import com.example.ProyectoLdp.modelo.Reserva;
	import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
	import java.util.Optional;

	@RestController
	@RequestMapping("/api/reservas")
	public class ReservaController {@Autowired
		private IReservaService reservaService;

	@GetMapping
	public List<Reserva> listar() {
	    return reservaService.listar();
	}

	@GetMapping("/{id}")
	public Optional<Reserva> buscarPorId(@PathVariable int id) {
	    return reservaService.buscarPorId(id);
	}
	
	@PostMapping
	public Reserva guardar(@RequestBody Reserva reserva) {
	    return reservaService.guardar(reserva);
	}

	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable int id) {
	    reservaService.eliminar(id);
	}
	@GetMapping("/ocupadas")
	public List<Mesa> obtenerMesasOcupadas(@RequestParam LocalDate fecha, @RequestParam int idHorario) {
	    return reservaService.obtenerMesasOcupadas(fecha, idHorario);
	}
	
	@GetMapping("/hoy")
	public ResponseEntity<List<Reserva>> getReservasDeHoy() {
	    return ResponseEntity.ok(reservaService.obtenerReservasDeHoy());
	}
	@PostMapping("/reservas")
	public ResponseEntity<?> guardarReserva(@RequestBody Reserva reserva) {
	    reservaService.guardar(reserva); // actualiza si trae id_reserva
	    return ResponseEntity.ok().build();
	}

	}
