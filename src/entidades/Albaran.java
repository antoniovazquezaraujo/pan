package entidades;

import static javax.persistence.TemporalType.DATE;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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




/**
 * Entity implementation class for Entity: Albaran
 *
 */

@Entity
@Table(name = "albaran", schema = "panaderia")

public class Albaran extends Entidad {

	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	
	@GeneratedValue
	private int id;
	
	@Column(name = "FECHA")
	@Temporal(DATE)
	private Date fecha;
	
	@Column(name = "OBSERVACIONES")
	private String observaciones;
	
	@Column(name = "TOTAL_ALBARAN")
	private double total_Albaran;
	
	@Column(name = "FACTURADO")
	private boolean facturado;
	
	
	@OneToMany(targetEntity = LineaAlbaran.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(schema = "panaderia")
	List<LineaAlbaran> lineasAlbaran;
	
	@OneToOne(targetEntity = Cliente.class)
	@JoinColumn(name = "CLIENTE_ID", referencedColumnName = "ID")
	Cliente cliente;
	
		
	// MÉTODOS

	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	public Albaran(){
		lineasAlbaran = new ArrayList<LineaAlbaran>();
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

	
	public String getObservaciones(){
		return observaciones;
	}
	
	public void setObservaciones(String observaciones){
		this.observaciones = observaciones;
	}
	
	
	public double getTotal_Albaran() {
		double total = 0;
		for(LineaAlbaran l:lineasAlbaran){
			total += l.getEncargo().getTotal_Encargo();
		}
		this.total_Albaran = total;
		return this.total_Albaran;
		
	}

	
	public void setTotal_Albaran(double total_Albaran) {
		this.total_Albaran = total_Albaran;
	}
	
	
	
	public List<LineaAlbaran> getLineasAlbaran() {
		return lineasAlbaran;
	}

	public void setLineasAlbaran(List<LineaAlbaran> lineasAlbaran) {
		this.lineasAlbaran = lineasAlbaran;
	}
	
	public boolean isFacturado() {
		return facturado;
	}


	public void setFacturado(boolean facturado) {
		this.facturado = facturado;
	}
	
	
	
	
	
	/* public double getTotalLinea() {
		recalcularTotal();
		return totalLinea;

	}
	public void recalcularTotal() {
		double total=0;
		if ( lineaAlbaran != null){
			total+=this.getProducto().getPrecio()*this.getUnidades();
		}
		this.totalLinea = total;
		
	}
	
	public void setTotalLinea(double totalLinea) {
		this.totalLinea = totalLinea;
	}
	 
	
	public double getImporteTotal() {
	 	double total = 0;
		for(LineaAlbaran l:lineasAlbaran){
			total += l.getTotalLinea();
		}
		this.importeTotal = total;
		return this.importeTotal;
		
	}

	public void setImporteTotal(double importeTotal) {
		this.importeTotal = importeTotal;

	}
	
	*/
	
		
	   
}

   

