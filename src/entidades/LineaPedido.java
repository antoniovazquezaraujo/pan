package entidades;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/** Entity implementation class for Entity: LineaPedido **/

@Entity
@Table(name = "lineapedido", schema = "panaderia")

public class LineaPedido extends  Entidad {

	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private int id;
	
	@Column(name = "CANTIDAD")
	private int cantidad;

	@Column(name = "UNIDADES_RECIBIDAS")
	private int unidadesRecibidas;

	@Column(name = "UNIDADES_PENDIENTES")
	private int unidadesPendientes;
	
	@Column(name = "TOTAL_LINEA")
	private double totalLinea;
		
	
	
	@OneToOne(targetEntity = Producto.class)
	@JoinColumn(name = "PRODUCTO_ID", referencedColumnName = "ID")
	Producto producto;
	
	
	
	// MÉTODOS.

	
	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	
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

	
	public int getUnidadesRecibidas() {
		return unidadesRecibidas;
	}

	public void setUnidadesRecibidas(int unidadesRecibidas) {
		this.unidadesRecibidas = unidadesRecibidas;
	}
	
	
	public int getUnidadesPendientes(){
		return unidadesPendientes;
	}
	
	public void setUnidadesPendientes(){
		this.unidadesPendientes = this.getCantidad() - this.getUnidadesRecibidas();
	}

		
	public double getTotalLinea() {
		totalLinea+=this.getProducto().getPrecio()*this.getCantidad();//   M. C.
		return totalLinea;

	}
	
	public void setTotalLinea(double totalLinea) {
		this.totalLinea = totalLinea;
	}
	
}

