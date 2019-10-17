package csf.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class SQLTools {
	private static Connection conn;
	
	/**
	 * 创建表
	 * @param tableName
	 * @param fields
	 */
	public static final void creatTable(String tableName,String[] fields) throws Exception{
		Connection connection = getConn();
		Statement st = connection.createStatement();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < fields.length; i++) {
			if(i==0){
				sb.append("CREATE TABLE `"+tableName.toUpperCase()+"` (`"+fields[0]+"` varchar(200) NOT NULL,");
				continue;
			}
			if(i==fields.length-1){
				sb.append(" `"+fields[i]+"` varchar(200) default NULL,PRIMARY KEY  (`"+fields[0]+"`) "
				+"	) ENGINE=InnoDB DEFAULT CHARSET=utf8 ");
				continue;
			}
			sb.append(" `"+fields[i]+"` varchar(200) default NULL, ");
		}
		String sql = sb.toString();
		System.out.println(sql);
		st.execute(sql);
		closeConnection();
		System.out.println("表（"+tableName+"）创建成功");
	}
	
	/**
     * 将数据插入表中
     * @param tabelName 表名
     * @param map 数据库字段与数据字段对应关系
     * @param list 数据
     * @param uuid 
     * @return 
     */
    public static int insertTable(String tabelName,String[] fields,List<Map> list) throws Exception{
        int flag = -1;
        Connection connection = getConn();
        String tempId = "";
        try {
            Statement st = connection.createStatement();
            	for (int i = 0; i < list.size(); i++) {
    				Map map = (Map)list.get(i);
    				String sql = "insert into "+tabelName+" values(";
    				String id = UUID.randomUUID().toString().replace("-", "");
    				for (int j = 0; j < fields.length; j++) {
    					if(j==fields.length-1){
    						sql +="'"+ map.get(fields[j])+"');";
    					}else if(j==0){
    						sql += "'"+id+"',";
    					}else{
    						sql +="'"+ map.get(fields[j])+"',";
    					}
    				}
    				System.out.println(sql);
    				st.executeUpdate(sql);
    				tempId = id;
    			}
        } catch (Exception e) {
            System.out.println(tempId+"已插入！");
            e.printStackTrace();
        }finally{
            closeConnection();
        }
        return list.size();
    }
    
    
	
	public final static Connection getConn() throws Exception{
		Map connInfo = ConnectionXMLParseTools.parseXml();
		Class.forName(connInfo.get("dbdriver").toString());
		String url = connInfo.get("url").toString(); 
		String username = connInfo.get("username").toString(); 
		String password = connInfo.get("password").toString(); 
		conn =  DriverManager.getConnection(url, username, password);
		return conn;
	}
	
	public final static void closeConnection(){
		if(conn!=null){
			try{
				conn.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
}
