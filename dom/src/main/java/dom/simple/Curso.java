package dom.simple;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.VersionStrategy;

import org.apache.isis.applib.annotation.Bookmarkable;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.ObjectType;
import org.apache.isis.applib.annotation.Render;
import org.apache.isis.applib.annotation.Render.Type;

import dom.planEstudio.Anio;


@SuppressWarnings("unused")
@javax.jdo.annotations.PersistenceCapable(identityType = IdentityType.DATASTORE)
@javax.jdo.annotations.DatastoreIdentity(strategy = javax.jdo.annotations.IdGeneratorStrategy.IDENTITY, column = "id")
@javax.jdo.annotations.Version(strategy = VersionStrategy.VERSION_NUMBER, column = "version")
@javax.jdo.annotations.Queries({ @javax.jdo.annotations.Query(name = "listarCursosDeUnPlan", language = "JDOQL", value = "SELECT "
		+ "FROM dom.simple.Curso "
		+ "WHERE this.anio.plan.descripcion == :plan") })
@ObjectType("CURSO")
@Bookmarkable
public class Curso {
	
	// {{ Anio (property)
	private Anio anio;

	@MemberOrder(sequence = "1")
	@Column(allowsNull = "true")
	public Anio getAnio() {
		return anio;
	}

	public void setAnio(final Anio anio) {
		this.anio = anio;
	}
	// }}

	// {{ Division (property)
	private String division;

	@MemberOrder(sequence = "1")
	@Column(allowsNull = "true")
	public String getDivision() {
		return division;
	}

	public void setDivision(final String division) {
		this.division = division;
	}
	// }}

	// MateriaDelCursoList (Collection)
	// //////////////////////////////////////////
	
	@Persistent(mappedBy = "curso", dependentElement = "true")
	@Join
	private List<MateriaDelCurso> materiaDelCursoList = new ArrayList<MateriaDelCurso>();

	@MemberOrder(sequence = "1")
	@Render(Type.EAGERLY)
	public List<MateriaDelCurso> getMateriaDelCursoList() {
		return materiaDelCursoList;
	}

	public void setMateriaDelCursoList(final List<MateriaDelCurso> materiaDelCursoList) {
		this.materiaDelCursoList = materiaDelCursoList;
	}
	// end region MateriaDelCursoList (Collection)


	// Title (GUI)
	// //////////////////////////////////////////

	public String title() {
		return getAnio().getAnioNumero() + "° '" + getDivision() + "' (" + getAnio().getPlan().getDescripcion() + ")";
	}

	// end region Title (GUI)
	// //////////////////////////////////////////


}
