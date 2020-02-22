package com.desafiolatam.test.Service;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.desafiolatam.test.DTO.PoemaDTO;
import com.desafiolatam.test.Entity.Usuario;
import com.desafiolatam.test.Repository.IUsuarioRepository;

@Service
public class UsuarioService implements IUsuarioService {
	
	@Autowired
	private IUsuarioRepository usuarioRepository;
	
	/*Metodo que recorre la lista de usuarios paginados y settea la edad de la persona
	 *llama al metodo para calcular los dias faltantes para su cumpleaños,
	 *si la cantidad de dias es cero, envia el mensaje de felicitaciones*/
	@Override
	public Page<Usuario> listarUsuarios(Pageable numeroPagina) {
		Page<Usuario> listaUsuarios = this.usuarioRepository.listarUsuarios(numeroPagina);
		for(Usuario usuario : listaUsuarios.getContent()) {
			usuario.setEdad(this.calculaEdad(usuario.getFechaNacimiento()));
			usuario.setDiasFaltantesCumple(this.calculaDiasFaltantes(usuario.getFechaNacimiento()));
			int diasFaltantes = this.calculaDiasFaltantes(usuario.getFechaNacimiento());
			if(diasFaltantes>0) {
				usuario.setDiasFaltantesCumple(diasFaltantes);
			}
			else {
				usuario.setFelicitaciones("Felicitaciones!");
			}
		}
		this.consultaPoema();
		return listaUsuarios;
	}
	/*Metodo que calcula la edad del usuario a partir de su fecha de nacimiento*/
	private int calculaEdad(Date fechaNacimiento) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		DateTimeFormatter formatoConversion = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fechaNacimientoStr = LocalDate.parse(dateFormat.format(fechaNacimiento), formatoConversion);
		LocalDate fechaActual = LocalDate.now();
		Period restaFechas = Period.between(fechaNacimientoStr, fechaActual);
		return restaFechas.getYears();
	}
	
	/*Metodo que calcula los dias faltantes para el cumpleaños de la persona,
	 * considera si son años biciestos o no*/
	private int calculaDiasFaltantes(Date fechaNacimiento) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		DateTimeFormatter formatoConversion = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fechaActual = LocalDate.now();
		LocalDate fechaNacimientoLD = LocalDate.parse(dateFormat.format(fechaNacimiento), formatoConversion);
        LocalDate ProximoCumple = fechaNacimientoLD.withYear(fechaActual.getYear());
        if (ProximoCumple == fechaActual || ProximoCumple.isBefore(fechaActual)) {
        	ProximoCumple = ProximoCumple.plusYears(1);
        }
        int diasFaltantes = (int)ChronoUnit.DAYS.between(fechaActual, ProximoCumple);
        if(fechaActual.getDayOfYear()==365 && diasFaltantes == 365) {
        	return 0;
        }
        if(fechaActual.getDayOfYear()==366 && diasFaltantes == 366) {
           return 0;
        }
        return diasFaltantes;
	}
	
	private void consultaPoema() {
	    RestTemplate plantilla = new RestTemplate();
	    PoemaDTO [] resultado = plantilla.getForEntity("https://www.poemist.com/api/v1/randompoems", PoemaDTO[].class).getBody();
	    int randomNum = (int) (Math.random() * (3 - 0 + 1) + 0);
	    System.out.println(resultado);
	}
	
}
