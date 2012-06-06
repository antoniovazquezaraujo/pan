package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import actions.Actions;

public class ActionButton extends JButton implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6690905131138874903L;
	private FieldDescription fieldDescription;
	private Screen screen;

	public ActionButton(FieldDescription f, Screen screen){
		super(f.getTitle());
		this.fieldDescription = f;
		this.screen = screen;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Actions.doAction(fieldDescription.actionName, screen);
	}
}
