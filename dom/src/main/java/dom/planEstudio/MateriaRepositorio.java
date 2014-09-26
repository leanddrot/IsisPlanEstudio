package dom.planEstudio;

import java.util.List;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.Hidden;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.annotation.PublishedAction;
import org.apache.isis.applib.query.QueryDefault;
import org.datanucleus.store.query.Query;

@DomainService(menuOrder = "30", repositoryFor = Materia.class)
public class MateriaRepositorio {

	// {{ listarPlanes (action)
	@MemberOrder(sequence = "2")
	public List<Materia> listarMateriasDeUnAnio(final @Named("Plan") Plan plan,
			final @Named("") Anio anio) {
		return container.allMatches(new QueryDefault<Materia>(Materia.class,
				"listarMateriasDeUnAnio", 
				"anio", anio.getAnioNumero(), 
				"plan", plan.getDescripcion()));
	}

	public Plan default0ListarMateriasDeUnAnio(){
		List<Plan> tempList = container.allInstances(Plan.class);
		if (tempList.isEmpty()){
			return null;
		}
		return tempList.get(0);
	}
	
	public List<Anio> choices1ListarMateriasDeUnAnio(Plan plan){
				
		return plan.getAnioList();
	}
	
	
	// }}

	
	// region > injected services
	// //////////////////////////////////////

	@javax.inject.Inject
	DomainObjectContainer container;

	// endregion

}
