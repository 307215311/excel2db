package cn.ecoinfo.excel.entity;

import java.io.Serializable;
/**
 * excel列与数据库表字段的映射实体类
 * @author zhiqiang
 *
 */
public class COLUMNInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	private int index;
	private String tcname;
	private String tctype;
	private String handler;
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String getTcname() {
		return tcname;
	}
	public void setTcname(String tcname) {
		this.tcname = tcname;
	}
	public String getTctype() {
		return tctype;
	}
	public void setTctype(String tctype) {
		this.tctype = tctype;
	}
	public String getHandler() {
		return handler;
	}
	public void setHandler(String handler) {
		this.handler = handler;
	}
	public String toString() {
		return "COLUMNInfo [index=" + index + ", tcname=" + tcname
				+ ", tctype=" + tctype  +  ", handler=" + handler + "]";
	}
	
}
