package inicio;

import i18n.MySpanishOnlyResourceFactory;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;


import org.openswing.swing.mdi.client.ClientFacade;
import org.openswing.swing.mdi.client.GenericStatusPanel;
import org.openswing.swing.mdi.client.MDIController;
import org.openswing.swing.mdi.client.MDIFrame;
import org.openswing.swing.mdi.java.ApplicationFunction;
import org.openswing.swing.permissions.client.LoginController;
import org.openswing.swing.permissions.client.LoginDialog;
import org.openswing.swing.permissions.java.ButtonsAuthorizations;
import org.openswing.swing.tree.java.OpenSwingTreeNode;
import org.openswing.swing.util.client.ClientSettings;

import entidades.Usuario;

import persistencia.Persistencia;
import reports.ReportSystem;
import views.ScreenFactory;

public class Start implements MDIController, LoginController {

	String username;
	//private ClientFacade clientFacade = null;
	private Hashtable domains = new Hashtable();
	static String actualUserName;

	public Start() {
		Persistencia.start();
		ScreenFactory.setup();
		ReportSystem.start();
		new LoginDialog(null, false, this);
	}

	/**
	 * Method called after MDI creation.
	 */
	public void afterMDIcreation(MDIFrame frame) {
		//MDIFrame.addStatusComponent(new Clock());
	}

	/**
	 * @see JFrame getExtendedState method
	 */
	public int getExtendedState() {
		return JFrame.MAXIMIZED_BOTH;
	}

	/**
	 * @return client facade, invoked by the MDI Frame tree/menu
	 */
	public ClientFacade getClientFacade() {
		 if(actualUserName.equals("admin")){
			 return new AdminClientFacade();
		 }else{
			 return new UserClientFacade();
		 }
	}

	/**
	 * Method used to destroy application.
	 */
	public void stopApplication() {
		Persistencia.stop();
		ReportSystem.stop();
		System.exit(0);
	}

	/**
	 * Defines if application functions must be viewed inside a tree panel of
	 * MDI Frame.
	 * 
	 * @return <code>true</code> if application functions must be viewed inside
	 *         a tree panel of MDI Frame, <code>false</code> no tree is viewed
	 */
	public boolean viewFunctionsInTreePanel() {
		return true;
	}

	/**
	 * Defines if application functions must be viewed in the menubar of MDI
	 * Frame.
	 * 
	 * @return <code>true</code> if application functions must be viewed in the
	 *         menubar of MDI Frame, <code>false</code> otherwise
	 */
	public boolean viewFunctionsInMenuBar() {
		return true;
	}

	/**
	 * @return <code>true</code> if the MDI frame must show a login menu in the
	 *         menubar, <code>false</code> no login menu item will be added
	 */
	public boolean viewLoginInMenuBar() {
		return true;
	}

	/**
	 * @return application title
	 */
	public String getMDIFrameTitle() {
		return "SGP";
	}

	/**
	 * @return text to view in the about dialog window
	 */
	public String getAboutText() {
		return "SGP v 1.0" + "\n" + "Copyright: Copyright (C) 2012\n\n" + "Autora: Ana María Fernández Castro";
	}

	/**
	 * @return image name to view in the about dialog window
	 */
	public String getAboutImage() {
		return null;
	}

	/**
	 * @param parentFrame
	 *            parent frame
	 * @return a dialog window to logon the application; the method can return
	 *         null if viewLoginInMenuBar returns false
	 */
	public JDialog viewLoginDialog(JFrame parentFrame) {
		JDialog d = new LoginDialog(parentFrame, true, this);
		return d;
	}

	/**
	 * @return maximum number of failed login
	 */
	public int getMaxAttempts() {
		return 3;
	}

	/**
	 * Method called by MDI Frame to authenticate the user.
	 * 
	 * @param loginInfo
	 *            login information, like username, password, ...
	 * @return <code>true</code> if user is correcly authenticated,
	 *         <code>false</code> otherwise
	 */
	public boolean authenticateUser(Map loginInfo) throws Exception {
		String intentUserName = (String) loginInfo.get("username");
		String intentPassword = (String) loginInfo.get("password");
		List l = Persistencia.load("SELECT c from Usuario c where c.nombre = '" + intentUserName + "'");
		Usuario usuario = null;
		if (l != null & !l.isEmpty()) {
			usuario = (Usuario) l.get(0);
		}
		// la primera vez no hay admin. Le dejamos entrar para que lo cree.
		if (usuario == null && intentUserName.equals("a")) {
			actualUserName = "admin";		
			return true;
		}
		if (usuario != null) {
			if (usuario.getPassword().equals(intentPassword)) {
				actualUserName = usuario.getNombre();
				return true;
			}
		}

		
		
		return false;
	}

