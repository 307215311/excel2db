package cn.ecoinfo.excel.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import cn.ecoinfo.excel.entity.COLUMNInfo;
import cn.ecoinfo.excel.entity.SheetInfo;
/**
 * EXCEL工具类
 * @author zhiqiang
 *
 */
public class EXCELUtil {
	/**
	 * 根据excel文件路径，加载excel
	 * @param filepath
	 * @return
	 */
	public static Workbook loadExcel(String filepath){
		FileInputStream fileStream;
		Workbook book = null;
		try {
			fileStream = new FileInputStream(filepath);
			if (filepath.indexOf("xlsx")<0) {
				book = new HSSFWorkbook(fileStream);
			} else {
				book = new XSSFWorkbook(fileStream);// xlsx
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return book;
	}
	/**
	 * 根据excel文件路径，加载excel
	 * @param filepath
	 * @return
	 */
	public static Workbook loadExcel(InputStream fileStream){
		Workbook book = null;
		try {
				book = new HSSFWorkbook(fileStream);
		} catch (Exception e) {
			try {
				book = new XSSFWorkbook(fileStream);	// xlsx
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} 
		return book;
	}
	/**
	 * 根据excel的字段映射关系，取得每一个字段对应的值
	 * @param workbook
	 * @param list
	 * @return
	 */
	public static List<HashMap> getRows(Workbook workbook,List<COLUMNInfo> list,SheetInfo sheetinfo,HashMap maps){
		List<HashMap> maplist = new ArrayList<HashMap>();
		Sheet sheet = null;
		if("".equals(sheetinfo.getName())){
			sheet = workbook.getSheetAt(0);
		}else{
			sheet = workbook.getSheet(sheetinfo.getName());
		}
		HashMap map = null;
		String str = null;
		for (int i = Integer.parseInt(sheetinfo.getRow1()); i <= sheet.getLastRowNum(); i++) {
			Row dataRow = sheet.getRow(i);// 数据行
			map = new HashMap();
			if(dataRow==null) break;
			for(COLUMNInfo column:list){
				String temp = dataRow.getCell(column.getIndex()).toString().trim();
				//如果XML文件中配置了Handler，则进行反射处理
				if(null!=column.getHandler()&&!"".equals(column.getHandler())){
					temp = StringUtil.getValue(temp,column.getHandler(),maps);
				}
				map.put(column.getTcname(),  temp);
			}
			maplist.add(map);
		}
		return maplist;
	}
}
