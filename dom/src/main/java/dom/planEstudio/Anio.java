package dom.planEstudio;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.VersionStrategy;

import org.apache.isis.applib.annotation.Bookmarkable;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.ObjectType;
import org.apache.isis.applib.util.ObjectContracts;

import dom.simple.SimpleObject;

@SuppressWarnings("unused")
@javax.jdo.annotations.PersistenceCapable(identityType = IdentityType.DATASTORE)
@javax.jdo.annotations.DatastoreIdentity(strategy = javax.jdo.annotations.IdGeneratorStrategy.IDENTITY, column = "id")
@javax.jdo.annotations.Version(strategy = VersionStrategy.VERSION_NUMBER, column = "version")
@ObjectType("ANIO")
@Bookmarkable
public class Anio implements Comparable<Anio>{

	// {{ AnioNumero (property)
	private int anioNumero;

	@MemberOrder(sequence = "1")
	@Column(allowsNull = "true")
	public int getAnioNumero() {
		return anioNumero;
	}

	public void setAnioNumero(final int anioNumero) {
		this.anioNumero = anioNumero;
	}

	// }}

	// {{ Plan (property)
	private Plan plan;

	@MemberOrder(sequence = "1")
	@Column(allowsNull = "true")
	public Plan getPlan() {
		return plan;
	}

	public void setPlan(final Plan plan) {
		this.plan = plan;
	}
	// }}
	
	//region > compareTo
    // //////////////////////////////////////

    @Override
    public int compareTo(Anio other) {
        return ObjectContracts.compare(this, other, "anioNumero");
    }

    //endregion

}
