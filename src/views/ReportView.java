package views;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import org.eclipse.birt.report.engine.api.IParameterDefn;
import org.eclipse.birt.report.engine.api.IScalarParameterDefn;
import org.openswing.swing.client.CheckBoxControl;
import org.openswing.swing.client.DateControl;
import org.openswing.swing.client.InputControl;
import org.openswing.swing.client.NumericControl;
import org.openswing.swing.client.TextControl;
import org.openswing.swing.internationalization.java.Resources;
import org.openswing.swing.mdi.client.InternalFrame;
import org.openswing.swing.util.java.Consts;

import reports.Report;
import reports.ReportSystem;

public class ReportView extends InternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6687488087727631714L;
	String reportName = null;
	Report report = null;
	Map componentsMap;
	Map fieldValues;
	Map parameterValues;
	JPanel getContentPane;
	MigLayout layout=null;

	public ReportView(String reportName) {
		setTitle("Informe " + reportName);
		componentsMap = new HashMap();
		fieldValues = new HashMap();
		parameterValues = new HashMap();
		this.reportName = reportName;
		report = new Report(reportName);
		jbInit();
	}

	public void jbInit() {
		setLayout(new FlowLayout());
		layout = new MigLayout();
		layout.setLayoutConstraints("wrap 2");
		this.getContentPane().setLayout(layout);
		Collection params = report.getParameterDefs();
		Iterator i = params.iterator();
		while (i.hasNext()) {
			IParameterDefn param = (IParameterDefn) i.next();
			addField(param.getName(), param.getPromptText(), param.getDataType());
		}
		JButton launch = new JButton("Ver");
		launch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Iterator key = componentsMap.keySet().iterator();
				while (key.hasNext()) {
					InputControl field = (InputControl) key.next();
					String paramName = (String) (componentsMap.get(field));
					parameterValues.put(paramName, field.getValue());
				}
				if (report.run(parameterValues)) {
					ReportSystem.view(reportName);
				}
			}
		});

		this.getContentPane().add(launch, "dock south");
		setSize(getPreferredSize());
		setVisible(true);
	}

	private void addField(String paramName, String promptText, int type) {
		JLabel l = new JLabel(promptText);
		InputControl c = null;
		c = makeControl(type);
		if (c != null) {
			componentsMap.put(c, paramName);
			this.getContentPane().add(l);
			this.getContentPane().add((Component) c);
		}
	}

	private InputControl makeControl(int type) {
		switch (type) {
		case IScalarParameterDefn.TYPE_BOOLEAN:
			return new CheckBoxControl();
		case IScalarParameterDefn.TYPE_DATE_TIME:
			return new DateControl(Consts.TYPE_DATE_TIME, Resources.DMY,  '/' ,false, "");
		case IScalarParameterDefn.TYPE_DATE:
			return new DateControl(Consts.TYPE_DATE_TIME, Resources.DMY,  '/' ,false, "");
		case IScalarParameterDefn.TYPE_DECIMAL:
			return new NumericControl();
		case IScalarParameterDefn.TYPE_INTEGER:
			return new NumericControl();
		case IScalarParameterDefn.TYPE_STRING:
			return new TextControl();
		}
		return null;
	}
}
