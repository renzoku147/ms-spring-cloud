package pe.edu.galaxy.training.java.sb.ms.gestion.alumnos.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.galaxy.training.java.sb.ms.gestion.alumnos.entity.AlumnoEntity;
import pe.edu.galaxy.training.java.sb.ms.gestion.alumnos.repository.generic.GenericRepository;

@Repository
public interface AlumnoRepository extends GenericRepository<AlumnoEntity, Long>{
	
	@Query("select p from AlumnoEntity p where p.estado='1'")
	List<AlumnoEntity> findAllCustom();
	

}
