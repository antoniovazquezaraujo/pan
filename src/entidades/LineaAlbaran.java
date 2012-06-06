package entidades;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



/** Entity implementation class for Entity: LineaAlbaran* */


@Entity
@Table(name = "lineaalbaran", schema = "panaderia")

public class LineaAlbaran extends Entidad {

	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private int id;
	
	
	@Column(name = "DESCRIPCIÓN")
	private String descripcion;
	
	@OneToOne(targetEntity = Encargo.class)
	@JoinColumn(name = "ENCARGO_ID", referencedColumnName = "ID")
	Encargo encargo;
	
	
	
	// MÉTODOS

	public int getId(){
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}


	public String getDescripcion(){
		return descripcion;
	}
	
	public void setDescripcion(String descripcion){
		this.descripcion = descripcion;
	}
	
	public Encargo getEncargo() {
		return encargo;
	}

	public void setEncargo(Encargo encargo) {
		this.encargo = encargo;
	}
	
}




