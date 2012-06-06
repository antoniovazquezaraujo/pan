package entidades;

import java.util.Date;

import static javax.persistence.TemporalType.TIMESTAMP;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/** Entity implementation class for Entity: RutaReparto* */


@Entity
@Table(name="rutareparto", schema="panaderia")

public class RutaReparto extends Entidad {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column (name="ID")

	@GeneratedValue
	private int id;
	
	@Column (name = "NOMBRE")
	private String nombre;
	
	@Column (name = "HORA_SALIDA")
	@Temporal (TIMESTAMP)
	private Date horaSalida;
	
	@Column (name = "DESCRIPCION")
	private String descripcion;
	
	@Column (name = "OBSERVACIONES")
	private String observaciones;
	
	@Column (name = "ACTIVO")
	private boolean activo;
	
	
	@OneToOne(targetEntity = Empleado.class)
	@JoinColumn(name = "EMPLEADO_ID", referencedColumnName = "ID")
	Empleado empleado;
	
	
	//MÉTODOS
	
	
	public Empleado getEmpleado(){
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {   //M.C.
			this.empleado = empleado;
	}
	
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id = id;	
	}
	
	
	public String getNombre(){
		return nombre;
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	
	public Date getHoraSalida(){
		return horaSalida;
	}
	
	
	public void setHoraSalida(Date horaSalida){
		this.horaSalida = horaSalida;
	}
	
	
	public String getDescripcion(){
		return descripcion;
	}
	
	public void setDescripcion(String descripcion){
		this.descripcion = descripcion;
	}
	
	public String getObservaciones(){
		return observaciones;
	}
	
	public void setObservaciones(String observaciones){
		this.observaciones = observaciones;
	}
	
	public boolean isActivo(){
		return activo;
	}
	
	public void setActivo(boolean activo){
		this.activo = activo;
	}
	
	
	
}