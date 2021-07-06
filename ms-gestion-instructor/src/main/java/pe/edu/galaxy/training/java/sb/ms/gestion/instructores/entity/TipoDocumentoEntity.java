package pe.edu.galaxy.training.java.sb.ms.gestion.instructores.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pe.edu.galaxy.training.java.sb.ms.gestion.instructores.entity.generic.GenericEntity;

@Data
@EqualsAndHashCode(callSuper=false)
@Table(name = "Tipo_Documento")
@Entity(name = "TipoDocumentoEntity")
public class TipoDocumentoEntity  extends GenericEntity{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_tipo_documento")
	protected Long id;

	@Column(name = "tipo")
	private String tipo;
	
	@Column(name = "descripcion_larga")
	private String descripcionLarga;
	
	@Column(name = "descripcion_corta")
	private String descripcionCorta;

}
