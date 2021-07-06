package pe.edu.galaxy.training.java.sb.ms.gestion.alumnos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.galaxy.training.java.sb.ms.gestion.alumnos.controller.generic.GenericController;
import pe.edu.galaxy.training.java.sb.ms.gestion.alumnos.dto.TipoDocumentoDTO;
import pe.edu.galaxy.training.java.sb.ms.gestion.alumnos.service.TipoDocumentoService;

@RestController
@RequestMapping("/tipo-documentos")
public class TipoDocumentoController extends GenericController{
	
	@Autowired
	private TipoDocumentoService tipoDocumentoService;
	
	@GetMapping
	public ResponseEntity<List<TipoDocumentoDTO>> findAll(){
		try {
			List<TipoDocumentoDTO> lst= tipoDocumentoService.list(null);
			return ResponseEntity.ok(lst);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}
