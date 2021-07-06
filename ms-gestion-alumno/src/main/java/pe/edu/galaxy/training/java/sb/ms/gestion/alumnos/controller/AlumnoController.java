package pe.edu.galaxy.training.java.sb.ms.gestion.alumnos.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;
import pe.edu.galaxy.training.java.sb.ms.gestion.alumnos.controller.commons.ObjectResponse;
import pe.edu.galaxy.training.java.sb.ms.gestion.alumnos.controller.enums.CRUDEnum;
import pe.edu.galaxy.training.java.sb.ms.gestion.alumnos.controller.generic.GenericController;
import pe.edu.galaxy.training.java.sb.ms.gestion.alumnos.dto.AlumnoDTO;
import pe.edu.galaxy.training.java.sb.ms.gestion.alumnos.service.AlumnoService;
import pe.edu.galaxy.training.java.sb.ms.gestion.alumnos.service.exception.ServiceException;

@Slf4j
@RestController
@RequestMapping("/alumnos")
public class AlumnoController extends GenericController {

	@Autowired
	private AlumnoService alumnoService;

	@GetMapping
	public ResponseEntity<ObjectResponse> findAll() {
		try {

			List<AlumnoDTO> lst = alumnoService.list(null);
			if (lst.isEmpty()) {	
				return super.notFound();
			}
			return super.ok(lst, CRUDEnum.CONSULTA);
		} catch (ServiceException e) {
			log.error(e.getMessage(), e);
			return super.error(e);

		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<ObjectResponse> findById(@PathVariable Long id) {
		try {
			if (id <= 0) {
				super.badRequest("Id no valido, debe ser mayor que cero");
			}
			Optional<AlumnoDTO> opt = alumnoService.findById(this.getAlumnoDTO(id));
			if (opt.isEmpty() || !opt.isPresent()) {
				return super.notFound(id);
			}
			return super.ok(opt.get(), CRUDEnum.CONSULTA);

		} catch (ServiceException e) {
			log.error(e.getMessage(), e);
			return super.error(e);
		}
	}

	@PostMapping
	public ResponseEntity<ObjectResponse> post(@RequestBody @Validated AlumnoDTO alumnoDTO,	BindingResult result) {

		if (result.hasErrors()) {
			return super.badRequest(result);
		}

		try {
			AlumnoDTO resAlumnoDTO = alumnoService.save(alumnoDTO);
			if (resAlumnoDTO != null) {
				return super.ok(resAlumnoDTO, CRUDEnum.REGISTRO);
			}
			return super.badRequest("Eror al registrar el cliente");
		} catch (ServiceException e) {
			log.error(e.getMessage(), e);
			return super.customError("Eror al registrar el cliente");
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<ObjectResponse> put(@PathVariable Long id, @RequestBody AlumnoDTO alumnoDTO,
			BindingResult result) {

		if (result.hasErrors()) {
			return super.badRequest(result);
		}

		try {

			Optional<AlumnoDTO> optAlumnoDTO = alumnoService.findById(this.getAlumnoDTO(id));

			if (!optAlumnoDTO.isEmpty()) {

				AlumnoDTO oAlumnoDTO = optAlumnoDTO.get();

				alumnoDTO.setId(id);
				BeanUtils.copyProperties(alumnoDTO, oAlumnoDTO);

				AlumnoDTO resAlumnoDTO = alumnoService.save(oAlumnoDTO);

				if (resAlumnoDTO != null) {
					return super.ok(resAlumnoDTO, CRUDEnum.ACTUALIZACION);
				}
			}
			return null;
		} catch (ServiceException e) {
			log.error(e.getMessage(), e);
			return super.error(e);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ObjectResponse> delete(@PathVariable Long id) {

		try {
			Optional<AlumnoDTO> optAlumnoDTO = alumnoService.findById(this.getAlumnoDTO(id));

			if (!optAlumnoDTO.isEmpty()) {
				AlumnoDTO oAlumnoDTO = optAlumnoDTO.get();
				oAlumnoDTO.setEstado("0");
				AlumnoDTO resAlumnoDTO = alumnoService.save(oAlumnoDTO);
				if (resAlumnoDTO != null) {
					return super.ok(resAlumnoDTO, CRUDEnum.ELIMINACION);
				}
			}

			return null;
		} catch (ServiceException e) {
			log.error(e.getMessage(), e);
			return super.error(e);
		}
	}

	private AlumnoDTO getAlumnoDTO(Long id) {
		return AlumnoDTO.builder().id(id).build();
	}

}
