package dom.planEstudio;

import java.util.ArrayList;
import java.util.List;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;

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
	
	
	// region > agregarAnio
	// //////////////////////////////////////
	@MemberOrder(sequence = "3")
	public Plan agregarAnio(	final @Named("Plan") Plan plan,
								final @Named("") int anioNumero) {
		
		Anio nuevoAnio = new Anio();
		nuevoAnio.setAnioNumero(anioNumero);
		
		plan.getAnioList().add(nuevoAnio);
				
		return plan; 
	}
	
	public List<Integer> choices1AgregarAnio(){
		
		List<Integer> aniosDisponibles = new ArrayList<Integer>();
		
		for (int i=1; i<9; i++){
			aniosDisponibles.add(i);
		}
		
		return aniosDisponibles;
		
	}
	
	
	// endRegion > agregarAnio
	// //////////////////////////////////////

	
	
	

	// region > injected services
	// //////////////////////////////////////

	@javax.inject.Inject
	DomainObjectContainer container;

	// endregion

}
