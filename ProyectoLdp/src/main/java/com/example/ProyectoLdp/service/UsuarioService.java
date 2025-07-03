package com.example.ProyectoLdp.service;

import com.example.ProyectoLdp.interfaces.IReserva;
import com.example.ProyectoLdp.interfaces.UsuarioRepository; 
import com.example.ProyectoLdp.interfacesService.IUsuarioService;
import com.example.ProyectoLdp.modelo.Reserva;
import com.example.ProyectoLdp.modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List; 
import java.util.Optional;


@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private UsuarioRepository data;
    
    @Override
    public List<Usuario> listar() {
        return data.findAll(); 
    }

    @Override
    public Optional<Usuario> buscarPorId(int id) {
        return data.findById(id);
    }

    @Override
    public Optional<Usuario> buscarPorNombreUsuario(String nombreUsuario) {
        return data.findByNombreUsuario(nombreUsuario);     }

   
    @Override
    public Usuario guardar(Usuario usuario) {
        return data.save(usuario); 
    }

    @Override
    public void eliminar(int id) {
        data.deleteById(id); 
    }
    


}