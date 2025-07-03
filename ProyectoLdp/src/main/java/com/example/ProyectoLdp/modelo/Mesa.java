package com.example.ProyectoLdp.modelo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "mesas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mesa")
    private int id_mesa;

    @Column(name = "numero_mesa", unique = true)
    private int numeroMesa;

    private int capacidad;

    @Enumerated(EnumType.STRING)
    private EstadoMesa estado;

    public enum EstadoMesa {
        disponible,
        reservada
    }
}
