package cn.ecoinfo.excel.handler;

import cn.ecoinfo.excel.util.UUIDUtil;
/**
 * 生成UUID的handler
 * @author zhiqiang
 */
public class UUIDHandler implements ValueHandler {
	public String todo(String value) {
		return UUIDUtil.getUUID();
	}
}