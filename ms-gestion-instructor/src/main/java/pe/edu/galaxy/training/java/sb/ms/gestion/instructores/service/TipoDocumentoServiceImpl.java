package pe.edu.galaxy.training.java.sb.ms.gestion.instructores.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import pe.edu.galaxy.training.java.sb.ms.gestion.instructores.dto.TipoDocumentoDTO;
import pe.edu.galaxy.training.java.sb.ms.gestion.instructores.repository.TipoDocumentoRepository;
import pe.edu.galaxy.training.java.sb.ms.gestion.instructores.service.exception.ServiceException;

@Slf4j
@Service
public class TipoDocumentoServiceImpl implements TipoDocumentoService{
	
	Logger logger= Logger.getLogger(TipoDocumentoServiceImpl.class);

	@Autowired
	private TipoDocumentoRepository tipoDocumentoRepository; //IoC/DI
	
	@Override
	public List<TipoDocumentoDTO> list(TipoDocumentoDTO t) throws ServiceException {
		try {
			
			List<TipoDocumentoDTO> lstTipoDocumentoDTO=new ArrayList<>();
			
			 tipoDocumentoRepository.findAllCustom().forEach(tdDTO -> {
				 lstTipoDocumentoDTO.add(
						 TipoDocumentoDTO
						 .builder()
						 .id(tdDTO.getId())
						 .tipo(tdDTO.getTipo())
						 .descripcionCorta(tdDTO.getDescripcionCorta())
						 .descripcionLarga(tdDTO.getDescripcionLarga())
						 .build());
			 });
			 
			 return lstTipoDocumentoDTO;
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Logger.Level.ERROR, e.getMessage(), e);
			log.error(e.getMessage(), t);
			throw new ServiceException(e);
		}
	}

	@Override
	public Optional<TipoDocumentoDTO> findById(TipoDocumentoDTO t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoDocumentoDTO save(TipoDocumentoDTO t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
