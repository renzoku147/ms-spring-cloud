package pe.edu.galaxy.training.java.sb.ms.gestion.alumnos.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

import pe.edu.galaxy.training.java.sb.ms.gestion.alumnos.dto.AlumnoDTO;
import pe.edu.galaxy.training.java.sb.ms.gestion.alumnos.entity.AlumnoEntity;
import pe.edu.galaxy.training.java.sb.ms.gestion.alumnos.repository.AlumnoRepository;
import pe.edu.galaxy.training.java.sb.ms.gestion.alumnos.service.exception.ServiceException;

@Service
public class AlumnoServiceImpl implements AlumnoService{

	@Autowired
	private AlumnoRepository alumnoRepository;
	
	@Autowired
	private ObjectMapper objectMapper;

	@Override
	public List<AlumnoDTO> list(AlumnoDTO t) throws ServiceException {
		try {
			return alumnoRepository.findAllCustom().stream()
								.map(e-> this.getAlumnoDTO(e))
								.collect(Collectors.toList());	
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public AlumnoDTO save(AlumnoDTO alumnoDTO) throws ServiceException {
		try {
			
			AlumnoEntity prmAlumnoEntity = this.getALumnoEntity(alumnoDTO);
			
			AlumnoEntity retAlumnoEntity = alumnoRepository.save(prmAlumnoEntity);
				
			return this.getAlumnoDTO(retAlumnoEntity);
			
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public Optional<AlumnoDTO> findById(AlumnoDTO alumnoDTO) throws ServiceException {
		try {
			Optional<AlumnoEntity> optAlumnoEntity=  alumnoRepository.findById(alumnoDTO.getId());
			if (!optAlumnoEntity.isEmpty() && optAlumnoEntity.isPresent()) {
				return Optional.of(this.getAlumnoDTO(optAlumnoEntity.get()));
			}
			return Optional.of(null);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	// Mappers
	
	
	private AlumnoEntity getALumnoEntity(AlumnoDTO alumnoDTO) {
		return objectMapper.convertValue(alumnoDTO, AlumnoEntity.class);
	}
	
	private AlumnoDTO getAlumnoDTO(AlumnoEntity alumnoEntity) {
		return objectMapper.convertValue(alumnoEntity, AlumnoDTO.class);
	}

}
