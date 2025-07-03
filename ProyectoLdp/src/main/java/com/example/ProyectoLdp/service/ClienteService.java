package com.example.ProyectoLdp.service;

import com.example.ProyectoLdp.interfaces.ClienteRepository;
import com.example.ProyectoLdp.interfacesService.IClienteService;
import com.example.ProyectoLdp.modelo.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    private ClienteRepository repo;

    @Override
    public List<Cliente> listar() {
        return repo.findAll();
    }

    @Override
    public Optional<Cliente> buscarPorId(int id) {
        return repo.findById(id);
    }

    @Override
    public Cliente guardar(Cliente cliente) {
        return repo.save(cliente);
    }

    @Override
    public void eliminar(int id) {
        repo.deleteById(id);
    }
}
