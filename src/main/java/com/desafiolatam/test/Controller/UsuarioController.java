package com.desafiolatam.test.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.desafiolatam.test.Entity.Usuario;
import com.desafiolatam.test.Service.IUsuarioService;

@Controller
@RequestMapping(path = "/usuarios")
public class UsuarioController {
	
	@Autowired
	private IUsuarioService usuarioService;
	
	/*Metodo que lista los usuarios que se encuentran registrados en base de datos,
	 * como parametro recibe el numero de pagina para paginar los resultados
	 * @Param(numeroPagina [int]
	 * @Return(ResponseEntity<Object> [JsonFormat][HttpStatus] ) )*/
	@GetMapping(path = {"/listar"})
	public ResponseEntity<Object> listarUsuarios(@RequestParam int numeroPagina){
		try {
			Pageable pagina = PageRequest.of(numeroPagina, 10,
					JpaSort.unsafe(Sort.Direction.DESC, "(id_usuario)"));
			this.usuarioService.consultaPoema();
			Page<Usuario> listaUsuarios = this.usuarioService.listarUsuarios(pagina);
			return ResponseEntity.status(HttpStatus.OK).body(listaUsuarios);
		}catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Se ha generado un error al momento de consultar los usuarios");
		}
	}
	
	/*Metodo que realiza el ingreso de nuevos usuarios al sistema,
	 *@Params(
	 {
		"primerNombre": "primerNombre",
		"segundoNombre": "segundoNombre",
		"appPaterno": "appPaterno",
		"appMaterno": "appMaterno",
		"fechaNacimiento": "dd/MM/yyyy"
	} [Type: jsonObject]
	 *)
	 *@Returns(ResponseEntity<Object> [jsonObject])
	 **/
	@PostMapping(path = "/ingresar")
	public ResponseEntity<Object> ingresarUsuario(@RequestBody Usuario usuario){
		try {
			this.usuarioService.consultaPoema();
			Usuario usuarioRegistrado = this.usuarioService.save(usuario);
			return ResponseEntity.status(HttpStatus.OK).body(usuarioRegistrado);
		}catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Se ha generado un error al momento de consultar los usuarios");
		}
	}
	
	
}
