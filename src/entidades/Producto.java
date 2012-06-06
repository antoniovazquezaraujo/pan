package entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.swing.JOptionPane;

/** Entity implementation class for Entity: Producto * */

@Entity
@Table(name = "producto", schema = "panaderia")
public class Producto extends  Entidad {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	
	@GeneratedValue
	private int id;
	
	@Column(name = "NOMBRE")
	private String nombre;	

	@Column(name = "DESCRIPCION")
	private String descripcion;
	
	@Column(name = "PRECIO")
	private double precio;

	@Column(name = "STOCK_ACTUAL")
	private int stockActual;

	@Column(name = "STOCK_MINIMO")
	private int stockMinimo;

	@Column(name = "OBSERVACIONES")
	private String observaciones;

	@Column(name = "ACTIVO")
	private boolean activo;
	
	
	@OneToOne(targetEntity = Proveedor.class)
	@JoinColumn(name = "PROVEEDOR_ID", referencedColumnName = "ID")
	Proveedor proveedor;
	
	
	/* 
	 * MÉTODOS
	 * 
	 */
	
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
		return precio;
	}

	public void setPrecio(double precio) {
			this.precio = precio;	
	}

	public int getStockActual() {
		return stockActual;
	}

	public void setStockActual(int stockActual) {
		if (stockActual < this.getStockMinimo()){
			JOptionPane.showMessageDialog(null, "El stock mínimo del siguiente producto se encuentra por debajo del valor permitido", nombre, JOptionPane.WARNING_MESSAGE );
		}
		this.stockActual = stockActual;
	}

	public int getStockMinimo() {
		return stockMinimo;
	}

	public void setStockMinimo(int stockMinimo) {
		this.stockMinimo = stockMinimo;
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

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
			this.proveedor = proveedor;// m.c.
		
	}
	
	   
}
