package controllers;


import org.openswing.swing.form.client.FormController;
import org.openswing.swing.message.receive.java.ErrorResponse;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.receive.java.VOResponse;
import org.openswing.swing.message.receive.java.ValueObject;

import entidades.Entidad;

import persistencia.Persistencia;

public class MyFormController extends FormController {
	@Override
	public boolean validateControl(String attributeName, Object oldValue, Object newValue) {

		return super.validateControl(attributeName, oldValue, newValue);
	}

	@Override
	public Response deleteRecord(ValueObject persistentObject) throws Exception {
		Persistencia.remove(persistentObject);
		return new VOResponse(persistentObject);
	}

	@Override
	public Response insertRecord(ValueObject newPersistentObject) throws Exception {
		Persistencia.add(newPersistentObject);
		return new VOResponse(newPersistentObject);
	}

	Object dato;

	public void setModel(Object dato) {
		this.dato = dato;
	}

	public Response updateRecord(ValueObject oldData, ValueObject newData) throws Exception {
		dato = newData;
		Entidad v = (Entidad) dato;
		if (v.isAllCorrect()) {
			Persistencia.save(newData);
			return new VOResponse(dato);
		} else {
			v.showErrors();
			return new ErrorResponse("");
		}
	}

	@Override
	public Response loadData(Class valueObjectClass) {
		return new VOResponse(dato);
	}
}
