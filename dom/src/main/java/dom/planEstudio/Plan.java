package dom.planEstudio;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.PersistenceCapable;

import org.apache.isis.applib.annotation.MemberOrder;

@PersistenceCapable
public class Plan {

	// {{ Descripcion (property)
	private String descripcion;

	@MemberOrder(sequence = "1")
	@Column(allowsNull = "true")
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(final String descripcion) {
		this.descripcion = descripcion;
	}
	// }}


	
}
