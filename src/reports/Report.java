package reports;

import java.util.Collection;
import java.util.Locale;
import java.util.Map;

import org.eclipse.birt.report.engine.api.EngineConstants;
import org.eclipse.birt.report.engine.api.EngineException;
import org.eclipse.birt.report.engine.api.IGetParameterDefinitionTask;
import org.eclipse.birt.report.engine.api.IRenderOption;
import org.eclipse.birt.report.engine.api.IReportEngine;
import org.eclipse.birt.report.engine.api.IReportRunnable;
import org.eclipse.birt.report.engine.api.IRunAndRenderTask;
import org.eclipse.birt.report.engine.api.RenderOption;

public class Report {
	IReportEngine engine = null;
	IRunAndRenderTask task = null;
	String reportName = null;
	IReportRunnable design = null;
	Map<String, Object> parameters;

	public Report(String reportName) {
		this.reportName = reportName;
		this.engine = ReportSystem.getEngine();
		try {
			design = engine.openReportDesign("informes/" + reportName + ".rptdesign");
			task = engine.createRunAndRenderTask(design);
			task.getAppContext().put(EngineConstants.APPCONTEXT_CLASSLOADER_KEY, ReportSystem.class.getClassLoader());
		} catch (EngineException e) {
			e.printStackTrace();
		}
		IRenderOption options = new RenderOption();
		options.setOutputFormat("html");
		options.setOutputFileName(reportName + ".html");
		task.setRenderOption(options);

		Locale locale = Locale.FRENCH;
		IGetParameterDefinitionTask paramTask = engine.createGetParameterDefinitionTask(design);
		paramTask.setLocale(locale);
		parameters = paramTask.getDefaultValues();
	}



	public Collection getParameterDefs() {
		IGetParameterDefinitionTask paramTask = engine.createGetParameterDefinitionTask(design);
		paramTask.setLocale(Locale.FRENCH);
		return paramTask.getParameterDefns(false);
	}

	public boolean setParameters(Map parameters) {
		task.setParameterValues(parameters);
		return task.validateParameters();
	}

	public Map getParameters() {
		return parameters;
	}

	public boolean run(Map parameters) {
		if (setParameters(parameters)) {
			try {
				task.run();
				return true;
			} catch (EngineException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

}
