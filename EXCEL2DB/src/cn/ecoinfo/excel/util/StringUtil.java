package cn.ecoinfo.excel.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Row;

import cn.ecoinfo.excel.entity.COLUMNInfo;

public class StringUtil {
	/**
	 * 通过反射机制，加载自定义的column value处理类，并且调用todo方法返回结果
	 * @param value
	 * @param handler
	 * @return
	 */
	public static String getValue(String value,String handler,HashMap maps){
		try{
			Class<?> clazz=Class.forName(handler);
			Object obj = null;
			if(maps!=null&&maps.size()>0){
				Constructor cons = clazz.getConstructor(java.util.HashMap.class);
				obj = cons.newInstance(maps);
			}else{
				obj = clazz.newInstance();
			}
			Method method = clazz.getMethod(Constants.todo, java.lang.String.class);
			return method.invoke(obj, value).toString();
		}catch(Exception e){
			return "Failed Value";
		}
	}
}
