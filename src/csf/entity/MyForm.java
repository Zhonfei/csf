package csf.entity;

public class MyForm {
	private String tabelName;
	private String fieldName;
	private String beanPath;
	private String daoPath;
	private String servicePath;
	private String serviceimplPath;
	private String controllerPath;

	public MyForm(){}

	
	
	public MyForm(String tabelName, String fieldName, String beanPath, String daoPath, String servicePath,
			String serviceimplPath, String controllerPath) {
		super();
		this.tabelName = tabelName;
		this.fieldName = fieldName;
		this.beanPath = beanPath;
		this.daoPath = daoPath;
		this.servicePath = servicePath;
		this.serviceimplPath = serviceimplPath;
		this.controllerPath = controllerPath;
	}



	public String getTabelName() {
		return tabelName;
	}



	public void setTabelName(String tabelName) {
		this.tabelName = tabelName;
	}



	public String getFieldName() {
		return fieldName;
	}



	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}



	public String getBeanPath() {
		return beanPath;
	}



	public void setBeanPath(String beanPath) {
		this.beanPath = beanPath;
	}



	public String getDaoPath() {
		return daoPath;
	}



	public void setDaoPath(String daoPath) {
		this.daoPath = daoPath;
	}



	public String getServicePath() {
		return servicePath;
	}



	public void setServicePath(String servicePath) {
		this.servicePath = servicePath;
	}



	public String getServiceimplPath() {
		return serviceimplPath;
	}



	public void setServiceimplPath(String serviceimplPath) {
		this.serviceimplPath = serviceimplPath;
	}



	public String getControllerPath() {
		return controllerPath;
	}



	public void setControllerPath(String controllerPath) {
		this.controllerPath = controllerPath;
	}



	public String toString(){
		return "MyForm [tabelName=" + tabelName + ",fieldName=" + fieldName + ",beanPath=" + beanPath + ",daoPath=" + daoPath + ",servicePath=" + servicePath + ",serviceimplPath=" + serviceimplPath + ",controllerPath=" + controllerPath + "]";
	}
}
