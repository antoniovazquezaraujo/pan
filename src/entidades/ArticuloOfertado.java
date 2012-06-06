package entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/*** Entity implementation class for Entity: ArticuloOfertado  */



@Entity
@Table(name = "articuloofertado", schema = "panaderia")

public class ArticuloOfertado extends Entidad {

	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	
	@GeneratedValue
	private int id;
	
	@Column(name = "NOMBRE")
	private String nombre;	

	@Column(name = "DESCRIPCION")
	private String descripcion;
	
	@Column(name = "PRECIO_UNIDAD")
	private double precio_Unidad;
	
	@Column(name = "OBSERVACIONES")
	private String observaciones;

	@Column(name = "ACTIVO")
	private boolean activo;

	
	//@OneToMany(targetEntity = LineaEncargo.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	//@JoinTable(schema = "panaderia")
	//List<LineaEncargo> lineasEncargo;
	
	//@OneToMany(targetEntity = LineaFactura.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	//@JoinTable(schema = "panaderia")
	//List<LineaFactura> lineasFactura;
	
	
	// MÉTODOS
	 
	
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio_Unidad;
	}

	public void setPrecio(double precio) {
		this.precio_Unidad = precio;	
	}

	

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	   
}
