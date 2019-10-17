package csf.service;

import csf.entity.MyForm;
import csf.tools.Tools;
import csf.tools.SQLTools;

public class DealService {
	
	public void deal(MyForm form) throws Exception{
		String tabelName = form.getTabelName();
		String[] fieldsName = form.getFieldName().split(",");
		String beanPath = form.getBeanPath();
		
		String bean = Tools.createEntityContent(tabelName, fieldsName);
		Tools.createFiles(beanPath, bean);
		
		String daoPath = form.getDaoPath();
		String dao = Tools.createOtherContent(tabelName, "Dao");
		Tools.createFiles(daoPath, dao);
		
		String servicePath = form.getServicePath();
		String service = Tools.createOtherContent(tabelName, "Service");
		Tools.createFiles(servicePath, service);
		
		String serviceImplPath = form.getServiceimplPath();
		String serviceImpl = Tools.createOtherContent(tabelName, "ServiceImpl");
		Tools.createFiles(serviceImplPath, serviceImpl);
		
		String controllerPath = form.getControllerPath();
		String controller = Tools.createOtherContent(tabelName, "controller");
		Tools.createFiles(controllerPath, controller);
		
		SQLTools.creatTable(tabelName, fieldsName);
	}
}
