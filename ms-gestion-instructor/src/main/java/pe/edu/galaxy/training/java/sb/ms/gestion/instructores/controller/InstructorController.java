package pe.edu.galaxy.training.java.sb.ms.gestion.instructores.controller;

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
import pe.edu.galaxy.training.java.sb.ms.gestion.instructores.controller.commons.ObjectResponse;
import pe.edu.galaxy.training.java.sb.ms.gestion.instructores.controller.enums.CRUDEnum;
import pe.edu.galaxy.training.java.sb.ms.gestion.instructores.controller.generic.GenericController;
import pe.edu.galaxy.training.java.sb.ms.gestion.instructores.dto.InstructorDTO;
import pe.edu.galaxy.training.java.sb.ms.gestion.instructores.service.InstructorService;
import pe.edu.galaxy.training.java.sb.ms.gestion.instructores.service.exception.ServiceException;

@Slf4j
@RestController
@RequestMapping("/instructores")
public class InstructorController extends GenericController {

	@Autowired
	private InstructorService instructorService;

	@GetMapping
	public ResponseEntity<ObjectResponse> findAll() {
		try {

			List<InstructorDTO> lst = instructorService.list(null);
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
				super.badRequest("Id no válido, debe ser mayor que cero");
			}
			Optional<InstructorDTO> opt = instructorService.findById(this.getInstructorDTO(id));
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
	public ResponseEntity<ObjectResponse> post(@RequestBody @Validated InstructorDTO instructorDTO,	BindingResult result) {

		if (result.hasErrors()) {
			return super.badRequest(result);
		}

		try {
			InstructorDTO resInstructorDTO = instructorService.save(instructorDTO);
			if (resInstructorDTO != null) {
				return super.ok(resInstructorDTO, CRUDEnum.REGISTRO);
			}
			return super.badRequest("Eror al registrar el cliente");
		} catch (ServiceException e) {
			log.error(e.getMessage(), e);
			return super.customError("Eror al registrar el cliente");
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<ObjectResponse> put(@PathVariable Long id, @RequestBody InstructorDTO instructorDTO,
			BindingResult result) {

		if (result.hasErrors()) {
			return super.badRequest(result);
		}

		try {

			Optional<InstructorDTO> optInstructorDTO = instructorService.findById(this.getInstructorDTO(id));

			if (!optInstructorDTO.isEmpty()) {

				InstructorDTO oInstructorDTO = optInstructorDTO.get();

				instructorDTO.setId(id);
				BeanUtils.copyProperties(instructorDTO, oInstructorDTO);

				InstructorDTO resInstructorDTO = instructorService.save(oInstructorDTO);

				if (resInstructorDTO != null) {
					return super.ok(resInstructorDTO, CRUDEnum.ACTUALIZACION);
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
			Optional<InstructorDTO> optInstructorDTO = instructorService.findById(this.getInstructorDTO(id));

			if (!optInstructorDTO.isEmpty()) {
				InstructorDTO oInstructorDTO = optInstructorDTO.get();
				oInstructorDTO.setEstado("0");
				InstructorDTO resInstructorDTO = instructorService.save(oInstructorDTO);
				if (resInstructorDTO != null) {
					return super.ok(resInstructorDTO, CRUDEnum.ELIMINACION);
				}
			}

			return null;
		} catch (ServiceException e) {
			log.error(e.getMessage(), e);
			return super.error(e);
		}
	}

	private InstructorDTO getInstructorDTO(Long id) {
		return InstructorDTO.builder().id(id).build();
	}

}
