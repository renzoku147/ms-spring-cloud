package pe.edu.galaxy.training.java.sb.ms.gestion.instructores.dto.generic;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GenericDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	protected Long id;
	
	protected String estado;
}
