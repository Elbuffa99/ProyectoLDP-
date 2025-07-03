package com.example.ProyectoLdp.service;

import com.example.ProyectoLdp.interfaces.IHorario;
import com.example.ProyectoLdp.interfacesService.IHorarioService;
import com.example.ProyectoLdp.modelo.Horario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HorarioService implements IHorarioService {

    @Autowired
    private IHorario data;

    @Override
    public List<Horario> listar() {
        return (List<Horario>) data.findAll();
    }

    @Override
    public Optional<Horario> listarId(int id) {
        return data.findById(id);
    }

    @Override
    public int save(Horario h) {
        Horario obj = data.save(h);
        return obj != null ? 1 : 0;
    }

    @Override
    public void delete(int id) {
        data.deleteById(id);
    }
}
