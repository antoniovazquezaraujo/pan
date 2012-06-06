package views;

public class FieldDescription {

	public FieldDescription(String actionName, String title, String componentContraints) {
		this.actionName= actionName;
		this.title = title;
		this.componentConstraints= componentContraints;
		this.setNoNull(false);
	}

	public FieldDescription(String name, String title, String className, String componentClassName, boolean oneToMany, String oneToManyScreenName, boolean oneToOne, String oneToOneScreenName, String componentConstraints) {
		this(name, title, className, componentClassName, oneToMany, oneToManyScreenName, oneToOne, oneToOneScreenName, componentConstraints, false, -1);
	}
	public FieldDescription(String name, String title, String className, String componentClassName, boolean oneToMany, String oneToManyScreenName, boolean oneToOne, String oneToOneScreenName, String componentConstraints, boolean noNull) {
		this(name, title, className, componentClassName, oneToMany, oneToManyScreenName, oneToOne, oneToOneScreenName, componentConstraints, noNull, -1);
	}
	public FieldDescription(String name, String title, String className, String componentClassName, boolean oneToMany, String oneToManyScreenName, boolean oneToOne, String oneToOneScreenName, String componentConstraints, boolean noNull, int size) {
		this.name = name;
		this.title = title;
		this.className = className;
		this.componentClassName = componentClassName;
		this.oneToMany = oneToMany;
		this.oneToManyScreenName = oneToManyScreenName;
		this.oneToOne = oneToOne;
		this.oneToOneScreenName = oneToOneScreenName;
		this.componentConstraints = componentConstraints;
		this.actionName = null;
		this.setNoNull(noNull);
		this.size = size;
	}

	public String getName() {
		return name;
	}

	public boolean isLookedUp(){
		return !oneToMany && !oneToOne && name.contains(".");
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getComponentClassName() {
		return componentClassName;
	}

	public void setComponentClassName(String componentClassName) {
		this.componentClassName = componentClassName;
	}

	public boolean isOneToMany() {
		return oneToMany;
	}

	public void setOneToMany(boolean oneToMany) {
		this.oneToMany = oneToMany;
	}

	public String getOneToManyScreenName() {
		return oneToManyScreenName;
	}

	public void setOneToManeScreenName(String oneToManeScreenName) {
		this.oneToManyScreenName = oneToManeScreenName;
	}

	public boolean isOneToOne() {
		return oneToOne;
	}

	public void setOneToOne(boolean oneToOne) {
		this.oneToOne = oneToOne;
	}

	public String getComponentConstraints() {
		return componentConstraints;
	}

	public void setComponentConstraints(String componentConstraints) {
		this.componentConstraints = componentConstraints;
	}

	String name;
	String actionName;
	String title;
	String className;
	String componentClassName;
	boolean oneToMany;
	String oneToManyScreenName;
	boolean oneToOne;
	private String oneToOneScreenName;
	private boolean noNull;
	private int size;

	public String getOneToOneScreenName() {
		return oneToOneScreenName;
	}

	public void setOneToOneScreenName(String oneToOneScreenName) {
		this.oneToOneScreenName = oneToOneScreenName;
	}

	String componentConstraints;
	public boolean isAction() {
		return actionName != null;
	}

	public void setNoNull(boolean noNull) {
		this.noNull = noNull;
	}

	public boolean isNoNull() {
		return noNull;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getSize() {
		return size;
	}
}
