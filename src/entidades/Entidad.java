package entidades;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import org.openswing.swing.message.receive.java.ValueObjectImpl;

@SuppressWarnings("serial")
public class Entidad extends  ValueObjectImpl {
	Map<String, String> errores = new HashMap<String, String>();
	public void correct(String campo){
		errores.remove(campo);
	}
	public void error(String campo, String explicacion){
		errores.put(campo, explicacion);
	}
	public boolean isAllCorrect(){
		return errores.isEmpty();
	}
	public void clearErrors(){
		errores.clear();
	}
	public void showErrors(){
		String lineas= "";
		for(String s:errores.keySet()){
			lineas += s+ " : "+ errores.get(s)+ "\n";
		}
		JOptionPane.showMessageDialog(null, lineas, "Errores", JOptionPane.ERROR_MESSAGE );
	}
}
