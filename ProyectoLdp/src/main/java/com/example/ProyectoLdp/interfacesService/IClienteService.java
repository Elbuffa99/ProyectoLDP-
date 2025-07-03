package com.example.ProyectoLdp.interfacesService;

import com.example.ProyectoLdp.modelo.Cliente;

import java.util.List;
import java.util.Optional;

public interface IClienteService {
    List<Cliente> listar();
    Optional<Cliente> buscarPorId(int id);
    Cliente guardar(Cliente cliente);
    void eliminar(int id);
}
