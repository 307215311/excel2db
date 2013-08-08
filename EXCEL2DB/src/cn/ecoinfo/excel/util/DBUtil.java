package cn.ecoinfo.excel.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import cn.ecoinfo.excel.entity.COLUMNInfo;
import cn.ecoinfo.excel.entity.DBInfo;
import cn.ecoinfo.excel.entity.ParentInfo;
/**
 * 数据库工具类
 * @author zhiqiang
 *
 */
public class DBUtil {
	private  Connection connection;
	
	public DBUtil(DBInfo dbinfo){
		try{ 
			Class.forName(dbinfo.getDriver());
			Connection con = DriverManager.getConnection(dbinfo.getUrl(),dbinfo.getUsername(),dbinfo.getPassword()) ;
			connection = con;
		}catch(ClassNotFoundException e){ 
			e.printStackTrace() ; 
		} catch (SQLException e) {
			e.printStackTrace();
		}  
	}
	/**
	 * 获取父表的比较字段与主键的MAP
	 * @param parent
	 * @return
	 */
	public HashMap getParents(ParentInfo parent){
		HashMap map = new HashMap();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery("SELECT "+parent.getKey()+","+parent.getCompare()+" FROM "+parent.getTablename());
			while(rs.next()){
				map.put(rs.getString(parent.getCompare()), rs.getString(parent.getKey()));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null)
					rs.close();
				if(stmt!=null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return map;
	}
	public void importdata(List<HashMap> maplist,List<COLUMNInfo> columns,String tablename){
		PreparedStatement pstmt = null;
		StringBuffer sql = new StringBuffer("insert into "+tablename+"(");
		StringBuffer params = new StringBuffer();
		for(int i=0;i<columns.size();i++){
			sql.append(columns.get(i).getTcname());
			params.append("?");
			if(i!=columns.size()-1){
				sql.append(",");
				params.append(",");
			}
		}
		sql.append(") values("+params+")");
		try {
			connection.setAutoCommit(false);
			pstmt = connection.prepareStatement(sql.toString());
			for(int i=0;i<maplist.size();i++){
				for(int j=0;j<columns.size();j++){
					pstmt.setObject(j+1, maplist.get(i).get(columns.get(j).getTcname()).toString());
				}
				pstmt.addBatch();
			}
			pstmt.executeBatch();
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public int toSqlType(String type){
		if("string".equals(type.toLowerCase())){
			return java.sql.Types.VARCHAR;
		}else if("float".equals(type.toLowerCase())){
			return java.sql.Types.FLOAT;
		}else if("int".equals(type.toLowerCase())){
			return java.sql.Types.INTEGER;
		}
		return 0;
	}
}
