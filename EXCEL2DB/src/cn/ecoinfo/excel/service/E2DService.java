package cn.ecoinfo.excel.service;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;

import cn.ecoinfo.excel.entity.ParentInfo;
import cn.ecoinfo.excel.entity.XMLInfo;
import cn.ecoinfo.excel.util.DBUtil;

public interface E2DService {
	/**
	 * 根据XML路径读取EXCEL2DB XML内容，并返回对象
	 * @param filepath
	 * @return
	 */
	public XMLInfo loadXMLTemplate(String filepath);
	/**
	 * 根据数据库信息和parent列表，获取多张父表的主键集合
	 * @param dbutil
	 * @param list
	 * @return
	 */
	public HashMap getParents(DBUtil dbutil,List<ParentInfo> list);
	/**
	 * 根据EXCEL路径，读取EXCEL对象
	 * @param filepath
	 * @return
	 */
	public List<HashMap> loadExcel(String filepath,XMLInfo xmlinfo,HashMap maps);
	/**
	 * 根据EXCEL文件流，读取EXCEL对象
	 * @param filepath
	 * @return
	 */
	public List<HashMap> loadExcel(InputStream inputStream,XMLInfo xmlinfo,HashMap maps);
	/**
	 * 将excel对象记录，插入相应的数据表
	 * @param workbook
	 * @param xmlinfo
	 */
	public void importdate(List<HashMap> maplist,DBUtil dbutil,XMLInfo xmlinfo);
}
