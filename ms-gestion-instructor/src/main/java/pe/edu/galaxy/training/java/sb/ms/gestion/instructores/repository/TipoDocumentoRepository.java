package pe.edu.galaxy.training.java.sb.ms.gestion.instructores.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.galaxy.training.java.sb.ms.gestion.instructores.entity.TipoDocumentoEntity;
import pe.edu.galaxy.training.java.sb.ms.gestion.instructores.repository.generic.GenericRepository;

@Repository
public interface TipoDocumentoRepository extends GenericRepository<TipoDocumentoEntity, Long>{
	
	@Query("select p from TipoDocumentoEntity p where p.estado='1'")
	List<TipoDocumentoEntity> findAllCustom();
	

}
