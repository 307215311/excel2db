package cn.ecoinfo.excel.entity;

import java.io.Serializable;

public class ParentInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	private String tablename;
	private String key;
	private String compare;
	public String getTablename() {
		return tablename;
	}
	public void setTablename(String tablename) {
		this.tablename = tablename;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getCompare() {
		return compare;
	}
	public void setCompare(String compare) {
		this.compare = compare;
	}
	public String toString() {
		return "ParentInfo [tablename=" + tablename + ", key=" + key
				+ ", compare=" + compare + "]";
	}
}
