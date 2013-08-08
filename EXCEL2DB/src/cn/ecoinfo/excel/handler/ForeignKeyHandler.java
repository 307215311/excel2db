package cn.ecoinfo.excel.handler;

import java.util.HashMap;

public class ForeignKeyHandler implements ValueHandler {
	private HashMap map;
	
	public ForeignKeyHandler(){}
	public ForeignKeyHandler(HashMap parentmap){
		map = parentmap;
	}
	
	public String todo(String value) {
		HashMap map1 = (HashMap) map.get("T2");
		String code = (String) map1.get(value);
		
		HashMap map2 = (HashMap) map.get("T1");
		String str = (String) map2.get(code);
		
		return str+code;
	}

}
