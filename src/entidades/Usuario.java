package entidades;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**
* Entity implementation class for Entity: USUARIO
*
*/

@Entity

@Table(name = "usuario", schema = "panaderia")
public class Usuario extends  Entidad{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID")
	
	@GeneratedValue
	private int id;
	
	@Column(name= "NOMBRE")
	String nombre;
	
	@Column(name = "PASSWORD")
	String password;
	
	
	//MÉTODOS
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
			this.password = password;
	}
}