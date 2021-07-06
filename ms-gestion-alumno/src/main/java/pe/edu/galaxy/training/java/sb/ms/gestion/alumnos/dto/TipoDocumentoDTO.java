package pe.edu.galaxy.training.java.sb.ms.gestion.alumnos.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import pe.edu.galaxy.training.java.sb.ms.gestion.alumnos.dto.generic.GenericDTO;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper=false)
public class TipoDocumentoDTO  extends GenericDTO{

	private static final long serialVersionUID = 1L;

	private String tipo;
	
	private String descripcionLarga;

	private String descripcionCorta;

}
