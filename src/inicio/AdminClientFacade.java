package inicio;

import java.util.List;

import org.openswing.swing.mdi.client.ClientFacade;
import org.openswing.swing.mdi.client.MDIFrame;

import persistencia.Persistencia;
import views.ReportView;
import views.Screen;
import views.ScreenFactory;
import views.ScreenFrame;
import entidades.Albaran;
import entidades.ArticuloOfertado;
import entidades.Cliente;
import entidades.Empleado;
import entidades.Encargo;
import entidades.Factura;
import entidades.Pedido;
import entidades.Producto;
import entidades.Proveedor;
import entidades.RutaReparto;
import entidades.Usuario;


public class AdminClientFacade implements ClientFacade{
	public AdminClientFacade() {
	}


	public void getRutasReparto() {
		List<RutaReparto> rutasReparto= Persistencia.load(RutaReparto.class);
		Screen screen = ScreenFactory.make(ScreenFactory.get("RutaRepartoGrid1"));
		screen.setModel(null, rutasReparto);
		ScreenFrame f = new ScreenFrame(screen);
		MDIFrame.add(f);
	}
	
	
	public void getListadoRutasReparto(){
		String report = "listado Rutas Reparto";
		ReportView view = new ReportView(report);
		MDIFrame.add(view);
	}
	
	
	public void getAlbaran() {
		List<Albaran> albaranes= Persistencia.load(Albaran.class);
		Screen screen = ScreenFactory.make(ScreenFactory.get("AlbaranGrid3"));
		screen.setModel(null, albaranes);
		ScreenFrame f = new ScreenFrame(screen);
		MDIFrame.add(f);
	}
	
	
	public void getListadoAlbaranes(){
		String report = "listado albaranes";
		ReportView view = new ReportView(report);
		MDIFrame.add(view);
	}
	
	public void getFactura() {
		List<Factura> facturas= Persistencia.load(Factura.class);
		Screen screen = ScreenFactory.make(ScreenFactory.get("FacturaGrid3"));
		screen.setModel(null, facturas);
		ScreenFrame f = new ScreenFrame(screen);
		MDIFrame.add(f);
	}
	
	
	public void getListadoFacturas(){
		String report = "listado facturas";
		ReportView view = new ReportView(report);
		MDIFrame.add(view);
	}
	
	
	
	public void getUsuarios() {
		List<Usuario> usuarios= Persistencia.load(Usuario.class);
		Screen screen = ScreenFactory.make(ScreenFactory.get("UsuarioGrid1"));
		screen.setModel(null, usuarios);
		ScreenFrame f = new ScreenFrame(screen);
		MDIFrame.add(f);
	}
	
	public void getClientes() {
		List<Cliente> clientes= Persistencia.load(Cliente.class);
		Screen screen = ScreenFactory.make(ScreenFactory.get("ClienteGrid2"));
		screen.setModel(null, clientes);
		ScreenFrame f = new ScreenFrame(screen);
		MDIFrame.add(f);
	}
	
	public void getListadoClientes(){
		String report = "listado clientes";
		ReportView view = new ReportView(report);
		MDIFrame.add(view);
	}
	
	
	public void getEmpleados() {
		List<Empleado> empleados= Persistencia.load(Empleado.class);
		Screen screen = ScreenFactory.make(ScreenFactory.get("EmpleadoGrid2"));
		screen.setModel(null, empleados);
		ScreenFrame f = new ScreenFrame(screen);
		MDIFrame.add(f);
	}
	public void getListadoEmpleados(){
		String report = "listado empleados";
		ReportView view = new ReportView(report);
		MDIFrame.add(view);
	}
	
	
	
	public void getProductos() {
		List<Producto> productos= Persistencia.load(Producto.class);
		Screen screen = ScreenFactory.make(ScreenFactory.get("ProductoGrid2"));
		screen.setModel(null, productos);
		ScreenFrame f = new ScreenFrame(screen);
		MDIFrame.add(f);
	}
	
	public void getListadoProductos(){
		String report = "listadoProductos";
		ReportView view = new ReportView(report);
		MDIFrame.add(view);
	}
	
	
	/*public void getProductosAlmacen() {
	List<Producto> productos= Persistencia.load(Producto.class);
	Screen screen = ScreenFactory.make(ScreenFactory.get("ProductoGrid3"));
	screen.setModel(null, productos);
	ScreenFrame f = new ScreenFrame(screen);
	MDIFrame.add(f);	
}*/
	
	
	public void getArticulosOfertados() {
		List<ArticuloOfertado> articulosOfertados= Persistencia.load(ArticuloOfertado.class);
		Screen screen = ScreenFactory.make(ScreenFactory.get("ArticuloOfertadoGrid2"));
		screen.setModel(null, articulosOfertados);
		ScreenFrame f = new ScreenFrame(screen);
		MDIFrame.add(f);
	}
	
	
	
	
	public void getListadoArticulosOfertados(){
		String report = "articulosOfertados";
		ReportView view = new ReportView(report);
		MDIFrame.add(view);
	}

	
	public void getEncargos() {
		List<Encargo> encargos= Persistencia.load(Encargo.class);
		Screen screen = ScreenFactory.make(ScreenFactory.get("EncargoGrid1"));
		screen.setModel(null, encargos);
		ScreenFrame f = new ScreenFrame(screen);
		MDIFrame.add(f);
	}
	
	
	public void getListadoEncargos(){
		String report = "listado encargos";
		ReportView view = new ReportView(report);
		MDIFrame.add(view);
	}
	
	
	public void getProveedores() {
		List<Proveedor> proveedores= Persistencia.load(Proveedor.class);
		Screen screen = ScreenFactory.make(ScreenFactory.get("ProveedorGrid2"));
		screen.setModel(null, proveedores);
		ScreenFrame f = new ScreenFrame(screen);
		MDIFrame.add(f);
	}
	public void getListadoProveedores(){
		String report = "listado proveedores";
		ReportView view = new ReportView(report);
		MDIFrame.add(view);
	}
	public void getPedidos() {
		List<Pedido> pedidos= Persistencia.load(Pedido.class);
		Screen screen = ScreenFactory.make(ScreenFactory.get("PedidoGrid2"));
		screen.setModel(null, pedidos);
		ScreenFrame f = new ScreenFrame(screen);
		MDIFrame.add(f);
	}
	public void getListadoPedidos(){
		String report = "listado pedidos";
		ReportView view = new ReportView(report);
		MDIFrame.add(view);
	}
	

}