package com.example.ProyectoLdp.controler;

import com.example.ProyectoLdp.interfacesService.IUsuarioService;
import com.example.ProyectoLdp.modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@RestController 
@RequestMapping("/api/auth") 
public class AuthController {

    @Autowired
    private IUsuarioService usuarioService;

  
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials, HttpSession session) {
        String nombreUsuario = credentials.get("nombreUsuario");
        String clave = credentials.get("clave");

        Optional<Usuario> usuarioOpt = usuarioService.buscarPorNombreUsuario(nombreUsuario);

        
        if (usuarioOpt.isPresent() && usuarioOpt.get().getClave().equals(clave)) {
            Usuario usuario = usuarioOpt.get();
           
            session.setAttribute("loggedInUser", usuario.getNombreUsuario());
            session.setAttribute("loggedInRole", usuario.getRol().name());

            Map<String, String> response = new HashMap<>();
            response.put("message", "Inicio de sesión exitoso");
            response.put("token", "simulated-jwt-token-for-" + usuario.getNombreUsuario()); 
            response.put("username", usuario.getNombreUsuario());
            response.put("role", usuario.getRol().name()); 

            return ResponseEntity.ok(response); 
        } else {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", "Credenciales inválidas");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse); 
        }
    }

    // Nota: Para un sistema real, se implementaría Spring Security para una autenticación robusta
    // y encriptación de contraseñas (ej. BCryptPasswordEncoder).
}
