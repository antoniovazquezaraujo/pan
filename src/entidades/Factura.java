package entidades;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static javax.persistence.TemporalType.DATE;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;


/** Entity implementation class for Entity: Factura  */

@Entity
@Table(name = "factura", schema = "panaderia")

public class Factura extends Entidad {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private int id;
	
	@Column(name = "FECHA")
	@Temporal(DATE)
	private Date fecha;
	
	@Column(name = "BASE_IMPONIBLE")
	private double baseImponible;
	
	
	@Column(name = "IVA")
	private double iva = 0.16;
	
	@Column(name = "TOTAL")
	private double total;
	
	@OneToMany(targetEntity = LineaFactura.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(schema = "panaderia")
	List<LineaFactura> lineasFactura;
	
	@OneToOne(targetEntity = Cliente.class)
	@JoinColumn(name = "CLIENTE_ID", referencedColumnName = "ID")
	Cliente cliente;
	
	
	
	
	// MÉTODOS

	
	public Factura(){
		lineasFactura = new ArrayList<LineaFactura>();
	}
	
	public int getId(){
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
		
	//** CALCULAR TOTAL FACTURA
	
	
	
	public double getBaseImponible() {
	double total = 0;
		for(LineaFactura l:lineasFactura){
			total += l.getEncargo().getTotal_Encargo();
		}
		this.baseImponible = total;
		return this.baseImponible;
		
	}

	public void setBaseImponible(double baseImponible) {
		this.baseImponible = baseImponible;
	}
	
	
	public double getTotal(){
		double t=0;
		t= (this.getBaseImponible()*this.getIva())+this.baseImponible;
		total=t;
		return total;
	}

	
	public void setTotal(double total){
		this.total = total;
	}
	
	public double getIva(){
		return iva;
	}
	
	public void setIva(double iva){
		this.iva = iva;
	}
	//REVISAR EL ACCESO A LINEA ALBARAN PARA CALCULAR TOTAL
	
	public List<LineaFactura> getLineasFactura() {
		return lineasFactura;
	}

	public void setLineasFactura(List<LineaFactura> lineasFactura) {
		this.lineasFactura = lineasFactura;
	}

	
	   
}

