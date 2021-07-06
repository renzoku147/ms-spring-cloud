package pe.edu.galaxy.training.java.sb.ms.gestion.instructores.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import pe.edu.galaxy.training.java.sb.ms.gestion.instructores.dto.InstructorDTO;
import pe.edu.galaxy.training.java.sb.ms.gestion.instructores.entity.InstructorEntity;
import pe.edu.galaxy.training.java.sb.ms.gestion.instructores.repository.InstructorRepository;
import pe.edu.galaxy.training.java.sb.ms.gestion.instructores.service.exception.ServiceException;

@Service
public class InstructorServiceImpl implements InstructorService{

	@Autowired
	private InstructorRepository instructorRepository;
	
	@Autowired
	private ObjectMapper objectMapper;

	@Override
	public List<InstructorDTO> list(InstructorDTO t) throws ServiceException {
		try {
			/*
			List<InstructorEntity> lstInstructorEntity= instructorRepository.findAllCustom();
			
			List<InstructorDTO> lstInstructorDTO =lstInstructorEntity
			*/
			return instructorRepository.findAllCustom().stream()
								.map(e-> this.getInstructorDTO(e))
								.collect(Collectors.toList());	
			
			//return lstInstructorDTO;
					
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public InstructorDTO save(InstructorDTO instructorDTO) throws ServiceException {
		try {
			
			InstructorEntity prmInstructorEntity = this.getInstructorEntity(instructorDTO);
			
			InstructorEntity retInstructorEntity = instructorRepository.save(prmInstructorEntity);
				
			return this.getInstructorDTO(retInstructorEntity);
			
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public Optional<InstructorDTO> findById(InstructorDTO instructorDTO) throws ServiceException {
		try {
			Optional<InstructorEntity> optInstructorEntity=  instructorRepository.findById(instructorDTO.getId());
			if (!optInstructorEntity.isEmpty() && optInstructorEntity.isPresent()) {
				return Optional.of(this.getInstructorDTO(optInstructorEntity.get()));
			}
			return Optional.of(null);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	// Mappers
	
	
	private InstructorEntity getInstructorEntity(InstructorDTO instructorDTO) {
		return objectMapper.convertValue(instructorDTO, InstructorEntity.class);
	}
	
	private InstructorDTO getInstructorDTO(InstructorEntity instructorEntity) {
		return objectMapper.convertValue(instructorEntity, InstructorDTO.class);
	}

}
