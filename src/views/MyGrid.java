package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;

import org.openswing.swing.client.DeleteButton;
import org.openswing.swing.client.EditButton;
import org.openswing.swing.client.GridControl;
import org.openswing.swing.client.InsertButton;
import org.openswing.swing.client.NavigatorBar;
import org.openswing.swing.client.ReloadButton;
import org.openswing.swing.client.SaveButton;
import org.openswing.swing.internationalization.java.Resources;
import org.openswing.swing.lookup.client.LookupController;
import org.openswing.swing.lookup.client.LookupDataLocator;
import org.openswing.swing.message.receive.java.ErrorResponse;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.receive.java.VOListResponse;
import org.openswing.swing.message.receive.java.VOResponse;
import org.openswing.swing.table.columns.client.CheckBoxColumn;
import org.openswing.swing.table.columns.client.CodLookupColumn;
import org.openswing.swing.table.columns.client.Column;
import org.openswing.swing.table.columns.client.DateColumn;
import org.openswing.swing.table.columns.client.DateTimeColumn;
import org.openswing.swing.table.columns.client.DecimalColumn;
import org.openswing.swing.table.columns.client.IntegerColumn;
import org.openswing.swing.table.columns.client.TextColumn;
import org.openswing.swing.tree.java.OpenSwingTreeNode;
import org.openswing.swing.util.java.Consts;

import persistencia.Persistencia;
import controllers.MyGridController;



public class MyGrid implements Screen {
	ScreenDescription description;
	JPanel controlPanel = new JPanel();
	InsertButton insertButton1 = new InsertButton();
	DeleteButton deleteButton1 = new DeleteButton();
	EditButton editButton1 = new EditButton();
	SaveButton saveButton1 = new SaveButton();
	ReloadButton reloadButton1= new ReloadButton();
	NavigatorBar navigatorBar1 = new NavigatorBar();

	protected Class clase;
	protected JPanel panel;

	List datos;
	GridControl grid;

	protected MyGridController controller;

	public MyGrid(ScreenDescription description) {
		this.description = description;
		try {
			String s = description.getModelClassName();
			this.clase = Class.forName(s);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

		grid = new GridControl();
		grid.setFunctionId(description.getName());
		grid.setAutoLoadData(true);
		grid.setValueObjectClassName(clase.getName());
		setupController();
		grid.setInsertButton(insertButton1);
		grid.setDeleteButton(deleteButton1);
		grid.setEditButton(editButton1);
		grid.setSaveButton(saveButton1);
		grid.setReloadButton(reloadButton1);
		grid.setNavBar(navigatorBar1);
		grid.setMode(Consts.READONLY);

		controlPanel.setLayout(new FlowLayout());
		controlPanel.add(insertButton1);
		controlPanel.add(deleteButton1);
		controlPanel.add(editButton1);
		controlPanel.add(saveButton1);
		controlPanel.add(reloadButton1);
		controlPanel.add(navigatorBar1);
		setupComponents();

	}

	public String getTitle() {
		return description.getTitle();
	}

	public void setupController() {
		controller = new MyGridController(description.getPopUpName());
		grid.setController(controller);
		grid.setGridDataLocator(controller);
	}

	public void setModel(Object parent, Object datos) {
		this.datos = (List) datos;
		controller.setParent(parent);
		controller.setModel(this.datos);
		grid.reloadData();
		grid.setMinimumSize(new Dimension(200, 100));
		grid.setPreferredSize(new Dimension(400, 200));
		grid.setMaximumSize(new Dimension(600, 300));
		panel.revalidate();
		panel.repaint();

	}

	public JPanel getPanel() {
		return panel;
	}

	public void setupComponents() {
		for (FieldDescription f : description.getFields()) {
			//Class<?> fieldType;
			//try {
				//fieldType = Class.forName(f.getClassName());
//				Column c = makeColumn(fieldType);
				Column c = makeColumn(f);
				if (c != null) {
					c.setColumnName(f.getName());
					c.setHeaderColumnName(f.getTitle());
					c.setColumnSortable(true);
					c.setColumnFilterable(true);
					c.setEditableOnEdit(true);
					c.setEditableOnInsert(true);
					c.setColumnRequired(false);
					if (f.getName().equals("id")) {
						c.setEditableOnEdit(false);
						c.setEditableOnInsert(false);
					}else if (f.getTitle().equals("Proveedor")) {
						c.setEditableOnEdit(false);
						c.setEditableOnInsert(false);
					}else if (f.getTitle().equals("Cliente")) {
						c.setEditableOnEdit(false);
						c.setEditableOnInsert(false);
					}else if (f.getTitle().equals("Producto")) {
						c.setEditableOnEdit(false);
						c.setEditableOnInsert(false);
					}else if (f.getTitle().equals("Precio/ud.(€)")) {
						c.setEditableOnEdit(false);
						c.setEditableOnInsert(false);
					}else if (f.getTitle().equals("Total(€)")) {
						c.setEditableOnEdit(false);
						c.setEditableOnInsert(false);
					}else if (f.getTitle().equals("Servicio")) {
						c.setEditableOnEdit(false);
						c.setEditableOnInsert(false);
					}else if (f.getTitle().equals("Total del Día")) {
						c.setEditableOnEdit(false);
						c.setEditableOnInsert(false);
					}else if (f.getTitle().equals("Hora")) {
						c.setEditableOnEdit(false);
						c.setEditableOnInsert(false);
					}else if (f.getTitle().equals("Total Cita(€)")) {
						c.setEditableOnEdit(false);
						c.setEditableOnInsert(false);
					}else if (f.getTitle().equals("Apell.1")) {
						c.setEditableOnEdit(false);
						c.setEditableOnInsert(false);
					}else if (f.getTitle().equals("Apell.2")) {
						c.setEditableOnEdit(false);
						c.setEditableOnInsert(false);
					}

					grid.getColumnContainer().add(c);
				} else {
					if (f.isOneToOne()) {
						CodLookupColumn cc = new CodLookupColumn();
						cc.setColumnName(f.getName() + ".id");
						cc.setHeaderColumnName(f.getTitle());
						cc.setEditableOnEdit(true);
						cc.setEditableOnInsert(true);
						cc.setLookupController(new MyGridLookupController(f));
						String sss = f.getOneToOneScreenName();
						cc.setControllerClassName(sss);
						grid.getColumnContainer().add(cc);
					}
				}
			//} catch (ClassNotFoundException e) {
			//	e.printStackTrace();
			//}
		}
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(controlPanel, BorderLayout.NORTH);
		panel.add(new JScrollPane(grid), BorderLayout.CENTER);
		panel.setMinimumSize(new Dimension(400, 200));
		panel.revalidate();
	}
//	private Column makeColumn(FieldDescription fd) {
//		Class componentClass = null;
//		try {
//			String name = fd.getComponentClassName();
//			componentClass = Class.forName(name);
//		} catch (ClassNotFoundException e1) {
//			e1.printStackTrace();
//		}
//		Column ret = null;
//		try {
//			ret = (Column) componentClass.newInstance();
//		} catch (InstantiationException e) {
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		}
//		return ret;
//	}
	
