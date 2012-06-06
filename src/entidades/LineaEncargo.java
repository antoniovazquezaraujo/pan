package entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/** Entity implementation class for Entity: LineaEncargo **/

@Entity
@Table(name = "lineaencargo", schema = "panaderia")

public class LineaEncargo extends Entidad {

	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private int id;
	
	@Column(name = "CANTIDAD")
	private int cantidad;

	@Column(name = "DESCRIPCION")
	private String descripcion;
	
	@Column(name = "TERMINADO")
	private boolean terminado;
	
	@Column(name = "TOTAL_LINEA")
	private double totalLinea;
		
	
	@OneToOne(targetEntity = ArticuloOfertado.class)
	@JoinColumn(name = "ARTICULO_ID", referencedColumnName = "ID")
	ArticuloOfertado articuloOfertado;
	
	
	
	// MÉTODOS.

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	
	public double getTotalLinea() {
		totalLinea+=this.getArticuloOfertado().getPrecio()*this.getCantidad();//   M. C.
		return totalLinea;

	}
	
	public void setTotalLinea(double totalLinea) { // M.C.
		this.totalLinea = totalLinea;
	}
	
	
	public String getDescripcion(){
		return descripcion;
	}
	
	public void setDescripcion(String descripcion){
		this.descripcion = descripcion;
	}
	
	
	public boolean isTerminado() {
		return terminado;
	}

	public void setTerminado(boolean terminado) {
		this.terminado = terminado;
	}

	
	public ArticuloOfertado getArticuloOfertado() {
		return articuloOfertado;
	}

	public void setArticulo(ArticuloOfertado articuloOfertado) {
		this.articuloOfertado = articuloOfertado;
	}

	
}