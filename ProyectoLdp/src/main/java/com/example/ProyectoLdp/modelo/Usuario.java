package com.example.ProyectoLdp.modelo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_usuario;

    @Column(name = "nombre_usuario", unique = true)
    private String nombreUsuario;

    private String clave;

    @Enumerated(EnumType.STRING)
    private Rol rol;

    public enum Rol {
        admin,
        recepcionista
    }
}
