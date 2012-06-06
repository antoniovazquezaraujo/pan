package entidades;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static javax.persistence.TemporalType.TIMESTAMP;

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



/** Entity implementation class for Entity: Encargo **/ 

@Entity
@Table (name = "encargo", schema = "panaderia")

public class Encargo extends Entidad {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID")
	@GeneratedValue
	private int id;
	
	@Column(name = "FECHA_ALTA")
	@Temporal (TIMESTAMP)
	private Date fecha_Alta;
	
	@Column(name = "FECHA_ENTREGA")
	@Temporal (TIMESTAMP)
	private Date fechaEntrega;
	
	@Column(name = "TOTAL_ENCARGO")
	private double total_Encargo;
	
	
	@Column(name = "ENTREGADO")
	private boolean entregado;
	
	
	@OneToMany(targetEntity = LineaEncargo.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(schema = "panaderia")
	List<LineaEncargo> lineasEncargo;
	
	@OneToOne(targetEntity = Cliente.class)
	@JoinColumn(name = "CLIENTE_ID", referencedColumnName = "ID")
	Cliente cliente;
	
	@OneToOne(targetEntity = Empleado.class)
	@JoinColumn(name = "EMPLEADO_ID", referencedColumnName = "ID")
	Empleado empleado;
	
	
// MÉTODOS
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public List<LineaEncargo> getLineasEncargo() {
		return lineasEncargo;
	}

	public void setLineasEncargo(List<LineaEncargo> lineasEncargo) {
		this.lineasEncargo = lineasEncargo;
	}

	
	public Encargo(){
		lineasEncargo = new ArrayList<LineaEncargo>();
	}
	
	
	public double getTotal_Encargo() {
		double total = 0;
		for(LineaEncargo l:lineasEncargo){
			total += l.getTotalLinea();
		}
		this.total_Encargo = total;
		return this.total_Encargo;
		
	}

	public void setTotal_Encargo(double total_Encargo) {
		this.total_Encargo = total_Encargo;
	}
	
	
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	
	public Date getFechaRecepcionEncargo(){
		return fecha_Alta;
	}

	public void setFechaRecepcionEncargo(Date fechaRecepcionEncargo) {
		this.fecha_Alta = fechaRecepcionEncargo;
	}

	public Date getFechaEntregaEncargo() {
		return fechaEntrega;
	}

	public void setFechaEntregaEncargo(Date fechaEntregaEncargo) {
		this.fechaEntrega = fechaEntregaEncargo;
	}
	
		
	public boolean isEntregado() {
		return entregado;
	}


	public void setEntregado(boolean entregado) {
		this.entregado = entregado;
	}

	}
