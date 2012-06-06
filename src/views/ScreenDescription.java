package views;

import java.util.ArrayList;
import java.util.List;

//============================================================================================
//ScreenDescription
//============================================================================================
public class ScreenDescription {
	private String title;
	String modelClassName;
	String name; 
	// form or grid
	Screen.Type screenType;
	String popUpName=null;
	String screenConstraints;
	public String getScreenConstraints() {
		return screenConstraints;
	}
	public void setScreenConstraints(String screenConstraints) {
		this.screenConstraints = screenConstraints;
	}
	public String getPopUpName() {
		return popUpName;
	}
	public void setPopUpName(String popUpName) {
		this.popUpName = popUpName;
	}

	List<FieldDescription> fields;
	public ScreenDescription(String title, String modelClassName, String name, Screen.Type screenType, String screenConstraints, String popUpName) {
		this.setTitle(title);
		this.modelClassName = modelClassName;
		this.name = name;
		this.screenType = screenType;
		this.fields = new ArrayList<FieldDescription>();
		this.screenConstraints= screenConstraints;
		this.popUpName = popUpName;
	}
	public ScreenDescription(String title, String modelClassName, String name, Screen.Type screenType, String constraints) {
		this(title, modelClassName, name, screenType, constraints, null);
	}

	public String getModelClassName() {
		return modelClassName;
	}
	public void setModelClassName(String modelClassName) {
		this.modelClassName = modelClassName;
	}


	public List<FieldDescription> getFields(){
		return fields;
	}
	public void add(FieldDescription field) {
		fields.add(field);
	}

	public String getName() {
		return name;
	}

	public Screen.Type getType() {
		return screenType;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
}