package com.example.ProyectoLdp.interfacesService;

import com.example.ProyectoLdp.modelo.Mesa;
import java.util.List;
import java.util.Optional;

public interface IMesaService { 

    public List<Mesa> listar();
    public Optional<Mesa> buscarPorId(int id);
    public Mesa guardar(Mesa mesa);
    public void eliminar(int id);
    
    
    
}
