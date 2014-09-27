package dom.simple;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.DomainService;

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

	// region > injected services
		// //////////////////////////////////////

		@javax.inject.Inject
		DomainObjectContainer container;

		// endregion
	
}
