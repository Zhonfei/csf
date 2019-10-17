package csf.test;


import java.io.File;
import java.util.Map;

import csf.tools.ConnectionXMLParseTools;
import csf.tools.Tools;

public class Test {

	public static void main(String[] args) throws Exception{
//		String tabelName = "MyForm";
//		String[] fields = {"tabelName","fieldName","beanPath","daoPath","servicePath","serviceimplPath","controllerPath"};
//		String path = "G:\\personalWorkPlace\\huoxingAPP\\csf\\src\\csf\\entity\\"+tabelName+".java";
//		String con = Tools.createEntityContent(tabelName, fields);
//		Tools.createFiles(path, con);
//		Map map = ConnectionXMLParseTools.parseXml();
//		System.out.println(map);
		String s = Tools.getBasePath();
		System.out.println(s);
		System.out.println(ConnectionXMLParseTools.PATH);
	}

}
