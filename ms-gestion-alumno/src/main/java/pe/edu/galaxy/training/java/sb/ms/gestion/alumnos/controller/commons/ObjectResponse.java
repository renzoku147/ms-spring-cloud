package pe.edu.galaxy.training.java.sb.ms.gestion.alumnos.controller.commons;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ObjectResponse {

	private ObjectMessage	message;
	
	private Object  		data;
	
}
