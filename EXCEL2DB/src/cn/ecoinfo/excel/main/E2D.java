package cn.ecoinfo.excel.main;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;

import cn.ecoinfo.excel.entity.XMLInfo;
import cn.ecoinfo.excel.service.E2DService;
import cn.ecoinfo.excel.service.impl.E2DServiceImpl;
import cn.ecoinfo.excel.util.DBUtil;
import cn.ecoinfo.excel.util.EXCELUtil;
/**
 * 启动类
 * @author zhiqiang
 *
 */
public class E2D {
	/**
	 * 根据XML和EXCEL文件的路径，启动程序
	 * @param xmlfilepath
	 * @param excelfilepath
	 */
	public E2D(String xmlfilepath,String excelfilepath){
		E2DService service = new E2DServiceImpl(); 
		
		XMLInfo xmlinfo = service.loadXMLTemplate(xmlfilepath);
		
		DBUtil dbutil = new DBUtil(xmlinfo.getDbinfo());
		
		HashMap parentmap = service.getParents(dbutil, xmlinfo.getParentinfo());
		
		List<HashMap> maplist = service.loadExcel(excelfilepath,xmlinfo,parentmap);
		
		service.importdate(maplist,dbutil, xmlinfo);
	}
	/**
	 * 根据XML文件的路径和EXCEL文件流，启动程序
	 * @param xmlfilepath
	 * @param excelfilepath
	 */
	public E2D(String xmlfilepath,InputStream stream){
		E2DService service = new E2DServiceImpl(); 
		
		XMLInfo xmlinfo = service.loadXMLTemplate(xmlfilepath);
		
		DBUtil dbutil = new DBUtil(xmlinfo.getDbinfo());
		
		HashMap parentmap = service.getParents(dbutil, xmlinfo.getParentinfo());
		
		List<HashMap> maplist = service.loadExcel(stream,xmlinfo,parentmap);
		
		service.importdate(maplist,dbutil, xmlinfo);
	}
	
	public static void main(String[] args) {
		long s = System.currentTimeMillis();
		String XMLPATH = "D:\\workspace_myelipse\\EXCEL2DB\\DOCUMENTATION\\EXCEL2DB.xml";
		String EXCELPATH = "E:\\T_BAS_REGION.xlsx";
		new E2D(XMLPATH,EXCELPATH);
		long e = System.currentTimeMillis();
		System.out.println(e-s);
	}
}
