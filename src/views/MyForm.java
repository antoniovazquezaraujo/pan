package views;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import net.miginfocom.swing.MigLayout;

import org.jdesktop.beansbinding.ELProperty;
import org.openswing.swing.client.BaseInputControl;
import org.openswing.swing.client.CheckBoxControl;
import org.openswing.swing.client.DateControl;
import org.openswing.swing.client.DeleteButton;
import org.openswing.swing.client.EditButton;
import org.openswing.swing.client.InputControl;
import org.openswing.swing.client.InsertButton;
import org.openswing.swing.client.NumericControl;
import org.openswing.swing.client.ReloadButton;
import org.openswing.swing.client.SaveButton;
import org.openswing.swing.client.TextControl;
import org.openswing.swing.form.client.Form;
import org.openswing.swing.util.java.Consts;

import controllers.MyFormController;

public class MyForm implements Screen {
	ScreenDescription description;

	protected Class clase;
	protected JPanel panel;
	protected Map<Screen, String> grids;
	protected Map<String, InputControl> labels;

	Object dato;

	public Object getDato() {
		return dato;
	}

	public void setDato(Object dato) {
		this.dato = dato;
	}

	protected Form form;
	protected MyFormController controller;

	public MyForm(ScreenDescription description) {
		this.description = description;
		try {
			String s = description.getModelClassName();
			this.clase = Class.forName(s);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

		grids = new HashMap<Screen, String>();
		labels = new HashMap<String, InputControl>();
		form = new Form();
		form.setFunctionId(description.getName());
		form.setVOClassName(clase.getName());
		setupController();
		setupComponents();
	}

	public void setupController() {
		controller = new MyFormController();
		form.setFormController(controller);
	}

	public void setModel(Object parent, Object dato) {
		form.setMode(Consts.READONLY);
		this.dato = dato;
		controller.setModel(dato);
		reloadLabels();
		reloadGrids();
		form.reload();
		form.revalidate();
		form.repaint();
	}

	public void reloadLabels() {
		if (dato != null) {
			for (String g : labels.keySet()) {
				InputControl l = labels.get(g);
				ELProperty prop = ELProperty.create("${" + g + "}");
				Object s = prop.getValue(dato);
				l.setValue(s);
			}
		}
	}

	void reloadGrids() {
		if (dato != null) {
			for (Screen g : grids.keySet()) {
				String s = grids.get(g);
				ELProperty prop = ELProperty.create("${" + s + "}");
				Object value = prop.getValue(dato);
				g.setModel(dato, value);
			}
		}
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setupComponents() {
		JPanel controlPanel = new JPanel();
		InsertButton insertButton1 = new InsertButton();
		ReloadButton reloadButton1 = new ReloadButton();
		DeleteButton deleteButton1 = new DeleteButton();
		EditButton editButton1 = new EditButton();
		SaveButton saveButton1 = new SaveButton();
		// NavigatorBar navigatorBar1 = new NavigatorBar();

		MigLayout lm = new MigLayout();
		lm.setLayoutConstraints(description.getScreenConstraints());
		form.setLayout(lm);
		form.setEditButton(editButton1);
		form.setReloadButton(reloadButton1);
		form.setSaveButton(saveButton1);
		form.setInsertButton(insertButton1);
		form.setDeleteButton(deleteButton1);

		controlPanel.setLayout(new FlowLayout());
		controlPanel.add(editButton1);
		controlPanel.add(reloadButton1);
		controlPanel.add(saveButton1);
		controlPanel.add(insertButton1);
		controlPanel.add(deleteButton1);
		for (FieldDescription f : description.getFields()) {
			if (f.isAction()) {
				ActionButton b = new ActionButton(f, this);
				form.add(b, f.getComponentConstraints());
			} else {
//				Class<?> fieldType = null;
//				try {
//					fieldType = Class.forName(f.getClassName());
//				} catch (ClassNotFoundException e) {
//
//					e.printStackTrace();
//				}
				InputControl control = null;
				control = (InputControl) makeControl(f);

				if (f.isLookedUp()) {
					labels.put(f.getName(), control);
					control.setEnabledOnEdit(false);
					control.setEnabledOnInsert(false);
					control.setEnabled(false);
					JLabel l = new JLabel(f.getTitle());
					JPanel p = new JPanel();
					p.add(l);
					p.add((Component) control);
					form.add(p, f.getComponentConstraints());
				} else {
					if (f.isOneToMany()) {
						String descriptionName = f.getOneToManyScreenName();
						ScreenDescription s = ScreenFactory.get(descriptionName);
						Screen g = ScreenFactory.make(s);
						// g.setMode(Consts.READONLY);
						grids.put(g, f.getName());
						JLabel l = new JLabel(f.getTitle());
						JPanel p = new JPanel();
						p.setLayout(new BorderLayout());
						p.add(l, BorderLayout.NORTH);
						p.add(g.getPanel(), BorderLayout.CENTER);
						form.add(p, f.getComponentConstraints());

					} else if (f.isOneToOne()) {
						LookUpComponent l = new LookUpComponent(f.getName(), f.getTitle(), f.getOneToOneScreenName());
						l.addPropertyChangeListener(new PropertyChangeListener() {
							@Override
							public void propertyChange(PropertyChangeEvent evt) {
								MyForm.this.reloadLabels();
							}

						});
						form.add(l, f.getComponentConstraints());
						grids.put(l, f.getName());
					} else if (f.getName().equals("id")) {
						control.setAttributeName(f.getName());
						control.setEnabledOnEdit(false);
						control.setEnabledOnInsert(false);
						JLabel l = new JLabel(f.getTitle());
						JPanel p = new JPanel();
						p.add(l);
						p.add((Component) control);
						form.add(p, f.getComponentConstraints());
					} else {
						control.setAttributeName(f.getName());
						control.setEnabledOnEdit(true);
						control.setEnabledOnInsert(true);
/*						if (f.getName().equals("Proveedor")) {
							labels.put(f.getName(), control);
							control.setEnabledOnEdit(false);
							control.setEnabledOnInsert(false);
							control.setEnabled(false);
						}
*/					
						JLabel l = new JLabel(f.getTitle());
						JPanel p = new JPanel();
						p.add(l);
						p.add((Component) control);
						form.add(p, f.getComponentConstraints());
					}
				}
			}
		}

		form.setMode(Consts.READONLY);
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(controlPanel, BorderLayout.NORTH);
		panel.add(new JScrollPane(form), BorderLayout.CENTER);
		panel.revalidate();
		panel.setSize(panel.getPreferredSize());
	}


	private Component makeControl(FieldDescription fd) {
		//Caso especial, porque no existe un componente TimeControl
		//Usamos un DateControl con el tipo puesto a TYPE_TIME.
		if(fd.getComponentClassName().equals("TimeControl")){
			DateControl ret = new DateControl();
			ret.setDateType(Consts.TYPE_TIME);
			return ret;
		}
		Class clazz = null;
		try {
			clazz = Class.forName(fd.getClassName());
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		BaseInputControl control = null;
		if (Boolean.class.isAssignableFrom(clazz)) {
			//caso especial. No hereda de BaseInputControl!!
			return new CheckBoxControl();
		}else if (String.class.isAssignableFrom(clazz)) {
			TextControl t = new TextControl();
			if(fd.getSize()>0){
				t.setColumns(fd.getSize());
			}
			control = t;
		}else if (Number.class.isAssignableFrom(clazz)) {
			control = new NumericControl();
			
		}if(Double.class.isAssignableFrom(clazz)){
                   NumericControl c = (NumericControl)control;
                   c.setDecimals(2);
		}else if (Date.class.isAssignableFrom(clazz)) {
			control = new DateControl();
		}
		if(control != null && fd.isNoNull()){
			control.setRequired(true);
		}
		return control;
	}

	public String getTitle() {
		return description.getTitle();
	}

	@Override
	public void setMode(int mode) {
		form.setMode(mode);

	}

	@Override
	public Object getModel() {
		return dato;
	}

}
