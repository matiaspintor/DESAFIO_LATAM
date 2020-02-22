package com.desafiolatam.test.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;
import com.desafiolatam.test.Entity.Usuario;

public interface IUsuarioRepository extends PagingAndSortingRepository<Usuario, Integer> {
	
	@Query(value = "SELECT id_usuario, \r\n" + 
			"primer_nombre, \r\n" + 
			"segundo_nombre, \r\n" + 
			"app_paterno, \r\n" + 
			"app_materno, \r\n" + 
			"fecha_nacimiento\r\n" + 
			"FROM usuarios ", nativeQuery = true)
	@Transactional(readOnly = true)
	public Page<Usuario> listarUsuarios(Pageable numeroPagina);
	
	public Usuario save(Usuario usuario);
}
