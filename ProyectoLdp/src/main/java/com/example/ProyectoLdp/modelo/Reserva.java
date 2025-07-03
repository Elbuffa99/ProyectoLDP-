package com.example.ProyectoLdp.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "reservas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    private int id_reserva;

    @ManyToOne
    @JsonIgnoreProperties("reservas")
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JsonIgnoreProperties("reservas")
    @JoinColumn(name = "id_mesa", nullable = false)
    private Mesa mesa;

    @ManyToOne
    @JsonIgnoreProperties("reservas")
    @JoinColumn(name = "id_horario", nullable = false)
    private Horario horario;

    private LocalDate fecha;

    @Enumerated(EnumType.STRING)
    private EstadoReserva estado;

    public enum EstadoReserva {
        activa,
        cancelada,
        completada
    }
}
