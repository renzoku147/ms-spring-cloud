package pe.edu.galaxy.training.java.sb.ms.gestion.alumnos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pe.edu.galaxy.training.java.sb.ms.gestion.alumnos.entity.generic.GenericEntity;

@Data
@EqualsAndHashCode(callSuper=false)
@Builder
@Entity(name="AlumnoEntity")
@Table(name="ALUMNO")
@NoArgsConstructor
@AllArgsConstructor
public class AlumnoEntity extends GenericEntity{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_alumno")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Builder.Default
	private Long id=0L;
	
	@Size(min=5, max=60, message="El nombre es requerido y debe ser mayor que 5 y m·ximo 60 caracteres")
	@Column(name="apellido_paterno")
	private String apellidoPaterno;
	
	@Column(name="apellido_materno")
	private String apellidoMaterno;
	
	@Size(min=5, max=220, message="El nombre es requerido y debe ser mayor que 5 y m·ximo 60 caracteres")
	@Column(name="nombre",length=60, nullable=false)
	private String nombre;
	
//	@Size(min=1, max=1, message="El sexo es requerido y debe ser  'F' o 'F'")
//	@Column(name="SEXO",length=1, nullable=false)
//	private String sexo;
	  
	@Size(min=8, max=20, message="El nroDocumento es requerido y debe ser   mayor que 8 y m√°ximo 20 caracteres")
	@Column(name="numero_documento",length=20, nullable=false)
	private String nroDocumento;
	 
	@Email(message="El correo es requerido y debe ser   mayor que 8 y m·ximo 20 caracteres")
	@Column(name="correo",length=20, nullable=false)
	private String correo;

	@Size(min=8, max=20, message="El telefono es requerido y debe ser mayor que 8 y m·ximo 20 caracteres")
	@Column(name="telefono",length=20, nullable=false)
	private String telefono;

	@Size(min=8, max=20, message="La fecha de ingreso es requerida")
	@Column(name="fecha_registro",length=20, nullable=false)
	private String fechaIngreso;

	@ManyToOne
	@JoinColumn(name="id_tipo_documento", nullable=false)
	private TipoDocumentoEntity tipoDocumento;
	
}
