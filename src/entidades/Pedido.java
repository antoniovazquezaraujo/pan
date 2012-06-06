package entidades;

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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Entity implementation class for Entity: Pedido* */


@Entity
@Table(name = "pedido", schema = "panaderia")

public class Pedido extends  Entidad {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	
	@GeneratedValue
	private int id;
	
	@Column(name = "FECHA_ALTA")
	@Temporal(DATE)
	private Date fecha_Alta;
	
	@Column(name = "FECHA_RECEPCION")
	@Temporal(DATE)
	private Date fecha_Recepcion;

	@Column(name = "FORMA_DE_PAGO")
	private String formaDePago;

	@Column(name = "TOTAL_PEDIDO")
	private double total_Pedido;
	
	@Column(name = "RECIBIDO")
	private boolean recibido;
	
	public boolean isRecibido(){
		return recibido;
	}
	
	@OneToMany(targetEntity = LineaPedido.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(schema = "panaderia")
	List<LineaPedido> lineasPedido;
	
	@OneToOne(targetEntity = Proveedor.class)
	@JoinColumn(name = "PROVEEDOR_ID", referencedColumnName = "ID")
	Proveedor proveedor;
	
	@OneToOne(targetEntity = Empleado.class)
	@JoinColumn(name = "EMPLEADO_ID", referencedColumnName = "ID")
	Empleado empleado;
	
	
	
	// MÉTODOS

	public Pedido(){
		lineasPedido = new ArrayList<LineaPedido>();
	}
	
	public int getId(){
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha_Alta() {
		return fecha_Alta;
	}

	public void setFecha_Alta(Date fecha_Alta) {
		this.fecha_Alta = fecha_Alta;
	}

	public Date getFecha_Recepcion() {
		return fecha_Recepcion;
	}

	public void setFecha_Recepcion(Date fecha_Recepcion) {
		this.fecha_Recepcion = fecha_Recepcion;
	}

	public String getFormaDePago() {
		return formaDePago;
	}

	public void setFormaDePago(String formaDePago) {
		this.formaDePago = formaDePago;
	}

	public double getTotal_Pedido() {
		double total = 0;
		for(LineaPedido l:lineasPedido){
			total += l.getTotalLinea();
		}
		this.total_Pedido = total;
		return this.total_Pedido;
		
	}

	public void setImporteTotal(double total_Pedido) {
		this.total_Pedido = total_Pedido;
	}

	public List<LineaPedido> getLineasPedido() {
		return lineasPedido;
	}

	public void setLineasPedido(List<LineaPedido> lineasPedido) {
		this.lineasPedido = lineasPedido;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	
	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

		
}