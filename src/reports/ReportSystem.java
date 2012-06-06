package reports;

import java.awt.Desktop;
import java.net.URI;

import org.eclipse.birt.core.framework.Platform;
import org.eclipse.birt.report.engine.api.EngineConfig;
import org.eclipse.birt.report.engine.api.IReportEngine;
import org.eclipse.birt.report.engine.api.IReportEngineFactory;

public class ReportSystem {
	static IReportEngine engine = null;
	static EngineConfig config = null;

	
	public static void start() {
		try {
			
			//String engineHome = "C:/Indigo/birt-runtime-3_7_2/ReportEngine";
			config = new EngineConfig();
			//config.setEngineHome(engineHome);

			Platform.startup(config);
			IReportEngineFactory factory = null;
			factory = (IReportEngineFactory) Platform.createFactoryObject(IReportEngineFactory.EXTENSION_REPORT_ENGINE_FACTORY);
			engine = factory.createReportEngine(config);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static IReportEngine getEngine(){
		return engine;
	}


	public static void stop() {
		engine.destroy();
		Platform.shutdown();
	}

	public static void view(String file) {
		try {
			Desktop desktop = Desktop.getDesktop();
			desktop.browse(new URI(file + ".html"));

		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

}
