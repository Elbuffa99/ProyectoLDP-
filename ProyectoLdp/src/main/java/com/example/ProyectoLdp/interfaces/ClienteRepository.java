package com.example.ProyectoLdp.interfaces;

import com.example.ProyectoLdp.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    // Puedes agregar métodos personalizados si lo necesitas, por ejemplo:
    Cliente findByEmail(String email);
}