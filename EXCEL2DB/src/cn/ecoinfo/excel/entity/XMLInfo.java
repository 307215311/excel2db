package cn.ecoinfo.excel.entity;

import java.io.Serializable;
import java.util.List;
/**
 * XML实体类，用于解析XML配置文件
 * @author zhiqiang
 *
 */
public class XMLInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	private DBInfo dbinfo;
	private List<COLUMNInfo> excelinfo;
	private List<ParentInfo> parentinfo;
	private SheetInfo sheetinfo;
	public DBInfo getDbinfo() {
		return dbinfo;
	}
	public void setDbinfo(DBInfo dbinfo) {
		this.dbinfo = dbinfo;
	}
	public List<COLUMNInfo> getExcelinfo() {
		return excelinfo;
	}
	public void setExcelinfo(List<COLUMNInfo> excelinfo) {
		this.excelinfo = excelinfo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public List<ParentInfo> getParentinfo() {
		return parentinfo;
	}
	public void setParentinfo(List<ParentInfo> parentinfo) {
		this.parentinfo = parentinfo;
	}
	public SheetInfo getSheetinfo() {
		return sheetinfo;
	}
	public void setSheetinfo(SheetInfo sheetinfo) {
		this.sheetinfo = sheetinfo;
	}
	public String toString() {
		return "XMLInfo [dbinfo=" + dbinfo + ", excelinfo=" + excelinfo
				+ ", parentinfo=" + parentinfo + ", sheetinfo=" + sheetinfo
				+ "]";
	}
	
	
}
