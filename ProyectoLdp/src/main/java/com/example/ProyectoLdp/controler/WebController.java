package com.example.ProyectoLdp.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.ProyectoLdp.interfacesService.IReservaService;
import com.example.ProyectoLdp.modelo.Reserva;

import jakarta.servlet.http.HttpSession; 

@Controller
public class WebController {

    @GetMapping("/")
    public String mostrarPaginaInicio(HttpSession session) {
      
        if (session.getAttribute("loggedInUser") != null) {
        	 List<Reserva> reservasDeHoy = reservaService.obtenerReservasDeHoy();
        	 session.setAttribute("reservasDeHoy", reservasDeHoy); 
        	return "index"; 
        } else {
            return "login"; 
        }
    }
    
    @Autowired
    private IReservaService reservaService;

    @GetMapping("/login")
    public String mostrarPaginaLogin() {
        return "login";
    }
     
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login"; 
    }

    
    @GetMapping("/GestionMesas")
    public String mostrarPaginaMesas() {
        return "mesas"; 
    }

    @GetMapping("/gestionclientes")
    public String mostrarPaginaClientes() {
        return "cliente";
    }

    @GetMapping("/gestionreservas")
    public String mostrarPaginaReservas() {
        return "reservas";
    }
    @GetMapping("/gestionhorarios")
    public String mostrarPaginaHorarios() {
    return "horas"; // asegúrate de que el archivo se llame horas.html y esté en /resources/templates o /static según tu configuración
    }
    
}
