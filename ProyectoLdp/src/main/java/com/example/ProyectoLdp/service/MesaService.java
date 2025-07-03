package com.example.ProyectoLdp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProyectoLdp.interfaces.MesaRepository;
import com.example.ProyectoLdp.interfacesService.IMesaService;
import com.example.ProyectoLdp.modelo.Mesa;

import java.util.List;
import java.util.Optional;

@Service 
public class MesaService implements IMesaService { 

    @Autowired 
    private MesaRepository repo; 
    @Override
    public List<Mesa> listar() {
        return repo.findAll(); 
    }
    @Override
    public Optional<Mesa> buscarPorId(int id) {
        return repo.findById(id); 
    }

    @Override
    public Mesa guardar(Mesa mesa) {
        return repo.save(mesa);
    }

    @Override
    public void eliminar(int id) {
        repo.deleteById(id); 
    }
}