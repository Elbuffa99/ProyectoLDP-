package com.example.ProyectoLdp.controler;

import com.example.ProyectoLdp.interfacesService.IMesaService;
import com.example.ProyectoLdp.modelo.Mesa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController 
@RequestMapping("/api/mesas")
public class MesaController {

    @Autowired 
    private IMesaService mesaService;

   
    @GetMapping
    public ResponseEntity<List<Mesa>> listar() {
        return ResponseEntity.ok(mesaService.listar());
    }

     
    @GetMapping("/{id}")
    public ResponseEntity<Mesa> obtenerPorId(@PathVariable int id) {
        Optional<Mesa> mesa = mesaService.buscarPorId(id);
        return mesa.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Mesa mesa) {
    try {
    Mesa mesaGuardada = mesaService.guardar(mesa);
    return ResponseEntity.ok(mesaGuardada);
    } catch (Exception e) {
    return ResponseEntity.badRequest().body("Error al guardar la mesa: " + e.getMessage());
    }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        mesaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
