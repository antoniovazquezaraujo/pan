package actions;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import reports.Report;
import reports.ReportSystem;
import views.Screen;
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

public class Actions {
	public static void doAction(String actionName, Screen screen) {
		try {
			Method m = Actions.class.getMethod(actionName, Screen.class);
			m.invoke(null, screen);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	
	
	public static void imprimirRutaReparto(Screen screen) {
		Report report = new Report("rutaReparto");
		Map parameterValues = new HashMap();
		RutaReparto p = (RutaReparto) screen.getModel();
		parameterValues.put("id", p.getId());
		if (report.run(parameterValues)) {
			ReportSystem.view("rutaReparto");
		}
	}
	
	
	public static void imprimirCliente(Screen screen) {
		Report report = new Report("cliente");
		Map parameterValues = new HashMap();
		Cliente c = (Cliente) screen.getModel();
		parameterValues.put("id", c.getId());
		if (report.run(parameterValues)) {
			ReportSystem.view("cliente");
		}
	}
	
	
	public static void imprimirEmpleado(Screen screen) {
		Report report = new Report("empleado");
		Map parameterValues = new HashMap();
		Empleado e = (Empleado) screen.getModel();
		parameterValues.put("id", e.getId());
		if (report.run(parameterValues)) {
			ReportSystem.view("empleado");
		}
	}
	
	
	public static void imprimirArticulOfertado(Screen screen) {
		Report report = new Report("articuloOfertado");
		Map parameterValues = new HashMap();
		ArticuloOfertado p = (ArticuloOfertado) screen.getModel();
		parameterValues.put("id", p.getId());
		if (report.run(parameterValues)) {
			ReportSystem.view("articuloOfertado");
		}
	}
	
	
	
	public static void imprimirProducto(Screen screen) {
		Report report = new Report("producto");
		Map parameterValues = new HashMap();
		Producto p = (Producto) screen.getModel();
		parameterValues.put("id", p.getId());
		if (report.run(parameterValues)) {
			ReportSystem.view("producto");
		}
	}
	
	
	
	public static void imprimirAlbaran(Screen screen) {
		Report report = new Report("albaran");
		Map parameterValues = new HashMap();
		Albaran p = (Albaran) screen.getModel();
		parameterValues.put("id", p.getId());
		if (report.run(parameterValues)) {
			ReportSystem.view("albaran");
		}
	}	
	
	
	public static void imprimirFactura(Screen screen) {
		Report report = new Report("factura");
		Map parameterValues = new HashMap();
		Factura p = (Factura) screen.getModel();
		parameterValues.put("id", p.getId());
		if (report.run(parameterValues)) {
			ReportSystem.view("factura");
		}
	}
	
	public static void imprimirPedido(Screen screen) {
		Report report = new Report("pedido");
		Map parameterValues = new HashMap();
		Pedido p = (Pedido) screen.getModel();
		parameterValues.put("id", p.getId());
		if (report.run(parameterValues)) {
			ReportSystem.view("pedido");
		}
	}
	
	
	public static void imprimirProveedor(Screen screen) {
		Report report = new Report("proveedor");
		Map parameterValues = new HashMap();
		Proveedor p = (Proveedor) screen.getModel();
		parameterValues.put("id", p.getId());
		if (report.run(parameterValues)) {
			ReportSystem.view("proveedor");
		}
	}
	
	
	public static void imprimirEncargo(Screen screen) {
		Report report = new Report("encargo");
		Map parameterValues = new HashMap();
		Encargo p = (Encargo) screen.getModel();
		parameterValues.put("id", p.getId());
		if (report.run(parameterValues)) {
			ReportSystem.view("encargo");
		}
	}
	
	
}