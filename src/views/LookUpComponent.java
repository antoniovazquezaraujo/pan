package views;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.lang.reflect.Method;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jdesktop.beansbinding.ELProperty;
import org.openswing.swing.mdi.client.InternalFrame;
import org.openswing.swing.mdi.client.MDIFrame;

import persistencia.Persistencia;

public class LookUpComponent extends JPanel implements Screen {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8633264575639758790L;
	Object model;
	Object oldModel;
	Object parent;
	String propertyName;
	String title;
	String name;
	Class propertyType;
	JTextField control;
	ScreenDescription description;
	PropertyChangeSupport support;

	public LookUpComponent(String name, String title, String screenName) {
		support = new PropertyChangeSupport(this);
		this.title = title;
		this.name = name;
		this.description = ScreenFactory.get(screenName);

		this.propertyName = name;

		try {
			this.propertyType = Class.forName(description.getModelClassName());
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		JLabel l = new JLabel(title);

		control = new JTextField();
		control.setPreferredSize(new Dimension(60, (int) control.getPreferredSize().getHeight()));
		control.setInputVerifier(new InputVerifier() {
			public boolean verify(JComponent comp) {
				boolean returnValue = true;
				JTextField textField = (JTextField) comp;
				String content = textField.getText();
				if (content.length() != 0) {
					try {
						int n = Integer.parseInt(textField.getText());
						Object o = Persistencia.load(LookUpComponent.this.propertyType, n);
						if (o == null)
							returnValue = false;
						else {
							model = o;
							returnValue = true;
						}
					} catch (NumberFormatException e) {
						returnValue = false;
					}
				}
				return returnValue;
			}

			public boolean shouldYieldFocus(JComponent input) {
				boolean valid = super.shouldYieldFocus(input);
				if (!valid) {
					getToolkit().beep();
				}
				return valid;
			}
		});
		control.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				setValue();
			}
		});

		ImageIcon image= null;
		try{    
			image= new ImageIcon(this.getClass().getResource("../images/buscar.gif"));
		}catch(Exception e){
			System.out.println("No existe la imagen");
		}
		
		JButton b = new JButton(image);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// JDialog f = new JDialog();
				InternalFrame frame = new InternalFrame();
				frame.setModal(true);
				MyLookupGrid grid = new MyLookupGrid(LookUpComponent.this.description);
				grid.setFrame(frame);
				List l = Persistencia.load(LookUpComponent.this.propertyType);
				grid.setModel(l);
				frame.add(grid.getPanel());
				frame.pack();
				MDIFrame.add(frame);
				frame.startModal();
				// frame.setVisible(true);
				oldModel = model;
				model = grid.getResult();
				setValue();
				reloadTextField();
			}

		});
		add(l);
		add(control);
		add(b);
	}

	private void reloadTextField() {
		if (model != null) {
			String methodName = "getId";
			try {
				Method m = propertyType.getMethod(methodName, (Class[])null);
				Integer t = (Integer) m.invoke(model, (Object[])null);
				control.setText(t.toString());
				control.repaint();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void setModel(Object parent, Object model) {
		this.parent = parent;
		this.model = model;

		reloadTextField();
	}

	public void setValue() {
		if (parent != null) {
			ELProperty prop = ELProperty.create("${" + propertyName + "}");
			prop.setValue(parent, model);
		}
		support.firePropertyChange(new PropertyChangeEvent(this, "value", oldModel, model));
	}

	public JPanel getPanel() {
		return this;
	}

	public void setupComponents() {

	}

	public String getTitle() {
		return description.getName();
	}

	@Override
	public void setMode(int mode) {
		// Agregar aqui un modo de poner en READONLY el grid
		// grid.setMode(mode);
	}

	public void addPropertyChangeListener(PropertyChangeListener l) {
		support.addPropertyChangeListener(l);
	}

	public void removePropertyChangeListener(PropertyChangeListener l) {
		support.removePropertyChangeListener(l);
	}

	@Override
	public Object getModel() {
		return model;
	}

}
