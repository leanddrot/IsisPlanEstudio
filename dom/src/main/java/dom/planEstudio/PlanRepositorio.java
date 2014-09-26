package dom.planEstudio;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.MemberOrder;

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

	// region > injected services
	// //////////////////////////////////////

	@javax.inject.Inject
	DomainObjectContainer container;

	// endregion

}
