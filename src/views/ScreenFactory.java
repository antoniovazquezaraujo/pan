package views;
import java.util.HashMap;
import java.util.Map;



//============================================================================================
// ScreenFactory
//============================================================================================
public class ScreenFactory {
	static Map<String, ScreenDescription> screens = new HashMap<String, ScreenDescription>();
	
	public static void setup() {
		ScreenDescription s = null;

		// Screen(Titulo, modelo de datos, Nombre del formulario, tipo(FORM o GRID), Constraints("wrap 3, etc") )
		// Campo(nombre, Titulo, Tipo, TipoDeControl, esUnoAMuchos, Screen, esUnoAUno, Screen, Contraints("wrap, span...etc"))
		// Campo(nombre, Titulo, Tipo, TipoDeControl, esUnoAMuchos, Screen, esUnoAUno, Screen, Contraints("wrap, span...etc"), Requerido)
		// Campo(nombre, Titulo, Tipo, TipoDeControl, esUnoAMuchos, Screen, esUnoAUno, Screen, Contraints("wrap, span...etc"), Requerido, Size)
		// Boton(nombreAccionARealizar, Titulo, Constraints)

		
		//Usuarios---------------------------------------------------------------------------------------------------------
		s = new ScreenDescription("Usuarios","entidades.Usuario","Formulario1 Usuario", Screen.Type.FORM, "wrap 4");
		s.add(new FieldDescription("id", "Id Usuario", "java.lang.Integer", "NumericControl", false, null, false, null, null));
		s.add(new FieldDescription("nombre", "Nombre Usuario", "java.lang.String", "TextControl", false, null, false, null, null));
		s.add(new FieldDescription("password", "Contraseña", "java.lang.String", "TextControl", false, null, false, null, null, true));
		add(s);

		s = new ScreenDescription("Usuarios","entidades.Usuario","UsuarioGrid1", Screen.Type.GRID, "wrap 4", "Formulario1 Usuario");
		s.add(new FieldDescription("id", "Id Usuario", "java.lang.Integer", "NumericControl", false, null, false, null, null));
		s.add(new FieldDescription("nombre", "Nombre Usuario", "java.lang.String", "TextControl", false, null, false, null, null, true));
		s.add(new FieldDescription("password", "Contraseña", "java.lang.String", "TextControl", false, null, false, null, null, true));
		add(s);
		

				
		//CLIENTES---------------------------------------------------------------------------------------------------
		s = new ScreenDescription("Cliente", "entidades.Cliente","Formulario1 Cliente", Screen.Type.FORM, "wrap 3");
		s.add(new FieldDescription("id", "Id", "java.lang.Integer", "NumericControl", false, null, false, null, "wrap"));
//		s.add(new FieldDescription("borrado", "Inactivo", "java.lang.Boolean", "TextControl", false, null, false, null, "wrap"));
		s.add(new FieldDescription("nombre", "Nombre", "java.lang.String", "TextControl", false, null, false, null, null, true, 18));
		s.add(new FieldDescription("apellido1", "Apellido1", "java.lang.String", "TextControl", false, null, false, null, null, true, 18));
//		s.add(new FieldDescription("apellido1", "Apellido1", "java.lang.String", "TextControl", false, null, false, null, null, true));
		s.add(new FieldDescription("apellido2", "Apellido2", "java.lang.String", "TextControl", false, null, false, null, "wrap"));
    	s.add(new FieldDescription("dni", "DNI", "java.lang.String", "TextControl", false, null, false, null, null));
//		s.add(new FieldDescription("fechaDeNacimiento", "Fecha de nacimiento", "java.util.Date", "TimeControl", false, null, false,null, "wrap"));
		s.add(new FieldDescription("fechaDeNacimiento", "Fecha de nacimiento", "java.util.Date", "DateControl", false, null, false,null, "wrap"));
		s.add(new FieldDescription("direccion", "Dirección", "java.lang.String", "TextControl", false, null, false, null, "wrap", false, 30));
		s.add(new FieldDescription("localidad", "Localidad", "java.lang.String", "TextControl", false, null, false, null, null, false, 20));
		s.add(new FieldDescription("codigoPostal", "C.Postal", "java.lang.String", "TextControl", false, null, false, null, null));
		s.add(new FieldDescription("provincia", "Provincia", "java.lang.String", "TextControl", false, null, false, null, "wrap"));
		s.add(new FieldDescription("telefono1", "Teléfono", "java.lang.Integer", "NumericControl", false, null, false, null, null));
		s.add(new FieldDescription("telefono2", "Teléfono(Secundario)", "java.lang.Integer", "NumericControl", false, null, false, null, "wrap"));
		s.add(new FieldDescription("correo", "e-mail", "java.lang.String", "TextControl", false, null, false, null, "wrap"));
		s.add(new FieldDescription("observaciones", "Observaciones", "java.lang.String", "TextControl", false, null, false, null,"span", false, 55));
		s.add(new FieldDescription("imprimirCliente", "Imprimir", null));
		add(s);
	
		s = new ScreenDescription("Clientes","entidades.Cliente", "ClienteGrid2", Screen.Type.GRID, "wrap 3", "ClienteForm1");
		s.add(new FieldDescription("borrado", "Inactivo", "java.lang.Boolean", "TextControl", false, null, false, null, "wrap"));
//		s.add(new FieldDescription("id", "Id", "java.lang.Integer", "NumericControl", false, null, false, null, null));
		s.add(new FieldDescription("nombre", "Nombre", "java.lang.String", "TextControl", false, null, false, null, null, true, 18));
		s.add(new FieldDescription("apellido1", "Apellido1", "java.lang.String", "TextControl", false, null, false, null, null));
		s.add(new FieldDescription("apellido2", "Apellido2", "java.lang.String", "TextControl", false, null, false, null, "wrap"));
		add(s);
		
	
		
		//EMPLEADOS---------------------------------------------------------------------------------------------------
		s = new ScreenDescription("Empleado", "entidades.Empleado","EmpleadoForm1", Screen.Type.FORM, "wrap 3");
		s.add(new FieldDescription("id", "Id", "java.lang.Integer", "NumericControl", false, null, false, null, null));
		s.add(new FieldDescription("borrado", "Inactivo", "java.lang.Boolean", "TextControl", false, null, false, null, "wrap"));
		s.add(new FieldDescription("nombre", "Nombre", "java.lang.String", "TextControl", false, null, false, null, null, true, 18));
		s.add(new FieldDescription("apellido1", "Apellido1", "java.lang.String", "TextControl", false, null, false, null, null, true));
		s.add(new FieldDescription("apellido2", "Apellido2", "java.lang.String", "TextControl", false, null, false, null, null));
		s.add(new FieldDescription("dni", "DNI", "java.lang.String", "TextControl", false, null, false, null, null,false));
		s.add(new FieldDescription("fechaDeNacimiento", "Fecha de nacimiento", "java.util.Date", "DateControl", false, null, false,null, "wrap"));
		s.add(new FieldDescription("direccion", "Dirección", "java.lang.String", "TextControl", false, null, false, null, "span", false, 50));
		s.add(new FieldDescription("localidad", "Localidad", "java.lang.String", "TextControl", false, null, false, null,null, false, 18));
		s.add(new FieldDescription("codigoPostal", "C.Postal", "java.lang.String", "TextControl", false, null, false, null, null));
		s.add(new FieldDescription("provincia", "Provincia", "java.lang.String", "TextControl", false, null, false, null, null));
		s.add(new FieldDescription("telefono1", "Teléfono", "java.lang.Integer", "NumericControl", false, null, false, null, null));
		s.add(new FieldDescription("telefono2", "Teléfono(Secundario)", "java.lang.Integer", "NumericControl", false, null, false, null, null));
		s.add(new FieldDescription("correo", "e-mail", "java.lang.String", "TextControl", false, null, false, null, null));
		s.add(new FieldDescription("fechaDeAlta", "Fecha de Alta", "java.util.Date", "DateControl", false, null, false,null, null,false));
		s.add(new FieldDescription("fechaDeBaja", "Fecha de Baja", "java.util.Date", "DateControl", false, null, false,null, "wrap"));
		s.add(new FieldDescription("numeroDeCuentaCorriente", "Num. de Cuenta", "java.lang.Integer", "NumericControl", false, null, false, null, "span", false, 30));
		s.add(new FieldDescription("numeroDeSeguridadSocial", "NSS", "java.lang.Integer", "NumericControl", false, null, false, null, null,false));
		s.add(new FieldDescription("salario", "Salario(€)", "java.lang.Double", "NumericControl", false, null, false, null, "wrap"));
		s.add(new FieldDescription("observaciones", "Observaciones", "java.lang.String", "TextControl", false, null, false, null, "span", false, 50));
		s.add(new FieldDescription("imprimirEmpleado", "Imprimir", null));
		add(s);
	
		
		s = new ScreenDescription("Empleados","entidades.Empleado", "EmpleadoGrid2", Screen.Type.GRID, "wrap 3", "EmpleadoForm1");
		s.add(new FieldDescription("borrado", "Inactivo", "java.lang.Boolean", "TextControl", false, null, false, null, "wrap"));
//		s.add(new FieldDescription("id", "Id Empleado", "java.lang.Integer", "NumericControl", false, null, false, null, null));
		s.add(new FieldDescription("nombre", "Nombre", "java.lang.String", "TextControl", false, null, false, null, null));
		s.add(new FieldDescription("apellido1", "Apellido1", "java.lang.String", "TextControl", false, null, false, null, null));
		s.add(new FieldDescription("apellido2", "Apellido2", "java.lang.String", "TextControl", false, null, false, null, "wrap"));
		s.add(new FieldDescription("dni", "DNI", "java.lang.String", "TextControl", false, null, false, null, null,false));
		s.add(new FieldDescription("telefono1", "Teléfono", "java.lang.Integer", "NumericControl", false, null, false, null, null));
		add(s);
		
		
		
		
		
	
		//PEDIDO---------------------------------------------------------------------------------------------------
		s = new ScreenDescription("Pedido", "entidades.Pedido","PedidoForm1", Screen.Type.FORM, "wrap 3");
		s.add(new FieldDescription("id", "Id", "java.lang.Integer", "NumericControl", false, null, false, null, "wrap"));
		s.add(new FieldDescription("proveedor", "Id Proveedor", "entidades.Proveedor", "NO-USADO", false, null, true, "ProveedorGrid2", null));
		s.add(new FieldDescription("proveedor.nombre", "Proveedor", "java.lang.String", "TextControl", false, null, false, null, "wrap"));
		s.add(new FieldDescription("fechaDeEnvio", "Fecha de Envío", "java.util.Date", "DateControl", false, null, false,null, null));
		s.add(new FieldDescription("fechaDeRecepcion", "Fecha de Recepción", "java.util.Date", "DateControl", false, null, false,null, "wrap"));
		s.add(new FieldDescription("formaDePago", "Forma de Pago", "java.lang.String", "TextControl", false, null, false, null, "span", false,40));
		s.add(new FieldDescription("empleado", "Realizado por el empleado", "entidades.Empleado", "NO-USADO", false, null, true, "EmpleadoGrid2", null));
		s.add(new FieldDescription("empleado.nombre", "Nombre", "java.lang.String", "TextControl", false, null, false, null, "wrap"));
		s.add(new FieldDescription("lineasPedido", "Líneas de Detalle", "entidades.LineaPedido", "NO-USADO", true, "LineaPedidoGrid1", false,null,  "span, grow"));		
		s.add(new FieldDescription("totalPedido", "Total(€)", "java.lang.Double", "NumericControl", false, null, false, null, "wrap"));
		s.add(new FieldDescription("imprimirPedido", "Imprimir", null));
		add(s);
		
		s = new ScreenDescription("Pedidos","entidades.Pedido", "PedidoGrid2", Screen.Type.GRID, "wrap 3", "PedidoForm1");
//		s.add(new FieldDescription("id", "Id Pedido", "java.lang.Integer", "NumericControl", false, null, false, null, null));
		s.add(new FieldDescription("proveedor", "Id Proveedor", "entidades.Proveedor", "NO-USADO", false, null, true, "ProveedorGrid2", null));
		s.add(new FieldDescription("proveedor.nombre", "Proveedor", "java.lang.String", "TextControl", false, null, false, null, "wrap"));
		s.add(new FieldDescription("fechaDeEnvio", "Fecha Envío", "java.util.Date", "DateControl", false, null, false,null, "wrap"));
		s.add(new FieldDescription("fechaDeRecepcion", "Fecha Recepción", "java.util.Date", "DateControl", false, null, false,null, "wrap"));
		s.add(new FieldDescription("empleado", "Id Empleado", "entidades.Empleado", "NO-USADO", false, null, true, "EmpleadoGrid2", null));
		s.add(new FieldDescription("empleado.nombre", "Empleado", "java.lang.String", "TextControl", false, null, false, null, "wrap"));

		add(s);
	
		//LíneaPedido---------------------------------------------------------------------------------------------------
		s = new ScreenDescription("Detalle de Pedido", "entidades.LineaPedido","LineaPedidoForm1", Screen.Type.FORM, "wrap 3");
		s.add(new FieldDescription("id", "Id", "java.lang.Integer", "NumericControl", false, null, false, null, null));
		s.add(new FieldDescription("unidades", "Unidades", "java.lang.Integer", "NumericControl", false, null, false, null, null,true));
		s.add(new FieldDescription("producto", "Id Producto", "entidades.Producto", "NO-USADO", false, null, true, "ProductoGrid2", null));
		s.add(new FieldDescription("producto.nombre", "Producto", "java.lang.String", "TextControl", false, null, false, null, null));
		s.add(new FieldDescription("producto.precio", "Precio/ud.(€)", "java.lang.Double", "NumericControl", false, null, false, null, null));	
		s.add(new FieldDescription("unidadesRecibidas", "Uds. Recibidas", "java.lang.Integer", "NumericControl", false, null, false, null, null));
		s.add(new FieldDescription("unidadesProcesadas", "Uds. Procesadas", "java.lang.Integer", "NumericControl", false, null, false, null, null));
		s.add(new FieldDescription("totalLinea", "Total(€)", "java.lang.Double", "NumericControl", false, null, false, null, null));
		add(s);

		s = new ScreenDescription("Detalle de Pedido","entidades.LineaPedido", "LineaPedidoGrid1", Screen.Type.GRID, "wrap 3", "LineaPedidoForm1");
//		s.add(new FieldDescription("id", "Id", "java.lang.Integer", "NumericControl", false, null, false, null, null));
		s.add(new FieldDescription("unidades", "Unidades", "java.lang.Integer", "NumericControl", false, null, false, null, null));
		s.add(new FieldDescription("producto", "Id Producto", "entidades.Producto", "NO-USADO", false, null, true, "ProductoGrid2", null));
		s.add(new FieldDescription("producto.nombre", "Producto", "java.lang.String", "TextControl", false, null, false, null, null));
		s.add(new FieldDescription("producto.precio", "Precio/ud.(€)", "java.lang.Double", "NumericControl", false, null, false, null, null));	
		s.add(new FieldDescription("unidadesRecibidas", "Uds. Recibidas", "java.lang.Integer", "NumericControl", false, null, false, null, null));
//		s.add(new FieldDescription("unidadesProcesadas", "Uds. Procesadas", "java.lang.Integer", "NumericControl", false, null, false, null, null));
		s.add(new FieldDescription("totalLinea", "Total(€)", "java.lang.Double", "NumericControl", false, null, false, null, null));
		add(s);	
		
				
		//PRODUCTO---------------------------------------------------------------------------------------------------
		s = new ScreenDescription("Producto", "entidades.Producto","ProductoForm1", Screen.Type.FORM, "wrap 3");
		s.add(new FieldDescription("id", "Id", "java.lang.Integer", "NumericControl", false, null, false, null, null));
		s.add(new FieldDescription("borrado", "Inactivo", "java.lang.Boolean", "TextControl", false, null, false, null, "wrap"));
		s.add(new FieldDescription("nombre", "Nombre", "java.lang.String", "TextControl", false, null, false, null, null, true, 20));
		s.add(new FieldDescription("precio", "Precio(€)", "java.lang.Double", "NumericControl", false, null, false, null, "wrap", true));
		s.add(new FieldDescription("descripcion", "Descripción", "java.lang.String", "TextControl", false, null, false, null,"span", false, 50));
		s.add(new FieldDescription("proveedor", "Id Proveedor", "entidades.Proveedor", "NO-USADO", false, null, true, "ProveedorGrid2", null));
		s.add(new FieldDescription("proveedor.nombre", "Proveedor", "java.lang.String", "TextControl", false, null, false, null, "wrap"));
		s.add(new FieldDescription("unidadesEnAlmacen", "Unidades en Almacén", "java.lang.Integer", "NumericControl", false, null, false, null, null,false));
		s.add(new FieldDescription("stockMinimo", "Stock Mínimo", "java.lang.Integer", "NumericControl", false, null, false, null, "wrap",false));
		s.add(new FieldDescription("observaciones", "Observaciones", "java.lang.String", "TextControl", false, null, false, null, "span", false, 50));
		s.add(new FieldDescription("imprimirProducto", "Imprimir", null));
		add(s);

		s = new ScreenDescription("Productos","entidades.Producto", "ProductoGrid1", Screen.Type.GRID, "wrap 3", "ProductoForm1");
		s.add(new FieldDescription("id", "Id", "java.lang.Integer", "NumericControl", false, null, false, null, null));
//		s.add(new FieldDescription("borrado", "Inactivo", "java.lang.Boolean", "TextControl", false, null, false, null, "wrap"));
		s.add(new FieldDescription("nombre", "Nombre", "java.lang.String", "TextControl", false, null, false, null, null));
		s.add(new FieldDescription("precio", "Precio (€)", "java.lang.Double", "NumericControl", false, null, false, null, null));
//		s.add(new FieldDescription("descripcion", "Descripción", "java.lang.String", "TextControl", false, null, false, null, "wrap"));
		s.add(new FieldDescription("proveedor", "Proveedor", "entidades.Proveedor", "NO-USADO", false, null, true, "ProveedorGrid2", null));
		s.add(new FieldDescription("unidadesEnAlmacen", "Uds. Almacén", "java.lang.Integer", "NumericControl", false, null, false, null, null));
		s.add(new FieldDescription("stockMinimo", "Stock Mínimo", "java.lang.Integer", "NumericControl", false, null, false, null, "wrap"));
		s.add(new FieldDescription("observaciones", "Observaciones", "java.lang.String", "TextControl", false, null, false, null, null));
		add(s);
		
		s = new ScreenDescription("Productos","entidades.Producto", "ProductoGrid2", Screen.Type.GRID, "wrap 3", "ProductoForm1");
//		s.add(new FieldDescription("id", "Id", "java.lang.Integer", "NumericControl", false, null, false, null, null));
		s.add(new FieldDescription("borrado", "Inactivo", "java.lang.Boolean", "TextControl", false, null, false, null, "wrap"));
		s.add(new FieldDescription("nombre", "Nombre", "java.lang.String", "TextControl", false, null, false, null, null, true, 20));
		s.add(new FieldDescription("precio", "Precio(€)", "java.lang.Double", "NumericControl", false, null, false, null, null, true));
		s.add(new FieldDescription("proveedor", "Id Proveedor", "entidades.Proveedor", "NO-USADO", false, null, true, "ProveedorGrid2", null));
		s.add(new FieldDescription("proveedor.nombre", "Proveedor", "java.lang.String", "TextControl", false, null, false, null, "wrap"));
		add(s);
		
		s = new ScreenDescription("Stock de Productos","entidades.Producto", "ProductoGrid3", Screen.Type.GRID, "wrap 3", "ProductoForm1");
		s.add(new FieldDescription("borrado", "Inactivo", "java.lang.Boolean", "TextControl", false, null, false, null, "wrap"));
//		s.add(new FieldDescription("id", "Id", "java.lang.Integer", "NumericControl", false, null, false, null, null));
		s.add(new FieldDescription("nombre", "Nombre", "java.lang.String", "TextControl", false, null, false, null, null, true));
		s.add(new FieldDescription("proveedor", "Id Proveedor", "entidades.Proveedor", "NO-USADO", false, null, true, "ProveedorGrid2", null));
		s.add(new FieldDescription("proveedor.nombre", "Proveedor", "java.lang.String", "TextControl", false, null, false, null, "wrap"));
		s.add(new FieldDescription("unidadesEnAlmacen", "Uds. Almacén", "java.lang.Integer", "NumericControl", false, null, false, null, null));
		s.add(new FieldDescription("stockMinimo", "Stock Min.", "java.lang.Integer", "NumericControl", false, null, false, null, "wrap"));
		add(s);
		
	
		

		//PROVEEDORES---------------------------------------------------------------------------------------------------
		s = new ScreenDescription("Proveedor", "entidades.Proveedor","ProveedorForm1", Screen.Type.FORM, "wrap 3");
		s.add(new FieldDescription("id", "Id", "java.lang.Integer", "NumericControl", false, null, false, null, null));
		s.add(new FieldDescription("borrado", "Inactivo", "java.lang.Boolean", "TextControl", false, null, false, null, "wrap"));
		s.add(new FieldDescription("nombre", "Razón Social", "java.lang.String", "TextControl", false, null, false, null, "wrap",true));
		s.add(new FieldDescription("cif", "CIF", "java.lang.String", "TextControl", false, null, false, null, null,true));
		s.add(new FieldDescription("direccion", "Dirección", "java.lang.String", "TextControl", false, null, false, null, "span", false, 50));
		s.add(new FieldDescription("localidad", "Localidad", "java.lang.String", "TextControl", false, null, false, null,null, false, 18));
		s.add(new FieldDescription("codigoPostal", "C.Postal", "java.lang.String", "TextControl", false, null, false, null, null));
		s.add(new FieldDescription("provincia", "Provincia", "java.lang.String", "TextControl", false, null, false, null, null));
		s.add(new FieldDescription("telefono1", "Teléfono", "java.lang.Integer", "NumericControl", false, null, false, null, null,true));
		s.add(new FieldDescription("telefono2", "Teléfono2", "java.lang.Integer", "NumericControl", false, null, false, null, null));
		s.add(new FieldDescription("fax", "Fax", "java.lang.Integer", "NumericControl", false, null, false, null, null));
		s.add(new FieldDescription("correo", "e-mail", "java.lang.String", "TextControl", false, null, false, null, "wrap"));
		s.add(new FieldDescription("observaciones", "Observaciones", "java.lang.String", "TextControl", false, null, false, null, "span, grow", false, 50));
		s.add(new FieldDescription("imprimirProveedor", "Imprimir", null));
		add(s);
		
		s = new ScreenDescription("Proveedores","entidades.Proveedor", "ProveedorGrid2", Screen.Type.GRID, "wrap 3", "ProveedorForm1");
		s.add(new FieldDescription("borrado", "Inactivo", "java.lang.Boolean", "TextControl", false, null, false, null, "wrap"));
//		s.add(new FieldDescription("id", "Id", "java.lang.Integer", "NumericControl", false, null, false, null, null));
		s.add(new FieldDescription("nombre", "Razón social", "java.lang.String", "TextControl", false, null, false, null, null));
		s.add(new FieldDescription("cif", "CIF", "java.lang.String", "TextControl", false, null, false, null, null,true));
		s.add(new FieldDescription("telefono1", "Teléfono", "java.lang.Integer", "NumericControl", false, null, false, null, null,true));
		add(s);
		
	}
		
		
	public static void add(ScreenDescription s) {
		screens.put(s.getName(), s);
	}

