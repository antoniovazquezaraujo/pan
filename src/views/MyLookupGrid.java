package views;

import java.awt.Dimension;
import java.util.List;

import org.openswing.swing.mdi.client.InternalFrame;
import org.openswing.swing.message.receive.java.ValueObject;

import controllers.MyGridController;


public class MyLookupGrid extends MyGrid {
	InternalFrame frame;
	MyLookupController controller;

	public MyLookupGrid(ScreenDescription description) {
		super(description);
	}

	public void setFrame(InternalFrame frame) {
		this.frame = frame;
		controller.setFrame(frame);
	}

	public void setupController() {
		controller = new MyLookupController(description.getPopUpName());
		grid.setController(controller);
		grid.setGridDataLocator(controller);
	}

	public void setModel(List datos) {
		this.datos = datos;
		controller.setModel(datos);
		grid.reloadData();
		grid.setMinimumSize(new Dimension(100, 200));
		grid.setPreferredSize(new Dimension(100, 200));
		grid.setMaximumSize(new Dimension(100, 200));
		panel.revalidate();
		panel.repaint();
	}

	public Object getResult() {
		return controller.getRet();
	}
}

 class MyLookupController extends MyGridController {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8214992791044593823L;

	public MyLookupController(String popUpName) {
		super(popUpName);
	}

	ValueObject ret = null;
	InternalFrame frame = null;

	public void setFrame(InternalFrame frame) {
		this.frame = frame;
	}

	public ValueObject getRet() {
		return ret;
	}

	public void setRet(ValueObject ret) {
		this.ret = ret;
	}

	@Override
	public void doubleClick(int rowNumber, ValueObject persistentObject) {
		setRet(persistentObject);
		frame.dispose();
	}
}