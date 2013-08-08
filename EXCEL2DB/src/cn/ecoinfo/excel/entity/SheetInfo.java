package cn.ecoinfo.excel.entity;

import java.io.Serializable;
/**
 * Excel Sheet 对象
 * @author zhiqiang
 *
 */
public class SheetInfo  implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private String row1;
	
	public SheetInfo(String name, String row1) {
		this.name = name;
		this.row1 = row1;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRow1() {
		return row1;
	}
	public void setRow1(String row1) {
		this.row1 = row1;
	}
	public String toString() {
		return "SheetInfo [name=" + name + ", row1=" + row1 + "]";
	}
}
