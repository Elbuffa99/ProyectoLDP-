package com.example.ProyectoLdp.interfacesService;

import java.util.List;
import java.util.Optional;
import com.example.ProyectoLdp.modelo.Usuario;
public interface IUsuarioService {
	public List<Usuario> listar();
	public Optional<Usuario> buscarPorId(int id); 
	Optional<Usuario> buscarPorNombreUsuario(String nombreUsuario);
	Usuario guardar(Usuario usuario);
	public void eliminar(int id);
 
}
