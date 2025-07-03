package com.example.ProyectoLdp.interfacesService;

import com.example.ProyectoLdp.modelo.Horario;
import java.util.List;
import java.util.Optional;

public interface IHorarioService {
    List<Horario> listar();
    Optional<Horario> listarId(int id);
    int save(Horario h);
    void delete(int id);
}
