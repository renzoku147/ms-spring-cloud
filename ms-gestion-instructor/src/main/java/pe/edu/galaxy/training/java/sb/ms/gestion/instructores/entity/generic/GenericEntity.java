package pe.edu.galaxy.training.java.sb.ms.gestion.instructores.entity.generic;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
public class GenericEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	protected String estado;
}
