package dom.planEstudio;

import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.annotation.PublishedAction;

@DomainService
public class NavegacionServicio {

	@MemberOrder(sequence = "1")
	@Named("<== Volver")
	@PublishedAction
	public Plan volver(final @Named("Año") Anio anio){
		return anio.getPlan();
	}

	@MemberOrder(sequence = "1")
	@Named("<== Volver")
	@PublishedAction
	public Anio volver(final @Named("Año") Materia materia){
		return materia.getAnio();
	}
}
