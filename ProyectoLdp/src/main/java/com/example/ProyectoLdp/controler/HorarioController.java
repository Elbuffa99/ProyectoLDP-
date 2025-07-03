package com.example.ProyectoLdp.controler;

import com.example.ProyectoLdp.interfacesService.IHorarioService;
import com.example.ProyectoLdp.modelo.Horario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/horarios")
public class HorarioController {

    @Autowired
    private IHorarioService service;

    @GetMapping
    public List<Horario> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Optional<Horario> obtener(@PathVariable int id) {
        return service.listarId(id);
    }

    @PostMapping
    public Horario guardar(@RequestBody Horario h) {
        service.save(h);
        return h;
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        service.delete(id);
    }
}
