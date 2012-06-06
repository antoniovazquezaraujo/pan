package views;

import javax.swing.JPanel;

public interface Screen {
	public enum Type {
		FORM, GRID;
	}
	public abstract void setupComponents();

	public abstract void setModel(Object parent, Object dato);

	public abstract JPanel getPanel();

	public abstract String getTitle();
	public abstract void setMode(int mode);
	public Object getModel();

}