	public static ScreenDescription get(String name) {
		return screens.get(name);
	}
	public static Screen make(ScreenDescription description){
		if(description.getType() == Screen.Type.FORM){
			return new MyForm(description);
		}else{
			return new MyGrid(description);
		}
	}
	
	
	
	
	/*****************************************************************************************************
	 * ***************************************************************************************************
	 * ********************************************************************************************************
	
	
	
	
	
	
	//Usuarios---------------------------------------------------------------------------------------------------------
			s = new ScreenDescription("Usuarios","entidades.Usuario","Formulario1 Usuario", Screen.Type.FORM, "wrap 4");
			s.add(new FieldDescription("id", "Id Usuario", "java.lang.Integer", "NumericControl", false, null, false, null, null));
			s.add(new FieldDescription("nombre", "Nombre Usuario", "java.lang.String", "TextControl", false, null, false, null, null));
			s.add(new FieldDescription("password", "Contraseña", "java.lang.String", "TextControl", false, null, false, null, null, true));
			add(s);

			s = new ScreenDescription("Usuarios","entidades.Usuario","UsuarioGrid1", Screen.Type.GRID, "wrap 4", "Formulario1 Usuario");
			s.add(new FieldDescription("id", "Id Usuario", "java.lang.Integer", "NumericControl", false, null, false, null, null));
			s.add(new FieldDescription("nombre", "Nombre Usuario", "java.lang.String", "TextControl", false, null, false, null, null, true));
			s.add(new FieldDescription("password", "Contraseña", "java.lang.String", "TextControl", false, null, false, null, null, true));
			add(s);
			

					
			//CLIENTES---------------------------------------------------------------------------------------------------
			s = new ScreenDescription("Cliente", "entidades.Cliente","Formulario1 Cliente", Screen.Type.FORM, "wrap 4");
			s.add(new FieldDescription("id", "Id Cliente", "java.lang.Integer", "NumericControl", false, null, false, null, "wrap"));
//			s.add(new FieldDescription("activo", "Activo", "java.lang.Boolean", "TextControl", false, null, false, null, "wrap"));
			s.add(new FieldDescription("nombre", "Nombre Cliente", "java.lang.String", "TextControl", false, null, false, null, null, true, 18));
			s.add(new FieldDescription("apellido1", "Apellido1", "java.lang.String", "TextControl", false, null, false, null, null, true, 18));
//			s.add(new FieldDescription("apellido1", "Apellido1", "java.lang.String", "TextControl", false, null, false, null, null, true));
			s.add(new FieldDescription("apellido2", "Apellido2", "java.lang.String", "TextControl", false, null, false, null, "wrap"));
	    	s.add(new FieldDescription("dni", "DNI", "java.lang.String", "TextControl", false, null, false, null, null));
//			s.add(new FieldDescription("direccion", "Dirección", "java.lang.String", "TextControl", false, null, false, null, "wrap", false, 30));
			s.add(new FieldDescription("poblacion", "Población", "java.lang.String", "TextControl", false, null, false, null, null, false, 20));
			s.add(new FieldDescription("cp", "CP", "java.lang.String", "TextControl", false, null, false, null, null));
			s.add(new FieldDescription("provincia", "Provincia", "java.lang.String", "TextControl", false, null, false, null, "wrap"));
			s.add(new FieldDescription("telefonoFijo", "Teléfono", "java.lang.Integer", "NumericControl", false, null, false, null, null));
			s.add(new FieldDescription("telefonoMovil", "Teléfono Móvil", "java.lang.Integer", "NumericControl", false, null, false, null, "wrap"));
			s.add(new FieldDescription("email", "E-MAIL", "java.lang.String", "TextControl", false, null, false, null, "wrap"));
			s.add(new FieldDescription("observaciones", "Observaciones", "java.lang.String", "TextControl", false, null, false, null,"span", false, 55));
			s.add(new FieldDescription("imprimirCliente", "Imprimir", null));
			add(s);
		
			s = new ScreenDescription("Clientes","entidades.Cliente", "Grid2 Cliente", Screen.Type.GRID, "wrap 3", "Formulario1 Cliente");
			s.add(new FieldDescription("activo", "Activo", "java.lang.Boolean", "TextControl", false, null, false, null, "wrap"));
//			s.add(new FieldDescription("id", "Id Cliente", "java.lang.Integer", "NumericControl", false, null, false, null, null));
			s.add(new FieldDescription("nombre", "Nombre Cliente", "java.lang.String", "TextControl", false, null, false, null, null, true, 18));
			s.add(new FieldDescription("apellido1", "Apellido1", "java.lang.String", "TextControl", false, null, false, null, null));
			s.add(new FieldDescription("apellido2", "Apellido2", "java.lang.String", "TextControl", false, null, false, null, "wrap"));
			add(s);
			
		
			
			//EMPLEADOS---------------------------------------------------------------------------------------------------
			s = new ScreenDescription("Empleado", "entidades.Empleado","Formulario1 Empleado", Screen.Type.FORM, "wrap 3");
			s.add(new FieldDescription("id", "Id Empleado", "java.lang.Integer", "NumericControl", false, null, false, null, null));
			s.add(new FieldDescription("activo", "Activo", "java.lang.Boolean", "TextControl", false, null, false, null, "wrap"));
			s.add(new FieldDescription("nombre", "Nombre Empleado", "java.lang.String", "TextControl", false, null, false, null, null, true, 18));
			s.add(new FieldDescription("apellido1", "Apellido1", "java.lang.String", "TextControl", false, null, false, null, null, true));
			s.add(new FieldDescription("apellido2", "Apellido2", "java.lang.String", "TextControl", false, null, false, null, null));
			s.add(new FieldDescription("dni", "DNI", "java.lang.String", "TextControl", false, null, false, null, null,false));
			s.add(new FieldDescription("direccion", "Dirección", "java.lang.String", "TextControl", false, null, false, null, "span", false, 50));
			s.add(new FieldDescription("poblacion", "Población", "java.lang.String", "TextControl", false, null, false, null,null, false, 18));
			s.add(new FieldDescription("cp", "C.P.", "java.lang.String", "TextControl", false, null, false, null, null));
			s.add(new FieldDescription("provincia", "Provincia", "java.lang.String", "TextControl", false, null, false, null, null));
			s.add(new FieldDescription("telefonoFijo", "Teléfono", "java.lang.Integer", "NumericControl", false, null, false, null, null));
			s.add(new FieldDescription("telefonoMovil", "Teléfono Móvil", "java.lang.Integer", "NumericControl", false, null, false, null, null));
			s.add(new FieldDescription("email", "E-MAIL", "java.lang.String", "TextControl", false, null, false, null, null));
			s.add(new FieldDescription("fecha_Inicio_Contrato", "Fecha Inicio de Contrato", "java.util.Date", "DateControl", false, null, false,null, null,false));
			s.add(new FieldDescription("fecha_Fin_Contrato", "Fecha Fin de Contrato", "java.util.Date", "DateControl", false, null, false,null, "wrap"));
			s.add(new FieldDescription("numeroCC", "Nº Cuenta", "java.lang.Integer", "NumericControl", false, null, false, null, "span", false, 30));
			s.add(new FieldDescription("numeroDeSS", "Nº Seguridad Social", "java.lang.Integer", "NumericControl", false, null, false, null, null,false));
			s.add(new FieldDescription("salario", "Salario", "java.lang.Double", "NumericControl", false, null, false, null, "wrap"));
			s.add(new FieldDescription("observaciones", "Observaciones", "java.lang.String", "TextControl", false, null, false, null, "span", false, 50));
			s.add(new FieldDescription("imprimirEmpleado", "Imprimir", null));
			add(s);
		
			
			s = new ScreenDescription("Empleados","entidades.Empleado", "Grid2 Empleado", Screen.Type.GRID, "wrap 3", "Formulario1 Empleado");
			s.add(new FieldDescription("activo", "Activo", "java.lang.Boolean", "TextControl", false, null, false, null, "wrap"));
//			s.add(new FieldDescription("id", "Id Empleado", "java.lang.Integer", "NumericControl", false, null, false, null, null));
			s.add(new FieldDescription("nombre", "Nombre Empleado", "java.lang.String", "TextControl", false, null, false, null, null));
			s.add(new FieldDescription("apellido1", "Apellido1", "java.lang.String", "TextControl", false, null, false, null, null));
			s.add(new FieldDescription("apellido2", "Apellido2", "java.lang.String", "TextControl", false, null, false, null, "wrap"));
			s.add(new FieldDescription("dni", "DNI", "java.lang.String", "TextControl", false, null, false, null, null,false));
			s.add(new FieldDescription("telefonoFijo", "Teléfono", "java.lang.Integer", "NumericControl", false, null, false, null, null));
			add(s);
			
			
			
			
			
		
			//PEDIDO---------------------------------------------------------------------------------------------------
			s = new ScreenDescription("Pedido", "entidades.Pedido","PedidoForm1", Screen.Type.FORM, "wrap 3");
			s.add(new FieldDescription("id", "Id", "java.lang.Integer", "NumericControl", false, null, false, null, "wrap"));
			s.add(new FieldDescription("proveedor", "Id Proveedor", "entidades.Proveedor", "NO-USADO", false, null, true, "ProveedorGrid2", null));
			s.add(new FieldDescription("proveedor.nombre", "Proveedor", "java.lang.String", "TextControl", false, null, false, null, "wrap"));
			s.add(new FieldDescription("fechaDeEnvio", "Fecha de Envío", "java.util.Date", "DateControl", false, null, false,null, null));
			s.add(new FieldDescription("fechaDeRecepcion", "Fecha de Recepción", "java.util.Date", "DateControl", false, null, false,null, "wrap"));
			s.add(new FieldDescription("formaDePago", "Forma de Pago", "java.lang.String", "TextControl", false, null, false, null, "span", false,40));
			s.add(new FieldDescription("empleado", "Realizado por el empleado", "entidades.Empleado", "NO-USADO", false, null, true, "EmpleadoGrid2", null));
			s.add(new FieldDescription("empleado.nombre", "Nombre", "java.lang.String", "TextControl", false, null, false, null, "wrap"));
			s.add(new FieldDescription("lineasPedido", "Líneas de Detalle", "entidades.LineaPedido", "NO-USADO", true, "LineaPedidoGrid1", false,null,  "span, grow"));		
			s.add(new FieldDescription("totalPedido", "Total(€)", "java.lang.Double", "NumericControl", false, null, false, null, "wrap"));
			s.add(new FieldDescription("imprimirPedido", "Imprimir", null));
			add(s);
			
			s = new ScreenDescription("Pedidos","entidades.Pedido", "PedidoGrid2", Screen.Type.GRID, "wrap 3", "PedidoForm1");
//			s.add(new FieldDescription("id", "Id Pedido", "java.lang.Integer", "NumericControl", false, null, false, null, null));
			s.add(new FieldDescription("proveedor", "Id Proveedor", "entidades.Proveedor", "NO-USADO", false, null, true, "ProveedorGrid2", null));
			s.add(new FieldDescription("proveedor.nombre", "Proveedor", "java.lang.String", "TextControl", false, null, false, null, "wrap"));
			s.add(new FieldDescription("fechaDeEnvio", "Fecha Envío", "java.util.Date", "DateControl", false, null, false,null, "wrap"));
			s.add(new FieldDescription("fechaDeRecepcion", "Fecha Recepción", "java.util.Date", "DateControl", false, null, false,null, "wrap"));
			s.add(new FieldDescription("empleado", "Id Empleado", "entidades.Empleado", "NO-USADO", false, null, true, "EmpleadoGrid2", null));
			s.add(new FieldDescription("empleado.nombre", "Empleado", "java.lang.String", "TextControl", false, null, false, null, "wrap"));

			add(s);
		
			//LíneaPedido---------------------------------------------------------------------------------------------------
			s = new ScreenDescription("Detalle de Pedido", "entidades.LineaPedido","LineaPedidoForm1", Screen.Type.FORM, "wrap 3");
			s.add(new FieldDescription("id", "Id", "java.lang.Integer", "NumericControl", false, null, false, null, null));
			s.add(new FieldDescription("unidades", "Unidades", "java.lang.Integer", "NumericControl", false, null, false, null, null,true));
			s.add(new FieldDescription("producto", "Id Producto", "entidades.Producto", "NO-USADO", false, null, true, "ProductoGrid2", null));
			s.add(new FieldDescription("producto.nombre", "Producto", "java.lang.String", "TextControl", false, null, false, null, null));
			s.add(new FieldDescription("producto.precio", "Precio/ud.(€)", "java.lang.Double", "NumericControl", false, null, false, null, null));	
			s.add(new FieldDescription("unidadesRecibidas", "Uds. Recibidas", "java.lang.Integer", "NumericControl", false, null, false, null, null));
			s.add(new FieldDescription("unidadesProcesadas", "Uds. Procesadas", "java.lang.Integer", "NumericControl", false, null, false, null, null));
			s.add(new FieldDescription("totalLinea", "Total(€)", "java.lang.Double", "NumericControl", false, null, false, null, null));
			add(s);

			s = new ScreenDescription("Detalle de Pedido","entidades.LineaPedido", "LineaPedidoGrid1", Screen.Type.GRID, "wrap 3", "LineaPedidoForm1");
//			s.add(new FieldDescription("id", "Id", "java.lang.Integer", "NumericControl", false, null, false, null, null));
			s.add(new FieldDescription("unidades", "Unidades", "java.lang.Integer", "NumericControl", false, null, false, null, null));
			s.add(new FieldDescription("producto", "Id Producto", "entidades.Producto", "NO-USADO", false, null, true, "ProductoGrid2", null));
			s.add(new FieldDescription("producto.nombre", "Producto", "java.lang.String", "TextControl", false, null, false, null, null));
			s.add(new FieldDescription("producto.precio", "Precio/ud.(€)", "java.lang.Double", "NumericControl", false, null, false, null, null));	
			s.add(new FieldDescription("unidadesRecibidas", "Uds. Recibidas", "java.lang.Integer", "NumericControl", false, null, false, null, null));
//			s.add(new FieldDescription("unidadesProcesadas", "Uds. Procesadas", "java.lang.Integer", "NumericControl", false, null, false, null, null));
			s.add(new FieldDescription("totalLinea", "Total(€)", "java.lang.Double", "NumericControl", false, null, false, null, null));
			add(s);	
			
					
			//PRODUCTO---------------------------------------------------------------------------------------------------
			s = new ScreenDescription("Producto", "entidades.Producto","ProductoForm1", Screen.Type.FORM, "wrap 3");
			s.add(new FieldDescription("id", "Id", "java.lang.Integer", "NumericControl", false, null, false, null, null));
			s.add(new FieldDescription("borrado", "Inactivo", "java.lang.Boolean", "TextControl", false, null, false, null, "wrap"));
			s.add(new FieldDescription("nombre", "Nombre", "java.lang.String", "TextControl", false, null, false, null, null, true, 20));
			s.add(new FieldDescription("precio", "Precio(€)", "java.lang.Double", "NumericControl", false, null, false, null, "wrap", true));
			s.add(new FieldDescription("descripcion", "Descripción", "java.lang.String", "TextControl", false, null, false, null,"span", false, 50));
			s.add(new FieldDescription("proveedor", "Id Proveedor", "entidades.Proveedor", "NO-USADO", false, null, true, "ProveedorGrid2", null));
			s.add(new FieldDescription("proveedor.nombre", "Proveedor", "java.lang.String", "TextControl", false, null, false, null, "wrap"));
			s.add(new FieldDescription("unidadesEnAlmacen", "Unidades en Almacén", "java.lang.Integer", "NumericControl", false, null, false, null, null,false));
			s.add(new FieldDescription("stockMinimo", "Stock Mínimo", "java.lang.Integer", "NumericControl", false, null, false, null, "wrap",false));
			s.add(new FieldDescription("observaciones", "Observaciones", "java.lang.String", "TextControl", false, null, false, null, "span", false, 50));
			s.add(new FieldDescription("imprimirProducto", "Imprimir", null));
			add(s);

			s = new ScreenDescription("Productos","entidades.Producto", "ProductoGrid1", Screen.Type.GRID, "wrap 3", "ProductoForm1");
			s.add(new FieldDescription("id", "Id", "java.lang.Integer", "NumericControl", false, null, false, null, null));
//			s.add(new FieldDescription("borrado", "Inactivo", "java.lang.Boolean", "TextControl", false, null, false, null, "wrap"));
			s.add(new FieldDescription("nombre", "Nombre", "java.lang.String", "TextControl", false, null, false, null, null));
			s.add(new FieldDescription("precio", "Precio (€)", "java.lang.Double", "NumericControl", false, null, false, null, null));
//			s.add(new FieldDescription("descripcion", "Descripción", "java.lang.String", "TextControl", false, null, false, null, "wrap"));
			s.add(new FieldDescription("proveedor", "Proveedor", "entidades.Proveedor", "NO-USADO", false, null, true, "ProveedorGrid2", null));
			s.add(new FieldDescription("unidadesEnAlmacen", "Uds. Almacén", "java.lang.Integer", "NumericControl", false, null, false, null, null));
			s.add(new FieldDescription("stockMinimo", "Stock Mínimo", "java.lang.Integer", "NumericControl", false, null, false, null, "wrap"));
			s.add(new FieldDescription("observaciones", "Observaciones", "java.lang.String", "TextControl", false, null, false, null, null));
			add(s);
			
			s = new ScreenDescription("Productos","entidades.Producto", "ProductoGrid2", Screen.Type.GRID, "wrap 3", "ProductoForm1");
//			s.add(new FieldDescription("id", "Id", "java.lang.Integer", "NumericControl", false, null, false, null, null));
			s.add(new FieldDescription("borrado", "Inactivo", "java.lang.Boolean", "TextControl", false, null, false, null, "wrap"));
			s.add(new FieldDescription("nombre", "Nombre", "java.lang.String", "TextControl", false, null, false, null, null, true, 20));
			s.add(new FieldDescription("precio", "Precio(€)", "java.lang.Double", "NumericControl", false, null, false, null, null, true));
			s.add(new FieldDescription("proveedor", "Id Proveedor", "entidades.Proveedor", "NO-USADO", false, null, true, "ProveedorGrid2", null));
			s.add(new FieldDescription("proveedor.nombre", "Proveedor", "java.lang.String", "TextControl", false, null, false, null, "wrap"));
			add(s);
			
			s = new ScreenDescription("Stock de Productos","entidades.Producto", "ProductoGrid3", Screen.Type.GRID, "wrap 3", "ProductoForm1");
			s.add(new FieldDescription("borrado", "Inactivo", "java.lang.Boolean", "TextControl", false, null, false, null, "wrap"));
//			s.add(new FieldDescription("id", "Id", "java.lang.Integer", "NumericControl", false, null, false, null, null));
			s.add(new FieldDescription("nombre", "Nombre", "java.lang.String", "TextControl", false, null, false, null, null, true));
			s.add(new FieldDescription("proveedor", "Id Proveedor", "entidades.Proveedor", "NO-USADO", false, null, true, "ProveedorGrid2", null));
			s.add(new FieldDescription("proveedor.nombre", "Proveedor", "java.lang.String", "TextControl", false, null, false, null, "wrap"));
			s.add(new FieldDescription("unidadesEnAlmacen", "Uds. Almacén", "java.lang.Integer", "NumericControl", false, null, false, null, null));
			s.add(new FieldDescription("stockMinimo", "Stock Min.", "java.lang.Integer", "NumericControl", false, null, false, null, "wrap"));
			add(s);
			
		
			

			//PROVEEDORES---------------------------------------------------------------------------------------------------
			s = new ScreenDescription("Proveedor", "entidades.Proveedor","ProveedorForm1", Screen.Type.FORM, "wrap 3");
			s.add(new FieldDescription("id", "Id", "java.lang.Integer", "NumericControl", false, null, false, null, null));
			s.add(new FieldDescription("borrado", "Inactivo", "java.lang.Boolean", "TextControl", false, null, false, null, "wrap"));
			s.add(new FieldDescription("nombre", "Razón Social", "java.lang.String", "TextControl", false, null, false, null, "wrap",true));
			s.add(new FieldDescription("cif", "CIF", "java.lang.String", "TextControl", false, null, false, null, null,true));
			s.add(new FieldDescription("direccion", "Dirección", "java.lang.String", "TextControl", false, null, false, null, "span", false, 50));
			s.add(new FieldDescription("localidad", "Localidad", "java.lang.String", "TextControl", false, null, false, null,null, false, 18));
			s.add(new FieldDescription("codigoPostal", "C.Postal", "java.lang.String", "TextControl", false, null, false, null, null));
			s.add(new FieldDescription("provincia", "Provincia", "java.lang.String", "TextControl", false, null, false, null, null));
			s.add(new FieldDescription("telefono1", "Teléfono", "java.lang.Integer", "NumericControl", false, null, false, null, null,true));
			s.add(new FieldDescription("telefono2", "Teléfono2", "java.lang.Integer", "NumericControl", false, null, false, null, null));
			s.add(new FieldDescription("fax", "Fax", "java.lang.Integer", "NumericControl", false, null, false, null, null));
			s.add(new FieldDescription("correo", "e-mail", "java.lang.String", "TextControl", false, null, false, null, "wrap"));
			s.add(new FieldDescription("observaciones", "Observaciones", "java.lang.String", "TextControl", false, null, false, null, "span, grow", false, 50));
			s.add(new FieldDescription("imprimirProveedor", "Imprimir", null));
			add(s);
			
			s = new ScreenDescription("Proveedores","entidades.Proveedor", "ProveedorGrid2", Screen.Type.GRID, "wrap 3", "ProveedorForm1");
			s.add(new FieldDescription("borrado", "Inactivo", "java.lang.Boolean", "TextControl", false, null, false, null, "wrap"));
//			s.add(new FieldDescription("id", "Id", "java.lang.Integer", "NumericControl", false, null, false, null, null));
			s.add(new FieldDescription("nombre", "Razón social", "java.lang.String", "TextControl", false, null, false, null, null));
			s.add(new FieldDescription("cif", "CIF", "java.lang.String", "TextControl", false, null, false, null, null,true));
			s.add(new FieldDescription("telefono1", "Teléfono", "java.lang.Integer", "NumericControl", false, null, false, null, null,true));
			add(s);
			
		}
			
			
		public static void add(ScreenDescription s) {
			screens.put(s.getName(), s);
		}

		public static ScreenDescription get(String name) {
			return screens.get(name);
		}
		public static Screen make(ScreenDescription description){
			if(description.getType() == Screen.Type.FORM){
				return new MyForm(description);
			}else{
				return new MyGrid(description);
			}
	}
	
	
	*/
}
