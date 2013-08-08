package cn.ecoinfo.excel.util;

import java.util.UUID;
/**
 * UUID工具类
 * @author zhiqiang
 *
 */
public class UUIDUtil {
	/**
	 * 生成UUID随机数方法
	 * @return
	 */
	public static String getUUID(){
		return UUID.randomUUID().toString().replaceAll("-","").toUpperCase();
	}
}