	private Column makeColumn(FieldDescription fd) {
		//Caso especial, porque no existe un componente TimeControl
		//Usamos un DateControl con el tipo puesto a TYPE_TIME.
		if(fd.getComponentClassName().equals("TimeControl")){
			DateTimeColumn ret = new DateTimeColumn();
			ret.setTimeFormat(Resources.HH_MM);
			return ret;
		}
		Class clazz = null;
		try {
			clazz = Class.forName(fd.getClassName());
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		Column control = null;
		if (Boolean.class.isAssignableFrom(clazz)) {
			//caso especial. No hereda de BaseInputControl!!
			return new CheckBoxColumn();
		}else if (String.class.isAssignableFrom(clazz)) {
			control = new TextColumn();
		}else if (Integer.class.isAssignableFrom(clazz)) {
			control = new IntegerColumn();
		}else if (Double.class.isAssignableFrom(clazz)) {//Lo de double lo puse yo antes no recuerdo que habia, number, creo
			control = new DecimalColumn();  
			DecimalColumn x = (DecimalColumn) control;
            x.setDecimals(2);
		}else if (Date.class.isAssignableFrom(clazz)) {
			control = new DateColumn();
		}
		return control;
	}
	
	

	@Override
	public void setMode(int mode) {
		grid.setMode(mode);

	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return datos;
	}
}

class MyGridLookupController extends LookupController {
	FieldDescription desc;

	MyGridLookupController(FieldDescription f) {
		this.desc = f;
		this.setLookupValueObjectClassName(desc.getClassName());
		this.addLookup2ParentLink("id", f.getName()+".id");
		String screenName = f.getOneToOneScreenName();

		// Filtramos para que solo se vean las columnas
		// que aparecen en el grid de búsqueda.
		this.setAllColumnVisible(false);
		ScreenDescription desc = ScreenFactory.get(screenName);
		for(FieldDescription field: desc.fields){
			this.setVisibleColumn(field.name, true);
		}
		
		this.setAnchorLastColumn(true);
		this.setLookupDataLocator(new LookupDataLocator() {

			@SuppressWarnings("unchecked")
			@Override
			public Response loadData(int arg0, int arg1, Map arg2, ArrayList arg3, ArrayList arg4, Class arg5) {
				List l = null;
				try {
					String s = MyGridLookupController.this.desc.getClassName();
					Class c = Class.forName(s);
					l = Persistencia.load(c);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return new VOListResponse(l, false, l.size());
			}

			@Override
			public Response validateCode(String arg0) {
				Object o = null;
				try {
					o = Persistencia.load(Class.forName(MyGridLookupController.this.desc.getClassName()), Integer.parseInt(arg0));
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (o != null) {
					return new VOResponse(o);
				} else {
					return new ErrorResponse("Dato no encontrado");
				}
			}

			@Override
			public Response getTreeModel(JTree arg0) {
				return new VOResponse(new DefaultTreeModel(new OpenSwingTreeNode()));
			}

		});
	}
}