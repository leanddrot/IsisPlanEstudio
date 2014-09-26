package dom.planEstudio;

import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.Hidden;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;

@Hidden
@DomainService(menuOrder = "20", repositoryFor = Anio.class)
public class AnioRepositorio {

	@MemberOrder(sequence = "3")
	public Anio agregarMateria(final @Named("Año") Anio anio,
			final @Named("Nombre") String nombre) {

		Materia materia = new Materia();
		materia.setNombre(nombre);
		anio.getMateriaList().add(materia);

		return anio;
	}
	
	@MemberOrder(sequence = "1")
	@Named("<== Volver")
	public Plan volver(final @Named("Año") Anio anio){
		return anio.getPlan();
	}
}
