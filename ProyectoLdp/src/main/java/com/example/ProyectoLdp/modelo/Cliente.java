package com.example.ProyectoLdp.modelo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "clientes")
@Data
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_cliente;

    private String nombre;
    private String telefono;

    @Column(unique = true)
    private String email;
}
