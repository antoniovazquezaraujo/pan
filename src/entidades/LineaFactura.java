package entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/** * Entity implementation class for Entity: LineaFactura  */


@Entity
@Table(name = "lineafactura", schema = "panaderia")

public class LineaFactura extends Entidad {

	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private int id;
	
	@Column(name = "TOTAL_LINEA")
	private double totalLinea;
	
	@OneToOne(targetEntity = Albaran.class)
	@JoinColumn(name = "ALBARAN_ID", referencedColumnName = "ID")
	Albaran albaran;
			
	@OneToOne(targetEntity = ArticuloOfertado.class)
	@JoinColumn(name = "ARTICULOOFERTADO_ID", referencedColumnName = "ID")
	ArticuloOfertado articuloOfertado;
	
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


	public double getTotalLinea(){
		//return this.getEncargo().getTotal_Encargo();
		double total= this.getAlbaran().getTotal_Albaran();
		totalLinea = total;
		return totalLinea;
	}
	
	
	
	public void setTotal(double totalLinea){
		this.totalLinea = totalLinea;
	}
	
	
	 public Encargo getEncargo() {
	 	return encargo;
	}

	public void setEncargo(Encargo encargo) {
		this.encargo = encargo;
	}
	
	
	public Albaran getAlbaran(){
		return albaran;
	}
		   
	public void setAlbaran(Albaran albaran){
		this.albaran = albaran;
	}

	
	public ArticuloOfertado getArticuloOfertado(){
		return articuloOfertado;
	}
	public void setArticuloOfertado(ArticuloOfertado articuloOfertado){
		this.articuloOfertado = articuloOfertado;
		
	}

}



