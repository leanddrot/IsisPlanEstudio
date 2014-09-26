package dom.planEstudio;

import java.util.ArrayList;
import java.util.List;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.query.Query;

@DomainService(menuOrder = "10", repositoryFor = Plan.class)
public class PlanRepositorio {

	// {{ crearPlan (action)
	@MemberOrder(sequence = "1")
	public Plan crearPlan(final String descripcion) {

		Plan plan = container.newTransientInstance(Plan.class);

		plan.setDescripcion(descripcion);

		container.persistIfNotAlready(plan);

		return plan;
	}

	// }}

	// {{ listarPlanes (action)
	@MemberOrder(sequence = "1.2")
	public List<Plan> listarPlanes() {
		return container.allInstances(Plan.class);
	}

	// }}

	// {{ seleccionar un Plan (action)
	@MemberOrder(sequence = "1.5")
	public Plan seleccionarUnPlan(Plan plan) {
		return plan;
	}

	// }}

	// region > agregarAnio
	// //////////////////////////////////////
	@MemberOrder(sequence = "3")
	public Plan agregarAnio(final @Named("Plan") Plan plan,
			final @Named("") int anioNumero) {

		Anio nuevoAnio = new Anio();
		nuevoAnio.setAnioNumero(anioNumero);

		plan.getAnioList().add(nuevoAnio);

		return plan;
	}

	public List<Integer> choices1AgregarAnio() {

		List<Integer> aniosDisponibles = new ArrayList<Integer>();

		for (int i = 1; i < 9; i++) {
			aniosDisponibles.add(i);
		}

		return aniosDisponibles;

	}

	public String validateAgregarAnio(Plan plan, int anioNumero) {
		List<Anio> aniosList = plan.getAnioList();
		for (Anio anio : aniosList) {
			if (anio.getAnioNumero() == anioNumero) {
				return "El año '" + anioNumero + "' ya fué creado";
			}
		}

		return null;
	}

	// endRegion > agregarAnio

	// {{ EliminarPlan (action)
	@MemberOrder(sequence = "1.1")
	public String eliminarPlan(final @Named("Plan a eliminar") Plan plan,
			final @Named("Esta seguro?") Boolean seguro) {
		String descripcion = plan.getDescripcion();
		container.remove(plan);
		return "El plan de estudio '" + descripcion + "' ha sido Eliminado";
	}

	public String validateEliminarPlan(Plan plan, Boolean seguro) {
		if (!seguro) {
			return "Marque en la opcion si está seguro!!! Si no lo está cancele esta opción";
		}

		return null;
	}

	// region > injected services
	// //////////////////////////////////////

	@javax.inject.Inject
	DomainObjectContainer container;

	// endregion

}
