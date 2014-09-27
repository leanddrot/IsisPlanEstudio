package dom.simple;

import java.util.List;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.query.QueryDefault;

import dom.planEstudio.Anio;
import dom.planEstudio.Materia;
import dom.planEstudio.Plan;

@DomainService(menuOrder = "60", repositoryFor = Curso.class)
public class CursoRepositorio {

	public Curso crearCurso (Plan plan, Anio anio, String division){
		
		Curso curso = container.newTransientInstance(Curso.class);
		curso.setAnio(anio);
		curso.setDivision(division);
		
		for (Materia materia : anio.getMateriaList()){
			
			MateriaDelCurso materiaDelCurso = new MateriaDelCurso();
			materiaDelCurso.setMateria(materia);
			curso.getMateriaDelCursoList().add(materiaDelCurso);
						
		} 
			
		container.persistIfNotAlready(curso);
		return curso;
	}

	
	// {{ listarCursosDeUnPlan (action)
	@MemberOrder(sequence = "2")
	public List<Curso> listarCursosDeUnPlan(@Named("Plan") final  Plan plan) {
		
		return container.allMatches(new QueryDefault<Curso>(Curso.class,
				"listarCursosDeUnPlan", 
				"plan", plan.getDescripcion()));
	}
	// }}


	
	
	
	
	
	
	// region > injected services
		// //////////////////////////////////////

		@javax.inject.Inject
		DomainObjectContainer container;

		// endregion
	
}
