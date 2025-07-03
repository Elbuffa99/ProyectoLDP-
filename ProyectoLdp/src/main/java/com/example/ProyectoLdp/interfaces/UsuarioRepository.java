package com.example.ProyectoLdp.interfaces;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ProyectoLdp.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

    Optional<Usuario> findByNombreUsuario(String nombreUsuario);
}