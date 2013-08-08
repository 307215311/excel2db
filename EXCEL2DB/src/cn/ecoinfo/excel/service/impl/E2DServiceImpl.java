package cn.ecoinfo.excel.service.impl;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.dom4j.Element;

import cn.ecoinfo.excel.entity.ParentInfo;
import cn.ecoinfo.excel.entity.XMLInfo;
import cn.ecoinfo.excel.service.E2DService;
import cn.ecoinfo.excel.util.DBUtil;
import cn.ecoinfo.excel.util.EXCELUtil;
import cn.ecoinfo.excel.util.XMLUtil;

public class E2DServiceImpl implements E2DService {

	public XMLInfo loadXMLTemplate(String filepath) {
		Element element = XMLUtil.loadXML(filepath);
		XMLInfo xmlinfo = XMLUtil.convert(element);
		return xmlinfo;
	}

	public List<HashMap> loadExcel(String filepath,XMLInfo xmlinfo,HashMap maps) {
		Workbook workbook = EXCELUtil.loadExcel(filepath);
		List<HashMap> maplist = EXCELUtil.getRows(workbook, xmlinfo.getExcelinfo(),xmlinfo.getSheetinfo(),maps);
		return maplist;
	}
	public List<HashMap> loadExcel(InputStream inputStream, XMLInfo xmlinfo,
			HashMap maps) {
		Workbook workbook = EXCELUtil.loadExcel(inputStream);
		List<HashMap> maplist = EXCELUtil.getRows(workbook, xmlinfo.getExcelinfo(),xmlinfo.getSheetinfo(),maps);
		return maplist;
	}

	public void importdate(List<HashMap> maplist,DBUtil dbutil,XMLInfo xmlinfo) {
		dbutil.importdata(maplist, xmlinfo.getExcelinfo(),xmlinfo.getDbinfo().getTarget());
	}

	public HashMap getParents(DBUtil dbutil,List<ParentInfo> list) {
		HashMap map = new HashMap();
		for(int i=0;i<list.size();i++){
			HashMap m1 = dbutil.getParents(list.get(i));
			map.put(list.get(i).getTablename(), m1);
		}
		return map;
	}

}
