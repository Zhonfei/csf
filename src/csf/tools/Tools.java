package csf.tools;

import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import csf.entity.MyForm;

public class Tools {
	
	public final static void createFiles(String path,String content) throws Exception{
		File file = new File(path);
		if(file.exists()){
			throw new Exception("文件"+path+"已存在!");
		}else{
			file.createNewFile();
			DataOutputStream dos = new DataOutputStream(new FileOutputStream(file));
			dos.write(content.getBytes());
			dos.flush();
			dos.close();
		}
	}
	
	public final static boolean objNotNull(MyForm form){
		if(form.getTabelName()==null || form.getFieldName()==null){
			return false;
		}
		if(form.getDaoPath()==null || form.getServicePath()==null){
			return false;
		}
		if(form.getServiceimplPath()==null || form.getControllerPath()==null){
			return false;
		}
		return true;
	}
	
	public final static String createOtherContent(String tabelName,String flag){
		String className = tabelName+flag;
		StringBuffer sb = new StringBuffer();
		sb.append("public class ");
		sb.append(className);
		if("ServiceImpl".equalsIgnoreCase(flag)){
			sb.append(" implements ");
			sb.append(className.replace("Impl", ""));
		}
		sb.append("{\n}");
		return sb.toString();
	}
	
	public final static String createEntityContent(String tabelName,String[] fields){
		StringBuffer sb = new StringBuffer();
		sb.append("public class ");
		sb.append(tabelName);
		sb.append("{\n\n");
		for (int i = 0; i < fields.length; i++) {
			sb.append("\tprivate String ");
			sb.append(fields[i]+";\n");
		}
		sb.append("\n\tpublic ");
		sb.append(tabelName);
		sb.append("(){}\n\n");
		sb.append("\tpublic String toString(){\n\t\treturn ");
		sb.append("\"");
		sb.append(tabelName);
		sb.append(" [");
		for (int i = 0; i < fields.length; i++) {
			sb.append(fields[i]);
			sb.append("=");
			if(i==fields.length-1){
				sb.append("\" + "+fields[i]+" + \"");
			}else{
				sb.append("\" + "+fields[i]+" + \",");
			}
		}
		sb.append("]\";");
		sb.append("\n\t}\n\n");
		sb.append("}");
		return sb.toString();
	}
}