	public static void main(String[] argv) {
		new Start();
	}

	/**
	 * Method called by LoginDialog to notify the sucessful login.
	 * 
	 * @param loginInfo
	 *            login information, like username, password, ...
	 */
	public void loginSuccessful(Map loginInfo) {
		Properties props = new Properties();

		ButtonsAuthorizations b = new ButtonsAuthorizations();
		if (actualUserName.equals("admin")) {

		} else {
// addButtonAuthorization ("Screen", botón de agregar registro , botón de editar, botón de borrar)
			b.addButtonAuthorization("ServicioForm1", false, false, false);
			b.addButtonAuthorization("ServicoGrid1", false, false, false);
			b.addButtonAuthorization("ServicoGrid2", false, false, false);
			
			b.addButtonAuthorization("OfertaForm1", false, false, false);
			b.addButtonAuthorization("OfertaGrid1", false, false, false);
	


		}
		new ClientSettings(new MySpanishOnlyResourceFactory("€", props, true), domains, b);
		/*ClientSettings.BACKGROUND = "asus.jpg";
		ClientSettings.TREE_BACK = "treeback2.jpg";
		*/
		ClientSettings.VIEW_BACKGROUND_SEL_COLOR = true;
		ClientSettings.VIEW_MANDATORY_SYMBOL = true;
		ClientSettings.ALLOW_OR_OPERATOR = false;
		ClientSettings.INCLUDE_IN_OPERATOR = false;
		ClientSettings.SHOW_SCROLLBARS_IN_MDI = true;

		new MDIFrame(this);

		GenericStatusPanel userPanel = new GenericStatusPanel();
		userPanel.setName("statusPanel");
		userPanel.setColumns(52);
		MDIFrame.addStatusComponent(userPanel);
		userPanel.setText("Usuario:"+ actualUserName);

		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @return <code>true</code> if the MDI frame must show a change language
	 *         menu in the menubar, <code>false</code> no change language menu
	 *         item will be added
	 */
	public boolean viewChangeLanguageInMenuBar() {
		return false;
	}

	/**
	 * @return list of languages supported by the application
	 */
	public ArrayList getLanguages() {
		return null;
	}

	/**
	 * @return application functions (ApplicationFunction objects), organized as
	 *         a tree
	 */
	public DefaultTreeModel getApplicationFunctions() {
		DefaultMutableTreeNode root = new OpenSwingTreeNode();
		DefaultTreeModel model = new DefaultTreeModel(root);
		ApplicationFunction n1 = new ApplicationFunction("Usuarios", null);

		if (getActualUserName().equals("admin")) {
			ApplicationFunction n15 = new ApplicationFunction("Usuarios", "U", null, "getUsuarios");
			n1.add(n15);
			
			ApplicationFunction n6 = new ApplicationFunction("Clientes", null);
			n1.add(n6);
			ApplicationFunction n61 = new ApplicationFunction("Clientes", "l", null, "getClientes");
			n6.add(n61);
			ApplicationFunction n63 = new ApplicationFunction("Detalle de Tintes", "T", null, "getLineasTintes");
			n6.add(n63);
			ApplicationFunction n62 = new ApplicationFunction("Listado de Clientes", "L", null, "getListadoClientes");
			n6.add(n62);
			
			ApplicationFunction n7 = new ApplicationFunction("Empleados", null);
			n1.add(n7);
			ApplicationFunction n71 = new ApplicationFunction("Empleados", "E", null, "getEmpleados");
			n7.add(n71);
			ApplicationFunction n72 = new ApplicationFunction("Listado de Empleados", "i", null, "getListadoEmpleados");
			n7.add(n72);
			
			ApplicationFunction n8 = new ApplicationFunction("Proveedores", null);
			n1.add(n8);
			ApplicationFunction n81 = new ApplicationFunction("Proveedores", "v", null, "getProveedores");
			n8.add(n81);
			ApplicationFunction n82 = new ApplicationFunction("Listado de Proveedores", "a", null, "getListadoProveedores");
			n8.add(n82);
			

			
			ApplicationFunction n2 = new ApplicationFunction("Productos", null);
			n1.add(n2);
			ApplicationFunction n21 = new ApplicationFunction("Productos", "c", null, "getProductos");
			n2.add(n21);
			ApplicationFunction n22 = new ApplicationFunction("Listado de Productos", "d", null, "getListadoProductos");
			n2.add(n22);
			
			ApplicationFunction n9 = new ApplicationFunction("Servicios", null);
			n1.add(n9);
			ApplicationFunction n91 = new ApplicationFunction("Servicios", "s", null, "getServicios");
			n9.add(n91);
			ApplicationFunction n92 = new ApplicationFunction("Listado de Servicios", "r", null, "getListadoServicios");
			n9.add(n92);
			
			ApplicationFunction n16 = new ApplicationFunction("Ofertas", null);
			n1.add(n16);
			ApplicationFunction n161 = new ApplicationFunction("Ofertas", "O", null, "getOfertas");
			n16.add(n161);
			ApplicationFunction n162 = new ApplicationFunction("Listado de Ofertas", "e", null, "getListadoOfertas");
			n16.add(n162);
			
			ApplicationFunction n3 = new ApplicationFunction("Almacén", null);
			ApplicationFunction n31 = new ApplicationFunction("stock de Almacén", "k", null, "getProductosAlmacen");
			n3.add(n31);
			ApplicationFunction n11 = new ApplicationFunction("Consumo", null);
			n3.add(n11);
			ApplicationFunction n111 = new ApplicationFunction("Consumo Interno", "n", null, "getConsumos");
			n11.add(n111);
			ApplicationFunction n112 = new ApplicationFunction("Listado de Consumo", "m", null, "getListadoConsumos");
			n11.add(n112);
			
			ApplicationFunction n12 = new ApplicationFunction("Pedidos", null);
			n1.add(n12);
			ApplicationFunction n121 = new ApplicationFunction("pedidos", "p", null, "getPedidos");
			n12.add(n121);
			ApplicationFunction n122 = new ApplicationFunction("Listado de Pedidos", "i", null, "getListadoPedidos");
			n12.add(n122);
			
			
			ApplicationFunction n4 = new ApplicationFunction("Citas", null);
			ApplicationFunction n41 = new ApplicationFunction("Citas", "C", null, "getCitas");
			n4.add(n41);
//			ApplicationFunction n42 = new ApplicationFunction("Historial de Citas", "H", null, "getListadoCitas");
//			n4.add(n42);
			
			ApplicationFunction n13 = new ApplicationFunction("Gastos", null);
			ApplicationFunction n131 = new ApplicationFunction("gastos", "G", null, "getGastos");
			n13.add(n131);
			ApplicationFunction n132 = new ApplicationFunction("listado de gastos", "l", null, "getListadoGastos");
			n13.add(n132);
			
			ApplicationFunction n14 = new ApplicationFunction("Diario", null);
			ApplicationFunction n141 = new ApplicationFunction("Diario de Trabajo", "D", null, "getDiarioTrabajos");
			n14.add(n141);
			ApplicationFunction n142 = new ApplicationFunction("Listado Diarios de Trabajo", "j", null, "getListadoDiariosTrabajos");
			n14.add(n142);
			
			
			root.add(n3);//Almacén
			root.add(n4);//Citas
			root.add(n6);//Clientes
			root.add(n11);//Consumo Interno
			root.add(n14);//Diario de Trabajo
			root.add(n7);//Empleados
			root.add(n13);//Gastos
			root.add(n16);//Ofertas
			root.add(n12);//Pedidos
			root.add(n2);//Productos
			root.add(n8);//Proveedores
			root.add(n9);//Servicios
			root.add(n1);//Fichero	
		}else{
			ApplicationFunction n15 = new ApplicationFunction("Usuarios", "U", null, "getUsuarios");
			n1.add(n15);
			ApplicationFunction n6 = new ApplicationFunction("Clientes", null);
			n1.add(n6);
			ApplicationFunction n61 = new ApplicationFunction("Clientes", "l", null, "getClientes");
			n6.add(n61);
			ApplicationFunction n63 = new ApplicationFunction("Detalle de Tintes", "T", null, "getLineasTintes");
			n6.add(n63);
			ApplicationFunction n62 = new ApplicationFunction("Listado de Clientes", "L", null, "getListadoClientes");
			n6.add(n62);
				
			ApplicationFunction n8 = new ApplicationFunction("Proveedores", null);
			n1.add(n8);
			ApplicationFunction n81 = new ApplicationFunction("Proveedores", "v", null, "getProveedores");
			n8.add(n81);
			ApplicationFunction n82 = new ApplicationFunction("Listado de Proveedores", "a", null, "getListadoProveedores");
			n8.add(n82);
		

		
			ApplicationFunction n2 = new ApplicationFunction("Productos", null);
			n1.add(n2);
			ApplicationFunction n21 = new ApplicationFunction("Productos", "c", null, "getProductos");
			n2.add(n21);
			ApplicationFunction n22 = new ApplicationFunction("Listado de Productos", "d", null, "getListadoProductos");
			n2.add(n22);
			
			ApplicationFunction n9 = new ApplicationFunction("Servicios", null);
			n1.add(n9);
			ApplicationFunction n91 = new ApplicationFunction("Servicios", "s", null, "getServicios");
			n9.add(n91);
			ApplicationFunction n92 = new ApplicationFunction("Listado de Servicios", "r", null, "getListadoServicios");
			n9.add(n92);
			
			ApplicationFunction n16 = new ApplicationFunction("Ofertas", null);
			n1.add(n16);
			ApplicationFunction n161 = new ApplicationFunction("Ofertas", "O", null, "getOfertas");
			n16.add(n161);
			ApplicationFunction n162 = new ApplicationFunction("Listado de Ofertas", "e", null, "getListadoOfertas");
			n16.add(n162);
			
			ApplicationFunction n3 = new ApplicationFunction("Almacén", null);
			ApplicationFunction n31 = new ApplicationFunction("stock de Almacén", "k", null, "getProductosAlmacen");
			n3.add(n31);
			ApplicationFunction n11 = new ApplicationFunction("Consumo", null);
			n3.add(n11);
			ApplicationFunction n111 = new ApplicationFunction("Consumo Interno", "n", null, "getConsumos");
			n11.add(n111);
			ApplicationFunction n112 = new ApplicationFunction("Listado de Consumo", "m", null, "getListadoConsumos");
			n11.add(n112);
			
			ApplicationFunction n12 = new ApplicationFunction("Pedidos", null);
			n1.add(n12);
			ApplicationFunction n121 = new ApplicationFunction("pedidos", "p", null, "getPedidos");
			n12.add(n121);
			ApplicationFunction n122 = new ApplicationFunction("Listado de Pedidos", "i", null, "getListadoPedidos");
			n12.add(n122);
			
			
			ApplicationFunction n4 = new ApplicationFunction("Citas", null);
			ApplicationFunction n41 = new ApplicationFunction("Citas", "C", null, "getCitas");
			n4.add(n41);
//		ApplicationFunction n42 = new ApplicationFunction("Historial de Citas", "H", null, "getListadoCitas");
//		n4.add(n42);
		
		
			ApplicationFunction n14 = new ApplicationFunction("Diario", null);
			ApplicationFunction n141 = new ApplicationFunction("Diario de Trabajo", "D", null, "getDiarioTrabajos");
			n14.add(n141);
			ApplicationFunction n142 = new ApplicationFunction("Listado Diarios de Trabajo", "j", null, "getListadoDiariosTrabajos");
			n14.add(n142);
		

		
			root.add(n3);//Almacén
			root.add(n4);//Citas
			root.add(n6);//Clientes
			root.add(n11);//Consumo Interno
			root.add(n14);//Diario de Trabajo
	//		root.add(n7);//Empleados
	//		root.add(n13);//Gastos
			root.add(n16);//Ofertas
			root.add(n12);//Pedidos
			root.add(n2);//Productos
			root.add(n8);//Proveedores
			root.add(n9);//Servicios
			root.add(n1);//Fichero
		}
		return model;
	}

	/**
	 * @return <code>true</code> if the MDI frame must show a panel in the
	 *         bottom, containing last opened window icons, <code>false</code>
	 *         no panel is showed
	 */
	public boolean viewOpenedWindowIcons() {
		return true;
	}

	/**
	 * @return <code>true</code> if the MDI frame must show the "File" menu in
	 *         the menubar of the frame, <code>false</code> to hide it
	 */
	public boolean viewFileMenu() {
		return true;
	}

	public static String getActualUserName() {
		return actualUserName;
	}

}
