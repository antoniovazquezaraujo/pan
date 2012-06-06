package controllers;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;


import org.openswing.swing.mdi.client.MDIFrame;
import org.openswing.swing.message.receive.java.ErrorResponse;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.receive.java.VOListResponse;
import org.openswing.swing.message.receive.java.ValueObject;
import org.openswing.swing.table.client.GridController;
import org.openswing.swing.table.java.GridDataLocator;
import org.openswing.swing.util.java.Consts;

import entidades.Entidad;

import persistencia.Persistencia;
import views.Screen;
import views.ScreenDescription;
import views.ScreenFactory;
import views.ScreenFrame;

public class MyGridController extends GridController implements GridDataLocator {
	@Override
	public boolean validateCell(int rowNumber, String attributeName, Object oldValue, Object newValue) {
		// TODO Auto-generated method stub
		return super.validateCell(rowNumber, attributeName, oldValue, newValue);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1667825568837986085L;
	List datos;
	Object parent;
	Screen popUp = null;
	String popUpName;
	MyComparator comparator = new MyComparator();

	public MyGridController(String popUpName) {
		this.popUpName = popUpName;
	}

	public void setParent(Object parent) {
		this.parent = parent;
	}

	public void setModel(List datos) {
		this.datos = datos;
	}

	@Override
	public Response deleteRecords(ArrayList persistentObjects) throws Exception {
		for (Object o : persistentObjects) {
			datos.remove(o);
			Persistencia.remove(o);
		}
		return new VOListResponse(persistentObjects, false, persistentObjects.size());
	}

	@Override
	public void doubleClick(int rowNumber, ValueObject persistentObject) {
		if (popUpName != null) {
			ScreenDescription d = ScreenFactory.get(popUpName);
			popUp = ScreenFactory.make(d);
			popUp.setModel(parent, persistentObject);
			ScreenFrame f = new ScreenFrame(popUp);
			MDIFrame.add(f);
		}
	}

	@Override
	public Response insertRecords(int[] rowNumbers, ArrayList newData) throws Exception {
		for (Object o : newData) {
			datos.add(o);
			Persistencia.add(o);
		}
		return new VOListResponse(newData, false, newData.size());
	}

	@Override
	public Response updateRecords(int[] rowNumbers, ArrayList oldData, ArrayList newData) throws Exception {
		for (Object o : newData) {
			Entidad v = (Entidad) o;
			if (v.isAllCorrect()) {
				Persistencia.save(o);
			} else {
				v.showErrors();
				return new ErrorResponse("");
			}
		}
		return new VOListResponse(newData, false, newData.size());
	}

	public Response loadData(int action, int startIndex, Map filteredColumns, ArrayList currentSortedColumns, ArrayList currentSortedVersusColumns, Class valueObjectType, Map otherGridParams) {
		if (currentSortedColumns.size() > 0) {
			boolean ascend = currentSortedVersusColumns.get(0) == Consts.ASC_SORTED;
			comparator.setFieldName((String) currentSortedColumns.get(0), ascend);
			Collections.sort(datos, comparator);
		}
		return new VOListResponse(datos, false, datos.size());
	}
}

class MyComparator implements Comparator {

	private String fieldName = "";
	Method getter;
	Class objectClass;
	private boolean ascend;
	private Class newClass = null;

	@Override
	public int compare(Object o1, Object o2) {
		newClass = o1.getClass();
		try {
			getter = newClass.getMethod("get" + fieldName.toUpperCase().charAt(0) + fieldName.substring(1));
			Comparable comp1 = (Comparable) getter.invoke(o1, (Object[]) null);
			Comparable comp2 = (Comparable) getter.invoke(o2, (Object[]) null);
			if (ascend) {
				return comp1.compareTo(comp2);
			} else {
				return comp2.compareTo(comp1);
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return -1; // ???
	}

	void setFieldName(String fieldName, boolean ascend) {
		this.ascend = ascend;
		this.fieldName = fieldName;
	}

}
