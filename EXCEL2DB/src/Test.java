import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;

public class Test {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
//		Class<?> clazz=Class.forName("cn.ecoinfo.excel.handler.TestValueHander");
//		Object obj = clazz.newInstance();
//		Method method = clazz.getMethod("todo", java.lang.String.class); 
//		System.out.println(method.invoke(obj, "111"));
//		
//		Constructor cons2 = clazz.getConstructor(java.lang.String.class);
//		Object obj2 = cons2.newInstance("obj_");
//		System.out.println(method.invoke(obj2, "222"));
		
		HashMap map = new HashMap();HashMap map1 = new HashMap();HashMap map2 = new HashMap();
		map1.put("北京", "010");map1.put("上海", "021");
		map2.put( "010","中国");map2.put( "021","086");
		map.put("T1", map2);
		map.put("T2", map1);
		
		Class<?> clazz=Class.forName("cn.ecoinfo.excel.handler.TestHandler");
		Method method = clazz.getMethod("todo", java.lang.String.class); 
		Constructor cons = clazz.getConstructor(java.util.HashMap.class);
		Object obj2 = cons.newInstance(map);
		System.out.println(method.invoke(obj2, "北京"));
	}

}
