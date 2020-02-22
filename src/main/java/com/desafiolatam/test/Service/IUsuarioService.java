package com.desafiolatam.test.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.desafiolatam.test.DTO.UsuarioDTO;
import com.desafiolatam.test.Entity.Usuario;

public interface IUsuarioService {
	public Page<Usuario> listarUsuarios(Pageable numeroPagina);
	public void consultaPoema();
	public UsuarioDTO save(Usuario usuario);
}
