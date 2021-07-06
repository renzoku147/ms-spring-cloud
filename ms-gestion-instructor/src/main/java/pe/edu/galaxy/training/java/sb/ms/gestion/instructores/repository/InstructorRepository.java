package pe.edu.galaxy.training.java.sb.ms.gestion.instructores.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.galaxy.training.java.sb.ms.gestion.instructores.entity.InstructorEntity;
import pe.edu.galaxy.training.java.sb.ms.gestion.instructores.repository.generic.GenericRepository;

@Repository
public interface InstructorRepository extends GenericRepository<InstructorEntity, Long>{
	
	@Query("select p from InstructorEntity p where p.estado='1'")
	List<InstructorEntity> findAllCustom();
	

}
