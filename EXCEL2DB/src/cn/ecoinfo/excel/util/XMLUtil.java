package cn.ecoinfo.excel.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import cn.ecoinfo.excel.entity.COLUMNInfo;
import cn.ecoinfo.excel.entity.DBInfo;
import cn.ecoinfo.excel.entity.ParentInfo;
import cn.ecoinfo.excel.entity.SheetInfo;
import cn.ecoinfo.excel.entity.XMLInfo;

public class XMLUtil {
	/**
	 * 根据路径加载XML文件，并且返回Document对象
	 * @param filepath
	 * @return
	 */
	public static Element loadXML(String filepath){
		Document document = null;
		File f = new File(filepath);
		SAXReader reader = new SAXReader();
		try {
			document = reader.read(f);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return document.getRootElement();
	}
	/**
	 * 将Document对象，转换并返回XMLInfo对象
	 * @param document
	 * @return
	 */
	public static XMLInfo convert(Element element){
		XMLInfo xmlinfo = new XMLInfo();
		xmlinfo.setDbinfo(XMLUtil.convertDBInfo(element));
		xmlinfo.setParentinfo(XMLUtil.convertParentList(element));
		xmlinfo.setSheetinfo(XMLUtil.convertSheetInfo(element));
		xmlinfo.setExcelinfo(XMLUtil.convertColumnList(element));
		return xmlinfo;
	}
	/**
	 * 根据element和xpath获取一个节点
	 * @param element
	 * @param xpath
	 * @return
	 */
	public static Element getElement(Element element,String xpath){
		Element e = (Element) element.selectSingleNode(xpath);
		return e;
	}
	/**
	 * 根据element和xpath获取一个节点list
	 * @param element
	 * @param xpath
	 * @return
	 */
	public static List<Element> getElements(Element element,String xpath){
		List list = element.selectNodes(xpath);
		return list;
	}
	/**
	 * 解析XML中关于DB的配置信息
	 * @param element
	 * @return
	 */
	public static DBInfo convertDBInfo(Element element){
		String driver = XMLUtil.getElement(element,Constants.driver).getText();
		String url = XMLUtil.getElement(element,Constants.url).getText();
		String username = XMLUtil.getElement(element,Constants.username).getText();
		String password = XMLUtil.getElement(element,Constants.password).getText();
		String target = XMLUtil.getElement(element,Constants.target).getText();
		DBInfo db = new DBInfo();
		db.setDriver(driver);
		db.setUrl(url);
		db.setUsername(username);
		db.setPassword(password);
		db.setTarget(target);
		return db;
	}
	/**
	 * 解析XML中关于父表的配置信息
	 * @param element
	 * @return
	 */
	public static List<ParentInfo> convertParentList(Element element){
		List<Element> elements = XMLUtil.getElements(element, Constants.PARENT);
		List<ParentInfo> list = new ArrayList<ParentInfo>(); 
		ParentInfo parent = null;
		for(int i=0;i<elements.size();i++){
			parent = new ParentInfo();
			Element e = elements.get(i);
			parent.setTablename(e.attributeValue(Constants.tablename));
			parent.setKey(e.attributeValue(Constants.key));
			parent.setCompare(e.attributeValue(Constants.compare));
			list.add(parent);
		}
		return list;
	}
	public static SheetInfo convertSheetInfo(Element element){
		String sheetname;String rownum;
		try{
			sheetname = XMLUtil.getElement(element,Constants.sheetname).getText();
			rownum = XMLUtil.getElement(element,Constants.rownum).getText();
		}catch(Exception e){
			sheetname = Constants.default_sheetname;
			rownum = Constants.default_rownum;
		}
		return new SheetInfo(sheetname,rownum);
	}
	/**
	 * 解析XML中关于excel列和数据库列的映射关系
	 * @param element
	 * @return
	 */
	public static List<COLUMNInfo> convertColumnList(Element element){
		List<Element> elements = XMLUtil.getElements(element, Constants.COLUMN);
		List<COLUMNInfo> list = new ArrayList<COLUMNInfo>();
		COLUMNInfo column = null;
		for(int i=0;i<elements.size();i++){
			column = new COLUMNInfo();
			Element e = elements.get(i);
			column.setIndex(Integer.parseInt(e.attributeValue(Constants.index)));
			column.setTcname(e.attributeValue(Constants.tcname));
			column.setTctype(e.attributeValue(Constants.tctype));
			column.setHandler(e.attributeValue(Constants.handler));
			list.add(column);
		}
		return list;
	}
	
}
