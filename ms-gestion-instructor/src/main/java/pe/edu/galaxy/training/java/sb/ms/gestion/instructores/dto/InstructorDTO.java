package pe.edu.galaxy.training.java.sb.ms.gestion.instructores.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import pe.edu.galaxy.training.java.sb.ms.gestion.instructores.dto.generic.GenericDTO;

@Data
@EqualsAndHashCode(callSuper=false)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({"id", "apellidoPaterno","apellidoMaterno",
	"nombres", "sexo","tipoDocumento", "nroDocumento","correo","telefono","fechaIngreso" })
public class InstructorDTO extends GenericDTO{

	private static final long serialVersionUID = 1L;

	@Size(min=5, max=60, message="El nombre es requerido y debe ser mayor que 5 y máximo 60 caracteres")
	private String apellidoPaterno;
	
	private String apellidoMaterno;
	
	@Size(min=5, max=220, message="El nombre es requerido y debe ser mayor que 5 y máximo 60 caracteres")
	private String nombres;
	
	@Size(min=1, max=1, message="El sexo es requerido y debe ser  'F' o 'F'")
	private String sexo;
	
	@Size(min=8, max=20, message="El nroDocumento es requerido y debe ser mayor que 8 y máximo 20 caracteres")
	private String nroDocumento;
	
	@Email(message="El correo no tiene un formato correcto")
	private String correo;

	@Size(min=8, max=20, message="El telefono es requerido y debe ser   mayor que 8 y máximo 20 caracteres")
	private String telefono;
	
	@Size(min=8, max=20, message="La fecha de ingreso es requerida")
	private String fechaIngreso;

	private TipoDocumentoDTO tipoDocumento;
	
	public String nombreCompleto() {
		if (nombres==null) {
			nombres="";
		}
		return nombres.concat(" ").concat(apellidoMaterno);
	}
}
